package services.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class PersonInput {
    static Scanner scanner = new Scanner(System.in);

    public static String inputId() {
        String id ="";
        try {
            System.out.println("input id:");
            id = scanner.nextLine();
        } catch (Exception e) {

        }
        return id;
    }

    public static String inputName() {
        String name ="";
        try {
            System.out.println("input name:");
            name = scanner.nextLine();
        } catch (Exception e) {

        }
        return name;
    }

    public static String inputBirthday() {
        while (true) {
            System.out.println("Enter birthday (dd/MM/yyyy) ");
            String birthday = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date birth = simpleDateFormat.parse(birthday);
                int yearOld = LocalDate.now().getYear()-birth.getYear()-1900;
                System.out.println(yearOld);
                if (yearOld>17&&yearOld<100&&yearOld<0) {
                    System.out.println(birthday + " is valid date");
                } else {
                    System.out.println("Age must be between 18 and 100");
                }

                return simpleDateFormat.format(birth);
            } catch (ParseException e) {
                System.out.println("Please enter birthday again");
            }
        }
    }

    public static String inputCheckInOut() {
        while (true) {
            System.out.println("Enter day (dd/MM/yyyy) ");
            String day = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date birth = simpleDateFormat.parse(day);
                return simpleDateFormat.format(birth);
            } catch (ParseException e) {
                System.out.println("Please enter day again");
            }
        }
    }

    public static String inputGender() {
        String gender ="";
        try {
            System.out.println("input Gender:");
            gender = scanner.nextLine();
        } catch (Exception e) {

        }
        return gender;
    }

    public static int identityNumber() {
        int  identityNumber =0;
        try {
            System.out.println("input identity Number:");
            identityNumber = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {

        }
        return identityNumber;
    }

    public static String phoneNumber() {
        String phoneNumeber ="";
        try {
            System.out.println("input phone Number:");
            phoneNumeber = scanner.nextLine();
        } catch (Exception e) {

        }
        return phoneNumeber;
    }

    public static String emailInput() {
        String emailInput = "";
        do {
            System.out.println("input email:");
            emailInput = scanner.nextLine();
        } while (!validateEmail(emailInput));

        return emailInput;
    }

    public static boolean validateEmail(String name) {
        String regexEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return name.matches(regexEmail);
    }

}
