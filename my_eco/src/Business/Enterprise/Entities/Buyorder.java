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
public class Buyorder {
    private int orderid;
    private static int counts=1;
//    private ArrayList<Material> materials;
    private HashMap<Material, Integer> materials;
    private boolean  isDelivered;
 
    
    public Buyorder(){
        this.orderid = counts;
        this.materials= new HashMap<Material, Integer>();
        counts++;
        this.isDelivered = false;
    }

    public HashMap<Material, Integer> getMaterials() {
        return materials;
    }

    public void setMaterials(HashMap<Material, Integer> materials) {
        this.materials = materials;
    }

    public boolean isIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isassigned) {
        this.isDelivered = isassigned;
    }
    
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    
    @Override
    public  String toString(){
        return  String.valueOf(this.orderid);
    }
    
    
}
