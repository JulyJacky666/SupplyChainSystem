/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Area.Area;
import Business.Enterprise.ManufactureEnterprise;
import java.util.ArrayList;
import java.util.HashMap;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
    
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
    private Enterprise enterprise;
    private Organization reOrganization;
    private boolean  isTakenBydriver;
    
 
    
    public Buyorder(){
        this.orderid = counts;
        this.materials= new HashMap<Material, Integer>();
        counts++;
        this.isDelivered = false;
        isTakenBydriver=false;
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
    
     public Organization getReOrganization() {
        return reOrganization;
    }

    public void setReOrganization(Organization reOrganization) {
        this.reOrganization = reOrganization;
    }

    public boolean isIsTakenBydriver() {
        return isTakenBydriver;
    }

    public void setIsTakenBydriver(boolean isTakenBydriver) {
        this.isTakenBydriver = isTakenBydriver;
    }

    
    
    public static int getCounts() {
        return counts;
    }

    public static void setCounts(int counts) {
        Buyorder.counts = counts;
    }


    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }    
    

 
    @Override
    public  String toString(){
        return  String.valueOf(this.orderid);
    }
    
    
}
