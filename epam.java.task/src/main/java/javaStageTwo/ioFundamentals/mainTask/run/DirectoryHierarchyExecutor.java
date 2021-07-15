package javaStageTwo.ioFundamentals.mainTask.run;

import javaStageTwo.ioFundamentals.mainTask.check.PathAnalyzer;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.SourceFileType;
import javaStageTwo.ioFundamentals.mainTask.input.DirectoryHierarchyCreator;
import javaStageTwo.ioFundamentals.mainTask.output.Writer;
import javaStageTwo.ioFundamentals.mainTask.services.Calculator;

import java.io.File;

public class DirectoryHierarchyExecutor {
    private static final String HIERARCHY_FILE_NAME = "C:/Users/UZER/IdeaProjects/hierarchy.txt";

    public static void execute(String path) {
        DirectoryHierarchy directoryHierarchy;
        Calculator calculator;
        switch (SourceFileType.getSourceFileType(path)) {
            case FILE:
                directoryHierarchy = new DirectoryHierarchy(PathAnalyzer.getParentPath(path));
                calculator = new Calculator(directoryHierarchy);
                new DirectoryHierarchyCreator(directoryHierarchy).createFromFile(path);
                System.out.println("Количество файлов " + calculator.getFilesCount());
                System.out.println("Количество папок " + calculator.getDirectoriesCount());
                System.out.println("Среднюю длинну названия файла " + calculator.getAverageFileNameLength());
                System.out.println("Среднее количество файлов в папке " + calculator.getAverageFilesCountInDirectory());
                break;
            case DIRECTORY:
                directoryHierarchy = new DirectoryHierarchy(path + File.separator);
                new DirectoryHierarchyCreator(directoryHierarchy).createFromDirectory(path);
                new Writer(directoryHierarchy.PARENT_PATH + HIERARCHY_FILE_NAME).writeToFile(directoryHierarchy);
                break;
        }
    }
}
