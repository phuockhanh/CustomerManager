package com.student.model;

public class Student {
    public String name;
    private String stCode;
    String date;
    public float point1;
    public float point2;
    public float point3;
    public float point4;
    public float mediumScore;

    public Student(String name, String Stcode, String dateString) {
        this.name = name;
        this.date = dateString;
        this.stCode = Stcode;
    }
    public Student(String name, String stCode, String date, float point1, float point2, float point3, float point4) {
        this.name = name;
        this.stCode = stCode;
        this.date = date;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMediumScore() {
        return (this.point1 + this.point2 + this.point3*2 + this.point4*3)/7;
    }

    public String getName() {
        return name;
    }
    public String getStCode() {
        return stCode;
    }
    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPoint1() {
        return point1;
    }

    public void setPoint1(float point1) {
        this.point1 = point1;
    }

    public float getPoint2() {
        return point2;
    }

    public void setPoint2(float point2) {
        this.point2 = point2;
    }

    public float getPoint3() {
        return point3;
    }

    public void setPoint3(float point3) {
        this.point3 = point3;
    }

    public float getPoint4() {
        return point4;
    }

    public void setPoint4(float point4) {
        this.point4 = point4;
    }

    public String toStringCsv(){
        return this.name + "," + this.stCode + "," + this.date + "," + this.point1 + "," + this.point2 + "," + this.point3 + ","
                + this.point4 +","+String.format("%.1f",getMediumScore()) +"\n";
    }

    @Override
    public String toString(){
        return "Name: "+this.name+ ", Date: " + this.date+ ", StCode: "+this.stCode;
    }
    public void displayFull(){
        System.out.printf("|%15s|%10s|%17s|%9.1f|%9.1f|%9.1f|%9.1f|%9.1f|",this.name,this.stCode,this.date
        ,this.point1,this.point2,this.point3,this.point4,getMediumScore());
        System.out.println();
    }
}
