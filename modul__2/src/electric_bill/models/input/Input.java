package electric_bill.models.input;

import electric_bill.models.customer.Customer;
import electric_bill.models.customer.ForengCustomer;
import electric_bill.service.CustomerSerrvice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);

    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static public boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static String inputIDKHVN() {
        while (true) {
            System.out.println("Enter mã  khvn");
            String bienKiemSoat = scanner.nextLine();
            if (validateKHVN(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap lại");
            }
        }
    }

    public static boolean validateKHVN(String bienKiemSoat) {
        String regex = "^[K][H][V][N]\\d{5}$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputIDKHNN() {
        while (true) {
            System.out.println("nhập mã khnn");
            String bienKiemSoat = scanner.nextLine();
            if (validateKHNN(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap lai");
            }
        }
    }

    public static boolean validateKHNN(String string) {
        String regex = "^[K][H][N][N]\\d{5}$";
        return string.matches(regex);
    }

    public static String inputName() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        return name;
    }

    public static String inputTypeOfCustomer() {
        while (true) {
            System.out.println("nhập loại kh");
            String inputTypeOfCustomer = scanner.nextLine();
            if (validateTypeOfCustomer(inputTypeOfCustomer)) {
                return inputTypeOfCustomer;
            } else {
                System.out.println("nhap lai");
            }
        }
    }

    public static boolean validateTypeOfCustomer(String string) {
        String regex = "^([S][i][n][h][h][o][a][t])|([K][i][n][h][d][o][a][n][h])|([S][a][n][x][u][a][t])$";
        return string.matches(regex);
    }

    public static double useElectric() {
        while (true) {
            System.out.println("nhap số điện sử dụng");
            String useElectric = scanner.nextLine();
            if (isStringDouble(useElectric)) {
                double useElectric1 = Double.parseDouble(useElectric);
                if (useElectric1 > 0) {
                    return useElectric1;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String inputCountry() {
        System.out.println("Enter country");
        String name = scanner.nextLine();
        return name;
    }

    public static String inputDayOfBill() {
        while (true) {
            System.out.println("Enter day (dd/MM/yyyy) ");
            String day = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date day1 = simpleDateFormat.parse(day);
                int yearOld = LocalDate.now().getYear() - day1.getYear() - 1900;
                System.out.println(yearOld);
                if (yearOld<5) {
                    System.out.println(day + "  hợp lệ");
                    return simpleDateFormat.format(day1);
                } else {
                    System.out.println("nam phai nhỏ hơn năm hiện tại trong khoảng 5 năm trở lại");
                }

            } catch (ParseException e) {
                System.out.println("nhập lại");
            }
        }
    }

    public static int numberOfElectric() {
        while (true) {
            System.out.println("nhap số kw điện sử dụng");
            String useElectric = scanner.nextLine();
            if (isStringInt(useElectric)) {
                int useElectric1 = Integer.parseInt(useElectric);
                if (useElectric1 > 0) {
                    return useElectric1;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static double inputUnitPrice() {
        while (true) {
            System.out.println("nhap đơn giá");
            String inputUnitPrice = scanner.nextLine();
            if (isStringDouble(inputUnitPrice)) {
                double useElectric1 = Double.parseDouble(inputUnitPrice);
                if (useElectric1 > 0) {
                    return useElectric1;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }
}
