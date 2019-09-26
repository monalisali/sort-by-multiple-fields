package com.github.hcsp.polymorphism;


import com.sun.org.apache.xpath.internal.objects.XObject;

import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

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

//    public static <Point> void swap(List<Point> list,int index1,int index2){//交换位置的方法
//        Point e=list.get(index1);
//            list.set(index1, list.get(index2));
//            list.set(index2,e);
//    }

    // 按照先x再y，从小到大的顺序排序
    // 例如排序后的结果应该是 (-1, 1) (1, -1) (2, -1) (2, 0) (2, 1)
    public static List<Point> sort(List<Point> points) {

        //不使用comparable接口，使用冒泡排序进行数组的排序
//        int len = points.size();
//        for (int i=0;i<len-1;i++){
//            for (int j=0;j < (len - 1 - i);j++){//先对X进行冒泡排序
//                if(points.get(j).x>points.get(j+1).x){
//                    swap(points,j,j+1);//交换两个数组的位置
//                }else if (points.get(j).x==points.get(j+1).x){//对Y进行排序
//                    if (points.get(j).y>points.get(j+1).y){
//                        swap(points,j,j+1);//交换两个数组的位置
//                    }
//                }
//            }
//        }
//        return points;
        Collections.sort(points);
        return points;
    }

    @Override
    public int compareTo(Point otherPoint){
        if (this.x > otherPoint.x){
            return 1;
        }else if (this.x == otherPoint.x){
            if (this.y > otherPoint.y){
                return 1;
            }else if (this.y == otherPoint.y){
                return 0;
            }else{
                return -1;
            }
        }else{
            return -1;
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

