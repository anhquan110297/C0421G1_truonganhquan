package _05_access_modifier_static_method_static_property.bai_tap;

public class TestModifier {
    public static void main(String[] args) {
        AccessModifier test1 = new AccessModifier();
        AccessModifier test2 = new AccessModifier(2.0);
        System.out.println(test1.getRadius());
        System.out.println(test1.getArea());
        System.out.println(test2.getRadius());
        System.out.println(test2.getArea());
    }
}
