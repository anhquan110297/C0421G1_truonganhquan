package _case_study.furama_resort.services.booking_contract_management;

import _case_study.furama_resort.models.booking_contract.Booking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class BookingContractServices implements BookingContractInterface {
    public static Scanner input (){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
    static {
        Booking booking1 = new Booking(1,"1/1/2021","2/1/2021",1,"Car","hihi");
    }
}
