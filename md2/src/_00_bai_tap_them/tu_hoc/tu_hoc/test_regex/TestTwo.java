package _00_bai_tap_them.tu_hoc.tu_hoc.test_regex;

import _case_study.furama_resort.models.person.Customer;

import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;

public class TestTwo {
    public static void main(String[] args) {
        TreeSet<String> hihi = new TreeSet();
//        Customer customer1 = new Customer(1,"hihi","11/02/1997","Female",201751603,0,"anhquan1102@gmail.com","hihi","hihi");
//        Customer customer2 = new Customer();
//        Customer customer3 = new Customer();
//        Customer customer4 = new Customer();
//        Customer customer5 = new Customer();
//        hihi.add(customer1);
//        hihi.add(customer2);
//        hihi.add(customer3);
//        hihi.add(customer4);
//        hihi.add(customer5);
        String string1 = "10";
        String string2 = "1";
        String string3 = "2";
        String string4 = "7";
        String string5 = "4";
        hihi.add(string1);
        hihi.add(string2);
        hihi.add(string3);
        hihi.add(string4);
        hihi.add(string5);
        System.out.println("truoc" + hihi);
        Iterator<String> quandeptrai = hihi.iterator();
        while (quandeptrai.hasNext()){
//            if (quandeptrai.next().equals("2"))
//            quandeptrai.remove();
            System.out.print(quandeptrai.next()+",");
        }
        System.out.println("sau "+hihi);
    }
}
