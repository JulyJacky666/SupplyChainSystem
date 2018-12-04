/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.HashMap;


/**
 *
 * @author maibenben
 */
public class Warehouse {
    private String warehousenameString;
    private HashMap<Product, Integer> avaliableProductsHashMap;
    private HashMap<Material,Integer> avaliableMaterialHashMap;
    
    public Warehouse(String name){
        this.warehousenameString= name;
        this.avaliableMaterialHashMap = new HashMap<Material,Integer> ();
        this.avaliableProductsHashMap = new HashMap<Product, Integer> ();
//        initialize();
    }
    
    public void initialize(){
         MaterialDirectory materialDirectory = new MaterialDirectory();
         for(Material material: materialDirectory.getMaterials()){
             if(material.getNameString()=="wheel"){
                 this.avaliableMaterialHashMap.put(material, 2);
             }
             if(material.getNameString()=="spokes"){
                 this.avaliableMaterialHashMap.put(material, 3);
             }
         }
         
//                HashMap<Material, Integer> wheels_sub = new HashMap<Material, Integer>();
//        wheels_sub.put(spokes, 25);
//        wheels_sub.put(tire_rims, 1);
//        Material wheel = new Material("wheel", wheels_sub);
    }
    public String getWarehousenameString() {
        return warehousenameString;
    }

    public void setWarehousenameString(String warehousenameString) {
        this.warehousenameString = warehousenameString;
    }

    public HashMap<Product, Integer> getAvaliableProductsHashMap() {
        return avaliableProductsHashMap;
    }

    public void setAvaliableProductsHashMap(HashMap<Product, Integer> avaliableProductsHashMap) {
        this.avaliableProductsHashMap = avaliableProductsHashMap;
    }

    public HashMap<Material, Integer> getAvaliableMaterialHashMap() {
        return avaliableMaterialHashMap;
    }

    public void setAvaliableMaterialHashMap(HashMap<Material, Integer> avaliableMaterialHashMap) {
        this.avaliableMaterialHashMap = avaliableMaterialHashMap;
    }
    
    
}
