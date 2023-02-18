package ru.job4j.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static ru.job4j.lambda.ThrowingExceptionConsumer.throwingExceptionConsumerWrapper;

public class ScopeInside {

    public static void main(String[] args) {
        String name = echo(
                () -> {
                    String ayyyy = "ayyyyy";
                    return ayyyy;
                }
        );
        System.out.println(name);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.forEach(n -> {
//            try {
//                methodThrowingAnException(n);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
       // numbers.forEach(throwingExceptionConsumerWrapper(n -> methodThrowingAnException(n)));
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}