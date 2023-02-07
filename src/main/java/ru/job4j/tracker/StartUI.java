package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
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
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>() {
            {
                add(new CreateAction(output));
                add(new ShowAllAction(output));
                add(new ReplaceAction(output));
                add(new DeleteAction(output));
                add(new FindItembyIdAction(output));
                add(new FindItemsbyNamesAction(output));
                add(new Exit(output));
            }
        };
//        List<UserAction> actions = {
//                new CreateAction(output),
//                new ShowAllAction(output),
//                new ReplaceAction(output),
//                new DeleteAction(output),
//                new FindItembyIdAction(output),
//                new FindItemsbyNamesAction(output),
//                new Exit(output)
//        };
        new StartUI(output).init(input, tracker, actions);
    }
}