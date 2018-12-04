/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author maibenben
 */
public class Product {

    private int ID;
    private String nameString;
//    private 

    private int price;
    private HashMap<Material, Integer> components;
//     private HashMap<Material,Integer>  Hash
    private int assembletime;

    public Product(String name, int price, HashMap<Material, Integer> components, int assembletime) {
        this.nameString = name;
        this.price = price;
        this.components = components;
        this.assembletime = assembletime;
    }
    
     public Product(){
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Product(ProductType productType, MaterialDirectory materialDirectory) {
        if (productType == productType.Bike) {
            components = new HashMap<Material, Integer>();
//              components.push
            ArrayList<Material> materials = materialDirectory.getMaterials();
            for (Material material : materials) {
                if (material.getNameString() == "Handlebars" || material.getNameString() == "Frame Assembly" || material.getNameString() == "Seat") {
                    components.put(material, 1);
                }
//            switch(material.getNameString()){
//                case "Handlebars":
//                    components.put(material,1); 
//                    break;
//                case "Frame Assembly":
//                                        components.put(material,1); 
//                    break;
//            }
            }

        }
        this.nameString = productType.name;
        this.price = price;
        this.components = components;
        this.assembletime = productType.days;
    }

    public enum ProductType {
        Bike("Bike", 120, 2);

        private String name;
        private int price;
        private int days;

        private ProductType(String name, int price, int days) {
            this.name = name;
            this.days = days;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

    }
    
    public HashMap<Material, Integer> getPeoductStructure(){
        HashMap<Material, Integer> map = this.getComponents();
         HashMap<Material, Integer> ret = new HashMap<Material, Integer>();
        for(Material material:map.keySet()){
            int number = map.get(material);
            helper(material, number, ret);
    }
        System.out.println(ret.toString());
        return ret;
    }
    public HashMap<Material,Integer> helper(Material material,int numbers_from_father,HashMap<Material,Integer> ret ){
//        arry.add(material.getNameString());
        if(material.getSub_materials().isEmpty()){
            ret.put(material, numbers_from_father );
            return ret;
        }
        if(!material.getSub_materials().isEmpty()){
            HashMap<Material, Integer> subMap = material.getSub_materials();
            for(Material sub_material:subMap.keySet()){
                 ret.put(material, numbers_from_father );
                int number = subMap.get(sub_material) * numbers_from_father;
                helper(sub_material, number,ret );
            }
        }
        return ret;
    }

    public int getAssembletime() {
        return assembletime;
    }

    public void setAssembletime(int assembletime) {
        this.assembletime = assembletime;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public HashMap<Material, Integer> getComponents() {
        return components;
    }

    public void setComponents(HashMap<Material, Integer> components) {
        this.components = components;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public static void main(String[] args) {
        MaterialDirectory materialDirectory = new MaterialDirectory();
        Product product  = new Product(ProductType.Bike, materialDirectory);
        product.getPeoductStructure();
    }
    @Override
    public  String toString(){
        return this.nameString;
    }
}
