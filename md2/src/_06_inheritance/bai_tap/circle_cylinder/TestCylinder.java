package _06_inheritance.bai_tap.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(3.5,"blue",4.0);
        System.out.println(cylinder);
        System.out.println(cylinder.getVolume());
    }
}
