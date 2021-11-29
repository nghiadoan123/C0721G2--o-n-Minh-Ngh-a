package dd;

import _16_io_text_file.exercise.read_file_cvs.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BugWeek4 {
    static List<Student> studentList = readFile("src\\dd\\d.txt");

    static {
        studentList.add(new Student(1, "John", 5.6));
        studentList.add(new Student(2, "David", 7.6));
        studentList.add(new Student(3, "Katherine", 8));
        studentList.add(new Student(4, "Sally", 2.0));
        studentList.add(new Student(5, "Banana", 7.0));
    }

    public static void writeFile(String filePath ,List<Student> student){
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student studentObj: student) {
                bufferedWriter.write(studentObj.toString());
                bufferedWriter.write("\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFile(String filePath){
        List<Student> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            while ((line= br.readLine()) != null){
                String[] arr = line.split(",");
                numbers.add(new Student(Integer.parseInt(arr[0]),arr[1],Double.parseDouble(arr[2])));
            }
        }catch (Exception e){
            System.out.println("File không tồn tại");
        }
        return numbers;
    }

    public static void main(String[] args) {
        writeFile("src\\dd\\d.txt",studentList);
    }
}
