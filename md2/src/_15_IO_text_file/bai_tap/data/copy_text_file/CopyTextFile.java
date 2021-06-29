package _15_IO_text_file.bai_tap.data.copy_text_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyTextFile {
    private static final String FILE_SRC_PATH = "D:\\C0421G1_truonganhquan\\md2\\src\\_15_IO_text_file\\bai_tap\\data\\copy_text_file\\src.csv";
    private static final String FILE_TARGET_PATH = "D:\\C0421G1_truonganhquan\\md2\\src\\_15_IO_text_file\\bai_tap\\data\\copy_text_file\\target.csv";

    private static String readFile(String filePath) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if ((!file.exists())) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String result = "";
        for (String n : strings) {
            result += n + "\n";
        }
        return result;
    }

    public void writeFile(String filePath, String line) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_TARGET_PATH, true));
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyTextFile copyTextFile = new CopyTextFile();
        System.out.println(copyTextFile.readFile(FILE_SRC_PATH));
        copyTextFile.writeFile(FILE_TARGET_PATH, readFile(FILE_SRC_PATH));
    }


}
