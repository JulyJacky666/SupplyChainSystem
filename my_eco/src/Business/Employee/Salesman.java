/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.Entities.SalesOrderDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author maibenben
 */
public class Salesman extends Employee {
     private SalesOrderDirectory salesOrderDictory;
    private CustomerDirectory customerDirectory;
    public Salesman(String name){
        super(name, 4);
        this.salesOrderDictory = new SalesOrderDirectory();
        this.customerDirectory = new CustomerDirectory();
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public SalesOrderDirectory getSalesOrderDictory() {
        return salesOrderDictory;
    }

    public void setSalesOrderDictory(SalesOrderDirectory salesOrderDictory) {
        this.salesOrderDictory = salesOrderDictory;
    }
    
    
}
