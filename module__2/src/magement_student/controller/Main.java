package magement_student.controller;

import magement_student.service.ManagerStudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerStudent managerStudent = new ManagerStudent();
        boolean flag = true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Add\n" +
                    "2.show\n" +
                    "3.delete\n" +
                    "4.edit\n" +
                    "5.search\n" +
                    "6.Exit");
            System.out.println("Chọn");
            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    managerStudent.add();
                    break;
                case 2:
                   managerStudent.showList();
                    // hiện thị
                    break;
                case 3:
                    // xóa
                    managerStudent.deleteList();
                    break;
                case 4:
                    // edit
                    managerStudent.editList();
                    break;
                case 5:
                    // search
                    managerStudent.searchList();
                    break;
                case 6:
                    flag = false;
            }
        }

    }
}
