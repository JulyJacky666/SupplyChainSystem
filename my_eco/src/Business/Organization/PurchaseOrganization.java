/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.WarehouserDirectorRole;
import java.util.ArrayList;

/**
 *
 * @author keweiji
 */
public class PurchaseOrganization extends Organization{
    
        public PurchaseOrganization(){
        super(Type.PurchaseOrganization.getValue());
        this.setTypeString(Type.PurchaseOrganization.getValue());
        
    }
        
        
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouserDirectorRole());
        return roles;
    }
}
