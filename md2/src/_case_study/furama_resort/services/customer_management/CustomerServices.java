package _case_study.furama_resort.services.customer_management;

import _case_study.furama_resort.models.person.Customer;

import _case_study.furama_resort.utils.ReadAndWriteFileByStream;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServices implements CustomerServicesInterface {
    ReadAndWriteFileByStream<Customer> rawfbs = new ReadAndWriteFileByStream<>();
    public static List<Customer> customers = new LinkedList<>();
    static boolean check = false;
    private static final String FILE_PATH = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\customer.csv";

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    @Override
    public void add() {
        customers = (List<Customer>) rawfbs.readFileByByteStream(FILE_PATH);
        int id;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            id = customers.get(customers.size() - 1).getId() + 1;
        }
        System.out.println("Enter name");
        String name = input().nextLine();
        System.out.println("Enter DateOfBirth");
        String dateOfBirth = input().nextLine();
        System.out.println("Enter Gender");
        String gender = input().nextLine();
        System.out.println("Enter idNo");
        int idNo = input().nextInt();
        System.out.println("Enter Telephone Number");
        int telePhoneNumber = input().nextInt();
        System.out.println("Enter Email");
        String email = input().nextLine();
        System.out.println("Enter typeOfGuest");
        String typeOfGuest = input().nextLine();
        System.out.println("Enter address");
        String address = input().nextLine();
        Customer customer = new Customer(id, name, dateOfBirth, gender, idNo, telePhoneNumber, email, typeOfGuest, address);
        customers.add(customer);
        rawfbs.writeFileByByteStream(customers, FILE_PATH);
    }

    @Override
    public void delete() {
    }

    @Override
    public void edit() {
        customers = (List<Customer>) rawfbs.readFileByByteStream(FILE_PATH);
        System.out.println("Please enter customer's id you want to edit");
        int id = input().nextInt();
        for (Customer n : customers) {
            if (id == n.getId()) {
                System.out.println("Enter name");
                String name = input().nextLine();
                System.out.println("Enter DateOfBirth");
                String dateOfBirth = input().nextLine();
                System.out.println("Enter Gender");
                String gender = input().nextLine();
                System.out.println("Enter idNo");
                int idNo = input().nextInt();
                System.out.println("Enter Telephone Number");
                int telePhoneNumber = input().nextInt();
                System.out.println("Enter Email");
                String email = input().nextLine();
                System.out.println("Enter Type Of Guest");
                String typeOfGuest = input().nextLine();
                System.out.println("Enter Address");
                String address = input().nextLine();
                n.setName(name);
                n.setDateOfBirth(dateOfBirth);
                n.setGender(gender);
                n.setIdNo(idNo);
                n.setTelephoneNumber(telePhoneNumber);
                n.setEmail(email);
                n.setTypeOfGuest(typeOfGuest);
                n.setAddress(address);
                check = true;
                customers = (List<Customer>) rawfbs.readFileByByteStream(FILE_PATH);
                rawfbs.writeFileByByteStream(customers, FILE_PATH);
                break;
            }
        }
        if (check) {
            System.out.println("Please re-enter id");
        }
    }

    @Override
    public void display() {
        customers = (List<Customer>) rawfbs.readFileByByteStream(FILE_PATH);
        if (customers == null) {
            System.err.println("customer's list is empty");
        } else {
            for (Customer n : customers) {
                System.out.println(n);
            }
        }
    }
}
