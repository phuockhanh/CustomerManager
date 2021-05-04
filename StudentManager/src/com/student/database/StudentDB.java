package com.student.database;

import com.student.model.Student;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class StudentDB {
    private Scanner sc = new Scanner(System.in);
    private static int CAPACITY = 10;
    int size=0;
    Student[] StArr = new Student[CAPACITY];
    public void saveFile() throws IOException {
        File fl = new File("Student.csv");
        if(!fl.exists()){
            fl.createNewFile();
        }
        FileOutputStream fileOut = null;
        BufferedOutputStream buffer = null;
        fileOut = new FileOutputStream("Student.csv");
        buffer = new BufferedOutputStream(fileOut);
        byte[] b ;
        for(int i=0;i<StArr.length;i++){
            if(StArr[i]!=null){
                b = StArr[i].toStringCsv().getBytes();
                fileOut.write(b);
            }
        }
        buffer.flush();
        fileOut.close();
    }
    public void readFile() throws IOException{
        File fl = new File("Student.csv");
        if(!fl.exists()){
            fl.createNewFile();
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        fileReader = new FileReader("Student.csv");
        bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str=bufferedReader.readLine())!=null){
            String[] strArr = str.split(",");
            Student student = new Student(strArr[0],strArr[1],strArr[2],Float.parseFloat(strArr[3]),Float.parseFloat(strArr[4]),Float.parseFloat(strArr[5]),Float.parseFloat(strArr[6]));
            add(student);
        }
        bufferedReader.close();
        fileReader.close();
    }
    public void add(Student st){
        isFull();
        if(!checkDate(st.getDate())){
            System.out.println("Found to Add "+st.getName()+" , Please check Date !! ");
            return;
        }
        for(int i=0;i<size;i++){
            if(StArr[i].getStCode().equals(st.getStCode())){
                System.out.println("Add "+ st.getName()+ " Found, please check com.student.model.Student Code");
                return;
            }
        }
        StArr[size] = st;
        size++;
    }
    public void isFull(){
        if(size==StArr.length){
            StArr = Arrays.copyOf(StArr,StArr.length*2);
        }
    }
    public boolean checkDate(String date){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private boolean isEmpty(){
        return (size==0);
    }
    public void remove(String stCode){
        if(isEmpty()){
            System.out.println("Not Found !! ");
            return;
        }
        for(int i=0;i<size;i++){
            if(StArr[i].getStCode().equals(stCode)){
                for(int j=i;j<size;j++){
                    StArr[j] = StArr[j+1];
                }
                StArr[size-1] = null;
                size--;
            }
        }
    }
    public boolean checkFloat(Student st){
        if(st.getPoint1()!=(float)st.getPoint1()){
            System.out.println("Found");
            return false;
        }
        return true;
    }
    public void editInfor(String StCode){
        for(int i=0;i<size;i++){
            if(StArr[i].getStCode().equals(StCode)){
                System.out.println("Input Name to Edit: ");
                String name = sc.nextLine();
                System.out.println("Input com.student.model.Student Code to Edit ");
                String StCodeEdit = sc.nextLine();
                System.out.println("Input Date Birthday to Edit, format : dd/mm/yyyy ");
                String date = sc.nextLine();
                for(int j=0;j<size;j++){
                    if(StArr[j].getStCode().equals(StCodeEdit)){
                        System.out.println("Invalid com.student.model.Student Code, please check !! , Edit not complete");
                        return;
                    }
                }
                if(!checkDate(date)){
                    System.out.println("Edit Found !! , please check Date ");
                    return;
                }
                StArr[i].setName(name);
                StArr[i].setDate(date);
                StArr[i].setStCode(StCodeEdit);
            }
        }
        System.out.println("Edit Complete !! ");
    }
    public void addPoint1All(){
        for(int i=0 ; i<size ; i++){
            System.out.println("Input point1 in "+StArr[i].getStCode());
            while (!sc.hasNextFloat()){
                sc.nextLine();
                System.out.println("Please enter valid number");
                System.out.println("Input point1 in "+StArr[i].getStCode());
            }
            StArr[i].setPoint1(sc.nextFloat());
            sc.nextLine();
        }
        System.out.println("Input point1 for alll Student complete !!");
    }

    public void addPoint2All(){
        for(int i=0 ; i<size ; i++){
            System.out.println("Input point2 in "+StArr[i].getStCode());
            while (!sc.hasNextFloat()){
                sc.nextLine();
                System.out.println("Please enter valid number");
                System.out.println("Input point1 in "+StArr[i].getStCode());
            }
            StArr[i].setPoint2(sc.nextFloat());
            sc.nextLine();
        }
        System.out.println("Input point2 for alll Student complete !!");
    }

    public void addPoint3All(){
        for(int i=0 ; i<size ; i++){
            System.out.println("Input point3 in "+StArr[i].getStCode());
            while (!sc.hasNextFloat()){
                sc.nextLine();
                System.out.println("Please enter valid number");
                System.out.println("Input point1 in "+StArr[i].getStCode());
            }
            StArr[i].setPoint3(sc.nextFloat());
            sc.nextLine();
        }
        System.out.println("Input point3 for alll Student complete !!");
    }

    public void addPoint4All(){
        for(int i=0 ; i<size ; i++){
            System.out.println("Input point4 in "+StArr[i].getStCode());
            while (!sc.hasNextFloat()){
                sc.nextLine();
                System.out.println("Please enter valid number");
                System.out.println("Input point4 in "+StArr[i].getStCode());
            }
            StArr[i].setPoint4(sc.nextFloat());
            sc.nextLine();
        }
        System.out.println("Input point4 for alll Student complete !!");
    }
    public void EditPoint(String StCode){
        for(int i=0;i<size;i++){
            if(StArr[i].getStCode().equals(StCode)){
                System.out.println("Edit point from Student : "+StArr[i].getName());
                System.out.println("Input Point1 to Edit");
                while (!sc.hasNextFloat()){
                    sc.nextLine();
                    System.out.println("Please enter valid number");
                    System.out.println("Input Point1 to Edit");
                }
                float point1 = sc.nextFloat();
                sc.nextLine();
                System.out.println("Input Point2 to Edit");
                while (!sc.hasNextFloat()){
                    sc.nextLine();
                    System.out.println("Please enter valid number");
                    System.out.println("Input Point2 to Edit");
                }
                float point2 = sc.nextFloat();
                sc.nextLine();
                System.out.println("Input Point3 to Edit");
                while (!sc.hasNextFloat()){
                    sc.nextLine();
                    System.out.println("Please enter valid number");
                    System.out.println("Input Point3 to Edit");
                }
                float point3 = sc.nextFloat();
                sc.nextLine();
                System.out.println("Input Point4 to Edit");
                while (!sc.hasNextFloat()){
                    sc.nextLine();
                    System.out.println("Please enter valid number");
                    System.out.println("Input Point4 to Edit");
                }
                float point4 = sc.nextFloat();
                sc.nextLine();
                StArr[i].setPoint1(point1);
                StArr[i].setPoint2(point2);
                StArr[i].setPoint3(point3);
                StArr[i].setPoint4(point4);
                System.out.println("Edit point complelte");
                return;
            }
        }
        System.out.println("Error searching !! ");
    }
    public void sort(){
        Student temp;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(StArr[i].getMediumScore()<StArr[j].getMediumScore()){
                    temp = StArr[i];
                    StArr[i] = StArr[j];
                    StArr[j] = temp;
                }
            }
        }
        for(int i=0;i<size;i++){
            if(i==0){
                System.out.println("________________________________________________________________________________________________");
                System.out.printf("|     Name      |  StCode  |  Date of Birth  | Point1  | Point 2 | Point 3 | Point 4 | MdScore | \n");
            }
            StArr[i].displayFull();
            if(i==size-1){
                System.out.println("________________________________________________________________________________________________");
            }
        }
    }

    public void display(){
        for(int i=0;i<size;i++){
            System.out.println(StArr[i].toString());
        }
    }
}
