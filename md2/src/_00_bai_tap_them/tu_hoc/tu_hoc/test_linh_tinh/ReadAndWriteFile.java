package _00_bai_tap_them.tu_hoc.tu_hoc.test_linh_tinh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile<E> {
    public void writeFile(String filePath, String line) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<E> readFile(String filePath) {
        List<E> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add((E) line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //    public class MyClass {
//        MyClass() {…};
//        void MyClass(int x) {…};
//        MyClass(float x) {…};
//         MyClass1(int x, double y) {…};
//    }
//    //    static final String REGEX_VILLA = "^SVVL-[0-9]{4}$";
////    static final String REGEX_HOUSE = "^SVHO-[0-9]{4}$";
////    static final String REGEX_ROOM = "^SVRO-[0-9]{4}$"; // ràng buộc về SV room-YYYY
////    static final String REGEX_SERVICE = "^[A-Z][a-z]{1,}"; // viết hoa kí tự đầu
////    static final String REGEX_AREA_POOL = "^([3-9]\\d|[0-9]\\d{2,})$"; // 1 số lớn hơn bao nhiêu ( cụ thể là 30)
////    static final String REGEX_RENTAL_FEE = "^[+]?([.]\\d+|\\d+[.]?\\d*)$"; // số dương thập phân
////    static final String REGEX_NUMBER_OF_PEOPLE = "^([1]\\d|[1-9])$"; // LỚN HƠN 1 SỐ VÀ BÉ HƠN 20
////    static final String REGEX_NUMBER_OF_FLOOR = "^[+]?([.]\\d+|\\d+[.]?\\d*)$"; // số dương thập phân
////    static final String REGEX_RENT_OF_TYPE = "^(NORMAL|LOW|VIP)-[0-9]{4}$";
////    static final String REGEX_DD_MM_YY = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$";
////     static final String EMAIL = "^[(a-z|A-Z)0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
//    static final String name = "^[a-zA-Z\\s]+";
}

