package _thi_module2.services;

import _case_study.furama_resort.controllers.BookingContractManagement;
import _case_study.furama_resort.controllers.CustomerManagement;
import _case_study.furama_resort.controllers.EmployeeManagement;
import _case_study.furama_resort.controllers.FacilityManagement;
import _case_study.furama_resort.models.person.Customer;
import _thi_module2.controller.ProductController;
import _thi_module2.models.ExportProduct;
import _thi_module2.models.ImportProduct;
import _thi_module2.models.Product;
import _thi_module2.utils.ExceptionCustom;
import _thi_module2.utils.ReadAndWriteFile;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements Services {
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    public ExceptionCustom exceptionCustom = new ExceptionCustom();

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
     static boolean check = false;

    private static final String FILE_PATH_IMPORT_PRODUCT = "D:\\C0421G1_truonganhquan\\md2\\src\\_thi_module2\\data\\importproduct.csv";
    private static final String FILE_PATH_EXPORT_PRODUCT = "D:\\C0421G1_truonganhquan\\md2\\src\\_thi_module2\\data\\exportproduct.csv";
    private static final String FILE_PATH_PRODUCT = "D:\\C0421G1_truonganhquan\\md2\\src\\_thi_module2\\data\\product.csv";
    public static List<ImportProduct> importProductList = new ArrayList<>();
    public static List<ExportProduct> exportProductList = new ArrayList<>();


    @Override
    public void add() {
        while (true) {
            System.out.println("-----Add Menu Product Management-----");
            System.out.println("1. Add import product");
            System.out.println("2. Add import product");
            System.out.println("3. Return Main Menu");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = ExceptionCustom.choiceNumber();
            switch (choice) {
                case 1:
                    addImportProduct();
                    break;
                case 2:
                    addExportProduct();
                    break;
                case 3:
                    new ProductController().displayMainMenu();
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong type");
            }
        }
    }

    public void addImportProduct() {
        importProductList = (List<ImportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_IMPORT_PRODUCT);
        int idProduct;
        if (importProductList == null) {
            importProductList = new ArrayList<>();
            idProduct = 1;
        } else {
            idProduct = importProductList.get(importProductList.size() - 1).getIdProduct() + 1;
        }
        String productName;
        System.out.println("Enter product's name");
        productName = input().nextLine();
        int productCode;
        while (true) {
            System.out.println("Enter product's code");
            productCode = ExceptionCustom.choiceNumber();
            if (productCode < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        int price;
        while (true) {
            System.out.println("Enter product's price");
            price = ExceptionCustom.choiceNumber();
            if (price < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        int amount;
        while (true) {
            System.out.println("Enter product's amount");
            amount = ExceptionCustom.choiceNumber();
            if (amount < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        String producer;
        System.out.println("Please enter producer");
        producer = input().nextLine();

        int importPrice;
        while (true) {
            System.out.println("Enter import price");
            importPrice = ExceptionCustom.choiceNumber();
            if (importPrice < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }

        String province;
        System.out.println("Please enter province");
        province = input().nextLine();

        int tax;
        while (true) {
            System.out.println("Enter tax");
            tax = ExceptionCustom.choiceNumber();
            if (tax < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        ImportProduct product = new ImportProduct(idProduct, productCode, price, amount, producer, importPrice, province, tax);
        importProductList.add(product);
        readAndWriteFile.writeFileByByteStream(importProductList, FILE_PATH_IMPORT_PRODUCT);
    }

    public void addExportProduct() {
        exportProductList = (List<ExportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_EXPORT_PRODUCT);
        int idProduct;
        if (exportProductList == null) {
            exportProductList = new ArrayList<>();
            idProduct = 1;
        } else {
            idProduct = exportProductList.get(exportProductList.size() - 1).getIdProduct() + 1;
        }
        String productName;
        System.out.println("Enter product's name");
        productName = input().nextLine();
        int productCode;
        while (true) {
            System.out.println("Enter product's code");
            productCode = ExceptionCustom.choiceNumber();
            if (productCode < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        int price;
        while (true) {
            System.out.println("Enter product's amount");
            price = ExceptionCustom.choiceNumber();
            if (price < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        int amount;
        while (true) {
            System.out.println("Enter product's amount");
            amount = ExceptionCustom.choiceNumber();
            if (amount < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        String producer;
        System.out.println("Please enter producer");
        producer = input().nextLine();

        int exportPrice;
        while (true) {
            System.out.println("Enter export price");
            exportPrice = ExceptionCustom.choiceNumber();
            if (exportPrice < 0) {
                System.out.println("Wrong type");
            } else {
                break;
            }
        }
        String country;
        System.out.println("Please enter producer");
        country = input().nextLine();
        ExportProduct product = new ExportProduct(idProduct, productCode, price, amount, producer, exportPrice, country);
        exportProductList.add(product);
        readAndWriteFile.writeFileByByteStream(exportProductList, FILE_PATH_EXPORT_PRODUCT);
    }

    @Override
    public void delete() {
        while (true) {
            System.out.println("1. Delete import product");
            System.out.println("2. Delete export product");
            System.out.println("3. Return Main Menu");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = ExceptionCustom.choiceNumber();
            switch (choice) {
                case 1:
                    deleteImportProduct();
                    break;
                case 2:
                    deleteExportProduct();
                    break;
                case 3:
                    new ProductController().displayMainMenu();
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong Type");
            }
        }
    }

    public void deleteImportProduct() {
        importProductList = (List<ImportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_IMPORT_PRODUCT);
        if (importProductList == null) {
            System.err.println("importProductList is empty");
        } else {
            System.out.println("Please enter import product's id you wanna delete");
            int id = ExceptionCustom.choiceNumber();
            for (ImportProduct n : importProductList)
                if (id == n.getIdProduct()) {
                    importProductList.remove(n);
                }
        }
        readAndWriteFile.writeFileByByteStream(importProductList, FILE_PATH_IMPORT_PRODUCT);
    }


    public void deleteExportProduct() {
        exportProductList = (List<ExportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_EXPORT_PRODUCT);
        if (exportProductList == null) {
            System.err.println("exportProductList is empty");
        } else {
            System.out.println("Please enter export product's id you wanna delete");
            int id = ExceptionCustom.choiceNumber();
            for (ExportProduct n : exportProductList)
                if (id == n.getIdProduct()) {
                    importProductList.remove(n);
                }
        }
        readAndWriteFile.writeFileByByteStream(exportProductList, FILE_PATH_EXPORT_PRODUCT);
    }


    @Override
    public void edit() {
        while (true) {
            System.out.println("1. edit import product");
            System.out.println("2. edit export product");
            System.out.println("3. return main menu");
            System.out.println("Enter your choice");
            int choice = exceptionCustom.choiceNumber();
            switch (choice) {
                case 1:
                    editImportProduct();
                    break;
                case 2:
                    break;
                case 3:
                    new ProductController().displayMainMenu();
                    break;
                default:
                    System.out.println("Wrong type");
            }
        }

    }

    public void editImportProduct(){
        importProductList = (List<ImportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_IMPORT_PRODUCT);
        System.out.println("Please enter id you wanna edit");
        int id = ExceptionCustom.choiceNumber();
        if (importProductList == null) {
            System.err.println("customer's list is empty");
        } else {
            for (ImportProduct n : importProductList){
                if (id == n.getIdProduct()){
                    String productName;
                    System.out.println("Enter product's name");
                    productName = input().nextLine();
                    int productCode;
                    while (true) {
                        System.out.println("Enter product's code");
                        productCode = ExceptionCustom.choiceNumber();
                        if (productCode < 0) {
                            System.out.println("Wrong type");
                        } else {
                            break;
                        }
                    }
                    int price;
                    while (true) {
                        System.out.println("Enter product's price");
                        price = ExceptionCustom.choiceNumber();
                        if (price < 0) {
                            System.out.println("Wrong type");
                        } else {
                            break;
                        }
                    }
                    int amount;
                    while (true) {
                        System.out.println("Enter product's amount");
                        amount = ExceptionCustom.choiceNumber();
                        if (amount < 0) {
                            System.out.println("Wrong type");
                        } else {
                            break;
                        }
                    }
                    String producer;
                    System.out.println("Please enter producer");
                    producer = input().nextLine();

                    int importPrice;
                    while (true) {
                        System.out.println("Enter import price");
                        importPrice = ExceptionCustom.choiceNumber();
                        if (importPrice < 0) {
                            System.out.println("Wrong type");
                        } else {
                            break;
                        }
                    }

                    String province;
                    System.out.println("Please enter province");
                    province = input().nextLine();

                    int tax;
                    while (true) {
                        System.out.println("Enter tax");
                        tax = ExceptionCustom.choiceNumber();
                        if (tax < 0) {
                            System.out.println("Wrong type");
                        } else {
                            break;
                        }
                    }
                    n.setAmount(amount);
                    n.setCodeProduct(productCode);
                    n.setPrice(price);
                    n.setProducer(producer);
                    n.setImportPrice(importPrice);
                    n.setProvince(province);
                    n.setTax(tax);
                    break;
                }else {
                    System.out.println("please re-enter id");
                }
            }
        }

    }


    public void editExportProduct(){}

    @Override
    public void display() {
        importProductList = (List<ImportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_IMPORT_PRODUCT);
        for (ImportProduct n : importProductList) {
            System.out.println(n);
        }
        exportProductList = (List<ExportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_EXPORT_PRODUCT);
        for (ExportProduct n : exportProductList) {
            System.out.println(n);
        }

    }

    @Override
    public void search() {
        while (true) {
            System.out.println("1. Search import product");
            System.out.println("2. search export product");
            System.out.println("3. return main menu");
            System.out.println("Enter your choice");
            int choice = exceptionCustom.choiceNumber();
            switch (choice) {
                case 1:
                    searchImportProduct();
                    break;
                case 2:
                    searchExportProduct();
                    break;
                case 3:
                    new ProductController().displayMainMenu();
                    break;
                default:
                    System.out.println("Wrong type");
                    break;
            }
        }
    }

    public void searchImportProduct () {
        importProductList = (List<ImportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_IMPORT_PRODUCT);
        System.out.println("Please enter id you wanna search");
        int id = ExceptionCustom.choiceNumber();
        for (ImportProduct n : importProductList) {
            if (id == n.getIdProduct()) {
                System.out.println(n);
            }
        }
    }

    public void searchExportProduct() {
        exportProductList = (List<ExportProduct>) readAndWriteFile.readFileByByteStream(FILE_PATH_EXPORT_PRODUCT);
        System.out.println("Please enter id you wanna search");
        int id = ExceptionCustom.choiceNumber();
        for (ExportProduct n : exportProductList) {
            if (id == n.getIdProduct()) {
                System.out.println(n);
            }
        }
    }
}
