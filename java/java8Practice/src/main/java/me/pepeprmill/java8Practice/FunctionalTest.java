package me.pepeprmill.java8Practice;

import java.util.function.*;

public class FunctionalTest {
    public static void main(String[] args) {
        Function<Integer, Integer> plus = (i) -> i+10;
        Function<Integer, Integer> mul = (i) -> i * 10;
        System.out.println(plus.apply(1));
        System.out.println(mul.apply(plus.apply(1)));
        System.out.println(plus.andThen(mul).apply(1));

        BiFunction<Integer, Integer, Integer> add = (i, j) -> i+j;
        System.out.println(add.apply(1, 2));

        Consumer<Integer> consumer = (i) -> System.out.println(" i = " + i);
        consumer.accept(10);

        Supplier<String> sayHello = () -> "Hello ";
        System.out.println(sayHello.get() + ", World");

        Predicate<String> start = (s) -> s.startsWith("hello");
        System.out.println(start.test("hello world"));
    }
}
