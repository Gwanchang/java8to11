package main.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        names.forEach(System.out::println);

        Spliterator<String> spliterator = names.spliterator();
        while( spliterator.tryAdvance(System.out::println));

        // stream : 연속된 데이터를 처리하는 오퍼레이션의 모음
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        stringStream.forEach(System.out::println);
    }

}
