/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ManagerWorkArea;

import Business.Employee.Employee;
import Business.Employee.SalesAndBuyDirector;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.BuyerRole;
import Business.Role.ManufactureDirectorRole;
import Business.Role.Role;
import Business.Role.SalesAndBuyDirectorRole;
import Business.Role.SalesManRole;
import Business.Role.WorkerRole;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

//    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
//    private SalesEnterprise maincompany;
    private Enterprise enterprise;

    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
//        this.organizationDir = maincompany.getOrganizationDirectory();

//        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
        populateEmployeeRoleComBox();
        populateTable();
    }

//    public void populateOrganizationComboBox() {
//        organizationJComboBox.removeAllItems();
//
//        for (Organization organization : organizationDir.getOrganizationList()) {
//            organizationJComboBox.addItem(organization);
//        }
//    }
    public void populateEmployeeRoleComBox() {
        empRoleJComboBox.removeAllItems();

        if (this.enterprise instanceof ManufactureEnterprise) {
            empRoleJComboBox.addItem("Worker");
            empRoleJComboBox.addItem("Manufacture Director");
            empRoleJComboBox.addItem("Buyer");
        }
        if (this.enterprise instanceof SalesEnterprise) {
            empRoleJComboBox.addItem("Sales&Buy Director");
            empRoleJComboBox.addItem("SalesMan");
        }

    }

    public void populateOrganizationEmpComboBox() {
        organizationEmpJComboBox.removeAllItems();

        for (Organization organization : this.enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationEmpJComboBox.addItem(organization);
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);
        for (Organization organization : this.enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount useraccount : organization.getUserAccountDirectory().getUserAccountList()) {
                Object[] row = new Object[6];
                row[0] = useraccount.getEmployee().getId();
                row[1] = useraccount.getEmployee().getHardOrg();
                row[2] = useraccount.getEmployee().getHardRole();
                row[3] = useraccount.getEmployee().getName();
                row[4] = useraccount.getUsername();
                row[5] = useraccount.getPassword();
                model.addRow(row);
            }
        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        empRoleJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Org", "Role", "Name", "User Name", "User Passwd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 67, 480, 92));

        addJButton.setText("Create Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 328, -1, -1));

        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 126, -1));

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationEmpJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 190, 126, -1));

        jLabel3.setText("Organization");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 194, -1, -1));

        empRoleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        empRoleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empRoleJComboBoxActionPerformed(evt);
            }
        });
        add(empRoleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 126, -1));

        jLabel4.setText("Role as:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jLabel5.setText("Usr Name:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 126, -1));

        jLabel6.setText("PassWord");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));
        add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        UserAccountDirectory useraccountdirectory = organization.getUserAccountDirectory();
        String name = nameJTextField.getText();

        String username = usernameJTextField.getText();
        String password = String.valueOf(PasswordField.getPassword());

        //need to create a box to create different employee
        String hardrole = (String) empRoleJComboBox.getSelectedItem();
        int number = 0;
        Role role = null;
        switch (hardrole) {
            case "Manufacture Director":
                number = 5;
                role = new ManufactureDirectorRole();
                break;
            case "Sales&Buy Director":
                number = 6;
                role = new SalesAndBuyDirectorRole();
                break;
            case "Worker":
                number = 4;
                role = new WorkerRole();
                break;

            case "SalesMan":
                number = 2;
                role = new SalesManRole();
                break;
            case "buyer":
                number = 3;
//                role = new BuyerRole();
                break;

        }
        Employee employee = organization.getEmployeeDirectory().createEmployee(name, number);
        UserAccount userAccount = organization.getUserAccountDirectory().createUserAccount(username, password, employee, role);
        enterprise.getTopemployeeDirectory().getEmployeeList().add(employee);
        enterprise.getUserAccountDirectory().getUserAccountList().add(userAccount);
//        System.out.println(username +password +employee);
        populateTable();

    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void empRoleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empRoleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empRoleJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox empRoleJComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}