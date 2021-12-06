package fundamentals.maintask.taskfive;

import java.util.Scanner;

public class MonthSelection {
    public static void main(String[] args) {
        int n;

        Scanner in = new Scanner(System.in);
        MonthName dataMonth = new MonthName();
        do {
            System.out.println("Введите целое число от 1 до 12 ");
            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число. Введите число");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0 || n > 12);
        dataMonth.setDatam(n);
        System.out.println(dataMonth.name());
    }
}




