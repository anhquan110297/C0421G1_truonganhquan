package _11_java_collection_framework.bai_tap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Product> product = new ArrayList<>();
    static boolean check = false;


    static {
        Product mobile = new Product(1, "Mobile", 30);
        Product car = new Product(2, "Car", 100);
        Product motorBike = new Product(3, "Motor Bike", 50);
        Product bike = new Product(4, "Bike", 10);
        product.add(mobile);
        product.add(car);
        product.add(motorBike);
        product.add(bike);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product Management");
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Edit products information");
            System.out.println("2. Delete products");
            System.out.println("3. Display products menu");
            System.out.println("4. Find products by name");
            System.out.println("5. Sort products by price ascending");
            System.out.println("6. Sort products by price descending");
            System.out.println("7. Add Products");
            System.out.println("Press '0' to exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    edit();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    findOut();
                    break;
                case 5:
                    sortAscending();
                    break;
                case 6:
                    sortDescending();
                    break;
                case 7:
                    add();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Please re-enter");
            }

        }

    }

    public static void add() {
        System.out.println("enter id ");
        int newId = input().nextInt();
        System.out.println("enter name ");
        String newName = scanner.nextLine();
        System.out.println("enter price ");
        int newPrice = input().nextInt();
        Product newProduct = new Product(newId, newName, newPrice);
        product.add(newProduct);
    }

    public static void display() {
        if (product.isEmpty()) {
            System.out.println("NO PRODUCT,CHECK CC");
        } else {
            for (Product display : product) {
                System.out.println(display);
            }
        }
    }

    public static void delete() {
        System.out.println("Please enter id");
        int id = input().nextInt();
        boolean check = false;
        Product temp = new Product();
        for (Product m : product) {
            if (id == m.getId()) {
                temp = m;
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Please re-enter id");
        }
        product.remove(temp);
    }

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }


    public static void edit() {
        System.out.println("Please enter product's id you want to edit");
        int id = input().nextInt();

        for (Product n : product) {
            if (id == n.getId()) {
                System.out.println("newName");
                String newName = input().nextLine();
                System.out.println("newPrice");
                int newPrice = input().nextInt();
                n.setName(newName);
                n.setPrice(newPrice);
                check = true;
                break;
            }

        }
        if (check) {
            System.out.println("Please re-enter id");
        }

    }

    public static void findOut() {
        System.out.println("Please enter product's name you want to find");
        String name = input().nextLine();
        for (Product z : product) {
            if (name.equals(z.getName())) {
                System.out.println(z.toString());
            }
        }

    }

    public static void sortAscending() {
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        display();
    }

    public static void sortDescending() {
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        display();
    }
    // LinkedList tuong tu nen khong lam, lam bieng qua sep oi :(
}
