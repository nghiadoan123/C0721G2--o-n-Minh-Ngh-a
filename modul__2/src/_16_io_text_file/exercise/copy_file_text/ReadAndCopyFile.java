package _16_io_text_file.exercise.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadAndCopyFile {
    public List<String> readFile(String filePath){
        List<String> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line= br.readLine()) != null){
                numbers.add(line);
            }
        }catch (Exception e){
            System.out.println("File không tồn tại");
        }
        return numbers;
    }

    public void writeFile(String filePath, List<String> lists){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String list:lists) {
               bufferedWriter.write(list);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
