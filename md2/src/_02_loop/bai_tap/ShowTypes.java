package _02_loop.bai_tap;

import java.util.Scanner;

public class ShowTypes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                for (int i = 1; i <= 3; i++) {
                    for (int j = 1; j <= 6; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Square triangle: top-left");
                for (int i = 0; i < 5; i++) {
                    for (int j = (5 - i); j > 0; j--) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println("Square triangle: top-right");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= 5; j++) {
                        if (j > i) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("Square triangle: bottom-right");
                for (int i = 1; i <= 5; i++) {
                    for (int j = 5; j > 0; j--) {
                        if ((j <= i)) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("Square triangle: bottom-left");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            case 3:
                System.out.println("Print isosceles triangle");
                for (int i=1;i<=3;i++){
                    for (int j=1;j<=5;j++){
                        if (i == 1 || i == j || i ==2 && j==4 ||i ==2 && j==3 ){
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 0:
                System.exit(1);
        }
    }
}

