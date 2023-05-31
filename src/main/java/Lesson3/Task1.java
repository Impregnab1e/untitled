package Lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Задание
//Пусть дан произвольный список целых чисел.
//1) Нужно удалить из него чётные числа
//2) Найти минимальное значение
//3) Найти максимальное значение
//4) Найти среднее значение
public class Task1 {
    public static void RandomNumberListOperations() {
        // Создаем произвольный список целых чисел
        List<Integer> numbers = generateRandomNumbers(10, 1, 100);
        System.out.println("Исходный список чисел: " + numbers);

        // Удаляем четные числа из списка
        List<Integer> oddNumbers = removeEvenNumbers(numbers);

        // Находим минимальное значение
        Integer min = Collections.min(oddNumbers);

        // Находим максимальное значение
        Integer max = Collections.max(oddNumbers);

        // Находим среднее значение
        double average = calculateAverage(oddNumbers);

        // Выводим результаты
        System.out.println("Список чисел после удаления четных: " + oddNumbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }

    // Метод для генерации списка рандомных чисел
    private static List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(max - min + 1) + min;
            numbers.add(number);
        }
        return numbers;
    }

    // Метод для удаления четных чисел из списка
    private static List<Integer> removeEvenNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }

    // Метод для вычисления среднего значения
    private static double calculateAverage(List<Integer> numbers) {
        double sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
}
