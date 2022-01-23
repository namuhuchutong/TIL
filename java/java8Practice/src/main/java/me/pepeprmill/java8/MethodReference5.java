package me.pepeprmill.java8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class MethodReference5 {
    public static void main(String[] args) {

        // normal
        final String[] array = new String[5];
        System.out.println("array = " + array.length);

        final Function<Integer, String[]> arrayFcatory = i -> new String[i];
        final String[] arrayCreatedByLambda = arrayFcatory.apply(6);
        System.out.println("arrayCreatedByLambda = " + arrayCreatedByLambda.length);

        final IntFunction<String[]> arrayFactory2 = String[]::new;
        final String[] arrayCreatedByMethodReference = arrayFactory2.apply(10);
        System.out.println("arrayCreatedByMethodReference = " + arrayCreatedByMethodReference.length);

        final Integer[] integers = Stream.of(1,2,3,4,5)
                                        .map(i -> i*2)
                                        .toArray(Integer[]::new);
        System.out.println("integers = " + Arrays.toString(integers));
    }
}
