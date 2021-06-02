package _01_java.thuc_hanh;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Weight");
        float weight = scanner.nextFloat();

        System.out.println("Please Enter Height");
        float height = scanner.nextFloat();

        System.out.println("BMI: ");
        double bmi;
        bmi = (weight / Math.pow(height, 2));
        if (bmi < 18.5) {
            System.out.println(bmi + " Underweight");

        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println(bmi + " Normal");

        } else if (bmi >= 25 && bmi < 30) {
            System.out.println(bmi + " Overweight");
        } else {
            System.out.println(bmi + " Obese");
        }

    }
}
