package ru.job4j.tracker;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemSortTest {
    List<Item> items = new ArrayList(List.of(
            "s",
            "b",
            "t",
            "f"
    ));
    List<Item> expected = new ArrayList(List.of(
            "b",
            "f",
            "s",
            "t"
    ));
    Collections.sort(items, new ItemAscByName());
}