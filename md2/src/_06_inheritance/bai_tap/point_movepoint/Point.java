package _06_inheritance.bai_tap.point_movepoint;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
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

    public float[] getXY(){
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
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", getXY= " + Arrays.toString(getXY()) +
                '}';
    }
}
