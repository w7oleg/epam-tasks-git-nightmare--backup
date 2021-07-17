package fundamentals.optionaltask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskProcessing {
    public void consoleInput(List<String> numbers) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите несколько чисел различной разрядности разделяя пробелом и нажмите <Enter>:");
            String nameInputData = bufferedReader.readLine();
            for (String splitNameInputData : nameInputData.split(" ")) {
                try {
                    Double.valueOf(splitNameInputData);
                    numbers.add(splitNameInputData);
                    System.out.println("Число : " + numbers.get(numbers.size() - 1));
                } catch (NumberFormatException e) {
                    System.out.println("Не число : " + splitNameInputData);
                }
            }
        } catch (IOException e) {
            System.out.print("ошибка ввода " + e);
        }
    }

    public List<String> getArrayNumbersSortedByLength(List<String> numbers) {
        numbers.sort(Comparator.comparing(String::length));
        return new ArrayList<>(numbers);
    }

    public List<String> getShortestAndLongestNumbers(List<String> numbersSorted) {
        List<String> shortestAndLongestNumbers = new ArrayList<>();
        if (numbersSorted.get(0).length() != numbersSorted.get(1).length()) {
            shortestAndLongestNumbers.add(numbersSorted.get(0));
        } else {
            shortestAndLongestNumbers.add("Больше одного");
        }
        if (numbersSorted.get(numbersSorted.size() - 1).length() != numbersSorted.get(numbersSorted.size() - 2).length()) {
            shortestAndLongestNumbers.add(numbersSorted.get(numbersSorted.size() - 1));
        } else {
            shortestAndLongestNumbers.add("Больше одного");
        }
        return shortestAndLongestNumbers;
    }

    public void showNumbersLessAverage(List<String> numbersSorted) {
        double averageNumberLength = 0;
        if (numbersSorted.size() != 0) {
            averageNumberLength = (double) numbersSorted.toString().length() / (double) (numbersSorted.size() + 2);
            System.out.println("Числа, длина которых меньше средней длины по всем числам (" + averageNumberLength + ") :");
        } else {
            System.out.println("Нет чисел, среди введенных значений.");
        }
        for (String number : numbersSorted) {
            if (number.length() < averageNumberLength) {
                System.out.println(number);
            }
        }
    }
}
