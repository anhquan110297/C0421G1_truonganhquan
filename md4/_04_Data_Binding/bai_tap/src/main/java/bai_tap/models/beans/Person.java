package bai_tap.models.beans;

public class Person {
    private String name;
    private Integer age;
    private boolean gender;
    private String country;
    private String idCard;
    private String[] transport;
    private String idTransport;
    private String idSeat;
    private String startDate;
    private String endDate;
    private String travelCity;
    private String address;
    private String phone;
    private String email;
    private String[] symptom;

    public Person() {
    }

    public Person(String name, int age, boolean gender, String country, String idCard, String[] transport,
                  String idTransport, String idSeat, String startDate, String endDate, String travelCity,
                  String address, String phone, String email, String[] symptom) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.transport = transport;
        this.idTransport = idTransport;
        this.idSeat = idSeat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.travelCity = travelCity;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String[] getTransport() {
        return transport;
    }

    public void setTransport(String[] transport) {
        this.transport = transport;
    }

    public String getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(String idTransport) {
        this.idTransport = idTransport;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTravelCity() {
        return travelCity;
    }

    public void setTravelCity(String travelCity) {
        this.travelCity = travelCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }
}
