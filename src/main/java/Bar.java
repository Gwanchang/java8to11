package main.java;

public interface Bar{

    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
