package _00_bai_tap_them.tu_hoc;

import java.util.Scanner;

public class Test{

    public static void main(String[] args) {
        
    }
    public static int greaterY(int[] arr, int Y) {
        // code here
        int count = 0;
        for (int i =0;i<arr.length;i++){
            if (arr[i] > Y){
                count++;
            }
        }
        return count;
    }

}



