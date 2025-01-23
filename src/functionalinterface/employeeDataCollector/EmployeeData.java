package functionalinterface.employeeDataCollector;

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

                StringBuilder data = new StringBuilder();
                data.append("Employee ID,First Name,Last Name,Email,Phone,Hire Date,Job Title,Salary,Department Name\n");

                while (resultSet.next()) {
                    data.append(resultSet.getInt("EmployeeID")).append(",")
                            .append(resultSet.getString("FirstName")).append(",")
                            .append(resultSet.getString("LastName")).append(",")
                            .append(resultSet.getString("Email")).append(",")
                            .append(resultSet.getString("Phone")).append(",")
                            .append(resultSet.getDate("HireDate")).append(",")
                            .append(resultSet.getString("JobTitle")).append(",")
                            .append(resultSet.getBigDecimal("Salary")).append(",")
                            .append(resultSet.getString("DepartmentName")).append("\n");
                }

                try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH, true)) {
                    fileOut.write(data.toString().getBytes());
                }

                System.out.println("Export completed for request: " + requestId);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
