/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Area;

import Business.Employee.CustomerDirectory;
import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author keweiji
 */
public class Area {
     private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private CustomerDirectory customerDirectory;
    private int salesamount;
    private int profits;
    private int orderamount;
    private int returnedaomunts;
            
    
    public Area(){
        enterpriseDirectory=new EnterpriseDirectory();
        customerDirectory = new CustomerDirectory();
        
        
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public int getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(int salesamount) {
        this.salesamount = salesamount;
    }

    public int getProfits() {
        return profits;
    }

    public void setProfits(int profits) {
        this.profits = profits;
    }

    public int getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(int orderamount) {
        this.orderamount = orderamount;
    }

    public int getReturnedaomunts() {
        return returnedaomunts;
    }

    public void setReturnedaomunts(int returnedaomunts) {
        this.returnedaomunts = returnedaomunts;
    }
    
    
    @Override
    public String toString(){
        return name;
    }
}
