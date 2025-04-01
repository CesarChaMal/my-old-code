package com.example.code.alg3;

import java.util.*;

public class Alg3_02 {
    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(70, 85, 90, 100, 95, 73, 65, 80);
        int n = grades.size();

        long rep = grades.stream().filter(c -> c <= 69).count();
        long cce78 = grades.stream().filter(c -> c >= 71 && c <= 79).count();
        long cce89 = grades.stream().filter(c -> c >= 81 && c <= 89).count();
        long cce910 = grades.stream().filter(c -> c >= 91 && c <= 99).count();
        long exacta = grades.stream().filter(c -> Arrays.asList(70, 80, 90, 100).contains(c)).count();
        long ce = grades.stream().filter(c -> c == 100).count();
        double avg = grades.stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("El numero de reprobados son : " + rep);
        System.out.println("El numero de calificaciones entre 70 y 80 son : " + cce78);
        System.out.println("El numero de calificaciones entre 80 y 90 son : " + cce89);
        System.out.println("El numero de calificaciones entre 90 y 100 son : " + cce910);
        System.out.println("El numero de calificaciones excelentes son : " + ce);
        System.out.println("El numero de calificaciones exactas son : " + exacta);
        System.out.printf("El promedio del grupo es : %.2f%n", avg);
    }
}
