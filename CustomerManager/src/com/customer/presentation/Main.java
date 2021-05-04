package com.customer.presentation;

import com.customer.service.CustomerManager;
import com.customer.model.Customer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static CustomerManager cus = new CustomerManager();
    public static Scanner sc = new Scanner(System.in);
    public static void add(){
        System.out.println("Input Name:");
        String name = sc.nextLine();
        System.out.println("Input Adress:");
        String address = sc.nextLine();
        System.out.println("Input phone:");
        String phone = sc.nextLine();
        System.out.println("Input Email:");
        String email = sc.nextLine();
        System.out.println("Input Gender:");
        String gender = sc.nextLine();
        System.out.println("Input Number-Order:");
        int orderNumber = sc.nextInt();
        sc.nextLine();
        try {
            cus.add(new Customer(name,address,email,phone,gender,orderNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void upOrderNumber(){
        System.out.println("Input phone");
        String phone = sc.nextLine();
        System.out.println("Input number order add : ");
        int n = sc.nextInt();
        sc.nextLine();
        try {
            cus.upOrderNumber(phone,n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createMenu(){
        System.out.println("Chao mung ban den voi he thong quan ly khach hang\n" +
                "Bấm 1 để nhập khách hang\n" +
                "Bấm 2 để tim kiem khach hang\n" +
                "Bam 3 de in thong khach hang\n" +
                "Bam 4 de in toan bo danh sach khach hang\n" +
                "Bam 5 de in ra mang da sap xep \n"+
                "Bam 6 de tang so don hang cho khach\n" +
                "Bam 0 de thoat"
        );
    }
    public static void main(String[] args) {
        while (true){
            try {
                cus.loadFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            createMenu();
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 1: {
                    add();
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 2: {
                    System.out.println("Input phone ");
                    String phone = sc.nextLine();
                    cus.search(phone);
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 3: {
                    System.out.println("Input phone");
                    String phone = sc.nextLine();
                    cus.getInfor(phone);
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 4: {
                    cus.display();
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 5: {
                    cus.sort();
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 6: {
                    upOrderNumber();
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Found");
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
            }
        }
    }
}
