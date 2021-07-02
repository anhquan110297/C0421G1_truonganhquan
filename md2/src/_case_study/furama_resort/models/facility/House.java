package _case_study.furama_resort.models.facility;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloor;

    public House() {
    }

    public House(String nameServices, int area, float rentalCost, int numberOfPeople, String rentOfType, String roomStandard, int numberOfFloor) {
        super(nameServices, area, rentalCost, numberOfPeople, rentOfType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString()+" ,roomStandard='" + roomStandard + " ,numberOfFloor='" + numberOfFloor +" " + '}';
    }
}
