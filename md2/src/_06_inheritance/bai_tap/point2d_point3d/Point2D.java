package _06_inheritance.bai_tap.point2d_point3d;

import java.awt.*;
import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float [] array = {this.x,this.y};
        System.out.println("array[0]"+"array[1]");
        return array;
    }

    public void setXY(float x, float y) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                "getXY" + Arrays.toString(getXY())
                ;
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(2,3);
        System.out.println(point2D);
        System.out.println(point2D.toString());
//        Arrays.toString()

    }

}
