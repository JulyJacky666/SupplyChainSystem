/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Entities.DeliveryOrder;
import Business.Enterprise.Entities.DeliveryOrderDictionary;

/**
 *
 * @author amber
 */
public class Driver extends Employee{
    DeliveryOrder deliveryOrder_ing;
    DeliveryOrderDictionary deliveryOrderDictionary;
    DeliveryOrderDictionary Completed;
   
    public  Driver(String name){
        super(name, 12);
        deliveryOrder_ing = null;
        deliveryOrderDictionary = new DeliveryOrderDictionary();
        Completed = new DeliveryOrderDictionary();
    }  

    public DeliveryOrderDictionary getCompleted() {
        return Completed;
    }

    public void setCompleted(DeliveryOrderDictionary Completed) {
        this.Completed = Completed;
    }

    public DeliveryOrder getDeliveryOrder_ing() {
        return deliveryOrder_ing;
    }

    public void setDeliveryOrder_ing(DeliveryOrder deliveryOrder) {
        this.deliveryOrder_ing = deliveryOrder;
    }

    public DeliveryOrderDictionary getDeliveryOrderDictionary() {
        return deliveryOrderDictionary;
    }

    public void setDeliveryOrderDictionary(DeliveryOrderDictionary deliveryOrderDictionary) {
        this.deliveryOrderDictionary = deliveryOrderDictionary;
    }
}
