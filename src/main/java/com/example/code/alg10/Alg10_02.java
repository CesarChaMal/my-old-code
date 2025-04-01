package com.example.code.alg10;

import java.util.*;
import java.util.stream.*;

public class Alg10_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = readPositiveInt(sc, "Filas (max 25): ", 25);
        int n = readPositiveInt(sc, "Columnas (max 25): ", 25);

        double[][] matrix = readMatrix(sc, m, n);

        double prodOddRows = productOddRows(matrix);
        System.out.println("Producto filas impares: " + prodOddRows);

        if (m == n) {
            double prodDiag = productDiagonal(matrix);
            System.out.println("Producto diagonal: " + prodDiag);
        } else {
            double sumPenult = sumPenultimateRow(matrix);
            System.out.println("Suma penúltima fila: " + sumPenult);
        }
    }

    private static int readPositiveInt(Scanner sc, String message, int max) {
        return Stream.generate(() -> {
                    System.out.print(message);
                    return sc.nextInt();
                })
                .filter(i -> i > 0 && i <= max)
                .findFirst()
                .get();
    }

    private static double[][] readMatrix(Scanner sc, int rows, int cols) {
        return IntStream.range(0, rows)
                .mapToObj(r -> IntStream.range(0, cols)
                        .mapToDouble(c -> {
                            System.out.printf("Elemento [%d,%d]: ", r + 1, c + 1);
                            return sc.nextDouble();
                        })
                        .toArray())
                .toArray(double[][]::new);
    }

    private static double productOddRows(double[][] matrix) {
        return IntStream.range(0, matrix.length)
                .filter(f -> f % 2 == 0)
                .mapToDouble(f -> Arrays.stream(matrix[f])
                        .filter(x -> x != 0)
                        .reduce(1, (a, b) -> a * b))
                .reduce(1, (a, b) -> a * b);
    }

    private static double productDiagonal(double[][] matrix) {
        return IntStream.range(0, matrix.length)
                .mapToDouble(i -> matrix[i][i])
                .filter(x -> x != 0)
                .reduce(1, (a, b) -> a * b);
    }

    private static double sumPenultimateRow(double[][] matrix) {
        return Arrays.stream(matrix[matrix.length - 2]).sum();
    }
}
