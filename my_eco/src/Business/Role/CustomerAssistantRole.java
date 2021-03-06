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
import Interface.CustomerAssistantWorkArea.CustomerAssistantWorkAreaJPanel;
import Interface.ManagerWorkArea.ManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author keweiji
 */
public class CustomerAssistantRole  extends Role{
        @Override
        public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
//        return new ManageAreaJPanel(userProcessContainer, account, (ManufactureOrganization)organization, enterprise);
//            return new ManagerWorkAreaJPanel(userProcessContainer, enterprise);
                return new CustomerAssistantWorkAreaJPanel(userProcessContainer,account,business.getAreaList(),business.getAllManufactureEnterprises());
//    return userProcessContainer;
        }
}
