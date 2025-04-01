package com.example.code.alg8;

import java.util.Scanner;

public class Alg8_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Dar el orden del arreglo (max 50): ");
            n = sc.nextInt();
        } while (n <= 0 || n > 50);

        double[] y = new double[n];
        System.out.println("Dar los elementos uno a uno:");
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextDouble();
        }

        double may = y[0];
        int posMay = 0;
        double ppp = 1;
        double pei = 1;
        boolean hasPpp = false, hasPei = false;

        for (int i = 0; i < n; i++) {
            if (y[i] > may) {
                may = y[i];
                posMay = i;
            }
            if ((i + 1) % 2 == 0 && y[i] != 0) {
                ppp *= y[i];
                hasPpp = true;
            }
            if (y[i] % 2 != 0) {
                pei *= y[i];
                hasPei = true;
            }
        }

        System.out.printf("El mayor = %.2f su posicion es %d%n", may, posMay + 1);
        System.out.println(hasPpp ? "Producto de posicion de pares " + ppp : "No hubo producto positivo de pares");
        System.out.println(hasPei ? "Producto de elementos impares " + pei : "No hubo producto de elementos impares");
    }
}
