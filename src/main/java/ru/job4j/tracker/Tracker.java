package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    //private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        // return Arrays.copyOf(items, size);
        return List.copyOf(items);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < items.size(); index++) {
            //Item item = items[index];
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        // int count = 0;
        for (Item item : items) {
            //Item item = items[i];
            if (item.getName().equals(key)) {
                result.add(item);
                //count++;
            }
        }
        //return Arrays.copyOf(result, count);
        return List.copyOf(result);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            // if (items[index].getId() == id) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.add(item);
            items.remove(index);
            //items[index].setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            //System.arraycopy(items, index + 1, items, index, items.size() - index - 1);
            //items[size - 1] = null;
            items.remove(index);
            //size--;
        }
        return result;
    }
}