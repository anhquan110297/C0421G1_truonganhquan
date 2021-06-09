package _06_inheritance.thuc_hanh.shape;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5);
        System.out.println(circle);
        circle = new Circle("red", false, 3.5);
        System.out.println(circle);
    }
}
