package com.example.mobilepizza.Order;

import java.sql.Date;
import java.util.UUID;

public class Order {
    UUID OrderId;
    String Cost;
    String Addres;
    Date CreationDate;

    public Order(UUID orderId, String cost, String addres, Date creationDate) {
        OrderId = orderId;
        Cost = cost;
        Addres = addres;
        CreationDate = creationDate;
    }

    public UUID getOrderId() {
        return OrderId;
    }

    public String getCost() {
        return Cost;
    }

    public String getAddres() {
        return Addres;
    }

    public Date getCreationDate() {
        return CreationDate;
    }


    public void setOrderId(UUID orderId) {
        OrderId = orderId;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public void setAddres(String addres) {
        Addres = addres;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }



}
