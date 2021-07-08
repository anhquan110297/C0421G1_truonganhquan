package _case_study.furama_resort.services.booking_contract_management;

import _case_study.furama_resort.models.booking_contract.Booking;
import _case_study.furama_resort.models.booking_contract.Contract;
import _case_study.furama_resort.services.Services;
import _case_study.furama_resort.utils.ExceptionCustom;
import _case_study.furama_resort.utils.ReadAndWriteFileByStream;

import java.io.Serializable;
import java.util.*;

public class ContractServices implements Serializable, Services {
    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    private static final String FILE_PATH_BOOKING = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\booking.csv";
    private static final String FILE_PATH_CONTRACT = "D:\\C0421G1_truonganhquan\\md2\\src\\_case_study\\furama_resort\\data\\contract.csv";
    private static ReadAndWriteFileByStream rawfbs = new ReadAndWriteFileByStream();
    private static Queue<Booking> booking = new LinkedList();
    private static List<Contract> contractsList = new ArrayList<>();
    public   ExceptionCustom exceptionCustom = new ExceptionCustom();

    @Override
    public void add() {
        TreeSet<Booking> treeSetBooking = new TreeSet<>();
        treeSetBooking = (TreeSet<Booking>) rawfbs.readFileByByteStream(FILE_PATH_BOOKING);
        booking.addAll(treeSetBooking);
        contractsList = (List<Contract>) rawfbs.readFileByByteStream(FILE_PATH_CONTRACT);
        while (!booking.isEmpty()) {
            if (booking.isEmpty()){
                System.out.println("Booking's list is empty");
                break;
            }
            Booking booking = ContractServices.booking.poll();
            int id;
            if (contractsList == null) {
                contractsList = new ArrayList<>();
                id = 1;
            } else {
                id = contractsList.get(contractsList.size() - 1).getIdBooking() + 1;
            }
            int idBooking = booking.getIdContract();
            System.out.println("Please enter deposit amount");
            double depositAmount = input().nextDouble();
            System.out.println("Please enter total amount");
            double totalAmount = input().nextDouble();
            int idGuest = booking.getIdCustomer();
            Contract contract = new Contract(id, idBooking, depositAmount, totalAmount, idGuest);
            contractsList.add(contract);
        }
        rawfbs.writeFileByByteStream(contractsList, FILE_PATH_CONTRACT);
        rawfbs.writeFileByByteStream(booking,FILE_PATH_BOOKING);
    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {
     rawfbs.readFileByByteStream(FILE_PATH_CONTRACT);
     for (Contract n : contractsList){
         int id = exceptionCustom.choiceNumber();
         if (id == n.getIdContract()){
             System.out.println("Please enter deposit amount");
             float depositAmount = exceptionCustom.choiceNumberFloat();
             System.out.println("Please enter total amount");
             float totalAmount = exceptionCustom.choiceNumberFloat();
             n.setDepositAmount(depositAmount);
             n.setTotalAmount(totalAmount);
         }
     }
     rawfbs.writeFileByByteStream(contractsList,FILE_PATH_CONTRACT);
    }

    @Override
    public void display() {
        contractsList = (List<Contract>) rawfbs.readFileByByteStream(FILE_PATH_CONTRACT);
        for (Contract contract : contractsList){
            System.out.println(contract.toString());
        }
    }
}
