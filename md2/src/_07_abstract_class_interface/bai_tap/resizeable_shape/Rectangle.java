package _07_abstract_class_interface.bai_tap.resizeable_shape;

import _07_abstract_class_interface.bai_tap.colorable_shape.Shape;

public class Rectangle extends Shape implements Resizeable{
        double width;
        double height;

        public Rectangle() {
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public void getArea() {
            System.out.println("Area: " + this.width * this.height);
        }

        public void getPerimeter() {
            System.out.println("Perimeter: " + (this.width + this.height) * 2);

        }

        @Override
        public void resize(double increasePercent) {
            setWidth(getWidth() * increasePercent);
            setHeight(getHeight() * increasePercent);
        }
}


