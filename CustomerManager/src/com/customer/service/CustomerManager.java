package com.customer.service;

import com.customer.database.CustomerDT;
import com.customer.model.Customer;

import java.io.IOException;
import java.util.*;

public class CustomerManager{
    CustomerDT customerDT = new CustomerDT();
    public void loadFile() throws IOException {
        customerDT.readFile();
    }
    public void add(Customer ct) throws IOException{
        customerDT.add(ct);
        customerDT.saveFile();
    }
    public void search(String phone){
        customerDT.searchInfor(phone);
    }
    public void getInfor(String phone){
        customerDT.getInfor(phone);
    }
    public void display(){
        customerDT.display();
    }
    public void upOrderNumber(String phone,int n) throws IOException{
        customerDT.addNumberOrder(phone,n);
        customerDT.saveFile();
    }
    public void sort(){
        customerDT.sort();
    }
}
