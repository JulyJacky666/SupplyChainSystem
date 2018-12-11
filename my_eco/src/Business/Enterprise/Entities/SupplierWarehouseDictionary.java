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
public class SupplierWarehouseDictionary {
     private ArrayList<SupplierWarehouse> warehouses ;
    
    public SupplierWarehouseDictionary() {
        warehouses = new ArrayList<SupplierWarehouse>();
    }

    public ArrayList<SupplierWarehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(ArrayList<SupplierWarehouse> warehouses) {
        this.warehouses = warehouses;
    }

    
    
    public SupplierWarehouse AddWarehouse() {
        SupplierWarehouse p = new SupplierWarehouse();
        warehouses.add(p);
        return p;
    }
    
    public void removeSalesOrder(SalesOrder p) {
        warehouses.remove(p);
    }
}
