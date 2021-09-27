package _19_string_regex.exercise.validate_phone_number;

public class ValidatePhoneNumber {
    public static boolean validatePhoneNumber(String name){
        String regex = "[(]\\d{2}[)]-";
        return name.matches(regex);
    }

}
