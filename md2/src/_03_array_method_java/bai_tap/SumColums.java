package _03_array_method_java.bai_tap;

import java.util.Scanner;

public class SumColums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] myArr = {
                {4,6,1},
                {8,9,3},
                {1,6,5}
        };
        System.out.println("Enter your choice");
        System.out.println("sum of first column: Press '1' ");
        System.out.println("sum of second column: Press '2'  ");
        System.out.println("sum of third column: Press '3'  ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                int sum1 = 0;
                for (int i=0;i<myArr.length;i++){
                        sum1 += myArr[i][0];
                }
                System.out.println(sum1);
                break;
            case 2:
                int sum2 = 0;
                for (int i=0;i<myArr.length;i++){
                        sum2 += myArr[i][1];
                }
                System.out.println(sum2);
                break;
            case 3:
                int sum3 = 0;
                for (int i=0;i<myArr.length;i++){
                        sum3 += myArr[i][2];
                }
                System.out.println(sum3);
                break;
            default:
                System.out.println("undefined");
                break;

        }

    }
}
