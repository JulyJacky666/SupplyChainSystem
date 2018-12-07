/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Entities.Buyorder;
import java.util.ArrayList;

/**
 *
 * @author maibenben
 */
public class Buyer extends Employee{
    private ArrayList<Buyorder> buyerorders ;
    public  Buyer(String name){
        super(name, 8);
        this.buyerorders = new ArrayList<Buyorder>();
    }

    public ArrayList<Buyorder> getBuyerorders() {
        return buyerorders;
    }
    
    public void setBuyerorders(ArrayList<Buyorder> buyerorders) {
        this.buyerorders = buyerorders;
    }
    
      
}
