package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInsideFourth {
    public static void main(String[] args) {
        //String ayyyy = "ayyyyy";
        //ayyyy = "aaaaa";
        String ayyyy = "ayyyyy";
        ayyyy = "aaaaaa";
        String tmp = ayyyy;
        String name = echo(() -> tmp);
//        String name = echo(
//                () -> {
//                   // ayyyy = ayyyy + ", People.";
//                    return ayyyy;
//                }
//        );
        System.out.println(ayyyy);
        System.out.println(name);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}