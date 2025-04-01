package com.example.code.alg6;

import java.util.Scanner;

public class Alg1_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dar dos valores : ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        double suma = a + b;
        double prod = a * b;
        double sumacua = a * a + b * b;

        System.out.printf("La suma es : %.2f\n", suma);
        System.out.printf("El producto es : %.2f\n", prod);
        System.out.printf("La suma de los cuadrados es : %.2f\n", sumacua);
        sc.close();
    }
}
