/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import java.util.HashMap;

/**
 *
 * @author amber
 */
public class AddMaterialOrder {
    private HashMap<Material,Integer> add_materials;
    private int orderid;
    private static int counts=1000;
    public AddMaterialOrder(){
        add_materials = new HashMap<Material,Integer>();
        this.orderid = counts;
        counts++;
    }

    public HashMap<Material, Integer> getAdd_materials() {
        return add_materials;
    }

    public void setAdd_materials(HashMap<Material, Integer> add_materials) {
        this.add_materials = add_materials;
    }

    public String toString(){
        return String.valueOf(orderid);
    }
}
