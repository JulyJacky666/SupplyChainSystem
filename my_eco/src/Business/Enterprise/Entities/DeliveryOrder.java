/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Employee.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

/**
 *
 * @author amber
 */
public class DeliveryOrder {
    private Buyorder buyorder;
    private Driver drivers;
    private int orderid;
    private ArrayList<String> location;

    public DeliveryOrder(){
        this.orderid = (int)(Math.random()*1000);;
        location = new ArrayList<String>();
    }
    
    public Buyorder getBuyorder() {
        return buyorder;
        
    }

    public void setBuyorder(Buyorder buyorder) {
        this.buyorder = buyorder;
    }

    public Driver getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver drivers) {
        this.drivers = drivers;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }
    
    public String toString(){
        return String.valueOf(orderid);
    }
}
