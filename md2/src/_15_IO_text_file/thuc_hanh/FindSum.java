package _15_IO_text_file.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class FindSum {
    private static final String FILE_PATH = "D:\\C0421G1_truonganhquan\\md2\\src\\_15_IO_text_file\\thuc_hanh\\data\\data.csv";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";

    public void readFile(String filePath) {
        try {
            // đọc file theo đường dẫn
            File file = new File(FILE_PATH);
            // kiểm tra file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            // đọc từng dòng của file và tiến hành cộng dồn lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi
            System.err.println("File không tồn tại or nội dung lỗi");

        }
    }

    public static void main(String[] args) {
        FindSum findSum = new FindSum();
        findSum.readFile(FILE_PATH);
    }

}
