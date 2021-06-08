package _05_access_modifier_static_method_static_property.bai_tap;

public class TestStudents {
    public static void main(String[] args) {
        Students objOne = new Students();
        objOne.setName("Nam");
        objOne.setClasses("SO2");
        System.out.println(objOne.getName());
        System.out.println(objOne.getClasses());
    }
}
