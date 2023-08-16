package ru.job4j.tracker;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ===");
        int count = input.askInt("Vvedite kol-vo zajavok ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Zajavka № " + i));
        }
        out.println("Dobavleno zajavok: " + count);
        return true;
    }
}