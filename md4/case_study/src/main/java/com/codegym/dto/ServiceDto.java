package com.codegym.dto;

import com.codegym.models.entity.service.RentType;
import com.codegym.models.entity.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ServiceDto {
    private Long id;
    @NotBlank(message = "You must input something")
    private String name;
    @NotNull(message = "You must input something")
    @Min(value = 0, message = "Area must be positive")
    private int area;
    @NotNull(message = "You must input something")
    @Min(value = 0,message = "Cost must be positive")
    private double cost;
    @NotNull(message = "You must input something")
    @Min(value = 0,message = "Capacity must be positive")
    private int capacity;
    private RentType rentType;
    private ServiceType serviceType;
    @NotEmpty(message = "You must input something")
    private String standard;
    @NotEmpty(message = "You must input something")
    private String description;
    @NotNull(message = "You must input something")
    @Min(value = 0, message = "Pool area must be positive")
    private double poolArea;
    @NotNull(message = "You must input something")
    @Min(value = 0, message = "Pool area must be positive")
    private int floor;

    public ServiceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
