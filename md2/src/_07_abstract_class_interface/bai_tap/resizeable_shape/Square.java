package _07_abstract_class_interface.bai_tap.resizeable_shape;

public class Square implements Resizeable {
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
    public void resize(double increasePercent) {
        setSide(getSide() * increasePercent);
    }
}
