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
    public static ReadAndWriteFileByStream readAndWriteFile = new ReadAndWriteFileByStream();
    private static final String FILE_PATH = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\facility.csv";
    public static LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();

    static {
        House house = new House("House", 100, 500, 5, "Day", "vip", 2);
        Room room = new Room("Room", 40, 100, 2, "week", "Clean Room");
        Villa villa = new Villa("Villa", 150, 1000, 10, "year", "vip", 15, 2);
        facilities.put(house, 0);
        facilities.put(room, 0);
        facilities.put(villa, 0);
        readAndWriteFile.writeFileByByteStreamUseMap(facilities,FILE_PATH);
    }

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
        facilities = (LinkedHashMap<Facility, Integer>) readAndWriteFile.readFileByByteStream(FILE_PATH);
        for (Map.Entry<Facility,Integer> entry : facilities.entrySet()){
            System.out.println(entry);
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
        for (Facility key : facilities.keySet()) {
            if (key.getNameServices().equals("House")) {
                if (facilities.get(key) >= 5) {
                    System.out.println("Service is under maintenance");
                    break;
                }
            }
            facilities.put(key, facilities.get(key) + 1);
        }
        System.out.println("Ok");
    }

    @Override
    public void addRoom() {
        for (Facility key : facilities.keySet()) {
            if (key.getNameServices().equals("Room")) {
                if (facilities.get(key) >= 5) {
                    System.out.println("Service is under maintenance");
                    break;
                }
            }
            facilities.put(key, facilities.get(key) + 1);
        }
        System.out.println("Ok");

    }

    @Override
    public void addVilla() {
        for (Facility key : facilities.keySet()) {
            if (key.getNameServices().equals("Villa")) {
                if (facilities.get(key) >= 5) {
                    System.out.println("Service is under maintenance");
                    break;
                }
            }
            facilities.put(key, facilities.get(key) + 1);
        }
        System.out.println("Ok");
    }

    public void displayMaintenance(){
        for (Map.Entry<Facility,Integer> maintenance : facilities.entrySet()){
            if (maintenance.getValue() > 5){
                System.out.println("Service is under maintenance "+maintenance);
            }
        }
    }
}
