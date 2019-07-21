package com.github.hcsp.polymorphism;

import java.io.IOException;
import java.util.*;

public class Point implements Comparable<Point>{

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
        // 不需要自己去 比较，利用已有数据类型可以快速完成排序，只需实现好 Point类的 compareTo方法
        TreeSet<Point> tree = new TreeSet<>(points);
        // 原来不用记住很多API也能快速解决问题啊，真香!
        return Collections.list(Collections.enumeration(tree));
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
    public int compareTo(Point o) {
        if(((Integer) x).compareTo(o.x) == 0){
            return ((Integer) y).compareTo(o.y);
        }else {
           return ((Integer) x).compareTo(o.x);
        }
    }
}
