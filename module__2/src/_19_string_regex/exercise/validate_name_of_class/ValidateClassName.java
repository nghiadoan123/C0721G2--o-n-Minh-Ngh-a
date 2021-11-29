package _19_string_regex.exercise.validate_name_of_class;

public class ValidateClassName {
    public static boolean validateClassName(String name){
        String regex = "^[CAP]\\d{4}[GHIKLM]$";
        return name.matches(regex);
    }
}
