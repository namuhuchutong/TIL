package me.pepeprmill.java8;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample3 {

    public static void main(String[] args) {

        System.out.println(
                Stream.of(1,3,3,3,5,5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map( i -> "#" + i)
                        .collect(toList())
        );

        System.out.println(
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+i)
                        .collect(joining())
        );

        System.out.println(
                Stream.of(1, 3, 3, 3, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#"+i)
                      .collect(joining(" , "))
        );

        System.out.println(
                Stream.of(1, 3, 3, 3, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#"+i)
                      .collect(joining(", ", "[", "]"))
        );

        System.out.println(
                Stream.of(1, 3, 3, 3, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#"+i)
                      .distinct()
                      .collect(toList())
        );

        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1,2,3,4,5)
                        .filter(i -> i == integer3)
                        .findFirst()
        );

        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1,2, 3, 4, 5, 127)
                        .filter(i -> i == integer127)
                        .findFirst()
        );

        /*
         *  https://www.youtube.com/watch?v=KO0HWQ0vNRg
         *  return Optional.empty
         *  128부턴 캐시가 안됨. 새로운 object가 생성됨
         *  equals를 쓰도
         *  Integer valueOf 구현 확인
         */
        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                        .filter(i -> i == integer128)
                        .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                        .filter(i -> i.equals(integer128))
                        .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i > integer3)
                        .count()
        );

    }
}
