package _case_study.furama_resort.controllers;

import _case_study.furama_resort.controllers.FuramaController;
import _case_study.furama_resort.services.employee_management.EmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public void display(){
        while (true){
            System.out.println("-----Menu-----");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new EmployeeService().display();
                    break;
                case 2:
                    new EmployeeService().add();
                    break;
                case 3:
                    new EmployeeService().edit();
                    break;
                case 4:
                    new FuramaController().displayMainMenu();
                    break;
                default:
                    System.out.println("Wrong type");
                    break;
            }
        }

    }
}
