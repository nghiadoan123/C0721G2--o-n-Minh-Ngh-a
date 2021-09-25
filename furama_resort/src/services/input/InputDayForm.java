package services.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                Date birth = simpleDateFormat.parse(birthday);
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
}
