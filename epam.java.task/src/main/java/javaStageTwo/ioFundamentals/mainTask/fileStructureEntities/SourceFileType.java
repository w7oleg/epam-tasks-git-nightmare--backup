package javaStageTwo.ioFundamentals.mainTask.fileStructureEntities;

import java.io.File;

public enum SourceFileType {
    DIRECTORY, FILE;

    public static SourceFileType getSourceFileType(String path) {
        File file = new File(path);
        return file.isDirectory() ? DIRECTORY : FILE;
    }
}
