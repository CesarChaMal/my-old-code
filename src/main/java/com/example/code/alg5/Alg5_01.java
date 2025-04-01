package com.example.code.alg5;

import java.util.Scanner;

public class Alg5_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Prompt for the number of integers
        do {
            System.out.print("Dar cantidad de numeros: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Por favor, ingrese un número mayor que cero.");
            }
        } while (n <= 0);

        int productOfMultiplesOf3 = 1;
        int sumOfPositiveEvens = 0;
        int lucasCount = 0;
        boolean hasMultiplesOf3 = false;

        for (int i = 0; i < n; i++) {
            int x;
            do {
                System.out.print("Dar un numero entero distinto de cero: ");
                x = scanner.nextInt();
                if (x == 0) {
                    System.out.println("El número no puede ser cero.");
                }
            } while (x == 0);

            if (x % 3 == 0) {
                productOfMultiplesOf3 *= x;
                hasMultiplesOf3 = true;
            }

            if (x > 0 && x % 2 == 0) {
                sumOfPositiveEvens += x;
            }

            if (isLucasNumber(x)) {
                lucasCount++;
                System.out.println(x + " es un número de Lucas en la posición: " + (i + 1));
            }
        }

        System.out.println("La suma de pares positivos: " + sumOfPositiveEvens);
        System.out.println("Los números de Lucas encontrados: " + lucasCount);
        if (hasMultiplesOf3) {
            System.out.println("El producto de los múltiplos de 3 es: " + productOfMultiplesOf3);
        } else {
            System.out.println("No hubo múltiplos de 3.");
        }
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
