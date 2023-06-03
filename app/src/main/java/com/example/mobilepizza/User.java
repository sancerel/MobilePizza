package com.example.mobilepizza;

import android.provider.ContactsContract;

import com.example.mobilepizza.Order.Order;

import java.sql.Date;


public class User {
    public String email="";
    public String fullname="";
    public String address="";
    public String password="";
    public String telephone="";
    public Date date;
    public Order order;
    public User(){

    }
    public Boolean hasOrder(){
        return order != null;
    }
    public Order getOrder() throws Exception{
        if(hasOrder())
            return order;
        else throw new Exception("No order for user found!");
    }
    public void setOrder(Order or){
        this.order=or;
    }


}

