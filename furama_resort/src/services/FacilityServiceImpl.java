package services;

import models.service.facility.Facility;
import models.service.house.House;
import models.service.room.Room;
import models.service.villa.Villa;
import services.input.InpuFacility;
import utils.FacilityReadAndWriteFileToCSV;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static final String FILE_PATH_FACILITY = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\facility.csv";
    public static Map<Facility, Integer> facilityList = FacilityReadAndWriteFileToCSV.readListFacilityToCSV(FILE_PATH_FACILITY);
    public static final String FILE_PATH_ROOM = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\facilityroomdata.csv";
    public static Map<Facility, Integer> facilityListRoom = FacilityReadAndWriteFileToCSV.readListFacilityToCSV(FILE_PATH_ROOM);
    public static final String FILE_PATH_HOUSE = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\facilityhousedata.csv";
    public static Map<Facility, Integer> facilityListHouse = FacilityReadAndWriteFileToCSV.readListFacilityToCSV(FILE_PATH_HOUSE);
    public static final String FILE_PATH_VILLA = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\facilityvilladata.csv";
    public static Map<Facility, Integer> facilityListVilla = FacilityReadAndWriteFileToCSV.readListFacilityToCSV(FILE_PATH_VILLA);


    Scanner scanner = new Scanner(System.in);

//    static {
//        facilityList.put(new Villa("Villa1", 50, 100000, 4, Villa.HOURS, Villa.DELUXE, 50, 4), 0);
//        facilityList.put(new Villa("Villa2", 50, 120000, 4, Villa.MONTH, Villa.DELUXE, 50, 5), 0);
//        facilityList.put(new Villa("Villa3", 50, 150000, 4, Villa.YEAR, Villa.DELUXE, 50, 6), 0);
//
//    }

    public final static String HOURS = "Hours";
    public final static String DAY = "Day";
    public final static String MONTH = "Month";
    public final static String YEAR = "Year";

    public String chooseTypeOfRent() {

        while (true) {
            System.out.println("Enter type of rent:" + "\n" + "1.HOURS" + "\n" + "2.DAY" + "\n" + "3.MONTH" + "\n" + "4.YEAR");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return Facility.HOURS;
                case "2":
                    return Facility.DAY;
                case "3":
                    return Facility.MONTH;
                case "4":
                    return Facility.YEAR;
                default:
                    System.out.println("in put again");
            }
        }
    }

    public String chooseRoomStandard() {

        while (true) {
            System.out.println("Enter room standard:" + "\n" + "1.STANDARD" + "\n" + "2.DELUXE" + "\n" + "3.FAMILY" + "\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return Villa.STANDARD;
                case "2":
                    return Villa.DELUXE;
                case "3":
                    return Villa.FAMILY;
                default:
                    System.out.println("in put again");
            }
        }
    }

    public static void facilityTime(String facilityName) {
        for (Map.Entry<Facility, Integer> e : facilityList.entrySet()) {
            if (e.getKey().getServiceName().equals(facilityName)) {
                e.setValue(e.getValue() + 1);
            }
        }
    }


    @Override
    public void add() {
        boolean flag = true;
        System.out.println("Enter your choice" + "\n" + "1.Add New Villa" + "\n" + "2.Add New House" + "\n" + "3.Add New Room" + "\n" + "4.Back to Menu");
        while (flag) {
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    String name = InpuFacility.serviceNameInput();
                    int Area = InpuFacility.usableAreaInput();
                    int rentalCost = InpuFacility.rentalCostInput();
                    int maxNumberOfTenants = InpuFacility.maxNumberOfTenantsInput();
                    String typeOfRent = chooseTypeOfRent();
                    String roomStandard = chooseRoomStandard();
                    int poolArea = Integer.parseInt(scanner.nextLine());
                    int numOfFloor = InpuFacility.numberOfFloorInput();
                    Villa villa = new Villa(name, Area, rentalCost, maxNumberOfTenants, typeOfRent, roomStandard, poolArea, numOfFloor);
                    facilityListVilla.put(villa, 1);
                    facilityList.put(villa, 1);
                    FacilityReadAndWriteFileToCSV.writeListFacilityToCSV(facilityListVilla, FILE_PATH_VILLA, false);
                    FacilityReadAndWriteFileToCSV.writeListFacilityToCSV(facilityList, FILE_PATH_FACILITY, false);
                    flag = false;
                    break;
                case "2":
                    String serviceNameHouse = InpuFacility.serviceNameInput();
                    int areaHouse = InpuFacility.usableAreaInput();
                    int rentalCostHouse = InpuFacility.rentalCostInput();
                    int maxNumberOfTenantsHouse = InpuFacility.maxNumberOfTenantsInput();
                    System.out.println("Enter typeOfRent");
                    String typeOfRentHouse = chooseTypeOfRent();
                    System.out.println("Enter roomStandard");
                    String roomStandardHouse = scanner.nextLine();
                    System.out.println("Enter numOfFloor");
                    int numOfFloorHouse = InpuFacility.numberOfFloorInput();
                    House house = new House(serviceNameHouse, areaHouse, rentalCostHouse, maxNumberOfTenantsHouse, typeOfRentHouse, roomStandardHouse, numOfFloorHouse);
                    facilityListHouse.put(house, 1);
                    facilityList.put(house, 1);
                    facilityListHouse.put(house, 1);
                    FacilityReadAndWriteFileToCSV.writeListFacilityToCSV(facilityListHouse, FILE_PATH_HOUSE, false);
                    FacilityReadAndWriteFileToCSV.writeListFacilityToCSV(facilityList, FILE_PATH_FACILITY, false);
                    flag = false;
                    break;
                case "3":
                    String serviceNameRoom = InpuFacility.serviceNameInput();
                    int areaRoom = InpuFacility.usableAreaInput();
                    int rentalCostRoom = InpuFacility.rentalCostInput();
                    int maxNumberOfTenantsRoom = InpuFacility.maxNumberOfTenantsInput();
                    System.out.println("Enter typeOfRent");
                    String typeOfRentRoom = chooseTypeOfRent();

                    System.out.println("Enter promotionService");
                    String promotionService = scanner.nextLine();
                    Room room = new Room(serviceNameRoom, areaRoom, rentalCostRoom, maxNumberOfTenantsRoom, typeOfRentRoom, promotionService);
                    facilityList.put(room, 1);
                    facilityListRoom.put(room, 1);
                    FacilityReadAndWriteFileToCSV.writeListFacilityToCSV(facilityListRoom, FILE_PATH_ROOM, false);
                    FacilityReadAndWriteFileToCSV.writeListFacilityToCSV(facilityList, FILE_PATH_FACILITY, false);

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

    @Override
    public void maintenanceList() {
        for (Map.Entry<Facility, Integer> e : facilityList.entrySet()) {
            if (e.getValue() >= 5) {
                System.out.println("Need to maintenance " + e.getKey() + " exceed " + e.getValue() + "times");
            }
        }
    }

    @Override
    public void showList() {
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "times");
        }
    }


}
