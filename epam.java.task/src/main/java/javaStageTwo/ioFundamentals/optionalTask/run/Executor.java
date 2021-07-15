package javaStageTwo.ioFundamentals.optionalTask.run;


import javaStageTwo.ioFundamentals.optionalTask.javaProgram.JavaProgramModifier;
import javaStageTwo.ioFundamentals.optionalTask.javaProgram.Reader;
import javaStageTwo.ioFundamentals.optionalTask.javaProgram.Writer;
import javaStageTwo.ioFundamentals.optionalTask.randomNumbers.RandomNumbersContainer;
import javaStageTwo.ioFundamentals.optionalTask.randomNumbers.RandomNumbersReader;
import javaStageTwo.ioFundamentals.optionalTask.randomNumbers.RandomNumbersWriter;

import java.util.Scanner;

public class Executor {
    final static String FILES_ROOT_PATH = "C:/Users/UZER/IdeaProjects/Epam/epam.java.task/src/main/java/javaStageTwo/ioFundamentals/optionalTask/resources";
    final static String RANDOM_NUMBERS_FILE = "randomnumbers.txt";
    final static String JAVA_PROGRAM_FILE = "RandomNumbersContainer.java";
    final static String CHANGED_MODIFIERS_FILE = "changedmodifiers.txt";
    final static String TURNED_LINES_FILE = "turnedlines.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер сценария, который необходимо исполнить (1-3)");
        int programNumber = scanner.nextInt();
        switch (programNumber) {
            case 1:
                String path = FILES_ROOT_PATH + RANDOM_NUMBERS_FILE;
                RandomNumbersWriter writer = new RandomNumbersWriter(path);
                writer.write(new RandomNumbersContainer());
                RandomNumbersContainer randomNumbers = new RandomNumbersReader(path).read();
                System.out.println("Cлучайные целые числа:");
                System.out.println(randomNumbers);
                randomNumbers.sort();
                writer.write(randomNumbers);
                System.out.println("Результат сортировки записан в файл по пути " + FILES_ROOT_PATH + RANDOM_NUMBERS_FILE);
                break;
            case 2:
                System.out.println("Исходный файл " + FILES_ROOT_PATH + JAVA_PROGRAM_FILE);
                String programTextToChangeModifiers = new Reader(FILES_ROOT_PATH + JAVA_PROGRAM_FILE).read();
                new Writer(FILES_ROOT_PATH + CHANGED_MODIFIERS_FILE).writeToFile(
                        JavaProgramModifier.changeAccessModifierInJavaProgramText(programTextToChangeModifiers));
                System.out.println("Файл с замененными словами public в объявлении атрибутов и методов класса на слово private " + FILES_ROOT_PATH + CHANGED_MODIFIERS_FILE);
                break;
            case 3:
                System.out.println("Исходный файл " + FILES_ROOT_PATH + JAVA_PROGRAM_FILE);
                String programTextToTurnLines = new Reader(FILES_ROOT_PATH + JAVA_PROGRAM_FILE).read();
                new Writer(FILES_ROOT_PATH + TURNED_LINES_FILE).writeToFile(JavaProgramModifier.turnOverLines(programTextToTurnLines));
                System.out.println("Файл с записанными в обратном порядке символами каждой строки " + FILES_ROOT_PATH + TURNED_LINES_FILE);
                break;
            default:
                System.out.println("Введено неверное число!");
                break;
        }
    }
}
