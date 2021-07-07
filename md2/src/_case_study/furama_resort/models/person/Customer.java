package _case_study.furama_resort.models.person;

public class Customer extends Person {
    private String typeOfGuest;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirth, String gender, int idNo, int telephoneNumber, String email, String typeOfGuest, String address) {
        super(id, name, dateOfBirth, gender, idNo, telephoneNumber, email);
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }


    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                "typeOfGuest='" + typeOfGuest + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
