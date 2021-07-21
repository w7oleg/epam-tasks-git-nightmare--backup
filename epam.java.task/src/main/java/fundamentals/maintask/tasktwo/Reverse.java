package fundamentals.maintask.tasktwo;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите Ваше имя: ");

        String hello = sc.nextLine();

        char[] array = hello.toCharArray();
        char[] reverseName = new char[array.length];

        for (int i = 0; i < array.length; i++) {
            reverseName[(array.length - 1) - i] = array[i];
        }

        String result = new String(reverseName);

        System.out.println("Ваше имя наоборот: \n"+result);
    }
}
