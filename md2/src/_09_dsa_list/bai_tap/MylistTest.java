package _09_dsa_list.bai_tap;

public class MylistTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(10,1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        System.out.println(myList.indexOf(3));
        myList.remove(2);
        System.out.println(myList.contains(2));
    }

}
