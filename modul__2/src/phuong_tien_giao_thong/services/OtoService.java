package phuong_tien_giao_thong.services;

import phuong_tien_giao_thong.models.input.Input;
import phuong_tien_giao_thong.models.phuong_tien.HangSanXuat;
import phuong_tien_giao_thong.models.phuong_tien.Oto;
import phuong_tien_giao_thong.models.phuong_tien.PhuongTien;
import phuong_tien_giao_thong.models.phuong_tien.XeTai;
import phuong_tien_giao_thong.utils.HangSanXuatReadFileToCSV;
import phuong_tien_giao_thong.utils.OtoReadAndWriteToCSV;

import java.util.*;

public class OtoService implements Service {
    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\phuong_tien_giao_thong\\data\\oto.csv";
    public static final String HSX_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\phuong_tien_giao_thong\\data\\hangSanXuat.csv";

    public static TreeSet<Oto> otoList = OtoReadAndWriteToCSV.readListFromCSV(FILE_PATH);
    public static ArrayList<HangSanXuat> hangSanXuatsList = HangSanXuatReadFileToCSV.readHangSanXuatFromCSV(HSX_FILE_PATH);

    public static String chonKieuXe() {
        while (true) {
            System.out.println("chon kieu xe" + "\n" + "1.KIEU_DU_LICH" + "\n" + "2.KIEU_XE_KHACH" + "\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return Oto.KIEU_DU_LICH;
                case "2":
                    return Oto.KIEU_XE_KHACH;
                default:
                    System.out.println("in put again");
                    break;
            }
        }
    }


    @Override
    public void add() {
        for (HangSanXuat hangSanXuat: hangSanXuatsList) {
            System.out.println(hangSanXuat);
        }
        String bienKiemSoat = Input.inputBienKIemSoatXeOto();
        String tenHangSanXuat = Input.inputTenHangSanXuat();
        String namSanXuat = Input.inputNamsanXuat();
        String chuSoHuu = Input.inputChuSoHuu();
        int soChoNgoi = Input.inputSoChoNgoi();
        String chonKieuXe =OtoService.chonKieuXe();
        Oto oto = new Oto(bienKiemSoat,tenHangSanXuat,namSanXuat,chuSoHuu,soChoNgoi,chonKieuXe);
        otoList.add(oto);
        OtoReadAndWriteToCSV.writeListToCSV(otoList,FILE_PATH,false);
    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        for (Oto oto: otoList) {
            System.out.println(oto);
        }
    }

    @Override
    public void remove() {
        boolean flagRemove = true;
        System.out.println("nhập vào biển kiểm soát cần xóa");
       String inputBienKiemSoat = Input.inputBienKIemSoatXeOto();
        for (Oto oto: otoList) {
            if (oto.getBienKiemSoat().equals(inputBienKiemSoat)){
                do {
                    System.out.println("Chọn chức năng\n" +
                            "1.xóa .\n" +
                            "2.Không xóa. \n" +
                            "3.exit\n" );
                    int chooseCase1 = Integer.parseInt(scanner.nextLine());
                    switch (chooseCase1){
                        case 1:
                            System.out.println("xóa thành thông"+oto);
                            otoList.remove(oto);
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
        OtoReadAndWriteToCSV.writeListToCSV(otoList,FILE_PATH,false);
    }
}
