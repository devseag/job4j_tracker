package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = (x) -> x.getName().contains(key);
        Predicate<Person> combineSurname = (x) -> x.getSurname().contains(key);
        Predicate<Person> combinePhone = (x) -> x.getPhone().contains(key);
        Predicate<Person> combineAddress = (x) -> x.getAddress().contains(key);
        var result = new ArrayList<Person>();
        for (var person : persons) {
//            if (pers.getName().contains(key)
//                    || pers.getSurname().contains(key)
//                    || pers.getPhone().contains(key)
//                    || pers.getAddress().contains(key)) {
//                result.add(pers);
//            }
            if (combineName.or(combineSurname)
                    .or(combinePhone)
                    .or(combineAddress)
                    .test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}