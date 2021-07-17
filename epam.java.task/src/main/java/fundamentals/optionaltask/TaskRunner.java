package fundamentals.optionaltask;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        TaskProcessing taskProcessing = new TaskProcessing();
        taskProcessing.consoleInput(numbers);
        List<String> numbersSorted = taskProcessing.getArrayNumbersSortedByLength(numbers);
        List<String> shortestAndLongestNumbers = taskProcessing.getShortestAndLongestNumbers(numbersSorted);
        System.out.println("Самое короткое число: " + shortestAndLongestNumbers.get(0) + ", Самое длинное число: " + shortestAndLongestNumbers.get(1));
        System.out.println("Все числа в порядке возрастания значений их длины : " + numbersSorted);
        taskProcessing.showNumbersLessAverage(numbersSorted);
    }
}
