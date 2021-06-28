package _14_exception_debug.bai_tap;

import java.util.Scanner;

public class IllegalTriangleExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("lần lượt nhập 3 cạnh");
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            checkException(a, b, c);
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage() + " sai rồi");
        }
    }
    public static void checkException(int a, int b, int c) throws IllegalTriangleException {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("Error");
        } else if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Error");
        }
    }
}

