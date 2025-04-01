package com.example.code.alg6;

import java.util.Scanner;

public class Alg2_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dar tres valores : ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a != 0) {
            double d = b * b - 4 * a * c;
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.printf("Las raices son %.2f  %.2f%n", x1, x2);
            } else if (d == 0) {
                double x = -b / (2 * a);
                System.out.printf("Las raices son iguales a %.2f%n", x);
            } else {
                System.out.println("Las raices son complejas");
            }
        } else {
            System.out.println("La ecuacion no es de 2o grado");
            double x = -c / b;
            System.out.printf("La unica raiz es : %.2f%n", x);
        }

        sc.close();
    }
}
