package javaStageTwo.ioFundamentals.maintask.console.handlers;



import javaStageTwo.ioFundamentals.maintask.console.Printer;
import javaStageTwo.ioFundamentals.maintask.exceptions.NoDirectoriesInPath;
import javaStageTwo.ioFundamentals.maintask.exceptions.NoFilesInDirectories;
import javaStageTwo.ioFundamentals.maintask.readers.DirectoriesReader;
import javaStageTwo.ioFundamentals.maintask.readers.FilesReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesHandler {
    public void workWithFiles(File pathToFile) {
        FilesReader filesReader = new FilesReader();
        DirectoriesReader directoriesReader = new DirectoriesReader();

        Printer printer = new Printer();

        List<String> list = new ArrayList<>();

        try {
            list = filesReader.readFile(pathToFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        printer.printAmountDirectories(directoriesReader.getDirectoriesNumber(list));
        printer.printAmountFiles(filesReader.getFilesNumber(list));

        try {
            printer.printAverageQuantityFilesInDirectories(filesReader.getAverageFilesQuantityInDirectories(list));
        } catch (NoDirectoriesInPath e) {
            System.err.println(e.getMessage());
        }

        try {
            printer.printAverageLengthNameOfFiles(filesReader.getAverageLengthNameOfFiles(list));
        } catch (NoFilesInDirectories e) {
            System.err.println(e.getMessage());
        }
    }
}
