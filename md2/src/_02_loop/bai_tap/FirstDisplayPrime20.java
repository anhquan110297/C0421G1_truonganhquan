package _02_loop.bai_tap;

import java.util.Scanner;

public class FirstDisplayPrime20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter numbers prime: ");
        int userPrimeNumbers = input.nextInt();
        int run = 2;
        int countPrime = 0;
        while (true) {
            int count = 0;
            for (int i = 1; i <= run; i++) {
                if (run % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(run);
                countPrime++;
            }
            if (countPrime == userPrimeNumbers) {
                break;
            }
            run++;
        }

    }
}

