package me.pepeprmill.java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Foo {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hi");
        names.add("hello");
        names.add("world");
        names.add("foo");

        names.forEach(System.out::println);
        System.out.println("--------------------");
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));
        System.out.println(" ===================== ");
        while (spliterator1.tryAdvance(System.out::println));

        System.out.println("------------------------------------");
        names.removeIf( s -> s.startsWith("h"));
        names.forEach(System.out::println);


    }
}
