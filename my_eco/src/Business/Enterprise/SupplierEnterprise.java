/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Entities.Buyorder;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author keweiji
 */
public class SupplierEnterprise extends Enterprise{
    
    private ArrayList<Buyorder> buyorders;
       public SupplierEnterprise(String name){
        super(name, EnterpriseType.SupplierEnterprise);
        buyorders = new ArrayList<>();
    }
       
        @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
