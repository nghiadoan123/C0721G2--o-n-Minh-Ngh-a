package services;

import models.person.Employee;
import models.service.Facility;
import models.service.House;
import models.service.Room;
import models.service.Villa;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    static int valueOfVilla;
    static int valueOfHouse;
    static int valueOfRoom;
    public static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);

//    static {
//        facilityList.put(new Villa("villa1", 20.0, 500.0, 15, 0, 6, 0, 0, "normal", 60.0, 2),++ valueOfVilla);
//        facilityList.put(new Room("room1", 20.0, 500.0, 15, 0, 6, 0, "normal"), ++valueOfRoom);
//        facilityList.put(new House("house1", 20.0, 500.0, 15, 0, 6, 0, 0, "normal", 2), ++valueOfHouse);
//    }

    public final static String HOURS = "hours";
    public final static String DAY = "day";
    public final static String MONTH = "month";
    public final static String YEAR = "year";

    public String chooseTypeOfRent() {
        System.out.println("Enter type of rent:" + "\n" + "1.HOURS" + "\n" + "2.DAY" + "\n" + "3.MONTH" + "\n" + "4.YEAR" + "\n" + "5.MANAGER" + "\n" + "6.GENERAL");
        String choice = scanner.nextLine();
        while (true)
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

    public static Facility getFacilityTime(String facilityName) {
        for (Map.Entry<Facility, Integer> e : facilityList.entrySet()) {
            if (e.getKey().getServiceName().equals(facilityName)) {
                e.setValue(e.getValue() + 1);
                return e.getKey();
            }
        }
        return null;
    }

    @Override
    public void add() {
        boolean flag = true;
        while (flag) {
            String choose = scanner.next();
            System.out.println("Enter your choice" + "\n" + "1.Add New Villa" + "\n" + "2.Add New House" + "\n" + "3.Add New Room" + "\n" + "4.Back to Menu");
            switch (choose) {
                case "1":
                    System.out.println("Enter serviceName");
                    String name = scanner.nextLine();
                    System.out.println("Enter usableArea");
                    int Area = scanner.nextInt();
                    System.out.println("Enter rentalCost");
                    int rentalCost = scanner.nextInt();
                    System.out.println("Enter maxNumberOfTenants");
                    int maxNumberOfTenants = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter typeOfRent");
                    String typeOfRent = chooseTypeOfRent();

                    System.out.println("Enter roomStandard");
                    String roomStandard = scanner.nextLine();
                    System.out.println("Enter poolArea");
                    int poolArea = scanner.nextInt();
                    System.out.println("Enter numOfFloor");
                    int numOfFloor = scanner.nextInt();
                    Villa villa = new Villa(name, Area, rentalCost, maxNumberOfTenants, typeOfRent, roomStandard, poolArea, numOfFloor);
                    facilityList.put(villa, 1);
                    flag = false;
                    break;
                case "2":
                    System.out.println("Enter serviceName");
                    String serviceNameHouse = scanner.nextLine();
                    System.out.println("Enter usableArea");
                    int areaHouse = scanner.nextInt();
                    System.out.println("Enter rentalCost");
                    int rentalCostHouse = scanner.nextInt();
                    System.out.println("Enter maxNumberOfTenants");
                    int maxNumberOfTenantsHouse = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter typeOfRent");
                    String typeOfRentHouse = chooseTypeOfRent();

                    System.out.println("Enter roomStandard");
                    String roomStandardHouse = scanner.nextLine();
                    System.out.println("Enter numOfFloor");
                    int numOfFloorHouse = scanner.nextInt();
                    House house = new House(serviceNameHouse, areaHouse, rentalCostHouse, maxNumberOfTenantsHouse, typeOfRentHouse, roomStandardHouse, numOfFloorHouse);
                    facilityList.put(house, 1);
                    flag = false;
                    break;
                case "3":
                    System.out.println("Enter serviceName");
                    String serviceNameRoom = scanner.nextLine();
                    System.out.println("Enter usableArea");
                    int areaRoom = scanner.nextInt();
                    System.out.println("Enter rentalCost");
                    int rentalCostRoom = scanner.nextInt();
                    System.out.println("Enter maxNumberOfTenants");
                    int maxNumberOfTenantsRoom = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter typeOfRent");
                    String typeOfRentRoom = chooseTypeOfRent();

                    System.out.println("Enter promotionService");
                    String promotionService = scanner.nextLine();
                    Room room = new Room(serviceNameRoom, areaRoom, rentalCostRoom, maxNumberOfTenantsRoom, typeOfRentRoom, promotionService);
                    facilityList.put(room, 1);
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

    @Override
    public void search() {

    }

    @Override
    public void delete() {

    }


}
