package me.pepeprmill.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample2 {

    private static final List<Integer> NUMBERS = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    public static void main(String[] args) {

        System.out.println("NUMBERS = " + NUMBERS);
        Stream.of(1,2,3,4,5)
              .forEach(i -> System.out.print(i + " "));

        // Old
        Integer result = null;
        for (final Integer number : NUMBERS) {
            if (number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("\n" + result);

        // Functional
        System.out.println(
                NUMBERS.stream()
                        .filter(number -> number > 3)
                        .filter(number -> number < 9)
                        .map(number -> number * 2)
                        .filter(number -> number > 10)
                        .findFirst()
        );

        customMethod();
    }

    private static void customMethod() {

        final AtomicInteger count = new AtomicInteger(1);
        final List<Integer> greaterThan3 = filter(NUMBERS, i -> i > 3);
        final List<Integer> lessThan9 = filter(greaterThan3, i -> i < 9);
        final List<Integer> doubled = map(lessThan9, i -> i * 2);
        final List<Integer> greaterThan10 = filter(doubled, i -> i > 10);

        System.out.println("greaterThan10 = " + greaterThan10);
        System.out.println("greaterThan10 get(0) = " + greaterThan10.get(0));
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
