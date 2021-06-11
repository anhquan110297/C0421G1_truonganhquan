package _07_abstract_class_interface.bai_tap.resizeable_shape;

public class TestResizeable {
    public static void main(String[] args) {
        double percent = Math.random() * 100;
        Resizeable[] resizeable = new Resizeable[3];
        resizeable[0] = new Circle(4, "red");
        resizeable[1] = new Square(4);
        resizeable[2] = new Rectangle(4, 6);
        System.out.println("After array reszie");
        for (Resizeable resizeable1 : resizeable) {
            System.out.println(resizeable1.toString());
        }
        System.out.println("Before array reszie");
        for (Resizeable resizeable2 : resizeable) {
            resizeable2.resize(percent);
            System.out.println(resizeable2.toString());
        }
    }
}
