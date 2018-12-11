/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Interface.Driver.DriverWorkArea;
import Interface.WarehouseDirector.WarehouseDirector;

/**
 *
 * @author maibenben
 */
public class DriverRole extends Role{
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
//        return new ManageAreaJPanel(userProcessContainer, account, (ManufactureOrganization)organization, enterprise);
//            return new ManagerWorkAreaJPanel(userProcessContainer, enterprise);
                return new DriverWorkArea(userProcessContainer, account, organization,enterprise);
//    return userProcessContainer;
        }
}
