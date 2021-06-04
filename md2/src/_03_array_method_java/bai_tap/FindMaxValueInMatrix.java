package _03_array_method_java.bai_tap;

import java.util.Scanner;

public class FindMaxValueInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int row = scanner.nextInt();
        System.out.println("Enter cols: ");
        int col = scanner.nextInt();
        float[][] matrix;
        matrix = new float[row][col];
        for (int k = 0; k < row; k++) {
            for (int h = 0; h < col; h++) {
                System.out.println("Enter elements: ");
                matrix[k][h] = scanner.nextFloat();
            }
        }
        float max = matrix[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }

        }
        System.out.println("max: " + max);
    }
}
