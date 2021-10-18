//package audit.util;
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class ReadAndWriteToCSV {
//    public static void writeListToCSV(ArrayList<Cinema> cinemaList, String pathFile, boolean append) {
//        File file = new File(pathFile);
//        try {
//            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Cinema cinema : cinemaList) {
//                bufferedWriter.write(cinema.getInfoToCSV());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (Exception e){
//
//        }
//    }
//
//    public static ArrayList<Cinema> readListFromCSV(String pathFile) {
//        ArrayList<Cinema> cinemaList = new ArrayList<>();
//        File file = new File(pathFile);
//        if (file.length() > 0) {
//            try {
//                FileReader fileReader = new FileReader(file);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//                String line = "";
//                String[] array = null;
//                while ((line = bufferedReader.readLine()) != null) {
//                    array = line.split(",");
//                    Cinema cinema = new Cinema(array[0],array[1],array[2],Integer.parseInt(array[3]));
//                    cinemaList.add(cinema);
//                }
//                bufferedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("Lỗi đọc file");
//            }catch (Exception e){
//
//            }
//        }
//        return cinemaList;
//    }
//}
