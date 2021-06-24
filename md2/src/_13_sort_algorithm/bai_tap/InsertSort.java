package _13_sort_algorithm.bai_tap;

import java.util.ArrayList;

public class InsertSort {
    private static int[] myArr = {7, 5, 3, 4, 6, 12, 8, 54, 2, 2, 4, 45, 56, 67, 789, 98, 5, 3, 2};

    public static void main(String[] args) {
        insertSort(myArr);
        for (int n : myArr) {
            System.out.print(n + " ");
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k;
            int currentElement = array[i];
            for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
                array[k + 1] = array[k];
            }
            array[k + 1] = currentElement;
        }
    }
    ArrayList
}
