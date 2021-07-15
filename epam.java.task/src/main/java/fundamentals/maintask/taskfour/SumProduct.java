package fundamentals.maintask.taskfour;

import java.util.Scanner;

public class SumProduct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
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
            System.out.print("введите число: ");
            arr[i] = (int) (in.nextInt());
        }
        System.out.println("Полученный массив: ");
        int sum = 0;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("\nПолученная сумма чисел массива: " + sum);
        int mult = 1;
        for (int i = 0; i < arr.length; i++) {
            mult *= arr[i];
        }
        System.out.println("Произведение чисел в массиве: " + mult);
    }
}
