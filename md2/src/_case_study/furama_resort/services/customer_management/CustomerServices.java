package _case_study.furama_resort.services.customer_management;

import _case_study.furama_resort.models.person.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServices implements CustomerServicesInterface {
    public static List<Customer> linkedList = new LinkedList<>();
    static boolean check = false;
    static {
        Customer customer1 = new Customer(1,"Versace","11/02/97","Male",201751601,190473837,"customer1@gmail.com","Diamond","Da Nang");
        Customer customer2 = new Customer(2,"Ysl","1/02/97","Female",201751501,107173837,"customer2@gmail.com","Platinium","HCM");
        Customer customer3 = new Customer(3,"D&G","15/02/97","Male",201751301,109477537,"customer3@gmail.com","Gold","Ha Noi");
        linkedList.add(customer1);
        linkedList.add(customer2);
        linkedList.add(customer3);
    }

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    @Override
    public void add() {
        System.out.println("Enter id");
        int id = input().nextInt();
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
        Customer customer = new Customer(id,name,dateOfBirth,gender,idNo,telePhoneNumber,email,typeOfGuest,address);
        linkedList.add(customer);

    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {
        System.out.println("Please enter employee's id you want to edit");
        int id = input().nextInt();
        for (Customer n : linkedList) {
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
                break;
            }
        }
        if (check) {
            System.out.println("Please re-enter id");
        }
    }

    @Override
    public void display() {
        for (Customer n : linkedList){
            System.out.println(n);
        }
    }

}
