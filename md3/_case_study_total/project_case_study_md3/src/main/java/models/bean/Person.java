package models.bean;

public class Person {
    private int id;
    private String name;
    private String birthDay;
    private String idCard;
    private String email;
    private String phone;
    private String address;

    public Person() {
    }

    public Person(String name, String birthDay, String idCard, String email, String phone, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Person(int id, String name, String birthDay, String idCard, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
