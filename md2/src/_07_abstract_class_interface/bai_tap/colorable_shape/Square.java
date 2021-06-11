package _07_abstract_class_interface.bai_tap.colorable_shape;

public class Square extends Shape implements Colorable{
    double side;
    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void getArea() {
        System.out.println("Square's Area: " + this.side * this.side);

    }

    public void getPerimeter() {
        System.out.println("Square's Perimeter: " + this.side * 4);

    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
