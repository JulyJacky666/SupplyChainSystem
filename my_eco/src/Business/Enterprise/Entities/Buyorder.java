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
    private boolean  isassigned;
 
    
    public Buyorder(){
        this.orderid = counts;
        this.materials= new HashMap<Material, Integer>();
        counts++;
        this.isassigned = false;
        
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    
    
}
