package com.example.code.alg6;

import java.util.function.Function;

public class Alg2_02 {
    public static void main(String[] args) {
        double a = 1, b = 2, c = 1;

        Function<double[], String> solver = coeffs -> {
            double a1 = coeffs[0], b1 = coeffs[1], c1 = coeffs[2];
            if (a1 != 0) {
                double d = b1 * b1 - 4 * a1 * c1;
                if (d > 0) {
                    double x1 = (-b1 + Math.sqrt(d)) / (2 * a1);
                    double x2 = (-b1 - Math.sqrt(d)) / (2 * a1);
                    return String.format("Las raices son %.2f  %.2f", x1, x2);
                } else if (d == 0) {
                    double x = -b1 / (2 * a1);
                    return String.format("Las raices son iguales a %.2f", x);
                } else {
                    return "Las raices son complejas";
                }
            } else {
                double x = -c1 / b1;
                return String.format("La ecuacion no es de 2o grado\nLa unica raiz es : %.2f", x);
            }
        };

        System.out.println(solver.apply(new double[]{a, b, c}));
    }
}
