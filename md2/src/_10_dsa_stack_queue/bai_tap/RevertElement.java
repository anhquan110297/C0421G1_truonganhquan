package _10_dsa_stack_queue.bai_tap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class RevertElement<T> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("Check arrayList: " + arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            stack.push(arrayList.get(i));
        }
        System.out.println("Check stack: " + stack);
        for (int i = 0; i < arrayList.size(); i++) {
            //arraylist.set(index, element)
            arrayList.set(i, stack.pop());
        }
        System.out.println("Last Check: " + arrayList.toString());
        System.out.println("-------------------------------------");
        Stack<String> wStack = new Stack<>();
        System.out.println("Enter mWord");
        String string = scanner.nextLine();
        String[] mWord = string.split(" ");
        String str = "";
        // Day String vao mword
        for (String n : mWord) {
            wStack.push(n);
        }
        // Check wStack
        System.out.println("wstack" + wStack);
        System.out.println("check size stack: " + wStack.size());
        for (int i = 0; i < mWord.length; i++) {
            mWord[i] = wStack.pop();
            str += mWord[i] + " ";
        }
        System.out.println("Result: "+ str);
    }


}
