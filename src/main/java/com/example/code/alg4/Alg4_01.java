package com.example.code.alg4;

import java.util.Scanner;

public class Alg4_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Dar cantidad de numeros: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int count = 0;
        double productEven = 1;
        double productOdd = 1;
        boolean hasOdd = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int positionMax = -1;

        while (count < n) {
            int x;
            do {
                System.out.print("Dar un valor entero: ");
                x = scanner.nextInt();
            } while (x == 0);
            count++;

            if (x % 2 == 0) {
                productEven *= x;
            } else if (Math.abs(x) % 10 != 3) {
                productOdd *= x;
                hasOdd = true;
            }

            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
                positionMax = count;
            }
        }

        System.out.printf("El producto de pares es: %.2f%n", productEven);
        if (hasOdd) {
            System.out.printf("El producto de impares (excepto los terminados en 3) es: %.2f%n", productOdd);
        } else {
            System.out.println("No hay impares que no terminan en 3 para calcular el producto.");
        }
        System.out.println("El menor: " + min);
        System.out.println("El mayor es: " + max);
        System.out.println("La posicion del mayor es: " + positionMax);
    }
}
