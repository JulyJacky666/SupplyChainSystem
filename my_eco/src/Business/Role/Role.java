/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Employee.DeliveryDirector;
import Business.Employee.WarehouseDirector;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author maibenben
 */
public abstract class Role {

    public enum RoleType {
//        Admin("Admin"),
        Manager("Manager"),
        ProductionDirector("Production Director"),
        Workder("Worker"),
        CustomerServiceDirector("Customer Service Director"),
        CustomerAssistant("Customer Assistant"),
        SalesOrganizationDirector("Sales Organization Director"),
        Salesman("Salesman"),
        Customer("Customer"),
        Buyer("Buyer"),
        PurchaseDirector("Purchase Director"),
        WarehouseDirector("Warehouse Director"),
        Warehousekeeper("Warehouse keeper"),
        Driver("Driver"),
        DeliveryDirector("DeliveryDirector");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
