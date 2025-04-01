package com.example.code.alg6;

import java.util.Scanner;

public class Alg6_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, count = 0, cluc = 0;
        double x, pm3 = 1, supap = 0;
        boolean hasMultOf3 = false;

        do {
            System.out.print("Dar cantidad de numeros : ");
            n = scanner.nextInt();
        } while (n <= 0);

        while (count < n) {
            do {
                System.out.print("Dar un numero : ");
                x = scanner.nextDouble();
                if (x != (int) x)
                    System.out.println("error numero decimal");
            } while (x != (int) x);

            count++;

            if (((int) x % 2 == 0) && x > 0)
                supap += x;

            if (((int) x % 3 == 0) && x != 0) {
                pm3 *= x;
                hasMultOf3 = true;
            }

            if (x > 0 && isLucas((int) x)) {
                cluc++;
                System.out.printf("%.2f es de lucas\n", x);
                System.out.println("En la posicion : " + count);
            }
        }

        System.out.printf("La suma de pares positivos : %.2f\n", supap);
        System.out.println("Los numeros pares de lucas fueron : " + cluc);
        if (hasMultOf3)
            System.out.printf("El producto de los multiplos de 3 es : %.2f\n", pm3);
        else
            System.out.println("No hubo producto de multiplos de 3");

        scanner.close();
    }

    static boolean isLucas(int x) {
        int p = 1, seg = 3, sig;
        while (p < x) {
            sig = p + seg;
            p = seg;
            seg = sig;
        }
        return p == x;
    }
}
