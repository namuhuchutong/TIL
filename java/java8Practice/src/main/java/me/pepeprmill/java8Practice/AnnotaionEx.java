package me.pepeprmill.java8Practice;

public class AnnotaionEx {

    public static void main(String[] args) {

    }

    static class Foo<@Chicken T> {

        public static <@Chicken C> void print(@Chicken C c) {
            System.out.println("c = " + c);
        }
    }
}
