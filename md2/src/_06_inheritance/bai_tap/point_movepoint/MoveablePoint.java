package _06_inheritance.bai_tap.point_movepoint;

public class MoveablePoint extends Point {
    private float xSpeed ;
    private float ySpeed ;
    public MoveablePoint(){}
    public MoveablePoint( float xSpeed , float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed (float xSpeed , float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed =ySpeed;
    }
    public float [] getSpeed(){
        return new float[]{super.getX(),super.getY()};
    }
    public MoveablePoint move(){
        super.setX(super.getX()+ xSpeed) ;
        super.setY(super.getY()+ ySpeed) ;
        return this;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                "  " +super.toString()+
                '}';
    }

    public static void main(String[] args) {
        MoveablePoint movablePoint = new MoveablePoint(2,3);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
