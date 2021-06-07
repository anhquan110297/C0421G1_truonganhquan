package _04_class_and_obj_oop.bai_tap;

public class ClassFan {
    final int SlOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SlOW ;
    private boolean isOn = false;
    private double radius = 3;
    private String color = "Blue";
    public ClassFan (int speed , boolean isOn , double radius , String color){
        this.speed =speed;
        this.isOn = isOn;
        this.radius=radius;
        this.color =color;
    }
    public int getSlOW() {
        return SlOW;
    }
    public int getMEDIUM() {
        return MEDIUM;
    }
    public int getFAST() {
        return FAST;
    }
    public String getSpeed(){
        String speedFan = "";
        if ( this.isOn == true) {
            if (this.speed == getSlOW()) {
                return speedFan = "SlOW";
            } else if (this.speed == getMEDIUM()) {
                return speedFan = "MEDIUM";
            } else if (this.speed == getFAST()) {
                return speedFan = "FAST";
            }
        }else {
            return  speedFan = "";
        }
        return speedFan;
    }
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public String isOn() {
        String status = "";
        if (isOn == true) {
            status = "Turn ON";
        } else {
            status = "Turn OFF";
        }
        return status;
    }

    @Override
    public String toString() {
        return "XayDungLopFan{" +
                "speed = " + getSpeed() +
                ", isOn = " + isOn() +
                ", radius = " + getRadius() +
                ", color = '" + getColor() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ClassFan xayDungLopFan = new ClassFan(2,true,5,"pink");
        System.out.println(xayDungLopFan.toString());
    }

}
