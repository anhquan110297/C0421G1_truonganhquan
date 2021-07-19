package _thi_module2.utils;

import _case_study.furama_resort.models.facility.Facility;

import java.io.*;
import java.util.Collection;
import java.util.Map;

public class ReadAndWriteFile<K> {
    public  Object readFileByByteStream(String diaChi){
        //Khai báo đối tượng FileInputStream và ObjectInputStream trỏ tới null
        FileInputStream FIn = null;
        ObjectInputStream OIn = null;
        Object read = null;
        try {
            //Khở tạo đối tượng với địa chỉ truyền vào
            FIn = new FileInputStream(new java.io.File(diaChi));
            OIn = new ObjectInputStream(FIn);
            read = OIn.readObject();
            FIn.close();
            OIn.close();
            return read;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }


    public void writeFileByByteStream(Collection<K> list, String filePath) {
        File file = new File(filePath);
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFileByByteStreamUseMap(Map<Facility, Integer> map, String filePath) {
        File file = new File(filePath);
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
