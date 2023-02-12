package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = Integer.compare(
                Integer.parseInt(left.split(". ")[0]),
                Integer.parseInt(right.split(". ")[0])
        );
        if (rsl == 0) {
            rsl = left.compareTo(right);
        }
        return rsl;
    }
}