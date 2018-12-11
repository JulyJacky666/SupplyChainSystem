/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SalesmanWorkarea;

import Business.Area.Area;
import Business.Employee.Customer;
import Business.Employee.Salesman;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.MaterialDirectory;
import Business.Enterprise.Entities.Product;
import Business.Organization.SalesOrganization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.SalesEnterprise;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author amber
 */
public class CreatAOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatAOrder
     */
    private JPanel userProcessContainer;
    private SalesOrganization organization;
    private SalesEnterprise salesEnterprise;
    private UserAccount userAccount;
    private ArrayList<Area> arealist;
    private HashMap<Product, Integer> itemsHashMap;
    private MaterialDirectory materialDirectory;
//     private int salesordertotalnumber:
//    private SalesOrder salesOrder;

    public CreatAOrderJPanel(JPanel userProcessContainer, UserAccount account, SalesOrganization organization, SalesEnterprise enterprise, ArrayList<Area> arealist, MaterialDirectory materialDirectory) {
        initComponents();
        this.setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.salesEnterprise = (SalesEnterprise) enterprise;
        this.userAccount = account;
        this.arealist = arealist;
        this.itemsHashMap = new HashMap<Product, Integer>();
        this.materialDirectory = materialDirectory;
//        this.salesOrder = new SalesOrder();

        populateTable();
        populatebox();
        this.setOpaque(false);

    }

    public void populatebox() {
        CustomerjComboBox.removeAllItems();
        for (Customer customer : this.salesEnterprise.getCustomerDirectory().getCustomerDict()) {
            CustomerjComboBox.addItem(customer);
        }
        AreajComboBox1.removeAllItems();
        for (Area area : this.arealist) {
            AreajComboBox1.addItem(area);
        }
        DefaultTableModel model=(DefaultTableModel) itemjTable.getModel();
        model.setRowCount(0);
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
        itemjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PricejTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        productjSpinner = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productjTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        CustomerjComboBox = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AreajComboBox1 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(itemjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 580, 127));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Create An Order");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 14, -1, -1));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 14, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel5.setText("Sales Price");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 20));

        PricejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PricejTextFieldActionPerformed(evt);
            }
        });
        add(PricejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel6.setText("Quantity");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 70, 40));
        add(productjSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 90, -1));

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton3.setText("Add item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 113, -1));

        productjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Target Price"
            }
        ));
        jScrollPane2.setViewportView(productjTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 580, 87));

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton4.setText("Create");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 94, -1));

        CustomerjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CustomerjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerjComboBoxActionPerformed(evt);
            }
        });
        add(CustomerjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 154, -1));

        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton6.setText("<<back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel7.setText("Customer Name :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 20));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel4.setText("Delivery Destination:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        AreajComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AreajComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreajComboBox1ActionPerformed(evt);
            }
        });
        add(AreajComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 154, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int orderid =(int)(Math.random() *10000);
        if (!itemsHashMap.isEmpty()) {
            Customer customer = (Customer) CustomerjComboBox.getSelectedItem();
//        salesOrder.setCustomer(customer);
            SalesOrder salesorder = ((Salesman) userAccount.getEmployee()).getSalesOrderDictory().addSalesOrder();
            salesorder.setCustomer(customer);
            customer.getSalesOrderDictory().getSalesorders().add(salesorder);
            salesorder.setOrderid(orderid);
            salesorder.setDestinationState(((Area) AreajComboBox1.getSelectedItem()).getName());
            for (Product product : this.itemsHashMap.keySet()) {
                salesorder.getItems().put(product, this.itemsHashMap.get(product));
            }
            this.itemsHashMap.clear();
            salesEnterprise.getSalesOrdersDirectoryArrayList().add(salesorder);

            JOptionPane.showMessageDialog(null, "Create sales order successfully !");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please add items first!!");
            return;

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void CustomerjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerjComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_CustomerjComboBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) itemjTable.getModel();
        try {
            int index = productjTable.getSelectedRow();
            Product product = (Product) productjTable.getValueAt(index, 0);
            System.out.println(product.getComponents().toString());
            int targetprice = product.getPrice();
            int salesprice = Integer.parseInt(PricejTextField.getText());
            if (salesprice > targetprice) {
                product.setSalesprice(salesprice); 
            System.out.println(productjSpinner.getValue().toString());
                this.itemsHashMap.put(product, Integer.parseInt(productjSpinner.getValue().toString()));
                            Object[] row = new Object[3];
            row[0] =product.getNameString() ;
            row[1] = Integer.parseInt(productjSpinner.getValue().toString());
            row[2] =Integer.parseInt(productjSpinner.getValue().toString())*product.getSalesprice() ;
//            row[3] = itemsHashMap.get(product2) * product2.getSalesprice();
            model.addRow(row);
            }else{
                JOptionPane.showMessageDialog(null, "Please input a price higher than its target");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a product and input the price and anmouts");
            return;
        }

//        DefaultTableModel model = (DefaultTableModel) itemjTable.getModel();

//        model.setRowCount(0);
//        for (Product product2 : itemsHashMap.keySet()) {

        

//        PricejTextField.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void AreajComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreajComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreajComboBox1ActionPerformed

    private void PricejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PricejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PricejTextFieldActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) productjTable.getModel();

        model.setRowCount(0);
//        if (salesEnterprise.getProductDictory().getProductsDict().isEmpty()) {
////            MaterialDirectory materialDirectory = new MaterialDirectory();
//            Product product = new Product(Product.ProductType.Bike, materialDirectory);
//            salesEnterprise.getProductDictory().getProductsDict().add(product);
//        }
        for (Product p : salesEnterprise.getProductDictory().getProductsDict()) {
            Object[] row = new Object[2];
//            row[0] = p.getID();
            row[0] = p;
            row[1] = p.getPrice();
            model.addRow(row);
        }

        DefaultTableModel model2 = (DefaultTableModel) itemjTable.getModel();
        model2.setRowCount(0);
        for (Product product2 : itemsHashMap.keySet()) {
            Object[] row = new Object[3];
            row[0] = product2.getNameString();
            row[1] = itemsHashMap.get(product2);
            row[2] = itemsHashMap.get(product2) * product2.getSalesprice();
            model2.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AreajComboBox1;
    private javax.swing.JComboBox CustomerjComboBox;
    private javax.swing.JTextField PricejTextField;
    private javax.swing.JTable itemjTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner productjSpinner;
    private javax.swing.JTable productjTable;
    // End of variables declaration//GEN-END:variables
}
