package ru.job4j.tracker;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class DeleteActionTest {

    @Test
    public void whenDeleteExecuteThenNoMoreItemInStore() {
        Output out = new StubOutput();
        Input input = mock(Input.class);
        DeleteAction action = new DeleteAction(out);
        Store tracker = new MemTracker();
        String ls = System.lineSeparator();
        tracker.add(new Item("Test item"));
        when(input.askInt(any(String.class))).thenReturn(1);
        action.execute(input, tracker);
        assertThat(out.toString(), is("=== Delete item ===" + ls + "Item deleted successfully." + ls));
        assertThat(tracker.findAll(), empty());
    }

    @Test
    public void whenDeleteWrongIdThenNoMoreItemInStore() {
        Output out = new StubOutput();
        Input input = mock(Input.class);
        DeleteAction action = new DeleteAction(out);
        Store tracker = new MemTracker();
        String ls = System.lineSeparator();
        tracker.add(new Item("Test item"));
        when(input.askInt(any(String.class))).thenReturn(9);
        action.execute(input, tracker);
        assertThat(out.toString(), is("=== Delete item ===" + ls + "Error while deleting item." + ls));
        assertThat(tracker.findById(1).getName(), is("Test item"));
    }


}