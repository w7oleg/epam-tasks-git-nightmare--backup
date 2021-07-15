package javaStageTwo.ioFundamentals.mainTask.services;

import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchyItem;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Calculator {
    private final DirectoryHierarchy directoryHierarchy;

    public Calculator(DirectoryHierarchy directoryHierarchy) {
        this.directoryHierarchy = directoryHierarchy;
    }

    public long getDirectoriesCount() {
        return directoryHierarchy.stream().
                filter(item -> item.getFile().isDirectory()).count();
    }

    public long getFilesCount() {
        return directoryHierarchy.stream().
                filter(item -> item.getFile().isFile()).count();
    }

    public double getAverageFilesCountInDirectory() {
        double averageFilesCount = 0;
        long directoriesCount = 0;
        for (DirectoryHierarchyItem item : directoryHierarchy) {
            if (item.getFile().isDirectory()) {
                averageFilesCount += Arrays.stream(Objects.requireNonNull(item.getFile().listFiles())).
                        filter(File::isFile).count();
                directoriesCount++;
            }
        }
        return averageFilesCount / directoriesCount;
    }

    public double getAverageFileNameLength() {
        double averageFileNameLength = 0;
        long filesCount = 0;
        for (DirectoryHierarchyItem item : directoryHierarchy) {
            if (item.getFile().isFile()) {
                averageFileNameLength += item.getFile().getName().length();
                filesCount++;
            }
        }
        return averageFileNameLength / filesCount;
    }

}
