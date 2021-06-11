package _07_abstract_class_interface.thuc_hanh.interface_comparable_shape;

import _06_inheritance.thuc_hanh.shape.Circle;
import javafx.scene.paint.Paint;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
