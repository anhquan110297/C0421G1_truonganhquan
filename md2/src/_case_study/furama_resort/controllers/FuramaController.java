package _case_study.furama_resort.controllers;

import _case_study.furama_resort.utils.ExceptionCustom;

import java.util.Scanner;

public class FuramaController {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public  ExceptionCustom exceptionCustom = new ExceptionCustom();
    public void displayMainMenu(){
        while (true){
            System.out.println("-----Menu-----");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            int choice = ExceptionCustom.choiceNumber();
            switch (choice){
                case 1:
                    new EmployeeManagement().display();
                    break;
                case 2:
                    new CustomerManagement().display();
                    break;
                case 3:
                    new FacilityManagement().display();
                    break;
                case 4:
                    new BookingContractManagement().display();
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong type");
                    break;

            }
        }
    }
}
