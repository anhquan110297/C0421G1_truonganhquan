package models;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String address;
    private String imgSrc;

    public Customer(String name, String dateOfBirth, String address, String imgSrc) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.imgSrc = imgSrc;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
