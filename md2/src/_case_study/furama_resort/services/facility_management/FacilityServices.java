package _case_study.furama_resort.services.facility_management;

import _15_IO_text_file.thuc_hanh.ReadAndWriteFile;
import _case_study.furama_resort.controllers.FacilityManagement;
import _case_study.furama_resort.models.facility.Facility;
import _case_study.furama_resort.models.facility.House;
import _case_study.furama_resort.models.facility.Room;
import _case_study.furama_resort.models.facility.Villa;
import _case_study.furama_resort.utils.ExceptionCustom;
import _case_study.furama_resort.utils.ReadAndWriteFileByStream;
import _case_study.furama_resort.utils.RegexClass;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityServices implements FacilityServicesInterface {

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    RegexClass regexClass = new RegexClass();
    ExceptionCustom exceptionCustom = new ExceptionCustom();
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
        if (facilities == null) {
            System.err.println("facility's list is empty");
        } else {
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
            int choice = exceptionCustom.choiceNumber();
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
        house = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_HOUSE);
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        if (house == null) {
            house = new LinkedHashMap<>();
        }
        if (facilities == null) {
            facilities = new LinkedHashMap<>();
        }
        String name = "";
        while (true) {
            System.out.println("Enter name");
            name = input().nextLine();
            if (regexClass.regexNameService(name) == true) {
                break;
            } else {
                System.out.println("Vui lòng nhập theo định dạng SVRO-YYYY với Y là 4 chữ số");
            }
        }
        int area = 0;
        while (true) {
            System.out.println("Enter area");
            area = input().nextInt();
            String str = String.valueOf(area); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.area(str) == true) {
                break;
            } else {
                System.out.println("diện tích hồ bơi phải lớn hơn 30");
            }
        }

        float rentalCost = 0;
        while (true) {
            System.out.println("Enter rental cost");
            rentalCost = input().nextFloat();
            String str = String.valueOf(rentalCost); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.rentalFee(str) == true) {
                break;
            } else {
                System.out.println("rental fee is positive number");
            }
        }
        int numberOfPeople = 0;
        while (true) {
            System.out.println("Enter number of people");
            numberOfPeople = input().nextInt();
            String str = String.valueOf(numberOfPeople); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.numberOfPeople(str) == true) {
                break;
            } else {
                System.out.println("rental fee is positive number");
            }
        }
        String rentOfType = "";
        while (true) {
            System.out.println("Enter rent of type");
            rentOfType = input().nextLine();
            if (regexClass.rentOfType(rentOfType) == true) {
                break;
            } else {
                System.out.println("Kiểu thuê phải theo định dạng ngày tháng năm");
            }
        }
        String roomStandard = "";
        while (true) {
            System.out.println("Enter room standard");
            roomStandard = input().nextLine();
            if (regexClass.roomStandard(roomStandard) == true) {
                break;
            } else {
                System.out.println("Kiểu phòng phải theo định dạng NORMAL,VIP,LOW-YYYY");
            }
        }
        int numberOfFloor = 0;
        while (true) {
            System.out.println("Enter number of floor");
            numberOfFloor = input().nextInt();
            String str = String.valueOf(numberOfFloor); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.numberOfFloor(str) == true) {
                break;
            } else {
                System.out.println("number of floor is positive number");
            }
        }
        house.put(new House(name, area, rentalCost, numberOfPeople, rentOfType, roomStandard, numberOfFloor), 0);
        facilities.put(new House(name, area, rentalCost, numberOfPeople, rentOfType, roomStandard, numberOfFloor), 0);
        rawfb.writeFileByByteStreamUseMap(house, FILE_PATH_HOUSE);
        rawfb.writeFileByByteStreamUseMap(facilities, FILE_PATH_FACILITY);
    }

    @Override
    public void addRoom() {
        room = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_ROOM);
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        if (room == null) {
            room = new LinkedHashMap<>();
        }
        if (facilities == null) {
            facilities = new LinkedHashMap<>();
        }
        String name = "";
        while (true) {
            System.out.println("Enter name");
            name = input().nextLine();
            if (regexClass.regexNameService(name) == true) {
                break;
            } else {
                System.out.println("Vui lòng nhập theo định dạng SVRO-YYYY với Y là 4 chữ số");
            }
        }
        int area = 0;
        while (true) {
            System.out.println("Enter area");
            area = input().nextInt();
            String str = String.valueOf(area); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.area(str) == true) {
                break;
            } else {
                System.out.println("diện tích sử dụng phải lớn hơn 30");
            }
        }

        float rentalCost = 0;
        while (true) {
            System.out.println("Enter rental cost");
            rentalCost = input().nextFloat();
            String str = String.valueOf(rentalCost); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.rentalFee(str) == true) {
                break;
            } else {
                System.out.println("rental fee is positive number");
            }
        }
        int numberOfPeople = 0;
        while (true) {
            System.out.println("Enter number of people");
            numberOfPeople = input().nextInt();
            String str = String.valueOf(numberOfPeople); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.numberOfPeople(str) == true) {
                break;
            } else {
                System.out.println("number of people is positive number");
            }
        }
        String rentOfType = "";
        while (true) {
            System.out.println("Enter rent of type");
            rentOfType = input().nextLine();
            if (regexClass.rentOfType(rentOfType) == true) {
                break;
            } else {
                System.out.println("Kiểu thuê phải theo định dạng ngày tháng năm");
            }
        }
        System.out.println("Enter free services");
        String freeService = input().nextLine();
        Room newRoom = new Room(name, area, rentalCost, numberOfPeople, rentOfType, freeService);
        room.put(newRoom, 0);
        facilities.put(newRoom, 0);
        rawfb.writeFileByByteStreamUseMap(room, FILE_PATH_ROOM);
        rawfb.writeFileByByteStreamUseMap(facilities, FILE_PATH_FACILITY);
    }

    @Override
    public void addVilla() {
        villa = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_VILLA);
        facilities = (LinkedHashMap<Facility, Integer>) rawfb.readFileByByteStream(FILE_PATH_FACILITY);
        if (villa == null) {
            villa = new LinkedHashMap<>();
        }
        if (facilities == null) {
            facilities = new LinkedHashMap<>();
        }
        String name = "";
        while (true) {
            System.out.println("Enter name");
            name = input().nextLine();
            if (regexClass.regexNameService(name) == true) {
                break;
            } else {
                System.out.println("Vui lòng nhập theo định dạng SVRO-YYYY với Y là 4 chữ số");
            }
        }
        int area = 0;
        while (true) {
            System.out.println("Enter area");
            area = input().nextInt();
            String str = String.valueOf(area); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.area(str) == true) {
                break;
            } else {
                System.out.println("diện tích sử dụng phải lớn hơn 30");
            }
        }

        float rentalCost = 0;
        while (true) {
            System.out.println("Enter rental cost");
            rentalCost = input().nextFloat();
            String str = String.valueOf(rentalCost); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.rentalFee(str) == true) {
                break;
            } else {
                System.out.println("rental fee is positive number");
            }
        }
        int numberOfPeople = 0;
        while (true) {
            System.out.println("Enter number of people");
            numberOfPeople = input().nextInt();
            String str = String.valueOf(numberOfPeople); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.numberOfPeople(str) == true) {
                break;
            } else {
                System.out.println("number of people is positive number");
            }
        }
        String rentOfType = "";
        while (true) {
            System.out.println("Enter rent of type");
            rentOfType = input().nextLine();
            if (regexClass.rentOfType(rentOfType) == true) {
                break;
            } else {
                System.out.println("Kiểu thuê phải theo định dạng ngày tháng năm");
            }
        }
        String roomStandard = "";
        while (true) {
            System.out.println("Enter room standard");
            roomStandard = input().nextLine();
            if (regexClass.roomStandard(roomStandard) == true) {
                break;
            } else {
                System.out.println("Kiểu phòng phải theo định dạng NORMAL,VIP,LOW-YYYY");
            }
        }
        int poolArea = 0;
        while (true) {
            System.out.println("Enter pool's area");
            poolArea = input().nextInt();
            String str = String.valueOf(poolArea); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.area(str) == true) {
                break;
            } else {
                System.out.println("diện tích hồ bơi lớn hơn 30");
            }
        }
        int numberOfFloor = 0;
        while (true) {
            System.out.println("Enter number of floor");
            numberOfFloor = input().nextInt();
            String str = String.valueOf(numberOfFloor); // String.valueof(int) -> chuyển đổi từ int sang string
            if (regexClass.numberOfFloor(str) == true) {
                break;
            } else {
                System.out.println("number of floor is positive number");
            }
        }
        Villa newVilla = new Villa(name, area, rentalCost, numberOfPeople, rentOfType, roomStandard, poolArea, numberOfFloor);
        villa.put(newVilla, 0);
        facilities.put(newVilla, 0);
        rawfb.writeFileByByteStreamUseMap(villa, FILE_PATH_VILLA);
        rawfb.writeFileByByteStreamUseMap(facilities, FILE_PATH_FACILITY);
    }

}
