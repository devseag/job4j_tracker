package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        System.out.print("Enter name: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            System.out.println("Item edited successfully.");
        } else {
            System.out.println("Error while editing item.");
        }

        return true;
    }
}