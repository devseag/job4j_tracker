package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Igra 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Pervyj igrok" : "Vtoroj igrok";
            System.out.println(player + " vvedite chislo ot 1 do 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3 && count >= matches) {
                count -= matches;
                turn = !turn;
                System.out.println(player + " took matches:" + matches + " left:" + count);
            } else {
                System.out.println("Please input again a number of matches between 1 and 3"
                        + " do not forget how many matches is left: " + count);
            }
        }
        if (!turn) {
            System.out.println("Vyigral pervyj igrok");
        } else {
            System.out.println("Vyigral vtoroj igrok");
        }
    }
}