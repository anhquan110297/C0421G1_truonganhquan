package _case_study.furama_resort.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexClass {
    public boolean regexNameService(String nameService) {
        final String REGEX_SERVICE = "^(SVVL|SVRO|SVHO)-[0-9]{4}$";
        Pattern pattern = Pattern.compile(REGEX_SERVICE);
        Matcher matcher = pattern.matcher(nameService);
        boolean result = matcher.matches();
        return result;
    }

    public boolean area(String area) {
        final String REGEX_AREA_POOL = "^([3-9]\\d|[0-9]\\d{2,})$"; // 1 số lớn hơn bao nhiêu ( cụ thể là 30)
        Pattern pattern = Pattern.compile(REGEX_AREA_POOL);
        Matcher matcher = pattern.matcher(area);
        boolean result = matcher.matches();
        return result;
    }

    public boolean numberOfPeople(String numberOfPeople) {
        final String REGEX_NUMBER_OF_PEOPLE = "^([1]\\d|[1-9])$"; // LỚN HƠN 1 SỐ VÀ BÉ HƠN 20
        Pattern pattern = Pattern.compile(REGEX_NUMBER_OF_PEOPLE);
        Matcher matcher = pattern.matcher(numberOfPeople);
        boolean result = matcher.matches();
        return result;
    }

    public boolean rentalFee(String rentalFee) {
        final String REGEX_RENTAL_FEE = "^[+]?([.]\\d+|\\d+[.]?\\d*)$"; // số dương thập phân
        Pattern pattern = Pattern.compile(REGEX_RENTAL_FEE);
        Matcher matcher = pattern.matcher(rentalFee);
        boolean result = matcher.matches();
        return result;
    }

    public boolean numberOfFloor(String numberOfFloor) {
        final String REGEX_NUMBER_OF_PEOPLE = "^\\d+$"; // LỚN HƠN 1 SỐ VÀ BÉ HƠN 20
        Pattern pattern = Pattern.compile(REGEX_NUMBER_OF_PEOPLE);
        Matcher matcher = pattern.matcher(numberOfFloor);
        boolean result = matcher.matches();
        return result;
    }

    public boolean roomStandard(String roomStandard) {
        final String REGEX_ROOM_STANDARD = "^(NORMAL|LOW|VIP)-[0-9]{4}$";
        Pattern pattern = Pattern.compile(REGEX_ROOM_STANDARD);
        Matcher matcher = pattern.matcher(roomStandard);
        boolean result = matcher.matches();
        return result;
    }

    public boolean rentOfType(String rentOfType) {
        final String REGEX_RENT_TYPE = "^(DAY|MONTH|WEEK)$";
        Pattern pattern = Pattern.compile(REGEX_RENT_TYPE);
        Matcher matcher = pattern.matcher(rentOfType);
        boolean result = matcher.matches();
        return result;
    }

    public boolean dayOfBirth(String dayOfBirth) {
        final String REGEX_DD_MM_YY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
        Pattern pattern = Pattern.compile(REGEX_DD_MM_YY);
        Matcher matcher = pattern.matcher(dayOfBirth);
        boolean result = matcher.matches();
        return result;
    }


}
