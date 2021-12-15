package util;

public class Validate {

    public static boolean validateName(String string) {
        String regex = "(^([A-Z]{1}+[a-z]{1,}\\s)+$)";
        return string.matches(regex);
    }

    public static boolean validateEmail(String string) {
        String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        return string.matches(regex);
    }


    public static boolean validatePhonenumber(String string) {
        String regex ="(^09[01]\\d{7}$)||(\\(^84\\)\\+9[01]\\d{7}$)";
        return string.matches(regex);
    }

}
