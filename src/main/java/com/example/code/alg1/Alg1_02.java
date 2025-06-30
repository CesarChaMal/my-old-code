package com.example.code.alg1;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class Alg1_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dar dos valores : ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        DoubleBinaryOperator suma = Double::sum;
        DoubleBinaryOperator prod = (x, y) -> x * y;
        DoubleBinaryOperator sumacua = (x, y) -> x * x + y * y;

        System.out.printf("La suma es : %.2f\n", suma.applyAsDouble(a, b));
        System.out.printf("El producto es : %.2f\n", prod.applyAsDouble(a, b));
        System.out.printf("La suma de los cuadrados es : %.2f\n", sumacua.applyAsDouble(a, b));
    }
}
