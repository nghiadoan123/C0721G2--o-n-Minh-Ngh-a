package utils;

import models.person.Employee;
import models.service.facility.Facility;
import models.service.house.House;
import models.service.room.Room;
import models.service.villa.Villa;

import java.io.*;
import java.util.*;

public class FacilityReadAndWriteFileToCSV {
//    public static void writeListFacilityToCSV(Map<Facility,Integer> facilityList, String pathFile, boolean append){
//        File file = new File(pathFile);
//        try {
//            FileWriter fileWriter = new FileWriter(file,append);// append: true // cho phép ghi tiếp/ false nghi đề
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Map.Entry<Facility,Integer> entry : facilityList.entrySet() ){
//                bufferedWriter.write(entry.getValue()+","+entry.getKey().getInfoToCSV());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Map<Facility,Integer> readListFacilityToCSV(String filePath){
//        Map<Facility,Integer> facilityList = new LinkedHashMap<>();
//        File file = new File(filePath);
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = "";
//            String[] array =null;
//            while ((line = bufferedReader.readLine()) != null){
//                array = line.split(",");
//                String serviceName = array[1];
//                int usableArea = Integer.parseInt(array[2]);
//                int rentalCost = Integer.parseInt(array[3]);
//                int maxNumberOfTenants = Integer.parseInt(array[4]);
//                String typeOfRent = array[5];
//                String promotionService = array[6];
//                if (array.length == 7){
//                    Room room = new Room(serviceName,usableArea,rentalCost,maxNumberOfTenants,typeOfRent,promotionService);
//                    facilityList.put(room,Integer.parseInt(array[0]));
//                } else if (array.length == 8){
//                    House house = new House(serviceName,usableArea,rentalCost,maxNumberOfTenants,typeOfRent,array[6],Integer.parseInt(array[7]));
//                    facilityList.put(house,Integer.parseInt(array[0]));
//                }else {
//                    Villa villa = new Villa(serviceName,usableArea,rentalCost,maxNumberOfTenants,typeOfRent,array[6],Double.parseDouble(array[7]),Integer.parseInt(array[8]));
//                    facilityList.put(villa,Integer.parseInt(array[0]));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (Exception e){
//
//        }
//        return facilityList;
//    }
public static Map<Facility,Integer> readDataFromFile(String file) {
    Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();
    try {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        facilityIntegerMap = (Map<Facility,Integer>) ois.readObject();

        ois.close();
    } catch (Exception ex) {
//            System.err.println("Empty facility");
    }
    return facilityIntegerMap;
}

    public static void writeToFile(Map<Facility,Integer> facilities,String file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(facilities);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
