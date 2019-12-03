package com.github.hcsp.polymorphism;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    // 代表笛卡尔坐标系中的一个点
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }


    // 按照先x再y，从小到大的顺序排序
    // 例如排序后的结果应该是 (-1, 1) (1, -1) (2, -1) (2, 0) (2, 1)
    public static List<Point> sort(List<Point> points) {
        Collections.sort(points);
        return points;
    }


    public static void main(String[] args) throws IOException {
        List<Point> points =
                Arrays.asList(
                        new Point(2, 0),
                        new Point(-1, 1),
                        new Point(1, -1),
                        new Point(2, 1),
                        new Point(2, -1));
        System.out.println(Point.sort(points));
    }

    @Override
    public int compareTo(Point that) {
        Class cls1 = this.getClass();
        Class cls2 = that.getClass();
        Field[] fields1 = cls1.getDeclaredFields();
        Field[] fields2 = cls2.getDeclaredFields();
        for (int i = 0; i < fields1.length; i++) {
            Field f1 = fields1[i];
            Field f2 = fields2[i];
            f1.setAccessible(true);
            f2.setAccessible(true);
            Object x1 = null;
            Object x2 = null;
            try {
                x1 = f1.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                x2 = f2.get(that);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Integer x1ToInt = Integer.parseInt(x1.toString());
            Integer x2ToInt = Integer.parseInt(x2.toString());

            if (x1ToInt < x2ToInt) {
                return -1;
            } else if (x1ToInt > x2ToInt) {
                return 1;
            }

        }
        return 0;
    }
}
