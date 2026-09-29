package hm01;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static double readOperand(Scanner scanner) {
        return scanner.nextDouble();
    }

    private static char readOperation(Scanner scanner) {
        return scanner.next().charAt(0);
    }

    private static double calculate(double operand1, char operation, double operand2) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("на ноль делить нельзя");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("неподдерживаемая операция: " + operation);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double operand1 = readOperand(scanner);
            char operation = readOperation(scanner);
            double operand2 = readOperand(scanner);

            double result = calculate(operand1, operation, operand2);
            System.out.println(result);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: введено не число");
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка ввода: данные не введены");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

}
