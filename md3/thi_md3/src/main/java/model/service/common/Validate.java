package model.service.common;

public class Validate {
    public String name (String name){
        String message = null;
        final String REGEX = "^[a-zA-Z\\s]+";
        if (!name.matches(REGEX)){
            message = "Wrong!!! Name dont have number";
        }
        return message;
    }
}
