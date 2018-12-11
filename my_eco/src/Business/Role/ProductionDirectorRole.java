/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ProductOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.ManagerWorkArea.ManagerWorkAreaJPanel;
import Interface.ProductionDirectorWorkArea.ProductionDirectorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author keweiji
 */
public class ProductionDirectorRole extends Role{
        @Override
        public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
//        return new ManageAreaJPanel(userProcessContainer, account, (ManufactureOrganization)organization, enterprise);
            return new ProductionDirectorWorkAreaJPanel(userProcessContainer,(ProductOrganization)organization, enterprise,business.getMaterialDirectory());
//    return userProcessContainer;
        }
}
