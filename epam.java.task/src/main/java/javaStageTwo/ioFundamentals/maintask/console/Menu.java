package javaStageTwo.ioFundamentals.maintask.console;



import javaStageTwo.ioFundamentals.maintask.console.handlers.DirectoriesHandler;
import javaStageTwo.ioFundamentals.maintask.console.handlers.FilesHandler;

import java.io.File;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    public void readPathOrFile() {
        Scanner scanner = new Scanner(System.in);

        Printer printer = new Printer();

        while (true) {
            printer.printDescriptionMenu();

            String inputLine = scanner.nextLine();
            String lineWithoutSpace = inputLine.trim();

            if (lineWithoutSpace.length() != 0) {
                File pathToFolderOrFile = new File(lineWithoutSpace);

                if (Files.isDirectory(Paths.get(String.valueOf(pathToFolderOrFile)))) {
                    new DirectoriesHandler().workWithDirectories(pathToFolderOrFile);
                } else if (Files.isRegularFile(Paths.get(String.valueOf(pathToFolderOrFile)))) {
                    new FilesHandler().workWithFiles(pathToFolderOrFile);
                } else {
                    System.err.println("Path isn't exist please try again");
                }
            } else {
                System.err.println("Blank line isn't path please try again");
            }
        }
    }
}


