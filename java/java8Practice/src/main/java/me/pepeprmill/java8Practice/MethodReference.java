package me.pepeprmill.java8Practice;

import java.util.function.UnaryOperator;

public class MethodReference {

    public static void main(String[] args) {
        UnaryOperator<String> hi = Vehicle::hello;
        System.out.println(hi.apply("hey, "));
    }
}
