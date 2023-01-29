package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hey, what do you want from me? ");
        input.nextLine();
        switch (new Random().nextInt(3)) {
            case 0 -> System.out.println("Yes");
            case 1 -> System.out.println("No");
            default -> System.out.println("Maybe");
        }
    }
}
