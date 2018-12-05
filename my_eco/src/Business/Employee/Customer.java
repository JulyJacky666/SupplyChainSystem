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
    private static int counts = 1;
    private int id;
    private String address;
    private SalesOrderDirectory salesOrderDirectory;

    public Customer() {
        this.id = counts;
        this.salesOrderDirectory = new SalesOrderDirectory();
        counts += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SalesOrderDirectory getSalesOrderDictory() {
        return salesOrderDirectory;
    }

    public void setSalesOrderDictory(SalesOrderDirectory salesOrderDictory) {
        this.salesOrderDirectory = salesOrderDictory;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
