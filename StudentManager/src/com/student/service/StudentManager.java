package com.student.service;

import com.student.database.StudentDB;
import com.student.model.Student;

import java.io.IOException;

public class StudentManager {
    public static StudentDB studentDB = new StudentDB();
    public void addStudent(Student st) throws IOException {
        studentDB.add(st);
        studentDB.saveFile();
    }
    public void remove(String stCode) throws IOException {
        studentDB.remove(stCode);
        studentDB.saveFile();
    }
    public void editInfor(String stCode) throws IOException{
        studentDB.EditInfor(stCode);
        studentDB.saveFile();
    }
    public void editPoint(String stCode) throws IOException{
        studentDB.EditPoint(stCode);
        studentDB.saveFile();
    }
    public void editPoint1() throws IOException{
        studentDB.addPoint1All();
        studentDB.saveFile();
    }
    public void editPoint2() throws IOException{
        studentDB.addPoint2All();
        studentDB.saveFile();
    }
    public void editPoint3() throws IOException{
        studentDB.addPoint3All();
        studentDB.saveFile();
    }
    public void editPoint4() throws IOException{
        studentDB.addPoint4All();
        studentDB.saveFile();
    }
    public void sort() throws IOException{
        studentDB.sort();
    }
    public void display(){
        studentDB.display();
    }
    public void loadFile() throws IOException{
        studentDB.readFile();
    }
}
