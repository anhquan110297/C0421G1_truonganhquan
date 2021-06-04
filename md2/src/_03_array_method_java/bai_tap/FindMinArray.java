package _03_array_method_java.bai_tap;

import java.util.Scanner;

public class FindMinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] myArr;
        System.out.println("Please enter size: ");
        int size = scanner.nextInt();
        myArr = new int [size];
        int min =0;
        for (int i =0;i<size;i++){
            if (myArr[i]<min){
                min = myArr[i];
            }
        }
        System.out.println("Min: " + min);
    }
}
