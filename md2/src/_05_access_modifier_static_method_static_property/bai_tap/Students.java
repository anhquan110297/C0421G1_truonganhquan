package _05_access_modifier_static_method_static_property.bai_tap;

public class Students {
    private String name = "John";
    private String classes = "CO2";

    public Students() {
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setClasses(String newClass) {
        this.classes = newClass;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
