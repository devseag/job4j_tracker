package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            // out.println(index + ". " + actions[index].name());
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
//        Log4File log = Log4File.getInstance();
//        log.add("add new Item");
//        log.save();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
//        Store tracker = new tracker();
        try (Store tracker = new SqlTracker()) {
//            List<UserAction> actions = new ArrayList<>() {
//            {
//                add(new CreateAction(output));
//                add(new ShowAllAction(output));
//                add(new ReplaceAction(output));
//                add(new DeleteAction(output));
//                add(new FindItembyIdAction(output));
//                add(new FindItemsbyNamesAction(output));
//                add(new Exit(output));
//            }
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new CreateManyItems(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new DeleteAllItems(output),
                    new FindAllAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitAction(output)
            );
//        List<UserAction> actions = {
//                new CreateAction(output),
//                new ShowAllAction(output),
//                new ReplaceAction(output),
//                new DeleteAction(output),
//                new FindItembyIdAction(output),
//                new FindItemsbyNamesAction(output),
//                new Exit(output)
//        };
//        new StartUI(output).init(input, tracker, actions);
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}