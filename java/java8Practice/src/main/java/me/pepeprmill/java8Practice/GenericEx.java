package me.pepeprmill.java8Practice;

import java.util.Arrays;
import java.util.List;

public class GenericEx {

    // list에는 a의 서브타입이 들어갈 수도 있다.
    // ex) List<Number> <- List<Integer>
    // 자바 가이드 참고할 것
    private static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b).get();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,4,2,7,1,4,23142314);
        System.out.println("list = " + max(list));

    }
}
