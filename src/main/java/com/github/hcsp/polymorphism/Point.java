package com.github.hcsp.polymorphism;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Point implements Comparable<Point>{

    private final Integer x;
    private final Integer y;
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

        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
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
    /*
        @Override
        public int compareTo(Point point) {
            if (x < point.x) {
                return -1;
            } else if (x > point.x) {
                return 1;
            } else if (y < point.y) {
                return -1;
            } else if (y > point.y) {
                return 1;
            } else {
                return 0;
            }
        }
    */
    @Override
    public int compareTo(Point point) {
        int compareReasult = x.compareTo(point.x);
        if (compareReasult != 0) {
            return compareReasult;
        } else {
            return y.compareTo(point.y);
        }
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
}
