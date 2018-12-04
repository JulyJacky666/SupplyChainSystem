/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Employee.Customer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author maibenben
 */
public class SalesOrder {

    private int orderid;
    private static int counts = 1;
//    private int number;
    private HashMap<Product, Integer> items;
    private Boolean readyforproduction;
    private Boolean completion;
    private int estimatedtime;
    private ArrayList<ManufactureTask> subManufactureTasks;
    private boolean iscalcutated;
    private HashMap<Product, Double> price;
    private Customer customer;
    private boolean  isdeliveredtomanufac;
    private String destinationState;
    private boolean isEmergency;
   
//    private 

    public SalesOrder() {
        this.orderid = counts;
        counts++;
        this.items = new HashMap<Product, Integer>();
        this.price = new  HashMap<Product, Double>();
        readyforproduction = false;
        completion = false;
        this.iscalcutated = false;
        this.isdeliveredtomanufac= false;
        this.destinationState="";
    }
    
    public String getDestinationState() {
        return destinationState;
    }

    public void setDestinationState(String destinationState) {
        this.destinationState = destinationState;
    }

    public boolean isIsEmergency() {
        return isEmergency;
    }

//    public SalesOrder(){
//        
//    }
    public void setIsEmergency(boolean isEmergency) {    
        this.isEmergency = isEmergency;
    }

    public HashMap<Product, Double> getPrice() {
        return price;
    }

    public void setPrice(HashMap<Product, Double> price) {
        this.price = price;
    }

    public ArrayList<ManufactureTask> getSubManufactureTasks() {
        return subManufactureTasks;
    }

    public void setSubManufactureTasks(ArrayList<ManufactureTask> subManufactureTasks) {
        this.subManufactureTasks = subManufactureTasks;
    }

    public boolean isIscalcutated() {
        return iscalcutated;
    }

    public void setIscalcutated(boolean iscalcutated) {
        this.iscalcutated = iscalcutated;
    }

    public boolean isIsdeliveredtomanufac() {
        return isdeliveredtomanufac;
    }

    public void setIsdeliveredtomanufac(boolean isdeliveredtomanufac) {
        this.isdeliveredtomanufac = isdeliveredtomanufac;
    }
    
    

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public static int getCounts() {
        return counts;
    }

    public static void setCounts(int counts) {
        SalesOrder.counts = counts;
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Product, Integer> items) {
        this.items = items;
    }

    public int getEstimatedtime() {
        return estimatedtime;
    }

    public void setEstimatedtime(int estimatedtime) {
        this.estimatedtime = estimatedtime;
    }

    public Boolean getReadyforproduction() {
        return readyforproduction;
    }

    public void setReadyforproduction(Boolean readyforproduction) {
        this.readyforproduction = readyforproduction;
    }

    public Boolean getCompletion() {
        return completion;
    }

    public void setCompletion(Boolean completion) {
        this.completion = completion;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String toString(){
        return String.valueOf(this.orderid);
    }
}
