package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
        System.out.println(formatter.format(item.getCreated()));
        Item item1 = new Item(1, "Boom");
        System.out.println(item1);
    }

}
