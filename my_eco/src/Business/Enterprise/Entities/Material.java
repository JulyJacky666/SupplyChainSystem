/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.HashMap;

/**
 *
 * @author keweiji
 */
public class Material {
    
    private String nameString;
    private int price;
   private HashMap<Material,Integer> sub_materials;
   
   public Material(String name,HashMap<Material,Integer> sub_materials){
       this.nameString= name;
//       this.price= price;
       this.sub_materials = sub_materials;
   }
   
   
    
//    public enum RawMaterial{
//        Legs("Legs"),
//        CrossBar("CrossBar"),
//        SideRail("SideRail"),
//        BackSupport("BackSupport");
//        String name;
//        private RawMaterial(String name){
//            this.name= name;
//        }
//        
//    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
        public HashMap<Material, Integer> getMaterialStructure(){
        HashMap<Material, Integer> map = this.sub_materials;
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

    public HashMap<Material, Integer> getSub_materials() {
        return sub_materials;
    }
    

    public void setSub_materials(HashMap<Material, Integer> sub_materials) {
        this.sub_materials = sub_materials;
    }
    @Override
    public String toString(){
        return this.nameString;
    }
}
