package _case_study.furama_resort.services.employee_management;

import _11_java_collection_framework.bai_tap.Product;
import _case_study.furama_resort.models.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements EmployeeServicesInterface {
    public static List<Employee> list = new ArrayList<Employee>();
    static boolean check = false;

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    static {
        Employee employee1 = new Employee(1, "Thomas", "11/02/1997", "Male", 201751603, 1930192836, "employee1@gmail.com", "College", "Bellman", 1000);
        Employee employee2 = new Employee(2, "Jone", "12/3/1990", "Male", 201751604, 2128102938, "employee2@gmail.com", "university", "Driver", 1000);
        Employee employee3 = new Employee(3, "Jessica", "22/3/1990", "Female", 201752604, 1128102938, "employee3@gmail.com", "university", "Spa", 1000);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
    }

    @Override
    public void add() {
        System.out.println("Enter id");
        int id = input().nextInt();
        System.out.println("Enter name");
        String name = input().nextLine();
        System.out.println("Enter DateOfBirth");
        String dateOfBirth = input().nextLine();
        System.out.println("Enter Gender");
        String gender = input().nextLine();
        System.out.println("Enter idNo");
        int idNo = input().nextInt();
        System.out.println("Enter Telephone Number");
        int telePhoneNumber = input().nextInt();
        System.out.println("Enter Email");
        String email = input().nextLine();
        System.out.println("Enter Level");
        String level = input().nextLine();
        System.out.println("Enter onPosition");
        String onPosition = input().nextLine();
        System.out.println("Enter Slary");
        double salary = input().nextDouble();
        Employee employee = new Employee(id, name, dateOfBirth, gender, idNo, telePhoneNumber, email, level, onPosition, salary);
        list.add(employee);
    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {
        System.out.println("Please enter employee's id you want to edit");
        int id = input().nextInt();
        for (Employee n : list) {
            if (id == n.getId()) {
                System.out.println("Enter name");
                String name = input().nextLine();
                System.out.println("Enter DateOfBirth");
                String dateOfBirth = input().nextLine();
                System.out.println("Enter Gender");
                String gender = input().nextLine();
                System.out.println("Enter idNo");
                int idNo = input().nextInt();
                System.out.println("Enter Telephone Number");
                int telePhoneNumber = input().nextInt();
                System.out.println("Enter Email");
                String email = input().nextLine();
                System.out.println("Enter Level");
                String level = input().nextLine();
                System.out.println("Enter onPosition");
                String onPosition = input().nextLine();
                System.out.println("Enter Slary");
                double salary = input().nextDouble();
                n.setName(name);
                n.setDateOfBirth(dateOfBirth);
                n.setGender(gender);
                n.setIdNo(idNo);
                n.setTelephoneNumber(telePhoneNumber);
                n.setEmail(email);
                n.setLevel(level);
                n.setOnPosition(onPosition);
                n.setSalary(salary);
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Please re-enter id");
        }
    }

    @Override
    public void display() {
        for (Employee n : list) {
            System.out.println(n);
        }

    }
}
