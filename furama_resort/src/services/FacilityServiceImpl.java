package services;

import models.House;
import models.Room;
import models.Villa;

import java.util.*;

public class FacilityServiceImpl {
    static int valueOfVilla;
    static int valueOfHouse;
    static int valueOfRoom;
    private static Map<Object, Integer> facilityList = new LinkedHashMap<>();

    static {
        facilityList.put(new Villa("villa1", 20.0, 500.0, 15, 0, 6, 0, 0, "normal", 60.0, 2),++ valueOfVilla);
        facilityList.put(new Room("room1", 20.0, 500.0, 15, 0, 6, 0, "normal"), ++valueOfRoom);
        facilityList.put(new House("house1", 20.0, 500.0, 15, 0, 6, 0, 0, "normal", 2), ++valueOfHouse);
    }

    public void addFacility(){
        Scanner scanner = new Scanner(System.in);
        final int ADD_NEW_VILLA = 1;
        final int ADD_NEW_HOUSE = 2;
        final int ADD_NEW_ROOM = 3;
        final int BACK_TO_MENU = 4;
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng\n" +
                    "1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room \n" +
                    "4.Back to menu \n" );
            int chooseCase = scanner.nextInt();
            switch (chooseCase){
                case ADD_NEW_VILLA:
                    System.out.println("input villa service name:");
                    String serviceName = scanner.next();
                    System.out.println("input villa use area:");
                    double useArea = scanner.nextDouble();
                    System.out.println("input villa rent cost:");
                    double rentCost = scanner.nextDouble();
                    System.out.println("input villa max people:");
                    int maxPeople = scanner.nextInt();
                    System.out.println("input villa rent year:");
                    int rentYear = scanner.nextInt();
                    System.out.println("input villa rent month:");
                    int rentMonth = scanner.nextInt();
                    System.out.println("input villa rent day:");
                    int rentDay = scanner.nextInt();
                    System.out.println("input villa rent hour:");
                    int rentHour = scanner.nextInt();
                    System.out.println("input villa room stander:");
                    String roomStander = scanner.next();
                    System.out.println("input villa pool area:");
                    double poolArea = scanner.nextDouble();
                    System.out.println("input villa number floor:");
                    int numberFloor = scanner.nextInt();
                    Villa villa = new Villa(serviceName,useArea,rentCost,maxPeople,rentYear,rentMonth,rentDay,rentHour,roomStander,poolArea,numberFloor);
                    facilityList.put(villa,++valueOfVilla);
                    System.out.println("after add new villa service:");
                    displayFacility();
                    System.out.println();
                    facilityMaintenance();
                    break;
                case ADD_NEW_HOUSE:
                    System.out.println("input house service name:");
                    String serviceHouseName = scanner.next();
                    System.out.println("input house use area:");
                    double useHouseArea = scanner.nextDouble();
                    System.out.println("input house rent cost:");
                    double rentHouseCost = scanner.nextDouble();
                    System.out.println("input house max people:");
                    int maxHousePeople = scanner.nextInt();
                    System.out.println("input house rent year:");
                    int rentHouseYear = scanner.nextInt();
                    System.out.println("input house rent month:");
                    int rentHouseMonth = scanner.nextInt();
                    System.out.println("input house rent day:");
                    int rentHouseDay = scanner.nextInt();
                    System.out.println("input house rent hour:");
                    int rentHouseHour = scanner.nextInt();
                    System.out.println("input house room stander:");
                    String roomHouseStander = scanner.next();
                    System.out.println("input house number floor:");
                    int numberHouseFloor = scanner.nextInt();
                    House house = new House(serviceHouseName,useHouseArea,rentHouseCost,maxHousePeople,rentHouseYear,rentHouseMonth,rentHouseDay,rentHouseHour,roomHouseStander,numberHouseFloor);
                    facilityList.put(house,++valueOfHouse);
                    System.out.println("after add new house service:");
                    displayFacility();
                    System.out.println();
                    facilityMaintenance();
                    break;
                case ADD_NEW_ROOM:
                    System.out.println("input room service name:");
                    String serviceRoomName = scanner.next();
                    System.out.println("input room use area:");
                    double useRoomArea = scanner.nextDouble();
                    System.out.println("input room rent cost:");
                    double rentRoomCost = scanner.nextDouble();
                    System.out.println("input room max people:");
                    int maxRoomPeople = scanner.nextInt();
                    System.out.println("input room rent year:");
                    int rentRoomYear = scanner.nextInt();
                    System.out.println("input room rent month:");
                    int rentRoomMonth = scanner.nextInt();
                    System.out.println("input room rent day:");
                    int rentRoomDay = scanner.nextInt();
                    System.out.println("input room free service:");
                    String freeRoomService = scanner.next();
                    Room room = new Room(serviceRoomName,useRoomArea,rentRoomCost,maxRoomPeople,rentRoomYear,rentRoomMonth,rentRoomDay,freeRoomService);
                    facilityList.put(room,++valueOfRoom);
                    System.out.println("after add new room service:");
                    displayFacility();
                    System.out.println();
                    facilityMaintenance();
                    break;
                case BACK_TO_MENU:
                    // exit menu
                    flag = false;
                    break;
            }
        }while (flag);

    }

    public void facilityMaintenance(){
        Set<Object> set = facilityList.keySet();
        boolean flag = false;
        for (Object object : set) {
           if (facilityList.get(object) >5){
               flag = true;
               System.out.println(object);
           }
        }
        if (flag){
            System.out.println("need maintenance");
        }else {
            System.out.println("well");
            displayFacility();
        }
    }

    public void displayFacility() {
        Set<Object> set = facilityList.keySet();
        for (Object object : set) {
            System.out.println(object.toString() + " use times are: " + facilityList.get(object));
        }
    }

}
