package fundamentals.maintask.tasktwo;

import java.util.Scanner;

public class ViceVersa {
    public static void main(String[] args) {


        System.out.println("введите строку:");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Line human = new Line(line);
        System.out.println("строка наоборот:\n" + human.mReverse());
    }

}
