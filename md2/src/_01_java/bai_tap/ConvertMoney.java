package _01_java.bai_tap;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter VND");
        double vnd = scanner.nextDouble();
        double dollar;
        dollar = vnd/23000;
        System.out.println("Dollar: " + dollar);
    }
}
