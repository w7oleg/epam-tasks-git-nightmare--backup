package javaStageTwo.ioFundamentals.optionalTask.randomNumbers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNumbersWriter {
    private final String FILE_PATH;

    public RandomNumbersWriter(String path) {
        FILE_PATH = path;
    }

    public void write(RandomNumbersContainer randomNumbers) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(randomNumbers.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
