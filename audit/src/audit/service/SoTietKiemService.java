package audit.service;

import audit.input.Input;
import audit.model.*;
import audit.util.SoTietKiemReadAndWriteToCSV;
import audit.util.UuDaiReadFileToCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class SoTietKiemService {

    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH_VTH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\vothoihan.csv";
    public static final String FILE_PATH_CTH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\cothoihan.csv";
    public static final String FILE_PATH_DTH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\daihan.csv";
    public static final String FILE_PATH_TONG = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\sotietkiem.csv";
    public static final String UU_DAI_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\uudai.csv";


    public static ArrayList<UuDai> uuDaiArrayList = UuDaiReadFileToCSV.readUudaiFromCSV(UU_DAI_FILE_PATH);
    public static ArrayList<SoTietKiem> soTietKiemVoThoiHanArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_VTH);
    public static ArrayList<SoTietKiem> soTietKiemDaiHanArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_DTH);
    public static ArrayList<SoTietKiem> soTietKiemCoThoiHanArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_CTH);
    public static ArrayList<SoTietKiem> soTietKiemArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_TONG);

    public void add() {
        for (UuDai uuDai: uuDaiArrayList) {
            System.out.println(uuDai);
        }
        boolean flag = true;
        System.out.println("Enter your choice" + "\n" + "1.thêm sổ co thời han" + "\n" + "2.thêm sổ vô thời hạn" + "\n" + "3.thêm sổ dài hạn" + "\n" + "4.Back to Menu");
        while (flag) {
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    SoTietKiemCoThoiHan soTietKiemCoThoiHan = new SoTietKiemCoThoiHan(Input.inputMaSoXo(),Input.inputName(),Input.inputNgayMoSo(),Input.inputThoiGianBatDau(),Input.kiHan(),Input.soTienGui(),Input.laiXuat());
                    soTietKiemArrayList.add(soTietKiemCoThoiHan);
                    soTietKiemCoThoiHanArrayList.add(soTietKiemCoThoiHan);
                    SoTietKiemReadAndWriteToCSV.writeListToCSV(soTietKiemArrayList, FILE_PATH_TONG, false);
                    SoTietKiemReadAndWriteToCSV.writeListToCSV(soTietKiemCoThoiHanArrayList, FILE_PATH_CTH, false);
                    flag = false;
                    break;
                case "2":
                    SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan(Input.inputMaSoXo(),Input.inputName(),Input.inputNgayMoSo(),Input.inputThoiGianBatDau(),Input.soTienGui(),Input.laiXuat());
                    soTietKiemArrayList.add(soTietKiemVoThoiHan);
                    soTietKiemVoThoiHanArrayList.add(soTietKiemVoThoiHan);

                    SoTietKiemReadAndWriteToCSV.writeListToCSV(soTietKiemArrayList, FILE_PATH_TONG, false);
                    SoTietKiemReadAndWriteToCSV.writeListToCSV(soTietKiemVoThoiHanArrayList, FILE_PATH_VTH, false);

                    flag = false;
                    break;
                case "3":
                   SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(Input.inputMaSoXo(),Input.inputName(),Input.inputNgayMoSo(),Input.inputThoiGianBatDau(),Input.kiHan(),Input.soTienGui(),Input.laiXuat(),Input.inputUuDai());
                    soTietKiemArrayList.add(soTietKiemDaiHan);
                    soTietKiemDaiHanArrayList.add(soTietKiemDaiHan);
                    flag = false;
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("enter again:");
            }

        }
    }

    public void display(){
        //SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_TONG);
        for (SoTietKiem soTietKiem: soTietKiemArrayList) {
            System.out.println(soTietKiem);
        }
    }

    public void delete(){
        ArrayList<SoTietKiem> arrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_TONG);
        System.out.println("nhập mã");
        String ma = scanner.nextLine();
        boolean flag = true;
//        for (SoTietKiem soTietKiem: soTietKiemArrayList) {
//            if (soTietKiem.getMaSoXo().equals(ma)){
//                soTietKiemArrayList.remove(soTietKiem);
//               flag = false;
//            }
//        }
        for (int i = 0; i <arrayList.size() ; i++) {
            if (arrayList.get(i).getMaSoXo().equals(ma)){
                arrayList.remove(arrayList.get(i));
            }
        }
        SoTietKiemReadAndWriteToCSV.writeListToCSV(arrayList,FILE_PATH_TONG,false);
    }

}
