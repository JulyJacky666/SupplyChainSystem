/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.Entities.Factory;
import Business.Role.CustomerServiceDirectorRole;
import Business.Role.ManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author keweiji
 */
public class CustomerServiceOrganization extends Organization{
        public CustomerServiceOrganization(){
        super(Type.CustomerServiceOrganization.getValue());
        this.setTypeString(Type.CustomerServiceOrganization.getValue());
//        factory = new Factory();
    }
        
          @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CustomerServiceDirectorRole());
        return roles;
    }
}
