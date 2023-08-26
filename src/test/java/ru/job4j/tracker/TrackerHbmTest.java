package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemThenTrackerHasReplacedItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item itemUpdated = new Item();
            itemUpdated.setId(item.getId());
            itemUpdated.setName("test1update");
            tracker.replace(item.getId(), itemUpdated);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(itemUpdated.getName()));
        }
    }

    @Test
    public void whenDeleteItemThenTrackerHasNoItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result, is(nullValue()));
        }
    }

    @Test
    public void whenFindAllItemThenTrackerHasAllItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Collection<Item> tmp1 = tracker.findAll();
            for (Item item : tmp1) {
                tracker.delete(item.getId());
            }
            Item item1 = new Item();
            item1.setName("test1");
            tracker.add(item1);
            Item item2 = new Item();
            item1.setName("test2");
            tracker.add(item2);
            Collection<Item> result = tracker.findAll();
            assertThat(result.size(), is(2));
        }
    }

    @Test
    public void whenFindByNameItemThenTrackerHasItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Collection<Item> tmp1 = tracker.findAll();
            for (Item item : tmp1) {
                tracker.delete(item.getId());
            }
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Collection<Item> result = tracker.findByName("test1");
            assertThat(result.size(), is(1));
        }
    }

    @Test
    public void whenFindByIdItemThenTrackerHasItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Collection<Item> tmp1 = tracker.findAll();
            for (Item item : tmp1) {
                tracker.delete(item.getId());
            }
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }
}