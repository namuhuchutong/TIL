package me.pepeprmill.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class IdentityExample {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println("old : " + mapOld(numbers, null));
        System.out.println("identity : " + map(numbers, Function.identity()));
    }

    // 간결함
    private static <T, R> List<R> map(List<T> list,final Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    // 보기 불편함
    private static <T, R> List<R> mapOld(List<T> list, final Function<T, R> mapper) {
        final List<R> result;
        if (mapper != null) {
            result = new ArrayList<>();
        } else {
            result  = new ArrayList<>((List<R>) list);
        }

        if(result.isEmpty()) {
            for (final T t : list) {
                result.add(mapper.apply(t));
            }
        }
        return result;
    }
}
