package _05_access_modifier_static_method_static_property.bai_tap;

public class AccessModifier {
    private double radius =1.0;
    private String color = "red";
    AccessModifier(){
    }
    AccessModifier(double radius){
        this.radius = radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*2*radius;
    }
}
