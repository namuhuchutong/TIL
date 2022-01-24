package me.pepeprmill.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
       filteringTest();
    }

    private static void filteringTest() {
        System.out.println("---Lambda filtering test---");
        final List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // old
        final List<Integer> result = new ArrayList<>();
        for (final Integer number : list) {
            if (number > 2) {
                result.add(number);
            }
        }
        System.out.println("n > 2 = " + result);

        // old
       final List<Integer> result2 = new ArrayList<>();
       for (final Integer number : list) {
           if (number < 7) {
               result2.add(number);
           }
       }
        System.out.println("n < 7 = " + result2);

       // lambda
        final Predicate<Integer> greaterThan2 = n -> n > 2;
        final List<Integer> result3 = filter(list, greaterThan2);
        System.out.println("lambda n > 2 = " + result3);

        // lambda
        final Predicate<Integer> lessThan7 = n -> n < 7;
        final List<Integer> result4 = filter(list, lessThan7);
        System.out.println("lambda n < 7 = " + result4);


        // less than 2 and greater than 7
        final List<Integer> result5 = filter(list, greaterThan2.and(lessThan7));
        System.out.println("2 < n < 7 = " + result5);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T value : list) {
            if (predicate.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
