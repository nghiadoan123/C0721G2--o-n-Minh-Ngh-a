package util;

public class Validate {

    public static boolean validateName(String string) {
        String regex = "(^([A-Z]{1}+[a-z]{1,}\\s)+$)";
        return string.matches(regex);
    }
}
