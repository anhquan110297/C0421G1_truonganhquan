package models.bean.employee;

import models.bean.Person;

public class Employee extends Person {
    private double salary;
    private int positionID;
    private int divisionID;
    private int educationDegreeID;
    private String userName;

    public Employee() {
    }

    public Employee(int id, String name, String birthDay, String idCard, String email, String phone, String address, double salary, int positionID, int divisionID, int educationDegreeID, String userName) {
        super(id, name, birthDay, idCard, email, phone, address);
        this.salary = salary;
        this.positionID = positionID;
        this.divisionID = divisionID;
        this.educationDegreeID = educationDegreeID;
        this.userName = userName;
    }

    public Employee(int id, String name, String birthDay, String idCard, String email, String phone, String address, double salary, int positionID, int divisionID, int educationDegreeID) {
        super(id, name, birthDay, idCard, email, phone, address);
        this.salary = salary;
        this.positionID = positionID;
        this.divisionID = divisionID;
        this.educationDegreeID = educationDegreeID;
    }

    public Employee(String name, String birthDay, String idCard, String email, String phone, String address, double salary, int positionID, int divisionID, int educationDegreeID) {
        super(name, birthDay, idCard, email, phone, address);
        this.salary = salary;
        this.positionID = positionID;
        this.divisionID = divisionID;
        this.educationDegreeID = educationDegreeID;
    }

    public Employee(String name, String birthDay, String idCard, String email, String phone, String address, double salary, int positionID, int divisionID, int educationDegreeID, String userName) {
        super(name, birthDay, idCard, email, phone, address);
        this.salary = salary;
        this.positionID = positionID;
        this.divisionID = divisionID;
        this.educationDegreeID = educationDegreeID;
        this.userName = userName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public int getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(int educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
