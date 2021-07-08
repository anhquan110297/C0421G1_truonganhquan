package _case_study.furama_resort.utils;

import java.util.Scanner;

public class ExceptionCustom extends Exception {
    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static int choiceNumber() {
        boolean checkValid = false;
        int choice = 0;
        while (!checkValid) {
            try {
                choice = Integer.parseInt(input().nextLine());
                checkValid = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number: ");
            }
        }
        return choice;
    }

    public static float choiceNumberFloat() {
        boolean checkValid = false;
        float choice = 0;
        while (!checkValid) {
            try {
                choice = Float.parseFloat(input().nextLine());
                checkValid = true;
            } catch (NumberFormatException e) {
                System.out.print("You must enter a number: ");
            }
        }
        return choice;
    }
}
