package com.example.code.alg6;

import java.util.*;
import java.util.stream.*;

public class Alg6_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Dar cantidad de numeros : ");
            n = scanner.nextInt();
        } while (n <= 0);

        List<Integer> inputs = new ArrayList<>();
        while (inputs.size() < n) {
            System.out.print("Dar un numero : ");
            double x = scanner.nextDouble();
            if (x != (int) x) {
                System.out.println("error numero decimal");
                continue;
            }
            inputs.add((int) x);
        }

        double sumEven = inputs.stream()
            .filter(i -> i > 0 && i % 2 == 0)
            .mapToDouble(i -> i)
            .sum();

        double prodMult3 = inputs.stream()
            .filter(i -> i != 0 && i % 3 == 0)
            .reduce(1, (a, b) -> a * b);

        boolean hasMult3 = inputs.stream().anyMatch(i -> i != 0 && i % 3 == 0);

        List<Integer> lucasEvens = IntStream.range(0, n)
            .filter(i -> inputs.get(i) > 0 && isLucas(inputs.get(i)))
            .mapToObj(i -> {
                System.out.printf("%d es de lucas\n", inputs.get(i));
                System.out.println("En la posicion : " + (i + 1));
                return inputs.get(i);
            }).filter(i -> i % 2 == 0)
            .collect(Collectors.toList());

        System.out.printf("La suma de pares positivos : %.2f\n", sumEven);
        System.out.println("Los numeros pares de lucas fueron : " + lucasEvens.size());
        if (hasMult3)
            System.out.printf("El producto de los multiplos de 3 es : %.2f\n", prodMult3);
        else
            System.out.println("No hubo producto de multiplos de 3");

        scanner.close();
    }

    static boolean isLucas(int x) {
        int p = 1, seg = 3, sig;
        while (p < x) {
            sig = p + seg;
            p = seg;
            seg = sig;
        }
        return p == x;
    }
}
