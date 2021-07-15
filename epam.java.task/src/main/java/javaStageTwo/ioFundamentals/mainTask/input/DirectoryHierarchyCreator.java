package javaStageTwo.ioFundamentals.mainTask.input;

import javaStageTwo.ioFundamentals.mainTask.check.FileCheck;
import javaStageTwo.ioFundamentals.mainTask.check.StructureCheckFile;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class DirectoryHierarchyCreator {
    private final DirectoryHierarchy directoryHierarchy;

    public DirectoryHierarchyCreator(DirectoryHierarchy directoryHierarchy) {
        this.directoryHierarchy = directoryHierarchy;
    }

    public void createFromFile(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                directoryHierarchy.add(FileCheck.analyzeLine(line, directoryHierarchy));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFromDirectory(String directoryPath) {
        File Directory = new File(directoryPath);
        putFilesWithNestedLevel(directoryHierarchy, Directory);
    }

    private void putFilesWithNestedLevel(DirectoryHierarchy directoryHierarchy, File directory) {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            directoryHierarchy.add(StructureCheckFile.getDirectoryHierarchyItem(directoryHierarchy, file));
            if (file.isDirectory()) {
                putFilesWithNestedLevel(directoryHierarchy, file);
            }
        }
    }
}
