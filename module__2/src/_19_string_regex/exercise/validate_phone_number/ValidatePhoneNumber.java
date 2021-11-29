package _19_string_regex.exercise.validate_phone_number;

public class ValidatePhoneNumber {
    public static boolean validatePhoneNumber(String name){
        String regex = "^[(]\\d{2}[)]-[(][0]\\d{9}[)]$";
        return name.matches(regex);
    }

}
