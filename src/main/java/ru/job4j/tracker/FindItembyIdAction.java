package ru.job4j.tracker;

public class FindItembyIdAction implements UserAction {
    private final Output out;

    public FindItembyIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Item with id: " + id + " is not found.");
        }

        return true;
    }
}