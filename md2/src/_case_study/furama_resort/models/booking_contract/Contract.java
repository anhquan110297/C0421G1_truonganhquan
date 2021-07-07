package _case_study.furama_resort.models.booking_contract;

import java.io.Serializable;

public class Contract implements Serializable {
    private int idContract;
    private int idBooking;
    private double depositAmount;
    private double totalAmount;
    private int idGuest;

    public Contract() {
    }

    public Contract(int idContract, int idBooking, double depositAmount, double totalAmount, int idGuest) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.idGuest = idGuest;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", idBooking=" + idBooking +
                ", depositAmount=" + depositAmount +
                ", totalAmount=" + totalAmount +
                ", idGuest=" + idGuest +
                '}';
    }
}
