package _case_study.furama_resort.services.employee_management;

import _case_study.furama_resort.models.person.Customer;
import _case_study.furama_resort.models.person.Employee;
import _case_study.furama_resort.utils.ReadAndWriteFileByStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements EmployeeServicesInterface {
    static ReadAndWriteFileByStream<Employee> rawfbs = new ReadAndWriteFileByStream<>();
    public static List<Employee> employees = new ArrayList<>();
    static boolean check = false;
    private static final String FILE_PATH = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\employee.csv";
    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
//    static {
//        Employee employee1 = new Employee(1,"quan","123","123",1,1,"123","123","123",1);
//        employees.add(employee1);
//        rawfbs.writeFileByByteStream(employees,FILE_PATH);
//    }

    @Override
    public void add() {
        employees = (List<Employee>) rawfbs.readFileByByteStream(FILE_PATH);
        int id;
        if (employees.isEmpty()) {
            id = 1;
        } else {
            id = employees.get(employees.size() - 1).getId() + 1;
        }
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
        employees.add(employee);
        rawfbs.writeFileByByteStream(employees, FILE_PATH);
    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {
        System.out.println("Please enter employee's id you want to edit");
        int id = input().nextInt();
        employees = (List<Employee>) rawfbs.readFileByByteStream(FILE_PATH);
        for (Employee n : employees) {
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
                rawfbs.writeFileByByteStream(employees, FILE_PATH);
                break;
            }
        }
        if (check) {
            System.out.println("Please re-enter id");
        }
    }

    @Override
    public void display() {
        employees = (List<Employee>) rawfbs.readFileByByteStream(FILE_PATH);
        if (employees == null) {
            System.err.println("Employees's list is empty");
        } else {
            for (Employee n : employees) {
                System.out.println(n);
            }
        }
    }
}
