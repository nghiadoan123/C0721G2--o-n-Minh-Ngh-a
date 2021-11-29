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
        String regex = "^\\d\\d[C]-\\d\\d\\d.\\d\\d$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputBienKIemSoatXeMay() {
        while (true) {
            System.out.println("Enter bien kiem soat");
            String bienKiemSoat = scanner.nextLine();
            if (validateBienKiemSoatXeMay(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap bien kiem soat lai");
            }
        }
    }

    public static boolean validateBienKiemSoatXeMay(String bienKiemSoat) {
        String regex = "^\\d\\d-[A-Z](\\d|[A-Z])-\\d\\d\\d.\\d\\d$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputBienKIemSoatXeOto() {
        while (true) {
            System.out.println("Enter bien kiem soat");
            String bienKiemSoat = scanner.nextLine();
            if (validateBienKiemSoatXeOto(bienKiemSoat)) {
                return bienKiemSoat;
            } else {
                System.out.println("nhap bien kiem soat lai");
            }
        }
    }

    public static boolean validateBienKiemSoatXeOto(String bienKiemSoat) {
        String regex = "^\\d\\d[AB]-\\d\\d\\d.\\d\\d$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputTenHangSanXuat() {
        while (true) {
            System.out.println("nhập tên hãng sản xuất");
            String hangsanXuat = scanner.nextLine();
            if (validateTenHangSanXuat(hangsanXuat)) {
                return hangsanXuat;
            } else {
                System.out.println("nhap lại tên hãng sản xuất");
            }
        }
    }

    public static boolean validateTenHangSanXuat(String bienKiemSoat) {
        String regex = "^([Y][a][m][a][h][a])|([H][o][n][d][a])|([D][o][n][g][f][e][n][g])|([H][y][u][n][d][a][i])$";
        return bienKiemSoat.matches(regex);
    }

    public static String inputNamsanXuat() {
        while (true) {
            System.out.println("nhap nam san xuat");
            String name = scanner.nextLine();
            if (Integer.parseInt(name) > 0) {
                return name;
            } else {
                System.out.println("nhập lại nam san xuat");
            }

        }

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
                if (choNgoi > 0) {
                    return choNgoi;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static double inputTrongTai() {
        while (true) {
            System.out.println("nhap trong tai");
            String inputTrongTai = scanner.nextLine();
            if (isStringDouble(inputTrongTai)) {
                double trongTai = Double.parseDouble(inputTrongTai);
                if (trongTai > 0) {
                    return trongTai;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static double inputCongSuat() {
        while (true) {
            System.out.println("nhap cong suat");
            String inputCongSuat = scanner.nextLine();
            if (isStringDouble(inputCongSuat)) {
                double congSuat = Double.parseDouble(inputCongSuat);
                if (congSuat > 0) {
                    return congSuat;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }


}
