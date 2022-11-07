package main.java;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.UnaryOperator;

public class Foo {

    public static void main(String[] args) {
        // 람다식 : (인자 리스트) ->  {바디};
        Function<Integer, Integer> plus10 = (num) -> num + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> compose = plus10.compose(multiply2); //mutilply2먼저 실행 후 plus10 실행
        System.out.println(compose.apply(2));

        System.out.println(plus10.andThen(multiply2).apply(2)); // 매개값을 plus10에서 실행 후 multiply2에서 실행

        Consumer<Integer> printT = System.out::println; // Consumer : 리턴 값이 없는 것

        printT.accept(10);

//        UnaryOperator<Integer> 받는 값과 리턴 값이 타입이 같을 때 사용

        Foo foo = new Foo();
        foo.run();

    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11; //쉐도윙
                System.out.println(baseNumber); //final인 것이 와야 한다
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber); //final인 것이 와야 한다
            }
        };

        // 람다식
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber); //final인 것이 와야 한다

        printInt.accept(10);
    }

}
