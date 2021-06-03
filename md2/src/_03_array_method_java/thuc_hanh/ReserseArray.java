package _03_array_method_java.thuc_hanh;

import java.util.Scanner;

public class ReserseArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size");
            size = scanner.nextInt();
            if ( size > 20){
                System.out.println("size does not exceed 20");

            }
        }while (size > 20);
        array = new int[size];
        int i =0;
        while (i< array.length){
            System.out.println("Enter elements " + "a["+i+"]" + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        for ( int n : array){
            System.out.println(n);
        }
        for (int j =0;j< array.length/2;j++){
            int temp = array[j];
            array[j] = array[size-1-j];
            array[size-1-j] = temp;
        }
        for ( int n : array){
            System.out.println(n);
        }
    }
}
