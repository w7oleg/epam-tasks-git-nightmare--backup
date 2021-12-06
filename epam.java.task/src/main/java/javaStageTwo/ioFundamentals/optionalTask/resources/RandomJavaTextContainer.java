package javaStageTwo.ioFundamentals.optionalTask.resources;

import java.util.ArrayList;
import java.util.Comparator;

public class RandomJavaTextContainer {
    public static String separator = " ";
    private ArrayList<Integer> numbers;
    private int numbersCount;

    public RandomJavaTextContainer() {
        numbers = new ArrayList<>();
        initializeCount();
        initializeNumbers();
    }

    public RandomJavaTextContainer(ArrayList<Integer> numbers) {
        this.numbers = numbers;
        this.numbersCount = numbers.size();
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    private void initializeCount() {
        numbersCount = (int) ((Math.random() * 10) + 1);
    }

    private void initializeNumbers() {
        for (int i = 0; i < numbersCount; i++) {
            numbers.add((int) ((Math.random() * 100)));
        }
    }

    public void add(Integer number) {
        numbers.add(number);
        numbersCount++;
    }

    public void sort() {
        numbers.sort(Comparator.comparingInt(o -> o)
        );
    }

    @Override
    public String toString() {
        StringBuilder numbersInString = new StringBuilder();
        for (int number : numbers) {
            numbersInString.append(number);
            numbersInString.append(separator);
        }
        return numbersInString.toString();
    }

}
