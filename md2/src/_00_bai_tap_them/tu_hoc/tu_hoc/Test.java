package _00_bai_tap_them.tu_hoc.tu_hoc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public List<String[]> readFile(String filePath) {
        List<String[]> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] element = line.split(",");
                list.add(element);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(String filePath, String line) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void disPlay(List<String[]> list) {
        for (String[] n : list) {
            System.out.println(Arrays.toString(n));
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        disPlay(test.readFile("D:\\C0421G1_truonganhquan\\md2\\src\\_00_bai_tap_them\\tu_hoc\\src.csv"));
    }
}



