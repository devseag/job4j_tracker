package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @org.junit.Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @org.junit.Test
    public void when02to07then5() {
        double expected = 5;
        Point a = new Point(0, 2);
        Point b = new Point(0, 7);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @org.junit.Test
    public void when04to08then4() {
        double expected = 4;
        Point a = new Point(0, 4);
        Point b = new Point(0, 8);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when06to05then1() {
        double expected = 1;
        Point a = new Point(0, 6);
        Point b = new Point(0, 5);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

}