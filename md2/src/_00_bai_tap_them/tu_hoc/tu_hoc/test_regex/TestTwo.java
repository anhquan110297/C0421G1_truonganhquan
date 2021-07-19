package _00_bai_tap_them.tu_hoc.tu_hoc.test_regex;

import _case_study.furama_resort.models.person.Customer;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;

public class TestTwo {
    //Cho một mảng số nguyên Hãy kiểm tra xem tần số xuất hiện của tất cả các số nguyên trong mảng có bằng nhau hay không.
    // ●	Với inputArray = [1, 2, 2, 3, 1, 3, 1, 3], thì kết quả check(inputArray) = false.
    //Số 1 có tần số xuất hiện là 3, khác vs số 2 và số 3 có tần số xuất hiện là 2
    public static boolean test(int[] myArr) {
        boolean check = false;
        int[] temp = new int[myArr.length];
        for (int i = 0; i < myArr.length; i++) {
            int count1 = 0;
            for (int j = 0; j < myArr.length; j++) {
                if (myArr[i] == myArr[j]) {
                    count1++;
                    temp[i] = count1;
                }
            }
        }
        System.out.println(Arrays.toString(temp));
        for (int item : temp) {
            for (int value : temp) {
                if (item == value) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static void main(String[] args) {
        int[] testHiHi = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(test(testHiHi));
    }
}
