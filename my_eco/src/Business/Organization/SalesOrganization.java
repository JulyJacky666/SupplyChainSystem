/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.Entities.Factory;
import Business.Enterprise.Entities.Material;
import Business.Role.ManagerRole;
import Business.Role.Role;
import Business.Role.SalesOrganizationDirectorRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author amber
 */
public class SalesOrganization extends Organization {
//        private 

 

    public SalesOrganization() {
        super(Type.SalesOrganization.getValue());
        this.setTypeString(Type.SalesOrganization.getValue());
        
//        factory = new Factory();
    }



    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesOrganizationDirectorRole());
        return roles;
    }
}
