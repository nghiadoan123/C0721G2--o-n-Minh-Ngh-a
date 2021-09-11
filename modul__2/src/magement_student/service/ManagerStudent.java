package magement_student.service;

import magement_student.model.Student;

import java.util.Scanner;

public class ManagerStudent {
    Student[] studentLists = new Student[200];

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi:");
        int age = sc.nextInt();
        System.out.println("Nhập địa chỉ:");
        String address = sc.next();
        System.out.println("Nhập môn học:");
        String subject = sc.next();
        System.out.println();
        Student student = new Student(name, age, address, subject);
        for (int i = 0; i < studentLists.length; i++) {
            if (studentLists[i] == null) {
                studentLists[i] = student;
                break;
            }
        }
    }

    public void editList() {
        if (studentLists[0] == null) {
            System.out.println("không có gì để edit");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("nhập vào vị trí phần tử cần edit:");
            int index = sc.nextInt();
            if (index < 0 || index > studentLists.length) {
                System.out.println("nhập index khác");
            } else {
                index--;
                System.out.println("thông tin học sinh cần index:");
                System.out.println(studentLists[index]);
                System.out.println("Nhập tên cần edit:");
                String name = sc.next();
                System.out.println("Nhập tuổi cần edit:");
                int age = sc.nextInt();
                System.out.println("Nhập địa chỉ cần edit:");
                String address = sc.next();
                System.out.println("Nhập môn học cần edit:");
                String subject = sc.next();
                for (int i = 0; i < studentLists.length / 2; i++) {
                    studentLists[index].setName(name);
                    studentLists[index].setAge(age);
                    studentLists[index].setAddress(address);
                    studentLists[index].setSubject(subject);
                    break;
                }
                System.out.println("sau khi edit");
                showList();
            }
        }

    }

    public void showList() {
        if (studentLists[0] == null) {
            System.out.println("không có gì để hiển thị");
        } else {
            for (int i = 0; i < studentLists.length / 2; i++) {
                if (studentLists[i] != null) {
                    System.out.println(studentLists[i].toString());
                } else {
                    break;
                }

            }
        }

    }

    public void deleteList() {
        if (studentLists[0] == null) {
            System.out.println("không có gì để xóa");
        } else {
            System.out.println("hiển thị danh sách học sinh:");
            showList();
            System.out.println("nhập vào vị trí cần xóa");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            if (index < 0 || index > studentLists.length / 2) {
                System.out.println("nhập vào giá trị khác");
            } else {
                index--;
                for (int i = index; i < studentLists.length - 1; i++) {
                    studentLists[i] = studentLists[i + 1];
                }
                System.out.println("danh sach sau khi xoa");
                showList();
            }
        }

    }

    public void searchList() {
        if (studentLists[0] == null) {
            System.out.println("không có gì để search");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tuổi cần search:");
            //String searchName = sc.nextLine();
            int searchAge = sc.nextInt();
            for (int i = 0; i < studentLists.length; i++) {
                if (studentLists[i] != null) {
                    if (studentLists[i].getAge() == searchAge) {
                        System.out.println(studentLists[i].toString());
                        continue;
                    } else if (studentLists[i].getAge() != searchAge) {
                        System.out.println("không có độ tuổi này trong danh sách");
                        break;
                    }
                }
            }
        }
    }
}
