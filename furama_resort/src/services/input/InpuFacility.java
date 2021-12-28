package services.input;

import java.util.Scanner;

public class InpuFacility {
    static Scanner scanner = new Scanner(System.in);

    public static String serviceNameInput() {
        String serviceNameInput = "";
        do {
            System.out.println("input service name:");
            serviceNameInput = scanner.nextLine();
        } while (!validateServiceName(serviceNameInput));

        return serviceNameInput;
    }

    public static int usableAreaInput() {
        int usableAreaInput = 0;
        while (true){
            try {
                System.out.println("input use able area :");
                usableAreaInput = Integer.parseInt(scanner.nextLine());
                if (usableAreaInput>=30){
                    return usableAreaInput;
                }else {
                    System.out.println("input area >30");
                }
            } catch (Exception e) {
                System.out.println("nhập sai qui chuẩn mời nhập lại");
            }
        }
    }

    public static int rentalCostInput() {
        int rentalCostInput = 0;
        while (true){
            try {
                System.out.println("input rental cost :");
                rentalCostInput = Integer.parseInt(scanner.nextLine());
                if (rentalCostInput>0){
                    return rentalCostInput;
                }else {
                    System.out.println("input again");
                }
            } catch (Exception e) {
                System.out.println("nhập sai qui chuẩn mời nhập lại");
            }
        }

    }

    public static int maxNumberOfTenantsInput() {
        int maxNumberOfTenantsInput = 0;
        while (true) {
            try {
                System.out.println("input max person :");
                maxNumberOfTenantsInput = Integer.parseInt(scanner.nextLine());
                if (maxNumberOfTenantsInput > 0 && maxNumberOfTenantsInput <= 20) {
                    return maxNumberOfTenantsInput;
                } else {
                    System.out.println("input again");
                }
            } catch (Exception e) {
                System.out.println("nhập sai qui chuẩn");
            }
        }
    }

    public static int numberOfFloorInput() {
        int numberOfFloor = 0;
        while (true) {
            try {
                System.out.println("input number of floor :");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
                if (numberOfFloor > 0 && numberOfFloor <= 30) {
                    return numberOfFloor;
                } else {
                    System.out.println("input again");
                }
            } catch (Exception e) {
                System.out.println("nhập sai qui chuẩn");
            }
        }
    }

    public static boolean validateServiceName(String name) {
        String regexServiceName = "[S][V]([V][L]|[HR][O])-\\d{4}";
        String regexServiceName1 = "[0-9A-Za-z!@#$%-^&*()]\\d{6,}";
        return name.matches(regexServiceName1);
    }

}
