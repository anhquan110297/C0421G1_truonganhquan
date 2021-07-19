package _00_bai_tap_them.tu_hoc.tu_hoc.test_linh_tinh;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Test {
    public static int test(String str) {
        Set<String> anhquan = new TreeSet<>();
        int a = 0;
        int count = 0;
        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                anhquan.add(str.substring(i, j));
                a++;
                count++;
            }
        }
        System.out.println(anhquan);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(test("abac"));
    }

}





