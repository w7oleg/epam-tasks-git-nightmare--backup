package collections.additional.three;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VariousWords {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:/Users/UZER/IdeaProjects/Epam/epam.java.task/src/main/resources/midnight.txt");
        Set<String> strSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((line = bufferReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferReader.close();
        strSet.addAll(Arrays.asList(stringBuilder.toString().toLowerCase().split(" |, |. |\\.")));
        System.out.println(strSet);
    }
}
