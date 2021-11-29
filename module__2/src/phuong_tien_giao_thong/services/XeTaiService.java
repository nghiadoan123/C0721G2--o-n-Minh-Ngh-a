package phuong_tien_giao_thong.services;

import phuong_tien_giao_thong.models.input.Input;
import phuong_tien_giao_thong.models.phuong_tien.HangSanXuat;
import phuong_tien_giao_thong.models.phuong_tien.XeMay;
import phuong_tien_giao_thong.models.phuong_tien.XeTai;
import phuong_tien_giao_thong.utils.HangSanXuatReadFileToCSV;
import phuong_tien_giao_thong.utils.XeMayReadAndWriteToCSV;
import phuong_tien_giao_thong.utils.XeTaiReadAndWriteToCSV;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class XeTaiService implements Service {

    public static Scanner scanner = new Scanner(System.in);
    public static final String HSX_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\phuong_tien_giao_thong\\data\\hangSanXuat.csv";
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\phuong_tien_giao_thong\\data\\xeTai.csv";
    public static ArrayList<HangSanXuat> hangSanXuatsList = HangSanXuatReadFileToCSV.readHangSanXuatFromCSV(HSX_FILE_PATH);
    public static TreeSet<XeTai> xeTaiList = XeTaiReadAndWriteToCSV.readListFromCSV(FILE_PATH);

    @Override
    public void add() {
        for (HangSanXuat hangSanXuat: hangSanXuatsList) {
            System.out.println(hangSanXuat);
        }
        String bienKiemSoat = Input.inputBienKIemSoatXeOto();
        String tenHangSanXuat = Input.inputTenHangSanXuat();
        String namSanXuat = Input.inputNamsanXuat();
        String chuSoHuu = Input.inputChuSoHuu();
        double trongTai = Input.inputTrongTai();
        XeTai xeTai = new XeTai(bienKiemSoat,tenHangSanXuat,namSanXuat,chuSoHuu,trongTai);
        xeTaiList.add(xeTai);
        XeTaiReadAndWriteToCSV.writeListToCSV(xeTaiList,FILE_PATH,false);
    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        for (XeTai xeTai: xeTaiList) {
            System.out.println(xeTai);
        }
    }

    @Override
    public void remove() {
        boolean flagRemove = true;
        System.out.println("nhập vào biển kiểm soát cần xóa");
        String inputBienKiemSoat = Input.inputBienKIemSoatXeOto();
        for (XeTai xeTai: xeTaiList) {
            if (xeTai.getBienKiemSoat().equals(inputBienKiemSoat)){
                do {
                    System.out.println("Chọn chức năng\n" +
                            "1.xóa .\n" +
                            "2.Không xóa. \n" +
                            "3.exit\n" );
                    int chooseCase1 = Integer.parseInt(scanner.nextLine());
                    switch (chooseCase1){
                        case 1:
                            System.out.println("xóa thành thông"+xeTai);
                            xeTaiList.remove(xeTai);
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
        XeTaiReadAndWriteToCSV.writeListToCSV(xeTaiList,FILE_PATH,false);
    }
}
