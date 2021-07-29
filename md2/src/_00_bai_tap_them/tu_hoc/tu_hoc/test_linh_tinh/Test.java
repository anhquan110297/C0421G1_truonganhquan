package _00_bai_tap_them.tu_hoc.tu_hoc.test_linh_tinh;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Test {
    public static boolean check(int a[][], int b[][]) {
        boolean check = true;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i][j] != b[index][j]) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
            if (check == true && index == b.length - 1) {
                break;
            }

            if (index < b.length - 1) {
                index++;
            }

        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean check2 (int x[][], int y[][]){
        boolean check = false;
        if (x.length != y.length){
            return false;
        }else {
            for (int i=0;i<x.length;i++){
              for (int j=0;j<y.length;i++){
                  if (x[i][j] != y[i][j]){
                      check = false;
                      break;
                  } else {
                      check = true;
                  }
              }
            }
        }
        if (check == true){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {9, 9, 9, 9, 9, 9},
                {1, 2, 1, 2, 1, 1},
        };
        int[][] arr2 = {
                {9, 9},
                {1, 1}
        };

        System.out.println(check2(arr1, arr2));
    }
}





