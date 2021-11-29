package cinemar.service;

import cinemar.input.InputCinema;
import cinemar.model.Cinema;
import cinemar.util.CinemaReadAndWriteToCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaService {

    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\cinemar\\data\\cinema.csv";
    public static ArrayList<Cinema> cinemaList = CinemaReadAndWriteToCSV.readListFromCSV(FILE_PATH);


    public void display() {
        for (Cinema cinema : cinemaList) {
            System.out.println(cinema);
        }
    }

    public void add() {
        String maXuatChieuPhim = InputCinema.inputMaXuatChieuPhim();
        String tenPhim = InputCinema.inputTenPhim();
        String ngayChieu = InputCinema.inputNgayChieuPhim();
        int soLuongVe = InputCinema.inputSoLuongVe();
        Cinema cinema = new Cinema(maXuatChieuPhim, tenPhim, ngayChieu, soLuongVe);
        cinemaList.add(cinema);
        CinemaReadAndWriteToCSV.writeListToCSV(cinemaList, FILE_PATH, false);
    }

    public void delete() {
        System.out.println("nhập vào mã xuất chiếu phim");
        String maChieuPhim = scanner.nextLine();
        int index = 0;
        for (Cinema cinema : cinemaList) {
            if (cinema.getMaXuatChieuPhim().equals(maChieuPhim)) {
                index = cinemaList.indexOf(cinema);
            } else {
                System.out.println("not found");
            }
        }
        for (Cinema cinema : cinemaList) {
            if (cinema.getMaXuatChieuPhim().equals(maChieuPhim)) {
                while (true) {
                    System.out.println("Chọn chức năng\n" +
                            "1.xóa .\n" +
                            "2.Không xóa. \n" +
                            "3.exit\n");
                    String chooseCase1 = scanner.nextLine();
                    switch (chooseCase1) {
                        case "1":
                            cinemaList.remove(index);
                            CinemaReadAndWriteToCSV.writeListToCSV(cinemaList, FILE_PATH, false);
                            System.out.println("xóa thành công: " + cinema);
                            return;
                        case "2":
                            return;
                        case "3":
                            return;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
