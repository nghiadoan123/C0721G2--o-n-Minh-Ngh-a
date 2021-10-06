package phuong_tien_giao_thong.services;

import phuong_tien_giao_thong.models.input.Input;
import phuong_tien_giao_thong.models.phuong_tien.HangSanXuat;
import phuong_tien_giao_thong.models.phuong_tien.Oto;
import phuong_tien_giao_thong.models.phuong_tien.XeMay;
import phuong_tien_giao_thong.models.phuong_tien.XeTai;
import phuong_tien_giao_thong.utils.HangSanXuatReadFileToCSV;
import phuong_tien_giao_thong.utils.OtoReadAndWriteToCSV;
import phuong_tien_giao_thong.utils.XeMayReadAndWriteToCSV;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class XeMayService implements Service{

    public static Scanner scanner = new Scanner(System.in);
    public static final String HSX_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\phuong_tien_giao_thong\\data\\hangSanXuat.csv";
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\phuong_tien_giao_thong\\data\\xeMay.csv";
    public static ArrayList<HangSanXuat> hangSanXuatsList = HangSanXuatReadFileToCSV.readHangSanXuatFromCSV(HSX_FILE_PATH);
    public static TreeSet<XeMay> xeMayList = XeMayReadAndWriteToCSV.readListFromCSV(FILE_PATH);




    @Override
    public void add() {

        for (HangSanXuat hangSanXuat: hangSanXuatsList) {
            System.out.println(hangSanXuat);
        }
        String bienKiemSoat = Input.inputBienKIemSoatXeOto();
        String tenHangSanXuat = Input.inputTenHangSanXuat();
        String namSanXuat = Input.inputNamsanXuat();
        String chuSoHuu = Input.inputChuSoHuu();
        double congSuat = Input.inputCongSuat();
        XeMay xeMay = new XeMay(bienKiemSoat,tenHangSanXuat,namSanXuat,chuSoHuu,congSuat);
        xeMayList.add(xeMay);
        XeMayReadAndWriteToCSV.writeListToCSV(xeMayList,FILE_PATH,false);

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        for (XeMay xeMay: xeMayList) {
            System.out.println(xeMay);
        }
    }

    @Override
    public void remove() {
        boolean flagRemove = true;
        System.out.println("nhập vào biển kiểm soát cần xóa");
        String inputBienKiemSoat = Input.inputBienKIemSoatXeOto();
        for (XeMay xeMay: xeMayList) {
            if (xeMay.getBienKiemSoat().equals(inputBienKiemSoat)){
                do {
                    System.out.println("Chọn chức năng\n" +
                            "1.xóa .\n" +
                            "2.Không xóa. \n" +
                            "3.exit\n" );
                    int chooseCase1 = Integer.parseInt(scanner.nextLine());
                    switch (chooseCase1){
                        case 1:
                            System.out.println("xóa thành thông"+xeMay);
                            xeMayList.remove(xeMay);
                            flagRemove = false;
                            break;
                        case 2:
                            flagRemove = false;
                            break;
                        case 3:
                            flagRemove = false;
                            break;
                    }
                }while (flagRemove);

            }
        }
        XeMayReadAndWriteToCSV.writeListToCSV(xeMayList,FILE_PATH,false);
    }
}
