package com.mycompany.calci;

import java.util.Scanner;

public class CalculatorCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operation;

        while (true) {
            try {
                System.out.print("Digite o primeiro numero: ");
                if (!scanner.hasNextDouble()) {
                    throw new IllegalArgumentException("Entrada invalida. Por favor, digite um numero valido.");
                }
                num1 = scanner.nextDouble();

                System.out.print("Digite a operacao (+, -, *, /, s, c, t): ");
                operation = scanner.next().charAt(0);

                switch (operation) {
                    case 's':
                        result = Math.sin(Math.toRadians(num1));
                        System.out.println("Resultado: " + result);
                        break;
                    case 'c':
                        result = Math.cos(Math.toRadians(num1));
                        System.out.println("Resultado: " + result);
                        break;
                    case 't':
                        result = Math.tan(Math.toRadians(num1));
                        System.out.println("Resultado: " + result);
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        System.out.print("Digite o segundo numero: ");
                        if (!scanner.hasNextDouble()) {
                            throw new IllegalArgumentException("Entrada invalida. Por favor, digite um numero valido.");
                        }
                        num2 = scanner.nextDouble();

                        try {
                            switch (operation) {
                                case '+':
                                    result = num1 + num2;
                                    System.out.println("Resultado: " + result);
                                    break;
                                case '-':
                                    result = num1 - num2;
                                    System.out.println("Resultado: " + result);
                                    break;
                                case '*':
                                    result = num1 * num2;
                                    System.out.println("Resultado: " + result);
                                    break;
                                case '/':
                                    if (num2 == 0) {
                                        throw new ArithmeticException("Nao e possível dividir por zero!");
                                    }
                                    result = num1 / num2;
                                    System.out.println("Resultado: " + result);
                                    break;
                            }
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Operacao invalida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.next(); 
            }

            System.out.print("Deseja realizar outra operação? (s/n): ");
            char continueCalc = scanner.next().charAt(0);
            if (continueCalc != 's' && continueCalc != 'S') {
                break;
            }
        }
        scanner.close();
    }
}
