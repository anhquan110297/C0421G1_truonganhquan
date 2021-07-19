package _thi_module2.utils;

import java.util.Scanner;

public class ExceptionCustom extends Exception {
    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static int choiceNumber() {
        boolean checkValid = false;
        int choice = 0;
        String line;
        while (!checkValid) {
            line = input().nextLine();
            if (line.trim().equals("")){
                System.out.println(" Warning Blank!!!!");
                continue;
            }
            try {
                choice = Integer.parseInt(line);
                checkValid = true;
            } catch (NumberFormatException e) {
                System.out.println("You must re-enter");
            }
        }
        return choice;
    }
}
