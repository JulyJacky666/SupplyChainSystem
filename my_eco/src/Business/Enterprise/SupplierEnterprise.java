/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Entities.Buyorder;
import Business.Enterprise.Entities.DeliveryOrderDictionary;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.Entities.MaterialDirectory;
import Business.Enterprise.Entities.SupplierWarehouse;
import Business.Enterprise.Entities.SupplierWarehouseDictionary;
import Business.Enterprise.Entities.Material;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author keweiji
 */
public class SupplierEnterprise extends Enterprise{
    
    private ArrayList<Buyorder> buyorders;
    private MaterialDirectory materials;
//    private SupplierWarehouseDictionary supplierWarehouses;
    private DeliveryOrderDictionary deliveryOrderDictionary;
    private HashMap<Material,Integer> avaliableMaterialHashMap;
       public SupplierEnterprise(String name){
        super(name, EnterpriseType.SupplierEnterprise);
        buyorders = new ArrayList<>();
        avaliableMaterialHashMap = new HashMap<Material,Integer>();
        deliveryOrderDictionary = new DeliveryOrderDictionary();
    }

    public ArrayList<Buyorder> getBuyorders() {
        return buyorders;
    }

    public void setBuyorders(ArrayList<Buyorder> buyorders) {
        this.buyorders = buyorders;
    }

    public HashMap<Material, Integer> getAvaliableMaterialHashMap() {
        return avaliableMaterialHashMap;
    }

    public void setAvaliableMaterialHashMap(HashMap<Material, Integer> masterMaterial) {
        this.avaliableMaterialHashMap = masterMaterial;
    }
       
       
    public MaterialDirectory getMaterialDirectory() {
        return materials;
    }

    
//    public void setMaterialDirectory(MaterialDirectory materialDirectory) {
//        this.materials = materialDirectory;
//    }

    public MaterialDirectory getMaterials() {
        return materials;
    }

    public void setMaterials(MaterialDirectory materials) {
        this.materials = materials;
    }

    public DeliveryOrderDictionary getDeliveryOrderDictionary() {
        return deliveryOrderDictionary;
    }

    public void setDeliveryOrderDictionary(DeliveryOrderDictionary deliveryOrderDictionary) {
        this.deliveryOrderDictionary = deliveryOrderDictionary;
    }
//
//    public SupplierWarehouseDictionary getSupplierWarehouses() {
//        return supplierWarehouses;
//    }
//
//    public void setSupplierWarehouses(SupplierWarehouseDictionary supplierWarehouses) {
//        this.supplierWarehouses = supplierWarehouses;
//    }
         
        @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
