package _03_array_method_java.thuc_hanh;

import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter size: ");
            size = scanner.nextInt();
            if (size>20){
                System.out.println("Size should not exceed 20");
            }
        }while (size>20);
        array = new int [size];
        int i=0;
        while (i<array.length){
            System.out.print("Enter element a["+i+"]" + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        int max = array[0];
        int index = 0;
        for (int j=0;j<array.length;j++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
