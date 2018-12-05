/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.Entities.Factory;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.WorkLine;
import Business.Role.ManagerRole;
import Business.Role.Role;
import Business.Role.WarehouserDirectorRole;
import java.util.ArrayList;

/**
 *
 * @author maibenben
 */
public class WarehouseOrganization extends Organization {
    
    
   
    
    public WarehouseOrganization(){
        super(Type.WarehouseOrganization.getValue());
        this.setTypeString(Type.WarehouseOrganization.getValue());
        
    }

//    public ArrayList<ManufactureTask> getManufactureTasksdirectory() {
//        return manufactureTasksdirectory;
//    }
//
//    public void setManufactureTasksdirectory(ArrayList<ManufactureTask> manufactureTasksdirectory) {
//        this.manufactureTasksdirectory = manufactureTasksdirectory;
//    }
    


    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouserDirectorRole());
        return roles;
    }

}
