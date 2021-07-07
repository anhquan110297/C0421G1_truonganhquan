package _case_study.furama_resort.models.booking_contract;

import java.io.Serializable;

public class Booking implements Comparable<Booking>, Serializable {
    private int idBooking;
    private String startDay;
    private String endDay;
    private int idCustomer;
    private String nameService;
    private String typeOfService;

    public Booking() {
    }

    public Booking(int idBooking, String startDay, String endDay, int idCustomer, String nameService, String typeOfService) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeOfService = typeOfService;
    }

    public int getIdContract() {
        return idBooking;
    }

    public void setIdContract(int idContract) {
        this.idBooking = idContract;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", idCustomer=" + idCustomer +
                ", nameService='" + nameService + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        if (this.getStartDay().equals(o.getStartDay())){
            return this.getEndDay().compareTo(o.getEndDay());
        }
        return this.getStartDay().compareTo(o.getStartDay());
    }
}
