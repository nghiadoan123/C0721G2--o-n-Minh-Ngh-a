package services.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class InputDayForm {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputBirthday() {
        while (true) {
            System.out.println("Enter birthday (dd/MM/yyyy) ");
            String birthday = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date birth = new Date();
                birth = simpleDateFormat.parse(birthday);
                int yearOld = LocalDate.now().getYear() - birth.getYear();
                if (yearOld > 17 && yearOld < 100 && yearOld < 0) {
                    System.out.println(birthday + " is valid date");
                } else {
                    System.out.println("Age must be between 18 and 100");
                }
                String birthReturn = simpleDateFormat.format(birth);
                return birthReturn;
            } catch (ParseException e) {
                System.out.println("Please enter birthday again");
            }
        }
    }

    public static Date inputCheckInOut() {
        while (true) {
            System.out.println("Enter day (dd/MM/yyyy) ");
            String day = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return simpleDateFormat.parse(day);
            } catch (ParseException e) {
                System.out.println("Please enter day again");
            }
        }
    }
}
