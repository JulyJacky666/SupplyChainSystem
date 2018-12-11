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
public class DeliveryOrderDictionary {
    private ArrayList<DeliveryOrder> deliveryOrders;
    
    public DeliveryOrderDictionary(){
        deliveryOrders = new ArrayList<DeliveryOrder>(); 
    }

    public ArrayList<DeliveryOrder> getDeliveryOrders() {
        return deliveryOrders;
    }

    public void setDeliveryOrders(ArrayList<DeliveryOrder> deliveryOrders) {
        this.deliveryOrders = deliveryOrders;
    }
    
    
    public DeliveryOrder AddDeliveryOrder() {
        DeliveryOrder p = new DeliveryOrder();
        deliveryOrders.add(p);
        return p;
    }
    
    public void removeDeliveryOrder(DeliveryOrder p) {
        deliveryOrders.remove(p);
    }
}
