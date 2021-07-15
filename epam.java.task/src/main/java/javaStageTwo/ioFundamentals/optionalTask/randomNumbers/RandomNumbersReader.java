package javaStageTwo.ioFundamentals.optionalTask.randomNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RandomNumbersReader {
    private final String FILE_PATH;

    public RandomNumbersReader(String path) {
        FILE_PATH = path;
    }

    public RandomNumbersContainer read() {
        ArrayList<Integer> numbers = new ArrayList<>();
        RandomNumbersContainer randomNumbers = null;

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] stringNumbers = line.split(RandomNumbersContainer.separator);
                for (String stringNumber : stringNumbers) {
                    numbers.add(Integer.parseInt(stringNumber));
                }
            }

            randomNumbers = new RandomNumbersContainer(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return randomNumbers;
    }
}
