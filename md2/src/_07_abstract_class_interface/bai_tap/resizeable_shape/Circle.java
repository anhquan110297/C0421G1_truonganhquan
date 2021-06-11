package _07_abstract_class_interface.bai_tap.resizeable_shape;

import _07_abstract_class_interface.bai_tap.colorable_shape.Shape;
import _07_abstract_class_interface.bai_tap.resizeable_shape.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius=1.0;
    private String color="red";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(double i) {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return radius*radius*Math.PI;

    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle: " + "radius: " +radius +" color: " + color + " area: " +getArea()+"perimeter: " + getPerimeter();
    }

    @Override
    public void resize(double increasePercent) {
        setRadius(getRadius()*increasePercent);
    }
}
