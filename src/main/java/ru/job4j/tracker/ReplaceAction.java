package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ===");
        //System.out.print("Enter id: ");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        //System.out.print("Enter name: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            out.println("Item edited successfully.");
        } else {
            out.println("Error while editing item.");
        }

        return true;
    }
}