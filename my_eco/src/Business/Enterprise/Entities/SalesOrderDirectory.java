/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.ArrayList;

/**
 *
 * @author amber
 */
public class SalesOrderDirectory {
    private ArrayList<SalesOrder> salesorders ;
    
    public SalesOrderDirectory() {
        salesorders = new ArrayList<SalesOrder>();
    }

    public ArrayList<SalesOrder> getProductsDict() {
        return salesorders;
    }

    public ArrayList<SalesOrder> getSalesorders() {
        return salesorders;
    }

    public void setSalesorders(ArrayList<SalesOrder> salesorders) {
        this.salesorders = salesorders;
    }


    
    public SalesOrder addSalesOrder() {
        SalesOrder p = new SalesOrder();
        salesorders.add(p);
        return p;
    }
    
    public void removeSalesOrder(SalesOrder p) {
        salesorders.remove(p);
    }
}
