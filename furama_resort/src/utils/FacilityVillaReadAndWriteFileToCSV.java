package utils;

import models.service.facility.Facility;
import models.service.room.Room;
import models.service.villa.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityVillaReadAndWriteFileToCSV {
    public static void writeListFacilityVillaToCSV(Map<Facility,Integer> roomList, String pathFile, boolean append){
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

    public static Map<Facility,Integer> readListFacilityVillaToCSV(String filePath){
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
                String roomStandard = array[5];
                double poolArea = Double.parseDouble(array[6]);
                int numOfFloor = Integer.parseInt(array[7]);
                Villa villa = new Villa(serviceName,usableArea,rentalCost,maxNumberOfTenants,typeOfRent,roomStandard,poolArea,numOfFloor);
                facilityList.put(villa,1);
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
