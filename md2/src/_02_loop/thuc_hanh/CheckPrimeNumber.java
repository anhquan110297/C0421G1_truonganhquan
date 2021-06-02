package _02_loop.thuc_hanh;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number");
        int number = scanner.nextInt();
        if (number<2){
            System.out.println("Number is not prime number");
        }else {
            int i = 2;
            boolean check = true;
            while (i<number){
                if (number % i == 0){
                    check = false;
                    break;
                }
                i++;

            }
            if (check){
                System.out.println("number is prime number");
            }else {
                System.out.println("number is not prime number");
            }
        }
    }
}
