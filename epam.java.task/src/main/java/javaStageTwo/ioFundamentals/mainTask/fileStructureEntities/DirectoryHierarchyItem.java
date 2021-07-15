package javaStageTwo.ioFundamentals.mainTask.fileStructureEntities;

import java.io.File;

public class DirectoryHierarchyItem {
    private final File File;
    private final Integer NestedLevel;

    public DirectoryHierarchyItem(File file, Integer nestedLevel) {
        File = file;
        NestedLevel = nestedLevel;
    }

    public File getFile() {
        return File;
    }

    public Integer getNestedLevel() {
        return NestedLevel;
    }


    @Override
    public String toString() {
        String GENERAL_INDENT = "|";
        String FILE_INDENT = "   ";
        String DIRECTORY_INDENT = "---";

        StringBuilder directoryContent = new StringBuilder(GENERAL_INDENT);
        String indent = File.isDirectory() ? DIRECTORY_INDENT : FILE_INDENT;
        StringBuilder append = directoryContent.append(indent.charAt(Math.max(0, NestedLevel + 1)));
        directoryContent.append(File.getName());
        return directoryContent.toString();
    }
}
