package javaStageTwo.ioFundamentals.mainTask.check;

import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;
import javaStageTwo.ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchyItem;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCheck {
    private static final int GENERAL_INDENT = 1;
    private static final int NESTED_LEVEL_INDENT = 3;
    private static Integer NestingLevel = 0;
    private static String FileName;

    public static DirectoryHierarchyItem analyzeLine(String line, DirectoryHierarchy directoryHierarchy) {
        parseLineToFileName(line);
        String parentPath = PathAnalyzer.getParentPath(directoryHierarchy, NestingLevel);
        return new DirectoryHierarchyItem(new File(parentPath + FileName), NestingLevel);
    }

    private static void parseLineToFileName(String line) {
        if (line.matches("[|][-]+\\S+")) {
            parseByPattern(line, Pattern.compile(("[|][-]+")));
        } else if (line.matches("[|][ ]+\\S+")) {
            parseByPattern(line, Pattern.compile(("[|][ ]+")));
        }
    }

    private static void parseByPattern(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.lookingAt()) {
            int fileNameIndex = matcher.end();
            NestingLevel = (fileNameIndex - GENERAL_INDENT) / NESTED_LEVEL_INDENT;
            NestingLevel--;
            FileName = line.substring(fileNameIndex);
        }
    }
}
