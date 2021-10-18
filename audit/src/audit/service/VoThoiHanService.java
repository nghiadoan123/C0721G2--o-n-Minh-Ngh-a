package audit.service;

import audit.model.SoTietKiem;
import audit.model.UuDai;
import audit.util.SoTietKiemReadAndWriteToCSV;
import audit.util.UuDaiReadFileToCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class VoThoiHanService {

    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH_VTH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\vothoihan.csv";
    public static final String FILE_PATH_CTH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\cothoihan.csv";
    public static final String FILE_PATH_DTH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\daihan.csv";
    public static final String FILE_PATH_TONG = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\sotietkiem.csv";
    public static final String UU_DAI_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\audit\\src\\audit\\data\\uudai.csv";


    public static ArrayList<UuDai> uuDaiArrayList = UuDaiReadFileToCSV.readUudaiFromCSV(UU_DAI_FILE_PATH);
    public static ArrayList<SoTietKiem> soTietKiemVoThoiHanArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_VTH);
    public static ArrayList<SoTietKiem> soTietKiemDaiHanArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_VTH);
    public static ArrayList<SoTietKiem> soTietKiemNganHanHanArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_VTH);
    public static ArrayList<SoTietKiem> soTietKiemArrayList = SoTietKiemReadAndWriteToCSV.readListFromCSV(FILE_PATH_VTH);




}
