package com.example.code.alg8;// Functional Java requires streams
import java.util.*;
import java.util.stream.*;

public class Alg8_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Dar el orden del arreglo (max 50): ");
            n = sc.nextInt();
        } while (n <= 0 || n > 50);

        List<Double> y = Stream.generate(sc::nextDouble).limit(n).toList();

        double may = Collections.max(y);
        int posMay = y.indexOf(may) + 1;

        double ppp = IntStream.range(0, n)
                .filter(i -> (i + 1) % 2 == 0 && y.get(i) != 0)
                .mapToDouble(y::get)
                .reduce(1, (a, b) -> a * b);
        boolean hasPpp = IntStream.range(0, n).anyMatch(i -> (i + 1) % 2 == 0 && y.get(i) != 0);

        double pei = y.stream()
                .filter(e -> e % 2 != 0)
                .reduce(1.0, (a, b) -> a * b);
        boolean hasPei = y.stream().anyMatch(e -> e % 2 != 0);

        System.out.printf("El mayor = %.2f su posicion es %d%n", may, posMay);
        System.out.println(hasPpp ? "Producto de posicion de pares " + ppp : "No hubo producto positivo de pares");
        System.out.println(hasPei ? "Producto de elementos impares " + pei : "No hubo producto de elementos impares");
    }
}
