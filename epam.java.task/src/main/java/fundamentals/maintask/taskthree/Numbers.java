package fundamentals.maintask.taskthree;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("введите положительно число узывающееуке кол-во целых положительных цифр в массиве:");
            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число. Введите число");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0);
        int arr[];
        arr = new int[n];
        System.out.println("Спасибо!");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Полученный массив выведенный в столбец");
        for (int i : arr) {
            System.out.println(i + " ");
        }
        System.out.println("Полученный массив выведенный в строку");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
