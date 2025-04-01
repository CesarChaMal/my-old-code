package com.example.code.alg9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Alg9_02 {
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

        List<Integer> arr = Arrays.stream(y).boxed().collect(Collectors.toList());

        OptionalDouble pm3Func = arr.stream()
            .filter(x -> x % 3 == 0 && x != 0)
            .mapToDouble(x -> x)
            .reduce((a, b) -> a * b);

        OptionalDouble piepFunc = IntStream.range(0, arr.size())
            .filter(i -> i % 2 == 0 && arr.get(i) % 2 == 0 && arr.get(i) != 0)
            .mapToDouble(i -> arr.get(i))
            .reduce((a, b) -> a * b);

        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());

        System.out.println("\n--- Functional ---");
        System.out.println("Producto de multiplos de 3: " + (pm3Func.isPresent() ? pm3Func.getAsDouble() : "No hubo"));
        System.out.println("Producto de posicion impar, valor par: " + (piepFunc.isPresent() ? piepFunc.getAsDouble() : "No hubo"));
        System.out.println("Arreglo ordenado: " + sorted);
    }
}
