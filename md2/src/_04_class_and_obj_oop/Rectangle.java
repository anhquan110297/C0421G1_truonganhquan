package _04_class_and_obj_oop;

public class Rectangle {
    double width;
    double height;
    public Rectangle(){

    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public void getArea(){
        System.out.println("Diện tích hình chữ nhật: "+ this.width*this.height);
    }
    public void getPerimeter(){
        System.out.println("Chu vi của tham giác: "+ (this.width+this.height)*2);
    }
    public void displayRectangle(){
        System.out.println("Rectangle{ width: "+ this.width+ "; height: "+ this.height+"}");
    }

    public static void main(String[] args) {
        Rectangle newRectangle = new Rectangle(20,45.5);
        newRectangle.getArea();
        newRectangle.getPerimeter();
        newRectangle.displayRectangle();
    }
    Rectangle rectangle = new Rectangle(10,20);

}