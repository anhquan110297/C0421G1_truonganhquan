package _case_study.furama_resort.models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private int poolArea;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String nameServices, int area, float rentalCost, int numberOfPeople, String rentOfType, String roomStandard, int poolArea, int numberOfFloor) {
        super(nameServices, area, rentalCost, numberOfPeople, rentOfType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString()+" ,roomStandard='" + roomStandard + " ,poolArea='" + poolArea +" ,numberOfFloor='" + numberOfFloor +" " + '}';
    }
}
