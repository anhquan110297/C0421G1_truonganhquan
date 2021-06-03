package _03_array_method_java.thuc_hanh;

import java.util.Scanner;

public class FindMixInArray {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);

    }

    public static int minValue(int[] myArr) {
        int min = myArr[0];
        int index = 0;
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] < min) {
                min = myArr[i];
                index = i;
            }
        }
        return index;
    }
}
