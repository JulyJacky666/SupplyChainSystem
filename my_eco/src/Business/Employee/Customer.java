/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Entities.SalesOrderDirectory;

/**
 *
 * @author amber
 */
public class Customer {
    private String name;
    private int id;
    private SalesOrderDirectory salesOrderDictory;

    public Customer() {
        this.salesOrderDictory = new SalesOrderDirectory();
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SalesOrderDirectory getSalesOrderDictory() {
        return salesOrderDictory;
    }

    public void setSalesOrderDictory(SalesOrderDirectory salesOrderDictory) {
        this.salesOrderDictory = salesOrderDictory;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
}
