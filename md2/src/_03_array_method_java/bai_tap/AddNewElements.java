package _03_array_method_java.bai_tap;

import java.util.Scanner;

public class AddNewElements {
    public static void main(String[] args) {
        //khai báo mảng với độ dài người dùng nhập vào
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you want? ");
        int arrLength = scanner.nextInt();
        int [] myArr;
        myArr = new int[arrLength];
        // nhập element cho mảng
        for (int i=0;i<arrLength;i++){
            System.out.println("Please enter elements:");
            myArr[i] = scanner.nextInt();
        }
        //kiểm tra mảng đầu vào
        for (int n : myArr){
            System.out.println(n);
        }
        //input giá trị và index
        System.out.println("Please enter value:");
        int valueInput = scanner.nextInt();
        System.out.println("Please enter index");
        int indexInput = scanner.nextInt();
        // thiết lập điều kiện index
        if (indexInput <0 || indexInput > arrLength){
            System.out.println("Unable to add new element into array");
            // thêm phần tử
        }else {
            for (int j=myArr.length-1;j>= indexInput;j--){
                myArr[j] = myArr[j-1];
            }
            myArr[indexInput] = valueInput;
            myArr[arrLength-1] = 0;

            // xuất mảng kiểm tra
            for (int n : myArr){
                System.out.println(n);
            }




        }

    }
}
