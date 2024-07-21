package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class ToList {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream().map(number -> number * 3).collect(Collectors.toList());
        System.out.println(evenNumbers);  // [3, 6, 9, 12, 15, 18]
    }
}