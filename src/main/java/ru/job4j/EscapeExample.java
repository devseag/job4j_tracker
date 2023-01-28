package ru.job4j;

public class EscapeExample {
    public static void main(String[] args) {
        String str = "I learn on \"Job4j\" how to escape symbols";
        System.out.println(str);
        char escape = '\"';
        System.out.println(escape);
        System.out.println('\'');
        String str1 = "I learn on 'Job4j' how to escape symbols";
        System.out.println(str1);
        String str2 = "C:\\projects\\job4j\\File.java";
        System.out.println(str2);
        String str3 = "Old long text\r";
        System.out.print(str3);
        System.out.println("New text");
        System.out.print("First string\nSecond string");
        System.out.println("No tab");
        System.out.println("\tOne tab");
        System.out.println("\t\tTwo tab");
        System.out.println("Job4jjj\b\b");

    }
}