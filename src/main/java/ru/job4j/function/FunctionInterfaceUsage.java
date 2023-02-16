package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> supa = () -> "New String For Interface";
        System.out.println(supa.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supb = () -> new HashSet<>(list);
        Set<String> strings = supb.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Supplier<String> supc = () -> "New String For Interface";
        Consumer<String> consumera = (s) -> System.out.println(s);
        consumera.accept(supc.get());

        Supplier<String> supd = () -> "New String For Interface";
        BiConsumer<String, String> consumerb = (s, s1) -> System.out.println(s + s1);
        consumerb.accept(supd.get(), " and Second String");

        List<String> lista = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supe = () -> new HashSet<>(lista);
        BiConsumer<Integer, String> consumerc = (s, s1) -> System.out.println(s + s1);
        Set<String> stringsa = supe.get();
        int i = 1;
        for (String s : stringsa) {
            consumerc.accept(i++, " is " + s);
        }

        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Stroka pustaja: " + pred.test(""));
        System.out.println("Stroka pustaja: " + pred.test("test"));

        BiPredicate<String, Integer> cond = (s, ii) -> s.contains(ii.toString());
        System.out.println("Stroka soderzhit podstroku: " + cond.test("Name123", 123));
        System.out.println("Stroka soderzhit podstroku: " + cond.test("Name", 123));

        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Tretij simvol v stroke: " + func.apply("first"));
        System.out.println("Tretij simvol v stroke: " + func.apply("second"));

        BiFunction<String, Integer, String> biFunc = (s, iii) -> s.concat(" ").concat(iii.toString());
        System.out.println("Rezul'tat raboty bifunkcii: " + biFunc.apply("Name", 123));
        System.out.println("Rezul'tat raboty bifunkcii: " + biFunc.apply("String number", 12345));

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Stroka posle reversa: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Stroka posle reversa: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> builderBi = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Stroka posle ob#edinenija: " + builderBi.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}