package utils;

import models.service.facility.Facility;
import models.service.house.House;
import models.service.room.Room;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityHouseReadAndWriteFileToCSV {
    public static void writeListFacilityHouseToCSV(Map<Facility,Integer> roomList, String pathFile, boolean append){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Facility,Integer> entry : roomList.entrySet() ){
                bufferedWriter.write(entry.getKey().getInfoToCSV()+","+entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility,Integer> readListFacilityHouseToCSV(String filePath){
        Map<Facility,Integer> facilityList = new LinkedHashMap<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array =null;
            while ((line = bufferedReader.readLine()) != null){
                array = line.split(",");
                String serviceName = array[0];
                int usableArea = Integer.parseInt(array[1]);
                int rentalCost = Integer.parseInt(array[2]);
                int maxNumberOfTenants = Integer.parseInt(array[3]);
                String typeOfRent = array[4];
                String roomStander = array[5];
                int numberFloor = Integer.parseInt(array[6]);
                House house = new House(serviceName,usableArea,rentalCost,maxNumberOfTenants,typeOfRent,roomStander,numberFloor);
                facilityList.put(house,1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){

        }
        return facilityList;
    }
}
