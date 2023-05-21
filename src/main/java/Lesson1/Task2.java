package Lesson1;

//Вывести все простые числа от 1 до 1000
public class Task2 {
    public static void primeNumbers() {
        System.out.println("Простые числа от 1 до 1000: ");
        for (int i = 1; i <=1000; i++) {
            if (isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime (int number) {
        if (number <2 ) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if (number %i ==0){
                return false;
            }
        }
        return true;
    }
}