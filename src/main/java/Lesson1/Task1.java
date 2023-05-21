package Lesson1;

import java.util.Scanner;

// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class Task1 {
    public static void triangularAndFactorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение n");
        int n = scanner.nextInt();

        int triangularNumber = calculateTriangularNumber(n);
        long factorial = calculateFactorial(n);

        System.out.println("Треугольное число для " + n + " равно: " + triangularNumber);
        System.out.println("Факториал для " + n + " равен: " + factorial);
    }

    public static int calculateTriangularNumber(int n) {
        int triangularNumber = 0;
        for (int i = 1; i <= n; i++) {
            triangularNumber += i;
        }
        return triangularNumber;
    }

    public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}


