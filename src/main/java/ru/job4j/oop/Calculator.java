package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(sum(y) + minus(y) + divide(y) + multiply(y));
    }

    public int multiply(int a) {
        return x * a;
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        System.out.println(minus(15));
        System.out.println(calculator.divide(20));
        System.out.println(calculator.sumAllOperation(30));
    }
}