package _case_study.furama_resort.controllers;


import _case_study.furama_resort.services.booking_contract_management.BookingContractServices;
import _case_study.furama_resort.services.booking_contract_management.ContractServices;
import _case_study.furama_resort.utils.ExceptionCustom;

import java.util.Scanner;

public class BookingContractManagement {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    BookingContractServices b = new BookingContractServices();
    public ExceptionCustom exceptionCustom = new ExceptionCustom();

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
            int choice = ExceptionCustom.choiceNumber();
            switch (choice){
                case 1:
                  b.display();
                    break;
                case 2:
                    b.add();
                    break;
                case 3:
                    new ContractServices().add();
                    break;
                case 4:
                    new ContractServices().display();
                    break;
                case 5:
                    new ContractServices().edit();
                    break;
                case 6:
                    new FuramaController().displayMainMenu();
                    break;
            }
        }

    }
}
