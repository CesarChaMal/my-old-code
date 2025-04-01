package com.example.code.alg11;

import java.util.Scanner;

public class Alg11_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;

        do {
            System.out.print("Filas (max 25): ");
            m = sc.nextInt();
            System.out.print("Columnas (max 25): ");
            n = sc.nextInt();
        } while (m < 1 || m > 25 || n < 1 || n > 25);

        double[][] arr = new double[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                System.out.printf("Elemento (%d,%d): ", i + 1, j + 1);
                arr[i][j] = sc.nextDouble();
            }

        double pkfila = 1;
        double menor = arr[0][0];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == m - 1) pkfila *= arr[i][j];
                if (arr[i][j] < menor) menor = arr[i][j];
            }

        System.out.printf("Producto fila %d: %.2f%n", m, pkfila);
        System.out.printf("Menor elemento: %.2f%n", menor);
    }
}
