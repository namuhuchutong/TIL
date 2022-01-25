package me.pepeprmill.java8;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        consumerExamples();
    }

    private static void consumerExamples() {

        final Consumer<String> print = System.out::println;
        print.accept("Helllllllo");

        final Consumer<String> greetings = value -> System.out.println("hello" + value);
        greetings.accept(", world!");
        greetings.accept(", hahahahahahahahha");
    }
}
