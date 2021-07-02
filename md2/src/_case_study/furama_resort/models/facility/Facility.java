package _case_study.furama_resort.models.facility;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String nameServices;
    private int area;
    private double rentalCost;
    private int numberOfPeople;
    private String rentOfType;

    public Facility(String nameServices, int area, double rentalCost, int numberOfPeople, String rentOfType) {
        this.nameServices = nameServices;
        this.area = area;
        this.rentalCost = rentalCost;
        this.numberOfPeople = numberOfPeople;
        this.rentOfType = rentOfType;
    }

    public Facility() {
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(float rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getRentOfType() {
        return rentOfType;
    }

    public void setRentOfType(String rentOfType) {
        this.rentOfType = rentOfType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "nameServices='" + nameServices + '\'' +
                ", area=" + area +
                ", rentalCost=" + rentalCost +
                ", numberOfPeople=" + numberOfPeople +
                ", rentOfType='" + rentOfType + '\''
                ;
    }
}
