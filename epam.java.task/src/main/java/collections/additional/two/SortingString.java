package collections.additional.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingString {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("C:/Users/UZER/IdeaProjects/Epam/epam.java.task/src/main/resources/addition.txt"));
        ArrayList<String> arrStr = new ArrayList<>();

        while (scan.hasNext()) {
            arrStr.add(scan.nextLine());
        }
        scan.close();
        Collections.sort(arrStr);

        for (String anArrStr : arrStr) {
            System.out.println(anArrStr);
        }
    }

}
