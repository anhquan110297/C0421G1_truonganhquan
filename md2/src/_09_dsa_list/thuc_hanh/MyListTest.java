package _09_dsa_list.thuc_hanh;

public class MyListTest {
    public static void main(String[] args) {
        Mylist<Integer> listInteger = new Mylist<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));

//        listInteger.get(6);
//        System.out.println("element 6: "+listInteger.get(6));
        listInteger.get(-1);
        System.out.println("element -1: " + listInteger.get(-1));
    }
}
