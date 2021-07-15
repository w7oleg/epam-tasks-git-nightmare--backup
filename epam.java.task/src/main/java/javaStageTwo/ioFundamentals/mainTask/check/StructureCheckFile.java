package javaStageTwo.ioFundamentals.mainTask.check;

import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchyItem;

import java.io.File;

public class StructureCheckFile {

    public static DirectoryHierarchyItem getDirectoryHierarchyItem(DirectoryHierarchy directoryHierarchy, File file) {
        return new DirectoryHierarchyItem(file, calculateNestingLevel(directoryHierarchy, file));
    }

    private static Integer calculateNestingLevel(DirectoryHierarchy directoryHierarchy, File file) {
        Integer nestingLevel = 0;

        if (directoryHierarchy.stream().anyMatch(item -> item.getFile().equals(file.getParentFile()))) {
            nestingLevel = directoryHierarchy.stream().
                    filter(item -> item.getFile().equals(file.getParentFile())).findFirst().get().getNestedLevel();
            nestingLevel++;
        }
        return nestingLevel;
    }
}
