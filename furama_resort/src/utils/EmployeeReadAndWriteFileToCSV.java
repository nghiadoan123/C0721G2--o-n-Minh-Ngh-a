package utils;

import models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReadAndWriteFileToCSV {
    public static void writeListStudentToCSV(ArrayList<Employee> employeeList, String pathFile, boolean append){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList){
                bufferedWriter.write(employee.getInfoEmployeeToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> readListStudentFromCSV(String pathFile){
        ArrayList<Employee> employeeList = new ArrayList<>();
        File file = new File(pathFile);
        if (file.length()>0){
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line="";
                String[] array =null;
                while ((line=bufferedReader.readLine())!=null){
                    array = line.split(",");
                    String id = array[0];
                    String name = array[1];
                    String dayOfBirth = array[2];
                    String gender = array[3];
                    int identityNumber =Integer.parseInt(array[4]);
                    String phoneNumber = array[5];
                    String email = array[6];
                    String level = array[7];
                    String position = array[8];
                    double salary =Double.parseDouble(array[9]);

                    Employee employee = new Employee(id,name,dayOfBirth,gender,identityNumber,phoneNumber,email,level,position,salary);
                    employeeList.add(employee);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }
        }
        return employeeList;
    }
}
