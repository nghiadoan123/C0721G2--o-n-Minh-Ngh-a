package audit.util;

import audit.model.UuDai;

import java.io.*;
import java.util.ArrayList;

public class UuDaiReadFileToCSV {

    public static ArrayList<UuDai> readUudaiFromCSV(String pathFile) {
        ArrayList<UuDai> uuDais = new ArrayList<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    UuDai uuDai = new UuDai(array[0]);
                    uuDais.add(uuDai);
                }
                bufferedReader.close();
            }catch (EOFException e){

            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }catch (Exception e){

            }
        }
        return uuDais;
    }
}
