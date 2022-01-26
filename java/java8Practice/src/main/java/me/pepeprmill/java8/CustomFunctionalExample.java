package me.pepeprmill.java8;

import java.math.BigDecimal;

public class CustomFunctionalExample {

    public static void main(String[] args) {

        println(1,2,3,
                (i1, i2, i3) -> String.valueOf(i1+i2+i3)
        );

        println(1L, "hello", "tester@test.com",
                (id, name, email) -> "user info = " + id + ", " + name + ", " + email
        );

        final Function3<Integer, Integer, Integer, String> f3 = (a, b, c) -> String.valueOf(a+b+c);

        final BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println("bigDecimalToCurrency = " + bigDecimalToCurrency.toCurrency(new BigDecimal("120000")));

        //final InvalidFunctionalInterface bad = value -> value.toString();
        // Generic method를 가지는 인터페이스에서 람다를 사용할 수 없다.
        final InvalidFunctionalInterface anonymousClass = new InvalidFunctionalInterface() {
            @Override
            public <T> String mkString(final T value) {
                return value.toString();
            }
        };
        System.out.println("anonymousClass = " + anonymousClass.mkString(123));
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }
}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalInterface {
    <T> String mkString(T value);
}