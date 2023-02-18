package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInsideSecond {

    private static String first = "Woof";
    private static String second = "Mya";

    public static void main(String[] args) {
        String test = echo(
                () -> {
                    second = "Draaa";
                    return first + second;
                }
        );
        System.out.println(test);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}