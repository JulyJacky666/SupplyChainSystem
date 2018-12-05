/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SalesOrganization;
import Business.UserAccount.UserAccount;
import Interface.SalesmanWorkarea.SalesmanWorkAreaJPanel;
import javax.swing.JPanel;
import static Business.Organization.Organization.Type.SalesOrganization;

/**
 *
 * @author maibenben
 */
public class SalesManRole extends Role{
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SalesmanWorkAreaJPanel(userProcessContainer, account, (SalesOrganization)organization, enterprise, business.getAreaList());
    }
}
