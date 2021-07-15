package javaStageTwo.ioFundamentals.optionalTask.javaProgram;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class Writer {
    private final String filePath;

    public Writer(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(@NotNull String changedJavaProgramText) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (String line : changedJavaProgramText.lines().collect(Collectors.toList())) {
                writer.append(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
