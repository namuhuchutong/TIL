package me.pepeprmill.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample3 {
    public static void main(String[] args) {
        final List<String> abcdList = Arrays.asList("a", "b", "c", "d");
        final String targetString = "c";

        System.out.println("abcdList = " + abcdList);
        System.out.println("targetString = " + targetString);

        System.out.println("------------------------");

        System.out.println(
                abcdList
                        .stream()
                        .anyMatch(x -> x.equals("c"))
        );

        System.out.println("------------------------");

        System.out.println(
                abcdList
                        .stream()
                        .anyMatch(targetString::equals)
        );

        System.out.println("------------------------");

        System.out.println(
                abcdList
                        .stream()
                        .anyMatch("c"::equals)
        );
    }
}
