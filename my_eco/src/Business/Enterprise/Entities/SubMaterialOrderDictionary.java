/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.ArrayList;

/**
 *
 * @author amber
 */
public class SubMaterialOrderDictionary {
    private ArrayList<SubMaterialOrder> SubMaterialOrders;
    public SubMaterialOrderDictionary(){
        SubMaterialOrders = new ArrayList<SubMaterialOrder>();
    }
    
    public SubMaterialOrder AddMaterialOrder() {
        SubMaterialOrder p = new SubMaterialOrder();
        SubMaterialOrders.add(p);
        return p;
    }
    
    public void removeAddMaterialOrder(AddMaterialOrder p) {
        SubMaterialOrders.remove(p);
    }
}
