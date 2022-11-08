package main.api;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App02 {

    public static void main(String[] args) {
        List<OnlineClass> springCalsses = new ArrayList<>();
        springCalsses.add(new OnlineClass(1, "spring boot", true));
        springCalsses.add(new OnlineClass(2, "spring data jpa", true));
        springCalsses.add(new OnlineClass(3, "spring mvc", false));
        springCalsses.add(new OnlineClass(4, "spring core", false));
        springCalsses.add(new OnlineClass(5, "rest api development", false));


        System.out.println("spring으로 시작하는 수업");
        springCalsses.stream().filter(oc -> oc.getTitle()
                        .startsWith("spring"))
                        .forEach(oc-> System.out.println(oc.getTitle()));

        System.out.println("=============================");

        System.out.println("Close 되지 않은 수업");

        springCalsses.stream().filter(Predicate.not(OnlineClass::isClosed))
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("=============================");

        System.out.println("수업 이름만 모아서 스트림 만들기");

        springCalsses.stream().map(oc -> oc.getTitle())
                        .forEach(System.out::println);

        System.out.println("=============================");

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code mainpulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springCalsses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");

        keesunEvents.stream().flatMap(Collection::stream)
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("=============================");

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");

        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("=============================");

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");

        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("=============================");

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springCalsses.stream().map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring"))
                .toList();
        spring.forEach(System.out::println);

        System.out.println("=============================");

        Optional<OnlineClass> optional = springCalsses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        //optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        OnlineClass onlineClass = optional.orElseGet(App02::createNewClass);
        System.out.println(onlineClass.getTitle());


    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }

}
