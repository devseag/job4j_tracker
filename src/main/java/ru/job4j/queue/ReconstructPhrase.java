package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = evenElements.size();
        //while (evenElements.iterator().hasNext()) {
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        //while (descendingElements.iterator().hasNext()) {
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(descendingElements.pollLast());
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}