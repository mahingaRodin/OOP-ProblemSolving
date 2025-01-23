package functionalinterface.employeeDataCollector;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeData {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/EmployeeDB";
    private static final String USER = "postgres";
    private static final String PASS = "rodin123";
    private static final String FILE_PATH = "C:\\Users\\user\\OneDrive\\Desktop\\employee.xlsx";
    private static final Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            int requestId = i + 1;
            executor.submit(() -> exportEmployeeData(requestId));
        }
        executor.shutdown();
    }

    private static void exportEmployeeData(int requestId) {
        synchronized (lock) {
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(
                         "SELECT e.\"employeeid\", e.\"firstname\", e.\"lastname\", e.\"email\", e.\"phone\", e.\"hiredate\", " +
                                 "e.\"jobtitle\", e.\"salary\", d.\"departmentname\" " +
                                 "FROM \"employees\" e " +
                                 "LEFT JOIN \"departments\" d ON e.\"departmentid\" = d.\"departmentid\"")) {

                Workbook workbook;
                Sheet sheet;

                // If the file already exists, open it, otherwise create a new workbook
                try {
                    workbook = WorkbookFactory.create(new java.io.File(FILE_PATH));
                    sheet = workbook.getSheetAt(0);
                } catch (IOException e) {
                    workbook = new XSSFWorkbook();
                    sheet = workbook.createSheet("Employees");

                    // Add header row
                    Row headerRow = sheet.createRow(0);
                    String[] headers = {"Employee ID", "First Name", "Last Name", "Email", "Phone", "Hire Date",
                            "Job Title", "Salary", "Department Name"};
                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                    }
                }

                // Determine the starting row for new data
                int rowCount = sheet.getLastRowNum();

                // Populate rows with data from the database
                while (resultSet.next()) {
                    Row row = sheet.createRow(++rowCount);
                    row.createCell(0).setCellValue(resultSet.getInt("EmployeeID"));
                    row.createCell(1).setCellValue(resultSet.getString("FirstName"));
                    row.createCell(2).setCellValue(resultSet.getString("LastName"));
                    row.createCell(3).setCellValue(resultSet.getString("Email"));
                    row.createCell(4).setCellValue(resultSet.getString("Phone"));
                    row.createCell(5).setCellValue(resultSet.getDate("HireDate").toString());
                    row.createCell(6).setCellValue(resultSet.getString("JobTitle"));
                    row.createCell(7).setCellValue(resultSet.getBigDecimal("Salary").doubleValue());
                    row.createCell(8).setCellValue(resultSet.getString("DepartmentName"));
                }

                // Write workbook to file
                try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
                    workbook.write(fileOut);
                }

                System.out.println("Export completed for request: " + requestId);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
