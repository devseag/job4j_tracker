package ru.job4j.search;

import java.util.LinkedList;

/**
 * Klass opisyvaet rabotu prostejshej ocheredi po prioritetu, kotoraja rabotaet
 * po principu FIFO (first in - first out)
 * @author DEVSEAG
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Hranenie zadanija osushhestvljaetsja v kollekcii tipa LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Metod prinimaet na vhod zajavku i dobavljaet ee v ochered'.
     * Esli vstrechajutsja 2 zadanija s odinakovym prioritetom, to v ocheredi
     * oni raspredeljajutsja po principu FIFO.
     * @param task zadacha kotoraja dobavljaetsja v ochered'
     */
    public void put(Task task) {
        int index = 0;
        for (Task current  : tasks) {
            if (task.getPriority() < current.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    /**
     * Metod pozvoljaet poluchit' pervuju zadachu v ocheredi
     * @return vozvrashhaet zadachu iz golovy ocheredi ili null esli ochered' pusta
     */
    public Task take() {
        return tasks.poll();
    }
}