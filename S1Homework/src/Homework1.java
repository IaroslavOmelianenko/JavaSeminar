import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        //sumN(10);
        //primeNumbers(1000);
        //simpleCalculation(10, 5, 'l');
        restoreExpression();
    }

    // 1)Вычислить сумму чисел от 1 до n
    private static void sumN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers from 1 to " + n + " is " + sum);
    }

    // 2) Вывести все простые числа от 1 до 1000
    private static void primeNumbers(int endNumber) {
        boolean prime = true;
        for (int i = 2; i <= endNumber; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                System.out.println(i);
            prime = true;
        }
    }

    // 3) Реализовать простой калькулятор
    private static void simpleCalculation(int number1, int number2, char mathAction) {
        double result;
        switch (mathAction) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                System.out.println("Simple calculator supports only +, -, *, / actions");
                return;
        }
        System.out.println(number1 + " " + mathAction + " " + number2 + " = " + result);
    }

    // 4) Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

    private static void restoreExpression() {
        int valueWithMissingNumber1 = 2;
        int valueWithMissingNumber2 = 5;
        int result = 69;
        System.out.println(valueWithMissingNumber1 + "? + ?" + valueWithMissingNumber2 + " = " + result);

        String value1 = Integer.toString(valueWithMissingNumber1);
        String value2 = Integer.toString(valueWithMissingNumber2);

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int number1 = Integer.parseInt(value1 + i);
                int number2 = Integer.parseInt(j + value2);
                if ((number1 + number2) == result) {
                    System.out.println("Result found:\n" + value1 + i + " + " + j + value2 + " = " + result);
                    return;
                }
            }
        }
        System.out.println("No result");
    }
}


