package javaStageTwo.ioFundamentals.mainTask.output;

import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchyItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final String filePath;

    public Writer(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(DirectoryHierarchy directoryHierarchy) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (DirectoryHierarchyItem item : directoryHierarchy) {
                writer.append(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
