/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.CustomerDirectory;
import Business.Enterprise.Entities.Buyorder;
import Business.Enterprise.Entities.Factory;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.Entities.Warehouse;
import Business.Role.Role;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author keweiji
 */
public class SalesEnterprise extends Enterprise {

//    private Factory factory;
//    private Warehouse warehouse;
  
    private ArrayList<SalesOrder> salesOrdersDirectoryArrayList;
    private CustomerDirectory customerDirectory;
   

//    private HashMap<Material, Integer> todomaterialHashMap;

    public SalesEnterprise(String name) {
        super(name, EnterpriseType.SalesEnterprise);
        customerDirectory= new CustomerDirectory();        
        salesOrdersDirectoryArrayList = new ArrayList<SalesOrder>();
             
//        flushall();
    }



    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }


    public SalesOrder addSalesOrder() {
        return null;
    }

   
    public ArrayList<SalesOrder> getSalesOrdersDirectoryArrayList() {
        return salesOrdersDirectoryArrayList;
    }

    public void setSalesOrdersDirectoryArrayList(ArrayList<SalesOrder> salesOrdersDirectoryArrayList) {
        this.salesOrdersDirectoryArrayList = salesOrdersDirectoryArrayList;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

 

}
