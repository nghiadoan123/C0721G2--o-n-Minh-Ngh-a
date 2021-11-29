package _16_io_text_file.exercise.read_file_cvs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            String line = "";
            br = new BufferedReader(new FileReader("D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\countries.csv"));
            List<Country> countryList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                countryList.add(new Country (Integer.parseInt(arr[0]),arr[1],(arr[2])));
            }
            for (Country country:countryList) {
                System.out.println(country);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
