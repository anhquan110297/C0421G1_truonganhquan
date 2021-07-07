package _00_bai_tap_them.tu_hoc.tu_hoc.test_linh_tinh;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test  {
//    static final String REGEX_VILLA = "^SVVL-[0-9]{4}$";
//    static final String REGEX_HOUSE = "^SVHO-[0-9]{4}$";
//    static final String REGEX_ROOM = "^SVRO-[0-9]{4}$"; // ràng buộc về SV room-YYYY
//    static final String REGEX_SERVICE = "^[A-Z][a-z]{1,}"; // viết hoa kí tự đầu
//    static final String REGEX_AREA_POOL = "^([3-9]\\d|[0-9]\\d{2,})$"; // 1 số lớn hơn bao nhiêu ( cụ thể là 30)
//    static final String REGEX_RENTAL_FEE = "^[+]?([.]\\d+|\\d+[.]?\\d*)$"; // số dương thập phân
//    static final String REGEX_NUMBER_OF_PEOPLE = "^([1]\\d|[1-9])$"; // LỚN HƠN 1 SỐ VÀ BÉ HƠN 20
//    static final String REGEX_NUMBER_OF_FLOOR = "^[+]?([.]\\d+|\\d+[.]?\\d*)$"; // số dương thập phân
//    static final String REGEX_RENT_OF_TYPE = "^(NORMAL|LOW|VIP)-[0-9]{4}$";
//    static final String REGEX_DD_MM_YY = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$";
    public static void main(String[] args) {
//        String input = "11/02/1500";
//        Pattern pattern = Pattern.compile(REGEX_DD_MM_YY);
//        Matcher matcher = pattern.matcher(input);
//        System.out.println(matcher.matches());
        int hihi = 10;
        String str = String.valueOf(hihi);
        System.out.println(str instanceof String);
    }
//    -	Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:
//-	Nếu là Villa thì XX sẽ là VL
//-	Nếu là House thì XX sẽ là HO
//-	Nếu Room thì XX sẽ là RO
//-	Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường
//-	Diện tích sử dụng và diện tích hồ bơi phải là số thực lớn hơn 30m2
//-	Chi phí thuê phải là số dương
//-	Số lượng người tối đa phải >0 và nhỏ hơn <20
//-	Số tầng phải là số nguyên dương.
//-	 Kiểu thuê, Tiêu chuẩn phòng chuẩn hóa dữ liệu giống tên dịch v
//-	Ngày sinh phải nhỏ hơn ngày hiện tại 18 năm, người dùng không được quá 100 tuổi và phải đúng định dạng dd/mm/YYYY (sử dụng User Exception)
}





