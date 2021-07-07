package _case_study.furama_resort.controllers;

import _case_study.furama_resort.controllers.FuramaController;
import _case_study.furama_resort.services.booking_contract_management.BookingContractServices;

import java.util.Scanner;

public class BookingContractManagement {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    BookingContractServices b = new BookingContractServices();
    public void display(){
        while (true){
            System.out.println("-----Menu-----");
            System.out.println("1. Display list booking");
            System.out.println("2. Add new booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println("Enter your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                  b.display();
                    break;
                case 2:
                    b.add();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    new FuramaController().displayMainMenu();
                    break;
            }
        }

    }
}
