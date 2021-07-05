package _case_study.furama_resort.services.facility_management;

import _15_IO_text_file.thuc_hanh.ReadAndWriteFile;
import _case_study.furama_resort.controllers.FacilityManagement;
import _case_study.furama_resort.models.facility.Facility;
import _case_study.furama_resort.models.facility.House;
import _case_study.furama_resort.models.facility.Room;
import _case_study.furama_resort.models.facility.Villa;
import _case_study.furama_resort.utils.ReadAndWriteFileByStream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FacilityServices implements FacilityServicesInterface {

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    ReadAndWriteFileByStream rawfb = new ReadAndWriteFileByStream();
    private static final String FILE_PATH_HOUSE = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\house.csv";
    private static final String FILE_PATH_VILLA = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\villa.csv";
    private static final String FILE_PATH_ROOM = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\room.csv";
    private static final String FILE_PATH_FACILITY = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\facility.csv";
    public static LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
    public static LinkedHashMap<Facility, Integer> house = new LinkedHashMap<>();
    public static LinkedHashMap<Facility, Integer> villa = new LinkedHashMap<>();
    public static LinkedHashMap<Facility, Integer> room = new LinkedHashMap<>();

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {
    }

    @Override
    public void display() {
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        if (facilities == null){
            System.err.println("facility's list is empty");
        }else {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                System.out.println(entry);
            }
        }
    }

    @Override
    public void displayAddNewServices() {
        while (true) {
            System.out.println("-----Menu-----");
            System.out.println("1. Add House");
            System.out.println("2. Add Room");
            System.out.println("3. Add Villa");
            System.out.println("4. Return Facility menu");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = input().nextInt();
            switch (choice) {
                case 1:
                    addHouse();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    addVilla();
                    break;
                case 4:
                    new FacilityManagement().display();
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong type");
                    break;
            }
        }
    }

    @Override
    public void addHouse() {
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        house = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_HOUSE);
        System.out.println("Enter name");
        String name = input().nextLine();
        System.out.println("Enter area");
        int area = input().nextInt();
        System.out.println("Enter rental cost");
        float rentalCost = input().nextFloat();
        System.out.println("Enter number of people");
        int numberOfPeople = input().nextInt();
        System.out.println("Enter rent of type");
        String rentOfType = input().nextLine();
        System.out.println("Enter room standard");
        String roomStandard = input().nextLine();
        System.out.println("Enter number of floor");
        int numberOfFloor = input().nextInt();
        house.put(new House(name, area, rentalCost, numberOfPeople, rentOfType, roomStandard, numberOfFloor), 0);
        facilities.put(new House(name, area, rentalCost, numberOfPeople, rentOfType, roomStandard, numberOfFloor), 0);
        rawfb.writeFileByByteStreamUseMap(house, FILE_PATH_HOUSE);
        rawfb.writeFileByByteStreamUseMap(house, FILE_PATH_FACILITY);
    }

    @Override
    public void addRoom() {
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        house = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_HOUSE);
        System.out.println("Enter name");
        String name = input().nextLine();
        System.out.println("Enter area");
        int area = input().nextInt();
        System.out.println("Enter rental cost");
        double rentalCost = input().nextDouble();
        System.out.println("Enter number of people");
        int numberOfPeople = input().nextInt();
        System.out.println("Enter rent of type");
        String rentOfType = input().nextLine();
        System.out.println("Enter room standard");
        String roomStandard = input().nextLine();
        System.out.println("Enter number of floor");
        int numberOfFloor = input().nextInt();
        System.out.println("Enter freeservices");
        String freeService = input().nextLine();
        Room newRoom = new Room(name, area, rentalCost, numberOfPeople, rentOfType, freeService);
        room.put(newRoom, 0);
        facilities.put(newRoom, 0);
        rawfb.writeFileByByteStreamUseMap(room, FILE_PATH_ROOM);
        rawfb.writeFileByByteStreamUseMap(room, FILE_PATH_FACILITY);
    }

    @Override
    public void addVilla() {
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        house = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_HOUSE);
        System.out.println("Enter name");
        String name = input().nextLine();
        System.out.println("Enter area");
        int area = input().nextInt();
        System.out.println("Enter rental cost");
        float rentalCost = input().nextFloat();
        System.out.println("Enter number of people");
        int numberOfPeople = input().nextInt();
        System.out.println("Enter rent of type");
        String rentOfType = input().nextLine();
        System.out.println("Enter room standard");
        String roomStandard = input().nextLine();
        System.out.println("Enter pool's area");
        int poolArea = input().nextInt();
        System.out.println("Enter number of floor");
        int numberOfFloor = input().nextInt();
        Villa newVilla = new Villa(name, area, rentalCost, numberOfPeople, rentOfType, roomStandard, poolArea, numberOfFloor);
        villa.put(newVilla, 0);
        facilities.put(newVilla, 0);
        rawfb.writeFileByByteStreamUseMap(villa, FILE_PATH_VILLA);
        rawfb.writeFileByByteStreamUseMap(villa, FILE_PATH_FACILITY);
    }

}
