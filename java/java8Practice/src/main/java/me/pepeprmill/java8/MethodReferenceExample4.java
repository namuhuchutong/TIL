package me.pepeprmill.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExample4 {
    public static void main(String[] args) {
        final Function<Integer, String> fl = getDoubleThenToStringUsingLambda();
        final String result = fl.apply(3);
        System.out.println("result = " + result);

        final List<Function<Integer, String>> both =
                Arrays.asList(
                        i -> String.valueOf(i * 2),
                        MethodReferenceExample4::addHashPrefix,
                        MethodReferenceExample4::doubleThenToString
                );

        for (final Function<Integer, String> f : both) {
            final String a = f.apply(7);
            System.out.println(a);
        }
    }

    private static String doubleThenToString(int i) {
        return String.valueOf(i*2);
    }

    private static String addHashPrefix(int number) {
        return "#" + number;
    }

    private static String testFirstClassFunction(int n, Function<Integer, String> f) {
        return "Result : " + f.apply(n) + ".";
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambda() {
        return i -> String.valueOf(i * 2);
    }
}
