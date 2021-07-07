package _case_study.furama_resort.services.booking_contract_management;

import _case_study.furama_resort.models.booking_contract.Booking;
import _case_study.furama_resort.models.facility.Facility;
import _case_study.furama_resort.models.person.Customer;
import _case_study.furama_resort.utils.ReadAndWriteFileByStream;
import _case_study.furama_resort.utils.RegexClass;

import java.util.*;

public class BookingContractServices implements BookingContractInterface {
    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    private static final String FILE_PATH_BOOKING = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\booking.csv";
    private static final String FILE_PATH_CUSTOMER = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\customer.csv";
    private static final String FILE_PATH_FACILITY = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\facility.csv";
    private static ReadAndWriteFileByStream<Booking> rawfbs = new ReadAndWriteFileByStream<>();
    public static TreeSet<Booking> bookings = new TreeSet<>();
    public static LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
    public static List<Customer> customers = new LinkedList<>();
    public static RegexClass regexClass = new RegexClass();


    @Override
    public void displayCustomer() {
        customers = (List<Customer>) rawfbs.readFileByByteStream(FILE_PATH_CUSTOMER);
        for (Customer n : customers) {
            System.out.println(n.getId() + " " + n.getName());
        }
    }

    @Override
    public void displayFacility() {
        facilities = (LinkedHashMap<Facility, Integer>) rawfbs.readFileByByteStream(FILE_PATH_FACILITY);
        for (Facility n : facilities.keySet()) {
            System.out.println(n.getNameServices());
        }
    }

    @Override
    public void add() {
        bookings = (TreeSet<Booking>) rawfbs.readFileByByteStream(FILE_PATH_BOOKING);
        facilities = (LinkedHashMap<Facility, Integer>) rawfbs.readFileByByteStream(FILE_PATH_FACILITY);
        if (bookings == null){
            bookings = new TreeSet<>();
        }
        if (facilities == null){
            facilities = new LinkedHashMap<>();
        }
        System.out.println("Customer's list");
        displayCustomer();
        System.out.println("Facility's list");
        displayFacility();
        System.out.println("Please enter id booking");
        int id = input().nextInt();
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
        for (Facility facility : facilities.keySet()) {
            if (facility.getNameServices().equals(name)) {
                facilities.put(facility, facilities.get(facility) + 1);
            }
        }
        String startDay = "";
        while (true) {
            System.out.println("Enter startDay");
            startDay = input().nextLine();
            if (!regexClass.dayOfBirth(startDay)) {
                System.out.println("Vui lòng nhập theo định dạng DD/MM/YY ");
            } else {
                break;
            }
        }

        String endDay = "";
        while (true) {
            System.out.println("Enter endDay");
            endDay = input().nextLine();
            if (!regexClass.dayOfBirth(endDay)) {
                System.out.println("Vui lòng nhập theo định dạng DD/MM/YY ");
            } else {
                break;
            }
        }
        System.out.println("Please enter id customer");
        int idCustomer = input().nextInt();
        System.out.println("Please enter type of services");
        String typeOfServices = input().nextLine();
        Booking booking = new Booking(id, startDay, endDay, idCustomer, name, typeOfServices);
        bookings.add(booking);
        rawfbs.writeFileByByteStream(bookings,FILE_PATH_BOOKING);
        rawfbs.writeFileByByteStreamUseMap(facilities,FILE_PATH_FACILITY);
    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        bookings = (TreeSet<Booking>) rawfbs.readFileByByteStream(FILE_PATH_BOOKING);
        if (bookings == null) {
            System.err.println("List is empty");
        } else {
            for (Booking n : bookings) {
                System.out.println(n);
            }
        }
//        Iterator<String> quandeptrai = hihi.iterator();
//        while (quandeptrai.hasNext()){
////            if (quandeptrai.next().equals("2"))
////            quandeptrai.remove();
//            System.out.print(quandeptrai.next()+",");
//        }
    }

}
