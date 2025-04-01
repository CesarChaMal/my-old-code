package com.example.code.alg5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Alg5_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = promptForPositiveInteger(scanner, "Dar cantidad de numeros: ");

        List<Integer> numbers = IntStream.range(0, n)
            .mapToObj(i -> promptForNonZeroInteger(scanner, "Dar un numero entero distinto de cero: "))
            .collect(Collectors.toList());

        int productOfMultiplesOf3 = numbers.stream()
            .filter(x -> x % 3 == 0)
            .reduce(1, (a, b) -> a * b);

        int sumOfPositiveEvens = numbers.stream()
            .filter(x -> x > 0 && x % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();

        long lucasCount = numbers.stream()
            .filter(Alg5_02::isLucasNumber)
            .count();

        System.out.println("La suma de pares positivos: " + sumOfPositiveEvens);
        System.out.println("Los números de Lucas encontrados: " + lucasCount);
        if (numbers.stream().anyMatch(x -> x % 3 == 0)) {
            System.out.println("El producto de los múltiplos de 3 es: " + productOfMultiplesOf3);
        } else {
            System.out.println("No hubo múltiplos de 3.");
        }
    }

    private static int promptForPositiveInteger(Scanner scanner, String message) {
        int value;
        do {
            System.out.print(message);
            value = scanner.nextInt();
            if (value <= 0) {
                System.out.println("Por favor, ingrese un número mayor que cero.");
            }
        } while (value <= 0);
        return value;
    }

    private static int promptForNonZeroInteger(Scanner scanner, String message) {
        int value;
        do {
            System.out.print(message);
            value = scanner.nextInt();
            if (value == 0) {
                System.out.println("El número no puede ser cero.");
            }
        } while (value == 0);
        return value;
    }

    private static boolean isLucasNumber(int num) {
        if (num < 0) return false;
        int a = 2, b = 1;
        if (num == a || num == b) return true;
        int c = a + b;
        while (c <= num) {
            if (c == num) return true;
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }
}
