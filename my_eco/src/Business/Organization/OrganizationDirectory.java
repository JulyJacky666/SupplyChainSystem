/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author keweiji
 */
public class OrganizationDirectory {
     private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type, String name){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.ProductionOrganization.getValue())){
            organization = new ProductOrganization();
            organization.setName(name);
            organizationList.add(organization);
        }
        
        if (type.getValue().equals(Organization.Type.SalesOrganization.getValue())){
            organization = new SalesOrganization();
            organization.setName(name);
            organizationList.add(organization);
        }
        
//        else if (type.getValue().equals(Organization.Type.Lab.getValue())){
//            organization = new LabOrganization();
//            organizationList.add(organization);
//        }
        return organization;
    }
    
}
