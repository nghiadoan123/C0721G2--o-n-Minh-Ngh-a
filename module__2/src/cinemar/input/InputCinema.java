package cinemar.input;

import cinemar.model.Cinema;
import cinemar.service.CinemaService;
import cinemar.util.CinemaReadAndWriteToCSV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InputCinema {
    static Scanner scanner = new Scanner(System.in);
//    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\cinemar\\data\\cinema.csv";
//    public static ArrayList<Cinema> cinemaList = CinemaReadAndWriteToCSV.readListFromCSV(FILE_PATH);


    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String inputMaXuatChieuPhim() {
        while (true) {
            boolean flag = true;
            System.out.println("nhập Xuat Chieu Phim");
            String inputXuatChieuPhim = scanner.nextLine();
            if (validateMaXuatChieuPhim(inputXuatChieuPhim)) {
                for (Cinema cinema : CinemaService.cinemaList) {
                    if (cinema.getMaXuatChieuPhim().equals(inputXuatChieuPhim)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return inputXuatChieuPhim;
                } else {
                    System.out.println("Id does exist. Enter again");
                }
            } else {
                System.out.println("Enter again ex:CI-1234");
            }

        }
    }

    public static boolean validateMaXuatChieuPhim(String string) {
        String regex = "^[C][I]-\\d{4}$";
        return string.matches(regex);
    }

    public static String inputTenPhim() {
        System.out.println("Nhập tên phim");
        String name = scanner.nextLine();
        return name;
    }

    public static String inputNgayChieuPhim() {
        while (true) {
            System.out.println("nhập ngày chiều phim (dd/MM/yyyy) ");
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
                if (year == 0) {
                    if (month == 0) {
                        if (day2 > 0) {
                            System.out.println("hợp lệ");
                            return simpleDateFormat.format(day1);
                        } else {
                            System.out.println("không hợp lệ ngày nhập phải lớn hơn ngày hiện tai");
                            System.out.println("ngày hiện tại là:" + LocalDate.now());

                        }
                    } else {
                        System.out.println("không hợp lệ tháng nhập phải bằng tháng hiện tai");
                        System.out.println("ngày hiện tại là:" + LocalDate.now());
                    }
                } else {
                    System.out.println("không hợp lệ năm nhập phải bằng năm hiện tai");
                    System.out.println("ngày hiện tại là:" + LocalDate.now());
                }
            } catch (ParseException e) {
                System.out.println("nhập lại");
            }
        }
    }

    public static int inputSoLuongVe() {
        while (true) {
            System.out.println("nhap số lượng vé");
            String inputSoLuongVe = scanner.nextLine();
            if (isStringInt(inputSoLuongVe)) {
                int inputSoLuongVe1 = Integer.parseInt(inputSoLuongVe);
                if (inputSoLuongVe1 > 0) {
                    return inputSoLuongVe1;
                } else {
                    System.out.println("enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

}
