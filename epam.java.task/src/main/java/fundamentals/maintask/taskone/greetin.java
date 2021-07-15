package fundamentals.maintask.taskone;

import java.util.Scanner;

public class greetin {
    public static void main(String[] args) {
        System.out.println("Добрый день!. Введите ваше имя:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Привет " + name);

    }
}
