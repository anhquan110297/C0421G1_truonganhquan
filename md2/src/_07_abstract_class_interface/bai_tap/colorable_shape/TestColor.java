package _07_abstract_class_interface.bai_tap.colorable_shape;

import _07_abstract_class_interface.bai_tap.resizeable_shape.Circle;
import _07_abstract_class_interface.bai_tap.resizeable_shape.Rectangle;

public class TestColor {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[3];
        shapes[0] = new Square(1);
        shapes[1] = new Circle(3,"red");
        shapes[2] = new Rectangle(4,5);
        for (Shape shape1 : shapes){
            if (shape1 instanceof Colorable){
                ((Colorable) shape1).howToColor();
            }else {
                System.out.println(shape1);
            }
        }
    }

}
