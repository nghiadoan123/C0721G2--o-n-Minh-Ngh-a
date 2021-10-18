package electric_bill.service;

import electric_bill.models.bill.Bill;
import electric_bill.models.input.Input;
import electric_bill.untils.BillReadAndWriteToCSV;
import phuong_tien_giao_thong.models.phuong_tien.HangSanXuat;
import phuong_tien_giao_thong.models.phuong_tien.Oto;
import phuong_tien_giao_thong.utils.HangSanXuatReadFileToCSV;
import phuong_tien_giao_thong.utils.OtoReadAndWriteToCSV;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class BillService implements Service {
    int number = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\electric_bill\\data\\bill.csv";
    public static TreeSet<Bill> billList = BillReadAndWriteToCSV.readListFromCSV(FILE_PATH);
    CustomerSerrvice customerSerrvice = new CustomerSerrvice();
    Bill bill = new Bill();

    @Override
    public void add() {
        customerSerrvice.display();
        String idBill = "MHD-" + (billList.size() + 1);
        String dayOfBill = Input.inputDayOfBill();
        int numberOfElectric = Input.numberOfElectric();
        double UnitPrice = Input.inputUnitPrice();
        Bill bill = new Bill(idBill, dayOfBill, numberOfElectric, UnitPrice);
        billList.add(bill);
        BillReadAndWriteToCSV.writeListToCSV(billList, FILE_PATH, false);
    }

    @Override
    public void edit() {
        System.out.println("nhập vào sô id của bill");
        String idBill = scanner.nextLine();
        for (Bill bill : billList) {
            if (bill.getIdBill().equals(idBill)) {
                boolean flagCheck = true;
                while (flagCheck) {
                    System.out.println("1 Edit ngày xuat bill \n" + "2 Edit số chữ điện" + "\n" + "3 Edit đơn giá" + "\n" + "4 Finish edit");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new dayOfBill");
                            String dayOfBill = Input.inputDayOfBill();
                            bill.setDayOFfBill(dayOfBill);
                            break;
                        case 2:
                            System.out.println("Enter new numberOfElectric");
                            int numberOfElectric = Input.numberOfElectric();
                            bill.setNumberOfElectric(numberOfElectric);
                            break;
                        case 3:
                            System.out.println("Enter new ID");
                            double UnitPrice = Input.inputUnitPrice();
                            bill.setUnitPrice(UnitPrice);
                            break;
                        case 4:
                            flagCheck = false;
                            break;
                    }
                }
            }

        }
        System.out.println("không tìm thấy");
        BillReadAndWriteToCSV.writeListToCSV(billList, FILE_PATH, false);
    }


    @Override
    public void display() {
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }

}
