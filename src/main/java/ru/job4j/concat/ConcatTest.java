package ru.job4j.concat;

public class ConcatTest {
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        String str = "Job4j";
//        for (int index = 0; index < 9999; index++) {
//            str = str + index;
//        }
//        System.out.println("Millisecond: " + (System.currentTimeMillis() - startTime));
//    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder str = new StringBuilder("Job4j");
        for (int index = 0; index < 9999; index++) {
            str.append(index);
        }
        System.out.println("Millisecond: " + (System.currentTimeMillis() - startTime));
    }
}
