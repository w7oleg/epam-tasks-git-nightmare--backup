<<<<<<< HEAD
package fundamentals.maintask.taskfive;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class MonthSelection {
    public static void main(String[] args) {
        int number;

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите целое число от 1 до 12 ");
            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число. Введите число");
                in.next();
            }
            number = in.nextInt();
        } while (number <= 0 || number > 12);

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, number - 1);

        System.out.println("Месяц соответствующий введённому числу: \n"
                + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
    }
}




=======
package fundamentals.maintask.taskfive;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class MonthSelection {
    public static void main(String[] args) {
        int number;

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите целое число от 1 до 12 ");
            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число. Введите число");
                in.next();
            }
            number = in.nextInt();
        } while (number <= 0 || number > 12);

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, number - 1);

        System.out.println("Месяц соответствующий введённому числу: \n"
                + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
    }
}




>>>>>>> b7c79300cbfe201dfb62ff62db2f6954aeb51182
