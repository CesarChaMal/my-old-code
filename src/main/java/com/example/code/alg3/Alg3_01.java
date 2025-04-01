package com.example.code.alg3;

import java.util.Scanner;

public class Alg3_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Dar cantidad de calificaciones: ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("El numero que diste es cero o negativo");
        } while (n <= 0);

        int rep = 0, cce78 = 0, cce89 = 0, cce910 = 0, exacta = 0, ce = 0, sumc = 0;

        for (int i = 0; i < n; i++) {
            int c;
            do {
                System.out.print("Dar una calificacion: ");
                c = sc.nextInt();
                if (c <= 0 || c > 100) {
                    System.out.println("El numero que diste es cero, negativo o mayor que 100");
                }
            } while (c <= 0 || c > 100);

            if (c <= 69) rep++;
            else if (c == 70 || c == 80 || c == 90) exacta++;
            else if (c == 100) {
                exacta++;
                ce++;
            } else if (c >= 71 && c <= 79) cce78++;
            else if (c >= 81 && c <= 89) cce89++;
            else if (c >= 91 && c <= 99) cce910++;

            sumc += c;
        }

        double avg = (double) sumc / n;

        System.out.println("\nEl numero de reprobados son : " + rep);
        System.out.println("El numero de calificaciones entre 70 y 80 son : " + cce78);
        System.out.println("El numero de calificaciones entre 80 y 90 son : " + cce89);
        System.out.println("El numero de calificaciones entre 90 y 100 son : " + cce910);
        System.out.println("El numero de calificaciones excelentes son : " + ce);
        System.out.println("El numero de calificaciones exactas son : " + exacta);
        System.out.printf("El promedio del grupo es : %.2f%n", avg);

        sc.close();
    }
}
