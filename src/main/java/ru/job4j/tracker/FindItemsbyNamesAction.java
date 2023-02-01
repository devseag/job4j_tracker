package ru.job4j.tracker;

public class FindItemsbyNamesAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Names";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        System.out.print("Enter name: ");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item with name: " + name + " is not found.");
        }

        return true;
    }
}