package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0", "Item name", "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", "Item name", "1")));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = {
//                new CreateAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        // assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Dobavim v tracker novuju zajavku */
        Item item = tracker.add(new Item("Replaced item"));
        /* Vhodnye dannye dolzhny soderzhat' ID dobavlennoj zajavki item.getId() */
        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(item.getId()), replacedName, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = {
//                new ReplaceAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Dobavim v tracker novuju zajavku */
        Item item = tracker.add(new Item("Deleted item"));
        /* Vhodnye dannye dolzhny soderzhat' ID dobavlennoj zajavki item.getId() */
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(item.getId()), "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(item.getId()), "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = {
//                new DeleteAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0")));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
//        UserAction[] actions = {
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "=== Exit menu ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(one.getId()), replaceName, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = new UserAction[]{
//                new ReplaceAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Item edited successfully." + ln
                        + "Menu." + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
                        + "=== Exit menu ===" + ln
        );
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(one.getId()), "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(one.getId()), "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = new UserAction[]{
//                new ShowAllAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "==== Show all items ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Exit menu ===" + ln
        );
    }

    @Test
    public void whenFindByNameActionOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String findName = "test1";
//        Input in = new StubInput(
//                new String[]{"0", findName, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", findName, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemsbyNamesAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = new UserAction[]{
//                new FindItemsbyNamesAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find Item by Names" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find Item by Names" + ln
                        + "1. Exit" + ln
                        + "=== Exit menu ===" + ln
        );
    }

    @Test
    public void whenFindByIdActionOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String findId = String.valueOf(one.getId());
//        Input in = new StubInput(
//                new String[]{"0", findId, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", findId, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItembyIdAction(out));
        actions.add(new Exit(out));
//        UserAction[] actions = new UserAction[]{
//                new FindItembyIdAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find by Id Item" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find by Id Item" + ln
                        + "1. Exit" + ln
                        + "=== Exit menu ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"7", "0"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("7", "0")));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
//        UserAction[] actions = new UserAction[]{
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                        + "=== Exit menu ===" + ln
        );
    }
}