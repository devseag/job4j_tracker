package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition){
        String output;
        output = condition ? "Eaten" : "Ran away";
        System.out.println(output);
    }
}
