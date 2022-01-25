package me.pepeprmill.java8;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        functionExamples();
    }

    private static void functionExamples() {

        final Function<String, Integer> toInt = Integer::parseInt;

        final Integer number = toInt.apply("1000");
        System.out.println("number = " + number);


        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = t -> t;

        System.out.println("identity = " + identity.apply(999));
        System.out.println("identity2 = " + identity2.apply(999999));
    }
}
