package me.pepeprmill.java8Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api dev", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "java", true));
        javaClasses.add(new OnlineClass(7, "java8", true));
        javaClasses.add(new OnlineClass(8, "java byte code", false));


        List<List<OnlineClass>> classEvents = new ArrayList<>();
        classEvents.add(springClasses);
        classEvents.add(javaClasses);

        System.out.println("----start with spring----");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()+ " : " + oc.getTitle()));

        System.out.println("----not closed classes----");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId() + " : " + oc.getTitle()));

        System.out.println("---only spring class title allowed---");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        System.out.println("---두 수업 목록에 들어 있는 모든 수업 아이디 출력----");
        classEvents.stream()
                .flatMap(l -> l.stream())
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무한 스트림 중에서 앞에 10개 빼고 최대 10개 까지");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에서 Test가 들어있는 수업 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에서 제목에 spring이 들어간 것들만 모아 list 생성");
        List<String> spring = springClasses.stream().filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

    }
}
