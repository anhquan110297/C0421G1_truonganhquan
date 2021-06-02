package _02_loop.thuc_hanh;

import java.util.Scanner;

public class ApplicationBorrowMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter month: ");
        int month = scanner.nextInt();
        System.out.println("Please enter interestRate: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Please enter money: ");
        double money = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * ((interestRate / 100) / 12) * month;
        }
        System.out.println(totalInterest);

    }
}
