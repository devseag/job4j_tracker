package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Odin", "Dva", "Tri", "Chetyre", "Pjat'");
        List<String> rslS = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(rslS);
        List<String> rslL = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(rslL);
        List<String> rslSL = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(rslSL);
        String rslSLF = strings
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("By default");
        System.out.println(rslSLF);
        String rslSLFD = strings
                .stream()
                .skip(5)
                .findFirst()
                .orElse("By default");
        System.out.println(rslSLFD);
        String rslLastOne = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("By default");
        System.out.println(rslLastOne);
    }
}