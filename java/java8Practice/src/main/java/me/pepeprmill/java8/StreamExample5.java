package me.pepeprmill.java8;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StreamExample5 {

    public static void main(String[] args) {

        raceConditionTest();

        int numOfCores = Runtime.getRuntime().availableProcessors();
        streamTest(numOfCores);
    }

    private static void raceConditionTest() {

        System.out.println("Race Condition Test");

        final int[] sum = {0};
        IntStream.range(0, 100)
                .forEach(i -> sum[0] += i);
        System.out.println("stream sum (side-effect) = " + sum[0]);

        final int[] sum2 = {0};
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> sum2[0] += i);
        System.out.println("parallel sum (side-effect) = " + sum2[0]);

        System.out.println(
                "stream sum (no side-effect) = " +
                        IntStream.range(0, 100)
                                .sum()
        );

        System.out.println(
                "parallel stream sum (no side-effect) = " +
                        IntStream.range(0, 100)
                                .parallel()
                                .sum()
        );
    }

    private static void streamTest(int numOfCores) {

        System.out.println("------------------");
        System.out.println("stream Test");

        final List<Integer> numbers = getNubmers(numOfCores);

        System.out.println("Parallel Stream : " + numbers.size() + " elements");
        final Long start2 = System.currentTimeMillis();
        numbers.parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start2);
    }

    private static List<Integer> getNubmers(final int howMany) {
        return IntStream.range(1, howMany)
                .mapToObj(i -> i)
                .collect(toList());
    }
}
