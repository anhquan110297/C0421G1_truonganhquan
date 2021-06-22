package _11_java_collection_framework.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapLinkedHashMapTreeMap {
    public static void main(String[] args) {
        Map <String, Integer> hashMap = new HashMap<>();
        hashMap.put("Donic", 30);
        hashMap.put("Jame", 31);
        hashMap.put("Luka", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");
        Map <String, Integer> treeMap = new TreeMap<>();
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        Map < String,Integer> LinkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        LinkedHashMap.put("Lebron",30);
        LinkedHashMap.put("Anderson",30);
        LinkedHashMap.put("Scott",30);
        LinkedHashMap.put("Lewis",30);
        LinkedHashMap.put("Travis",30);
    }
}
