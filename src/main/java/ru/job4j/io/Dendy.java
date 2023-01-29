package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Igry.");
            System.out.println("1. Tanchiki");
            System.out.println("2. Super Mario");
            System.out.println("3. Vyjti");
            System.out.print("Vvedite punkt menju, chtoby nachat' igru: ");
            int select = Integer.parseInt(input.nextLine());
            if (select == 3) {
                System.out.println("Igra zavershena.");
                run = false;
            } else if (select == 1) {
                System.out.println("Tanchiki zagruzhajutsja ... ");
            } else if (select == 2) {
                System.out.println("Super Mario zagruzhaetsja ... ");
            } else {
                System.out.println("Takoj igry net.");
            }
            System.out.println();
        }
    }
}