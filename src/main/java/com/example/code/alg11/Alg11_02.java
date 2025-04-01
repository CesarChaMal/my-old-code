package com.example.code.alg11;

import java.util.*;
import java.util.stream.*;

public class Alg11_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Use Stream<int[]> to generate valid matrix dimensions
        int[] dimensions = Stream.generate(() -> {
                    System.out.print("Filas y columnas (max 25): ");
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    return new int[]{m, n};
                })
                .filter(d -> d[0] >= 1 && d[0] <= 25 && d[1] >= 1 && d[1] <= 25)
                .findFirst()
                .orElseThrow();

        int m = dimensions[0];
        int n = dimensions[1];

        // Functional matrix reading
        double[][] arr = IntStream.range(0, m)
                .mapToObj(i -> IntStream.range(0, n)
                        .mapToDouble(j -> {
                            System.out.printf("Elemento (%d,%d): ", i + 1, j + 1);
                            return sc.nextDouble();
                        })
                        .toArray())
                .toArray(double[][]::new);

        double pkfila = Arrays.stream(arr[m - 1])
                .reduce(1.0, (a, b) -> a * b);

        double menor = Arrays.stream(arr)
                .flatMapToDouble(Arrays::stream)
                .min()
                .orElse(Double.NaN); // Safe default if matrix is empty

        System.out.printf("Producto fila %d: %.2f%n", m, pkfila);
        System.out.printf("Menor elemento: %.2f%n", menor);
    }
}
