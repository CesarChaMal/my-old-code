package com.example.code.alg10;

import java.util.Scanner;

public class Alg10_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        do {
            System.out.print("Filas: ");
            m = sc.nextInt();
            System.out.print("Columnas: ");
            n = sc.nextInt();
        } while (m <= 0 || m > 25 || n <= 0 || n > 25);

        double[][] a = new double[m][n];

        System.out.println("Dar elementos por columnas:");
        for (int c = 0; c < n; c++)
            for (int f = 0; f < m; f++)
                a[f][c] = sc.nextDouble();

        double prodOddRows = 1;
        boolean hasOddProd = false;

        for (int f = 0; f < m; f += 2) {
            for (int c = 0; c < n; c++) {
                if (a[f][c] != 0) {
                    prodOddRows *= a[f][c];
                    hasOddProd = true;
                }
            }
        }

        if (hasOddProd)
            System.out.printf("Producto filas impares: %.2f%n", prodOddRows);
        else
            System.out.println("No hay producto filas impares");

        if (m == n) {
            double prodDiag = 1;
            boolean hasDiag = false;
            for (int i = 0; i < m; i++) {
                if (a[i][i] != 0) {
                    prodDiag *= a[i][i];
                    hasDiag = true;
                }
            }
            System.out.println(hasDiag ? "Producto diagonal: " + prodDiag : "No hay producto diagonal");
        } else {
            double sumPenult = 0;
            for (int c = 0; c < n; c++)
                sumPenult += a[m - 2][c];
            System.out.printf("Suma penultima fila: %.2f%n", sumPenult);
        }
    }
}
