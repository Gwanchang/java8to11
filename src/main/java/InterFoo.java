package main.java;

public interface InterFoo {

    void printName();

    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

}
