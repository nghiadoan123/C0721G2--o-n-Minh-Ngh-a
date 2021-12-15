package util;

public class Validate {

    public static boolean validateMaBenhNhan(String string) {
        String regex = "(^BN-\\d{3,}+$)";
        return string.matches(regex);
    }

    public static boolean validateMaBenhAn(String string) {
        String regex = "(^BA-\\d{3,}+$)";
        return string.matches(regex);
    }


//    public static boolean validatePhonenumber(String string) {
//        String regex ="(^09[01]\\d{7}$)||(\\(^84\\)\\+9[01]\\d{7}$)";
//        return string.matches(regex);
//    }

}
