package javaStageTwo.ioFundamentals.optionalTask.javaProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private final String JavaProgramPath;

    public Reader(String path) {
        JavaProgramPath = path;
    }

    public String read() {
        StringBuilder javaProgramText = new StringBuilder();
        try (FileReader fileReader = new FileReader(JavaProgramPath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                javaProgramText.append(line);
                javaProgramText.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaProgramText.toString();
    }
}
