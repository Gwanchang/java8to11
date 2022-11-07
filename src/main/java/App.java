package main.java;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting::hi; //static 메소드 레퍼런스 사용

        Supplier<Greeting> supplier = Greeting::new; //public Greeting() {}

        Function<String , Greeting> function = Greeting::new; //public Greeting(String name) {this.name = name;}

        Greeting keesun = function.apply("Keesun");
        System.out.println(keesun.getName());


        String[] names = {"keesun", "whiteship", "toby"};
        Integer[] is = {1, 2};
        Arrays.sort(names, (f,d)-> {
            return 0;
        });

    }
}
