package _19_string_regex.exercise.validate_phone_number;

public class TestPhoneNumber {
    public static final String[] validPhoneNumber = new String[] { "(84)-(0978489648)", "(80)-(0978434648)"};
    public static final String[] invalidPhoneNumber = new String[] { "84)-(0978489648)", "(84)-(09784896482)"};

    public static void main(String[] args) {
        for (String phoneNum: validPhoneNumber) {
            boolean isValid = ValidatePhoneNumber.validatePhoneNumber(phoneNum);
            System.out.println("phone number  is " + phoneNum +" is valid: "+ isValid);
        }

        for (String phoneNum: invalidPhoneNumber) {
            boolean isValid = ValidatePhoneNumber.validatePhoneNumber(phoneNum);
            System.out.println("phone number is " + phoneNum +" is valid: "+ isValid);
        }

    }
}
