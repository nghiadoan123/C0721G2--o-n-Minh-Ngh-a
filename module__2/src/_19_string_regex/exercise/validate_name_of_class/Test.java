package _19_string_regex.exercise.validate_name_of_class;

public class Test {
    public static final String[] validClassName = new String[] { "C0318G", "A0318H", "P0318I" };
    public static final String[] invalidClassName = new String[] { "M0318G", "M0318L", "P0318N"};

    public static void main(String[] args) {
        for (String string: validClassName) {
            boolean isValid = ValidateClassName.validateClassName(string);
            System.out.println("class name is " + string +" is valid: "+ isValid);
        }

        for (String string: invalidClassName) {
            boolean inValid = ValidateClassName.validateClassName(string);
            System.out.println("class name is " + string +" is valid: "+ inValid);
        }

    }
}
