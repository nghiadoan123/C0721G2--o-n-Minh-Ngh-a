package phuong_tien_giao_thong.models.input;

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
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String inputBienKIemSoatXeTai() {
        while (true) {
            System.out.println("Enter bien kiem soat");
            String bienKiemSoat = scanner.nextLine();
            if (validateBienKiemSoatXeTai(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap bien kiem soat lai");
            }
        }
    }

    public static boolean validateBienKiemSoatXeTai(String bienKiemSoat) {
        String regex = "^\\d\\d[C]\\d\\d\\d.\\d\\d$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputBienKIemSoatXeDuLich() {
        while (true) {
            System.out.println("Enter bien kiem soat");
            String bienKiemSoat = scanner.nextLine();
            if (validateBienKiemSoatXeDuLich(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap bien kiem soat lai");
            }
        }
    }

    public static boolean validateBienKiemSoatXeDuLich(String bienKiemSoat) {
        String regex = "^\\d\\d[A]\\d\\d\\d.\\d\\d$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputBienKIemSoatXeKhach() {
        while (true) {
            System.out.println("Enter bien kiem soat");
            String bienKiemSoat = scanner.nextLine();
            if (validateBienKiemSoatXeDuLich(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap bien kiem soat lai");
            }
        }
    }

    public static boolean validateBienKiemSoatXeKhach(String bienKiemSoat) {
        String regex = "^\\d\\d[B]\\d\\d\\d.\\d\\d$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputNấmnXuat() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        return name;
    }

    public static String inputChuSoHuu() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        return name;
    }

    public static int inputSoChoNgoi() {
        while (true) {
            System.out.println("Enter ID Card Number");
            String inputSoChoNgoi = scanner.nextLine();
            if (isStringInt(inputSoChoNgoi)) {
                int choNgoi = Integer.parseInt(inputSoChoNgoi);
                if (choNgoi>0) {
                    return choNgoi;
                }else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }


}
