package _03_array_method_java.bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] myArray1 = new int[5];
        int[] myArray2 = new int[5];
        int[] myArray3 = new int[10];
        for (int i = 0; i < myArray1.length; i++) {
            System.out.println("Please enter elements in myArray1 a[" + i + "]");
            myArray1[i] = scanner.nextInt();
        }
        for (int j = 0; j < myArray2.length; j++) {
            System.out.println("Please enter elements in myArray2 a[" + j + "]");
            myArray2[j] = scanner.nextInt();
        }
        for (int n : myArray1) {
            System.out.println("myArray1: " + n);
        }
        for (int n : myArray2) {
            System.out.println("myArray2: " + n);
        }
        for (int k = 0; k < 5; k++) {
            myArray3[k] = myArray1[k];
        }
        int q = 0;
        for (int h = myArray1.length; h < myArray3.length; h++) {
//
//            myArray3[h] = myArray2[q];
//
//
            if ( myArray3[h]==0){

                myArray3[h] = myArray2[q];
                q++;
            if (q > myArray2.length)
                break;
            }
        }
        for (int n : myArray3) {
            System.out.println("myArray3" + n);
        }

    }
}
