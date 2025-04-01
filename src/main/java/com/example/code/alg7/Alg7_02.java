package com.example.code.alg7;

import java.util.*;
import java.util.stream.*;

public class Alg7_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Dar cantidad de numeros: ");
            n = sc.nextInt();
        } while (n <= 0);

        List<Integer> numbers = IntStream.range(0, n).mapToObj(i -> {
            int x;
            do {
                System.out.print("Dar un valor entero distinto de cero: ");
                x = sc.nextInt();
            } while (x == 0);
            return x;
        }).collect(Collectors.toList());

        double productEven = numbers.stream()
                .filter(x -> x % 2 == 0 && Math.abs(x % 10) != 2 && Math.abs(x % 10) != 4)
                .reduce(1, (a, b) -> a * b);

        OptionalInt maxOdd = numbers.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).max();

        numbers.stream().filter(x -> x > 0).forEach(x -> {
            List<Integer> divs = IntStream.rangeClosed(2, x / 2)
                    .filter(d -> x % d == 0).boxed().toList();
            divs.forEach(d -> System.out.println(d + " es divisor de " + x));
            System.out.println(x + " tuvo " + divs.size() + " divisores");
        });

        System.out.println(productEven != 1 ? "El producto de pares es: " + productEven : "No hubo producto de pares");
        System.out.println(maxOdd.isPresent() ? "El mayor de los impares es: " + maxOdd.getAsInt() : "No se dieron impares");
    }
}
