package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("First song");
        }
        else if (position == 2) {
            System.out.println("Good bye");
        }
        else {
            System.out.println("No song");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(3);
    }
}
