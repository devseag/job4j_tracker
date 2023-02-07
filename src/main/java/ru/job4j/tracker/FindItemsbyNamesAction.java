package ru.job4j.tracker;

import java.util.List;

public class FindItemsbyNamesAction implements UserAction {
    private final Output out;

    public FindItemsbyNamesAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Names";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        System.out.print("Enter name: ");
        String name = input.askStr("Enter name: ");
        //Item[] items = tracker.findByName(name);
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Item with name: " + name + " is not found.");
        }

        return true;
    }
}