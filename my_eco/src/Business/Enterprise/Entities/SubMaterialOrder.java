/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.HashMap;

/**
 *
 * @author amber
 */
public class SubMaterialOrder {
    private HashMap<Material,Integer> sub_materials;
    private SupplierWarehouse supplierWarehouse;
    public SubMaterialOrder(){
        sub_materials = new HashMap<Material,Integer>();
        supplierWarehouse = new SupplierWarehouse();
    }

    public HashMap<Material, Integer> getAdd_materials() {
        return sub_materials;
    }

    public void setAdd_materials(HashMap<Material, Integer> add_materials) {
        this.sub_materials = add_materials;
    }

    public SupplierWarehouse getSupplierWarehouse() {
        return supplierWarehouse;
    }

    public void setSupplierWarehouse(SupplierWarehouse supplierWarehouse) {
        this.supplierWarehouse = supplierWarehouse;
    }
}
