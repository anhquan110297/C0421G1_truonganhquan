package _03_array_method_java.thuc_hanh;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name’s student:");
        String inputName = scanner.nextLine();
        boolean isExist = false;
        for (int i =0;i<students.length;i++){
            if (students[i].equals(inputName)){
                System.out.println("Position of the students in the list " + inputName + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("Not found " + inputName + " in the list.");
        }
    }
}
