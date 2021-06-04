package _03_array_method_java.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter arrLength");
        int arrLength = scanner.nextInt();
        int[] myArr;
        myArr = new int[arrLength];
    // nhập phần tử mảng
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Please enter a[" + i + "]");
            myArr[i] = scanner.nextInt();
        }
//          kiểm tra xem mảng đã tồn tại hay chưa?
        for (int n : myArr){
            System.out.println("Mảng ban đầu " + n);
        }
        //kiểm tra giá trị có tồn tại trong mảng hay không
        System.out.println("Please enter element you want to delete");
        int inputElement = scanner.nextInt();
        int index =0;
        for (int j =0;j<myArr.length;j++){
            if(inputElement == myArr[j]){
                index = j;
            }
        }
        System.out.println("Index: " + index);
        //thực hiện xóa
        for (int k=index;k<myArr.length-1;k++){
            myArr[k] = myArr[k+1];
        }
        myArr[arrLength-1] = 0;
        //kiểm tra mảng sau khi xóa
        for (int z : myArr){
            System.out.println("Mảng sau khi xóa "+ z);
        }

    }
}