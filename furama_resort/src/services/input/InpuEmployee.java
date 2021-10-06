package services.input;

import java.util.Scanner;

public class InpuEmployee {
    static Scanner scanner = new Scanner(System.in);

    public static double salary() {
        double salary = 0;
        boolean flag = true;
        do {
            try {
                System.out.println("input salary:");
                salary = Double.parseDouble(scanner.nextLine());
                flag = false;
            } catch (Exception e) {
                flag = true;
                System.out.println("nhập sai qui chuẩn mời nhập lại");
            }
        } while (flag);
        return salary;
    }
}
