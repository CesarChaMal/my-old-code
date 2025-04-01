package com.example.code.alg4;

import java.util.*;
import java.util.stream.*;

public class Alg4_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = IntStream.generate(() -> {
            System.out.print("Dar cantidad de numeros: ");
            return scanner.nextInt();
        }).filter(num -> num > 0).findFirst().orElse(0);

        List<Integer> numbers = IntStream.range(0, n)
            .mapToObj(i -> {
                int x;
                do {
                    System.out.print("Dar un valor entero: ");
                    x = scanner.nextInt();
                } while (x == 0);
                return x;
            })
            .collect(Collectors.toList());

        double productEven = numbers.stream()
            .filter(x -> x % 2 == 0)
            .reduce(1, (a, b) -> a * b);

        OptionalDouble productOdd = numbers.stream()
            .filter(x -> x % 2 != 0 && Math.abs(x) % 10 != 3)
            .mapToDouble(Double::valueOf)
            .reduce((a, b) -> a * b);

        int min = numbers.stream().min(Integer::compare).orElseThrow(NoSuchElementException::new);
        int max = numbers.stream().max(Integer::compare).orElseThrow(NoSuchElementException::new);
        int positionMax = IntStream.range(0, numbers.size())
            .reduce((a, b) -> numbers.get(a) > numbers.get(b) ? a : b)
            .orElse(-1) + 1;

        System.out.printf("El producto de pares es: %.2f%n", productEven);
        if (productOdd.isPresent()) {
            System.out.printf("El producto de impares (excepto los terminados en 3) es: %.2f%n", productOdd.getAsDouble());
        } else {
            System.out.println("No hay impares que no terminan en 3 para calcular el producto.");
        }
        System.out.println("El menor: " + min);
        System.out.println("El mayor es: " + max);
        System.out.println("La posicion del mayor es: " + positionMax);
    }
}
