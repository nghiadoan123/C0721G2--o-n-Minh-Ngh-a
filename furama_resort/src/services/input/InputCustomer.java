package services.input;

import java.util.Scanner;

public class InputCustomer {
    private static Scanner scanner = new Scanner(System.in);

    public static String address() {
        String address ="";
        try {
            System.out.println("input adress:");
            address = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("nhập sai định dạng");
        }
        return address;
    }

}
