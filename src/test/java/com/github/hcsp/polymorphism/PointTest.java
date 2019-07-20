package com.github.hcsp.polymorphism;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    public void test1() {
        List<Point> points =
                Arrays.asList(
                        new Point(2, 0),
                        new Point(-1, 1),
                        new Point(1, -1),
                        new Point(2, 1),
                        new Point(2, -1));
        Assertions.assertEquals(
                Arrays.asList(
                        new Point(-1, 1),
                        new Point(1, -1),
                        new Point(2, -1),
                        new Point(2, 0),
                        new Point(2, 1)),
                Point.sort(points));
    }

    @Test
    public void test2() {
        List<Point> points =
                Arrays.asList(
                        new Point(1234567890, -1234567890), new Point(-1234567890, 1234567890));
        Assertions.assertEquals(
                Arrays.asList(
                        new Point(-1234567890, 1234567890), new Point(1234567890, -1234567890)),
                Point.sort(points));
    }
}
