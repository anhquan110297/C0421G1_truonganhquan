package _10_dsa_stack_queue.bai_tap;

import java.util.Map;
import java.util.Scanner;

public class TreeMap {
    public static void main(String[] args) {
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter string: ");
        String string = scanner.nextLine();
        String[] stringStorage = string.split("");
        for (String n : stringStorage) {
            treeMap.put(n.toLowerCase(), 0);
        }
        System.out.println(treeMap);
        for (Map.Entry m : treeMap.entrySet()) {
//            System.out.println(m);
            for (int i = 0; i < stringStorage.length; i++) {
                if (m.getKey().equals(" ")){
                    continue;
                }
                if (m.getKey().equals(stringStorage[i])) {
                    int temp = (int) m.getValue();
                    temp++;
                    m.setValue(temp);
                }
            }
            System.out.println(m);
        }

    }
}

