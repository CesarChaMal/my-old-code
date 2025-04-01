package com.example.code.alg7;

import java.util.Scanner;

public class Alg7_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Dar cantidad de numeros: ");
            n = sc.nextInt();
        } while (n <= 0);

        double pp = 1;
        int maxOdd = Integer.MIN_VALUE;
        boolean hasEven = false, hasOdd = false;

        for (int k = 0; k < n; k++) {
            int x;
            do {
                System.out.print("Dar un valor entero: ");
                x = sc.nextInt();
            } while (x == 0);

            if (x % 2 == 0 && Math.abs(x % 10) != 2 && Math.abs(x % 10) != 4) {
                pp *= x;
                hasEven = true;
            } else if (x % 2 != 0) {
                if (!hasOdd || x > maxOdd) {
                    maxOdd = x;
                    hasOdd = true;
                }
            }

            if (x > 0) {
                int divisors = 0;
                for (int d = 2; d <= x / 2; d++) {
                    if (x % d == 0) {
                        System.out.println(d + " es divisor de " + x);
                        divisors++;
                    }
                }
                System.out.println(x + " tuvo " + divisors + " divisores");
            }
        }

        System.out.println(hasEven ? "El producto de pares es: " + pp : "No hubo producto de pares");
        System.out.println(hasOdd ? "El mayor de los impares es: " + maxOdd : "No se dieron impares");
    }
}
