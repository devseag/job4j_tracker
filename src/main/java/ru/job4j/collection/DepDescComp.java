package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        if (o1.split("/")[0].compareTo(o2.split("/")[0]) == 0) {

        }
//        int rsl = Integer.compare(
//                Integer.parseInt(o1.split("/")[0]),
//                Integer.parseInt(o2.split("/")[0])
//        );
//        if (rsl == 0) {
//            rsl = o1.compareTo(o2);
//        }
//        return rsl;
//    }
}