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
public class AddMaterialDictionary {
    private ArrayList<AddMaterialOrder> addMaterialOrders;
    public AddMaterialDictionary(){
        addMaterialOrders = new ArrayList<AddMaterialOrder>();
    }

    public ArrayList<AddMaterialOrder> getAddMaterialOrders() {
        return addMaterialOrders;
    }

    public void setAddMaterialOrders(ArrayList<AddMaterialOrder> addMaterialOrders) {
        this.addMaterialOrders = addMaterialOrders;
    }
    
    public AddMaterialOrder AddMaterialOrder() {
        AddMaterialOrder p = new AddMaterialOrder();
        addMaterialOrders.add(p);
        return p;
    }
    
    public void removeAddMaterialOrder(AddMaterialOrder p) {
        addMaterialOrders.remove(p);
    }
}
