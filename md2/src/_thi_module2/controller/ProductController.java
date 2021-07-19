package _thi_module2.controller;

import _thi_module2.services.ProductServiceImpl;
import _thi_module2.utils.ExceptionCustom;

import java.util.Scanner;

public class ProductController {
    public Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public ExceptionCustom exceptionCustom = new ExceptionCustom();

    public void displayMainMenu() {
        while (true) {
            System.out.println("-----Menu Product Management-----");
            System.out.println("1. Add new product");
            System.out.println("2. Delete new product");
            System.out.println("3. Display product's list");
            System.out.println("4. Search product");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = ExceptionCustom.choiceNumber();
            switch (choice) {
                case 1:
                    new ProductServiceImpl().add();
                    break;
                case 2:
                    new ProductServiceImpl().delete();
                    break;
                case 3:
                    new ProductServiceImpl().display();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong type");
                    break;
            }
        }
    }
}
