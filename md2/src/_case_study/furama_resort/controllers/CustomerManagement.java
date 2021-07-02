package _case_study.furama_resort.controllers;

import _case_study.furama_resort.controllers.FuramaController;
import _case_study.furama_resort.services.customer_management.CustomerServices;

import java.util.Scanner;

public class CustomerManagement {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public void display(){
        while (true){
            System.out.println("-----Menu-----");
            System.out.println("1. Display list customer");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new CustomerServices().display();
                    break;
                case 2:
                    new CustomerServices().add();
                    break;
                case 3:
                    new CustomerServices().edit();
                    break;
                case 4:
                    new FuramaController().displayMainMenu();
                    break;
                default:
                    System.out.println("Wrong Type");
                    break;
            }
        }

    }
}
