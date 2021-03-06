package me.pepeprmill.java8Practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
                .flatMap(Collection::stream)
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
        List<String> spring = springClasses.stream().map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring"))
                .collect(Collectors.toList());
        spring.forEach(System.out::println);


        Optional<OnlineClass> springOpt = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findAny();
        boolean present = springOpt.isPresent();
        System.out.println("present = " + present);

        // isPresent를 사용하라고 IDE가 알려주는 중
//        OnlineClass onlineClass = springOpt.get();
//        System.out.println("onlineClass = " + onlineClass.getTitle());

        // 개선된 방법
        springOpt.ifPresent(oc -> System.out.println(oc.getTitle()));
        OnlineClass onlineClass1 = springOpt.orElseGet(App::createNewClass);
        System.out.println("onlineClass1 = " + onlineClass1.getTitle());

        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.atZone(ZoneId.of("UTC")));
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MM/d/yyyy");
        LocalDate date = LocalDate.parse("04/24/1996", formatter);
        System.out.println(date);
    }

    private static OnlineClass createNewClass() {
        System.out.println("created");
        return new OnlineClass(100, "New Class", false);
    }

}
