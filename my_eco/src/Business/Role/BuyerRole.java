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
import Interface.BuyerWorkArea.BuyerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author keweiji
 */
public class BuyerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
//        return new ManageAreaJPanel(userProcessContainer, account, (ManufactureOrganization)organization, enterprise);
//            return new ManagerWorkAreaJPanel(userProcessContainer, enterprise);
//                return null;
//    return userProcessContainer;
        return new BuyerWorkAreaJPanel(userProcessContainer, account, enterprise,business.getAllManufactureEnterprises(),business.getAllSupplierEnterprises());

    }
}
