package org.codeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SquaresCollector {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        long sumOfSquares = numbers.stream()
                .collect(new SumOfSquaresCollector());

        System.out.println("Sum of squares: " + sumOfSquares);
    }

    static class SumOfSquaresCollector implements Collector<Integer, long[], Long> {

        @Override
        public Supplier<long[]> supplier() {
            return () -> new long[1];
        }

        @Override
        public BiConsumer<long[], Integer> accumulator() {
            return (acc, num) -> acc[0] += (long) num * num;
        }

        @Override
        public BinaryOperator<long[]> combiner() {
            return (acc1, acc2) -> {
                acc1[0] += acc2[0];
                return acc1;
            };
        }

        @Override
        public Function<long[], Long> finisher() {
            return acc -> acc[0];
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of(Characteristics.UNORDERED);
        }
    }
}