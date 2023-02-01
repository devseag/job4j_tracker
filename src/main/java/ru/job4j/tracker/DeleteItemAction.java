package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Error while deleting item.");
        }

        return true;
    }
}