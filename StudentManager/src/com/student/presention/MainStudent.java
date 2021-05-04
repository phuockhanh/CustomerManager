package com.student.presention;

import com.student.model.Student;
import com.student.service.StudentManager;

import java.io.IOException;
import java.util.Scanner;

public class MainStudent {
    public static Scanner sc = new Scanner(System.in);
    public static StudentManager std = new StudentManager();
    public static void Menu(){
        Scanner sc = new Scanner(System.in);
    }

    private static void display() {
        std.display();
    }

    private static void addStudent() {
        System.out.println("Input Name to add");
        String name = sc.nextLine();
        System.out.println("Input Student Code to add");
        String stCode = sc.nextLine();
        System.out.println("Input Date of Birth to add, format : (dd/mm/yyyy)");
        String date = sc.nextLine();
        try {
            std.addStudent(new Student(name,stCode,date));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createMenu(){
        System.out.println("==========MENU============");
        System.out.println("1. Xem danh sách học viên\n" +
                "2. Thêm học viên\n" +
                "3. Sửa thông tin học viên\n" +
                "4. Xoá học viên\n" +
                "5. Nhập điểm học viên\n" +
                "6. Sửa nhập điểm học viên\n" +
                "7. Xếp loại học viên (hiển thị danh sách học viên theo điểm từ cao đến thấp)\n"+
                "8. Exit");
    }
    public static void main(String[] args) {
        try {
            std.loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            createMenu();
            while (!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Please enter a valid number ");
            }
            int x = sc.nextInt();
            sc.nextLine();
            switch (x){
                case 1:{
                    display();
                    break;
                }
                case 2:{
                    addStudent();
                    break;
                }
                case 3:{
                    System.out.println("Input Student Code to Edit");
                    String stCode = sc.nextLine();
                    try {
                        std.editInfor(stCode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4:{
                    System.out.println("Input Student Code to Remove");
                    String stCode = sc.nextLine();
                    try {
                        std.remove(stCode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:{
                    System.out.println("1. Nhập điểm học viên lần 1\n" +
                            "2. Nhập điểm học viên lần 2\n" +
                            "3. Nhập điểm học viên lần 3\n" +
                            "4. Nhập điểm học viên lần 4");
                    int y = sc.nextInt();
                    sc.nextLine();
                    switch (y){
                        case 1:{
                            try {
                                std.editPoint1();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 2 :{
                            try {
                                std.editPoint2();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 3:{
                            try {
                                std.editPoint3();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 4:{
                            try {
                                std.editPoint4();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                    break;
                }
                case 6:{
                    System.out.println("Input Student Code to Edit Point");
                    String stcode = sc.nextLine();
                    try {
                        std.editPoint(stcode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7:{
                    try {
                        std.sort();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 8:{
                    System.exit(0);
                }
                default:{
                    System.out.println("Wrong key, Press any key to continues ");
                    sc.nextLine();
                    createMenu();
                }
            }
        }
    }
}
