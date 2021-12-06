package javaStageTwo.ioFundamentals.maintask.writers;



import javaStageTwo.ioFundamentals.maintask.resources.PathPlaces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PathsToFileWriter {
    public void putLinesToFile(String text) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(PathPlaces.getPlaceAfterReadingDirectories()))) {
            out.write(text);
        }
    }
}
