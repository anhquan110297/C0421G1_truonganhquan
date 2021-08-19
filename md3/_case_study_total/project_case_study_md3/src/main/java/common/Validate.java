package common;

public class Validate {
    //dv tuowng tu dv - xxxx
    public  String customerCode (String code){
    String message = null;
    final String REGEX = "^KH-[0-9]{4}$";
        if (!code.matches(REGEX)) {
            message = "Wrong!!! Customer code KH-XXXX and X is a number";
        }
        return message;
    }

    public String name (String name){
        String message = null;
        final String REGEX = "^[a-zA-Z\\s]+";
        if (!name.matches(REGEX)){
            message = "Wrong!!! Name dont have number";
        }
        return message;
    }

    public  String telephoneNumber (String telephoneNumber){
    String message = null;
    final String REGEX = "^(09[0-1]\\d{7})|(\\(84\\)\\+9[01]\\d{7})$";
        if (!telephoneNumber.matches(REGEX)) {
            message = "Wrong!!! Please re-enter (Ex: 090 or 091 or +8490 or +84091 )";
        }
        return message;
    }

    public  String email (String email){
    String message = null;
    final String REGEX = "^[(a-z|A-Z)0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
        if (!email.matches(REGEX)) {
            message = "Wrong!!! email is incorrect";
        }
        return message;
    }

}
