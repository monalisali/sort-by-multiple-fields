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
        //1.原始写法
        Collections.sort(points);

        //2. 用lambda简化
//        Collections.sort(points, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                if(o1.x < o2.x)
//                {
//                    return  -1;
//                }
//                else if(o1.x > o2.x)
//                {
//                    return 1;
//                }
//
//                if(o1.y < o2.y)
//                {
//                    return -1;
//                }
//                else if(o1.y > o2.y)
//                {
//                    return 1;
//                }
//                else {
//                    return 0;
//                }
//            }
//        });

        //3. 用method reference简化
//        Collections.sort(points, Comparator.comparing(Point::getX).thenComparing(Point::getY));
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
        if(this.x < that.x)
        {
            return  -1;
        }
        else if(this.x > that.x)
        {
            return 1;
        }

        if(this.y < that.y)
        {
            return -1;
        }
        else if(this.y > that.y)
        {
            return 1;
        }
        else {
            return 0;
        }
    }
}
