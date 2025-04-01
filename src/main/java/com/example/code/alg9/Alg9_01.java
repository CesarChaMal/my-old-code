package com.example.code.alg9;
import java.util.*;
import java.util.stream.*;

public class Alg9_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L;
        do {
            System.out.print("Dar el orden del arreglo (max 50): ");
            L = sc.nextInt();
        } while (L <= 0 || L > 50);

        int[] y = new int[L];
        for (int i = 0; i < L; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            y[i] = sc.nextInt();
        }

        double pm3 = 1, piep = 1;
        boolean hasParImpar = false;

        for (int i = 0; i < L; i++) {
            if ((i % 2 == 0) && y[i] % 2 == 0 && y[i] != 0) {
                piep *= y[i];
                hasParImpar = true;
            }
            if (y[i] % 3 == 0 && y[i] != 0) {
                pm3 *= y[i];
            }
        }

        Arrays.sort(y);
        System.out.println("\n--- Procedural ---");
        System.out.println("Producto de multiplos de 3: " + (pm3 != 1 ? pm3 : "No hubo"));
        System.out.println("Producto de posicion impar, valor par: " + (hasParImpar ? piep : "No hubo"));
        System.out.println("Arreglo ordenado: " + Arrays.toString(y));
    }
}
