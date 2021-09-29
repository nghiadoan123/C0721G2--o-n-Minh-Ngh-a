package utils;

import models.person.Employee;
import models.service.facility.Facility;
import models.service.room.Room;

import java.io.*;
import java.util.*;

public class FacilityRoomReadAndWriteFileToCSV {
    public static void writeListFacilityRoomToCSV(Map<Facility,Integer> roomList, String pathFile, boolean append){
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

    public static Map<Facility,Integer> readListFacilityRoomToCSV(String filePath){
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
                String promotionService = array[5];
                Room room = new Room(serviceName,usableArea,rentalCost,maxNumberOfTenants,typeOfRent,promotionService);
                facilityList.put(room,1);
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
