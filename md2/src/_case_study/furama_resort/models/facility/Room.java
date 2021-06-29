package _case_study.furama_resort.models.facility;

public class Room extends Facility {
    private String freeServices;

    public Room() {
    }

    public Room(String nameServices, int area, float rentalCost, int numberOfPeople, String rentOfType, String freeServices) {
        super(nameServices, area, rentalCost, numberOfPeople, rentOfType);
        this.freeServices = freeServices;
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return super.toString()+" ,freeService='" + freeServices;
    }
}
