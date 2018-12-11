/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.Entities.AddMaterialDictionary;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.Entities.SupplierWarehouseDictionary;
import java.util.HashMap;
import Business.Enterprise.Entities.Factory;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.WorkLine;
import Business.Role.ManagerRole;
import Business.Role.Role;
import Business.Role.WarehouserDirectorRole;
import java.util.ArrayList;

/**
 *
 * @author maibenben
 */
public class WarehouseOrganization extends Organization {
    
    SupplierWarehouseDictionary supplierWarehouseDictionary;
    AddMaterialDictionary addMaterialDictionary;
    private HashMap<Material,Integer> avaliableMaterialHashMap;
   
    
    public WarehouseOrganization(){
        super(Type.WarehouseOrganization.getValue());
        this.setTypeString(Type.WarehouseOrganization.getValue());
        supplierWarehouseDictionary = new SupplierWarehouseDictionary();
        addMaterialDictionary  = new AddMaterialDictionary();
        avaliableMaterialHashMap = new HashMap<Material,Integer>();
        
    }

//    public ArrayList<ManufactureTask> getManufactureTasksdirectory() {
//        return manufactureTasksdirectory;
//    }
//
//    public void setManufactureTasksdirectory(ArrayList<ManufactureTask> manufactureTasksdirectory) {
//        this.manufactureTasksdirectory = manufactureTasksdirectory;
//    }
    
 public HashMap<Material, Integer> getAvaliableMaterialHashMap() {
        return avaliableMaterialHashMap;
    }

    public void setAvaliableMaterialHashMap(HashMap<Material, Integer> avaliableMaterialHashMap) {
        this.avaliableMaterialHashMap = avaliableMaterialHashMap;
    }
    


    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManagerRole());
        return roles;
    }

    public AddMaterialDictionary getAddMaterialDictionary() {
        return addMaterialDictionary;
    }

    public void setAddMaterialDictionary(AddMaterialDictionary addMaterialDictionary) {
        this.addMaterialDictionary = addMaterialDictionary;
    }

    
    public SupplierWarehouseDictionary getSupplierWarehouseDictionary() {
        return supplierWarehouseDictionary;
    }

    public void setSupplierWarehouseDictionary(SupplierWarehouseDictionary supplierWarehouseDictionary) {
        this.supplierWarehouseDictionary = supplierWarehouseDictionary;
    }

    
    
//    @Override
//    public ArrayList<Role> getSupportedRole() {
//        ArrayList<Role> roles = new ArrayList();
//        roles.add(new WarehouserDirectorRole());
//        return roles;
//    }

}
