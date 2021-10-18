package audit.input;

import audit.model.SoTietKiem;
import audit.service.SoTietKiemService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

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

    public static boolean validateMaSoxo(String ten) {
        String regex = "^[S][T][K]\\d{4}$";
        return ten.matches(regex);
    }

    public static String inputMaSoXo() {
        while (true) {
            boolean flag = true;
            System.out.println("Nhập ma số sổ");
            String ten = scanner.nextLine();
            if (validateMaSoxo(ten)) {
                for (SoTietKiem soTietKiem : SoTietKiemService.soTietKiemArrayList) {
                    if (soTietKiem.getMaKhachHang().equals(ten)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return ten;
                } else {
                    System.out.println("Id does exist. Enter again");
                }
                
            } else {
                System.out.println("nhap lại");
            }
        }
    }

    public static String inputName() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        return name;
    }

    public static double soTienGui() {
        while (true) {
            System.out.println("nhap số tienf gửi");
            String useElectric = scanner.nextLine();
            if (isStringDouble(useElectric)) {
                int useElectric1 = Integer.parseInt(useElectric);
                if (useElectric1 > 1000000) {
                    return useElectric1;
                } else {
                    System.out.println("nhập lại");
                }
            } else {
                System.out.println("nhập lại");
            }
        }
    }

    public static int laiXuat() {
        while (true) {
            System.out.println("nhap số lãi xuất");
            String useElectric = scanner.nextLine();
            if (isStringInt(useElectric)) {
                int useElectric1 = Integer.parseInt(useElectric);
                if (useElectric1 > 0) {
                    return useElectric1;
                } else {
                    System.out.println("nhập lại");
                }
            } else {
                System.out.println("nhập lại");
            }
        }
    }

    public static int kiHan() {
        while (true) {
            System.out.println("nhap số ki han");
            String useElectric = scanner.nextLine();
            if (isStringInt(useElectric)) {
                int useElectric1 = Integer.parseInt(useElectric);
                if (useElectric1 > 0) {
                    return useElectric1;
                } else {
                    System.out.println("nhập lại");
                }
            } else {
                System.out.println("nhập lại");
            }
        }
    }

    public static String inputUuDai() {
        while (true) {
            System.out.println("nhập uu dai");
            String uuDai = scanner.nextLine();
            if (validateUuDai(uuDai)) {
                return uuDai;
            } else {
                System.out.println("nhap lại tên ưu đãi");
            }
        }

    }

    public static boolean validateUuDai(String bienKiemSoat) {
        String regex = "^([d][u])|([c][a][p])|([t][u][i][x][a][c][h])$";
        return bienKiemSoat.matches(regex);
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
                    System.out.println("nhập lại sô lớn hơn 0");
                }
            } else {
                System.out.println("nhập lại");
            }
        }
    }

    public static String inputNgayMoSo() {
        while (true) {
            System.out.println("nhập ngày mở sổ (dd/MM/yyyy) ");
            String day = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date day1 = simpleDateFormat.parse(day);
                int day2 = day1.getDate() - LocalDate.now().getDayOfMonth();
                int month = day1.getMonth() - (LocalDate.now().getMonthValue() - 1);
                int year = day1.getYear() - (LocalDate.now().getYear() - 1900);
//                System.out.println(day1.getDate());
//                System.out.println(LocalDate.now().getDayOfMonth());
//                System.out.println(year);
                return simpleDateFormat.format(day1);
            } catch (ParseException e) {
                System.out.println("nhập lại");
            }
        }
    }

    public static String inputThoiGianBatDau() {
        while (true) {
            System.out.println("nhập ngày bắt đàu (dd/MM/yyyy) ");
            String day = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date day1 = simpleDateFormat.parse(day);
                int day2 = day1.getDate() - LocalDate.now().getDayOfMonth();
                int month = day1.getMonth() - (LocalDate.now().getMonthValue() - 1);
                int year = day1.getYear() - (LocalDate.now().getYear() - 1900);
//                System.out.println(day1.getDate());
//                System.out.println(LocalDate.now().getDayOfMonth());
//                System.out.println(year);
                return simpleDateFormat.format(day1);
            } catch (ParseException e) {
                System.out.println("nhập lại");
            }
        }
    }
}
