package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() throws SQLException {
        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0", "Item name", "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", "Item name", "1")));
//        tracker tracker = new tracker();
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
//        UserAction[] actions = {
//                new CreateAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        // assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
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
        actions.add(new ExitAction(out));
//        UserAction[] actions = {
//                new ReplaceAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        /* Dobavim v tracker novuju zajavku */
        Item item = tracker.add(new Item("Deleted item"));
        /* Vhodnye dannye dolzhny soderzhat' ID dobavlennoj zajavki item.getId() */
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(item.getId()), "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(item.getId()), "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
//        UserAction[] actions = {
//                new DeleteAction(out),
//                new Exit(out)
//        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0")));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
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
    public void whenReplaceItemTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(one.getId()), replaceName, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));
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
    public void whenFindAllActionTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(one.getId()), "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(one.getId()), "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction(out));
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
    public void whenFindByNameActionOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String findName = "test1";
//        Input in = new StubInput(
//                new String[]{"0", findName, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", findName, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
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
    public void whenFindByIdActionOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String findId = String.valueOf(one.getId());
//        Input in = new StubInput(
//                new String[]{"0", findId, "1"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("0", findId, "1")));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
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
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"7", "0"}
//        );
        Input in = new StubInput(new ArrayList<>(List.of("7", "0")));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
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

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===" + ln + "Item edited successfully." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenReplace() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Item edited successfully." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDelete() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Item deleted successfully." + ln));
        assertThat(tracker.findAll().isEmpty(), is(true));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item1 = new Item(1, "First item");
        Item item2 = new Item(2, "Second item");
        tracker.add(item1);
        tracker.add(item2);
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + item2 + ln));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item1 = new Item(1, "First item");
        Item item2 = new Item(2, "Second item");
        tracker.add(item1);
        tracker.add(item2);
        FindByNameAction find = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Second item");

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item2 + ln));
    }
}