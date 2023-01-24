package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }

    public static int max(int left, int right, int third) {
        //int result = third > max(left, right) ? third : max(left, right);
        return max(max(left, right), third);
    }

    public static int max(int left, int right, int third, int fourth) {
        //int result = fourth > max(left, right, third) ? fourth : max(left, right, third);
        return max(max(left, right, third), fourth);
    }

    public static int summation(int first, int second) {
        int result = first + second;
        return result;
    }
}