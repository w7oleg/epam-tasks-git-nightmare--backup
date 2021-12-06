package javaStageTwo.ioFundamentals.maintask.console.handlers;



import javaStageTwo.ioFundamentals.maintask.builders.PathsBuilder;
import javaStageTwo.ioFundamentals.maintask.console.Printer;
import javaStageTwo.ioFundamentals.maintask.writers.PathsToFileWriter;

import java.io.File;
import java.io.IOException;

public class DirectoriesHandler {
    public void workWithDirectories(File pathToDirectory) {
        PathsToFileWriter pathsToFileWriter = new PathsToFileWriter();

        Printer printer = new Printer();

        PathsBuilder pathsBuilder = new PathsBuilder();

        try {
            pathsToFileWriter.putLinesToFile(pathsBuilder.fillDirectoriesTree(pathToDirectory));
            printer.printPlaceWithResult();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
