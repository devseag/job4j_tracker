package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemSortTest {
    @Test
    public void whenAskList() {
        List<Item> list = new ArrayList<>() {
            {
                add(new Item("s"));
                add(new Item("b"));
                add(new Item("t"));
                add(new Item("f"));
            }
        };
        List<Item> expected = new ArrayList<>() {
            {
                add(new Item("b"));
                add(new Item("f"));
                add(new Item("s"));
                add(new Item("t"));
            }
        };
        Collections.sort(list, new ItemAscByName());
        assertEquals(list, expected);
    }

    @Test
    public void whenDeskList() {
        List<Item> list = new ArrayList<>() {
            {
                add(new Item("s"));
                add(new Item("b"));
                add(new Item("t"));
                add(new Item("f"));
            }
        };
        List<Item> expected = new ArrayList<>() {
            {
                add(new Item("t"));
                add(new Item("s"));
                add(new Item("f"));
                add(new Item("b"));
            }
        };
        Collections.sort(list, new ItemDescByName());
        assertEquals(list, expected);
    }
}