package _case_study.furama_resort.services.facility_management;

import _case_study.furama_resort.controllers.FuramaController;

import java.util.Scanner;

public class FacilityManagement {
    public Scanner input(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public void display(){
        while (true){
            System.out.println("-----Menu-----");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Edit facility");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    new FuramaController().displayMainMenu();
                    break;
            }
        }

    }
}
