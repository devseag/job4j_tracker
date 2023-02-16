package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s, s1) -> System.out.println(s + s1);
        /*
            Zamenite vstavku jelementov v kartu na ispol'zovanie BiConsumer, on uzhe ob#javlen, trebuetsja ego realizovat'.
         */
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");

        BiPredicate<Integer, String> biPred = ...;
        for (Integer i : map.keySet()) {
            /*
                Zamenite proverku v if() na ispol'zovanie BiPredicate, on ob#javlen vyshe, trebuetsja ego realizovat'.
             */
            if (i % 2 == 0 || map.get(i).length() == 4) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        /*
            Zamenit' sozdanie ArrayList iz znachenij Map na Supplier, ob#javlen nizhe, trebuetsja ego realizovat'.
         */
        Supplier<List<String>> sup = ...;
        List<String> strings = new ArrayList<>(map.values());

        Consumer<String> con = ...;
        Function<String, String> func = ...;
        for (String s : strings) {
            /*
                Zamenit' vyvod strok na primenenie Consumer
                Zamenit' preobrazovanie strok k strokam v verhnem registre s pomoshh'ju Function
                Neobhodimoe ob#javleno vyshe, trebuetsja ih realizovat'.
            */
            System.out.println(s.toUpperCase());
        }
    }
}