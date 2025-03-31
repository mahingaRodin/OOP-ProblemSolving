package rev.multithreading;

import java.io.IOException;

public class ProcessEX {
    public static  void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        try {
            Process process = processBuilder.start();//starting the process
            System.out.println("Process started: "+ process.pid());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
