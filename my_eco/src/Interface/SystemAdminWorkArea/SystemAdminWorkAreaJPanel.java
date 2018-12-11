/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Area.Area;
import Business.Employee.Employee;
import Business.Employee.Salesman;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;

    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        populateTree();
        populateOverView();
        this.setOpaque(false);
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);

    }
//    public void init(){
//        f
//    }

    public void populateTree() {
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        ArrayList<Area> areaList = ecosystem.getAreaList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;

        Area area;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode areas = new DefaultMutableTreeNode("Areas");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(areas, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;

        for (int i = 0; i < areaList.size(); i++) {
            area = areaList.get(i);
            networkNode = new DefaultMutableTreeNode(area.getName());
            areas.insert(networkNode, i);

            enterpriseList = area.getEnterpriseDirectory().getEnterpriseList();
            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }

    public void populateOverView() {
        int profits = 0;
        int sales = 0;
        int orders = 0;
        int productsamounts = 0;
        int returnamounts = 0;

        for (Area area : this.ecosystem.getAreaList()) {
            for (Enterprise enterprise : area.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof SalesEnterprise) {
                    SalesEnterprise salesEnterprise = (SalesEnterprise) enterprise;
                    for (Organization organization : salesEnterprise.getOrganizationDirectory().getOrganizationList()) {
                        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                            if (employee instanceof Salesman) {
                                Salesman salesman = (Salesman) employee;

                                area.setOrderamount(area.getOrderamount() + salesman.getSalesOrderDictory().getSalesorders().size());
                                
                                orders += area.getOrderamount();
//                                System.out.println("smTurnover"+salesman.getTurnover());
//                                sales += salesman.getTurnover();
                                
                                for (SalesOrder salesOrder : salesman.getSalesOrderDictory().getSalesorders()) {
                                    for (Product product : salesOrder.getItems().keySet()) {
                                        area.setSalesamount(product.getSalesprice() *salesOrder.getItems().get(product) + area.getSalesamount());
                                        sales +=product.getSalesprice() *salesOrder.getItems().get(product);
                                        area.setProfits((product.getSalesprice() - product.getPrice()) * salesOrder.getItems().get(product) + area.getProfits());
                                        profits += (product.getSalesprice() - product.getPrice()) * salesOrder.getItems().get(product);
                                    }
                                }
                            }
                        }
                    }
                }
//                if(enterprise instanceof  ManufactureEnterprise){
//                    ManufactureEnterprise manufactureEnterprise =(ManufactureEnterprise) enterprise;
//                    for(SalesOrder order:manufactureEnterprise.getReceivedOrders()){
//                        if(order.isIsReadyToCustomer()){
//                            for(int n :order.getItems().values()){
//                                productsamounts +=n;
//                            }
//                        }
//                    }
//                }
            }
        }

        profitslable.setText(String.valueOf(profits));
        salesamount.setText(String.valueOf(sales));
        orderamountslable.setText(String.valueOf(orders));
//        if (productsamounts == 0) {
//            returnperLable.setText("0 %");
//        } else {
//            returnperLable.setText(String.valueOf(returnamounts / productsamounts * 100) + " %");
//        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSelectedNode = new javax.swing.JLabel();
        btnManageNetwork = new javax.swing.JButton();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageAdmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        salesamount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        profitslable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        orderamountslable = new javax.swing.JLabel();
        turnovers = new javax.swing.JButton();
        orders = new javax.swing.JButton();
        profits = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTree.setBackground(new java.awt.Color(204, 204, 204));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 221, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel1.setText("Selected Node:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, 20));

        lblSelectedNode.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        lblSelectedNode.setText("<View_selected_node>");
        jPanel2.add(lblSelectedNode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, 20));

        btnManageNetwork.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnManageNetwork.setText("Manage Area");
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 220, 30));

        btnManageEnterprise.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnManageEnterprise.setText("Manage Enterprise");
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 220, 30));

        btnManageAdmin.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnManageAdmin.setText("Manage Enterprise Manager");
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 220, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Overview"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Overall Sales Amount:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 25, 165, 25));

        salesamount.setText("jLabel3");
        jPanel3.add(salesamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Overall Profits:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 165, 30));

        profitslable.setText("jLabel4");
        jPanel3.add(profitslable, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel7.setText("Overall Orders amounts:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 185, 23));

        orderamountslable.setText("jLabel4");
        jPanel3.add(orderamountslable, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        turnovers.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        turnovers.setText("Details");
        turnovers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoversActionPerformed(evt);
            }
        });
        jPanel3.add(turnovers, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, -1, -1));

        orders.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        orders.setText("Details");
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });
        jPanel3.add(orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 94, -1, -1));

        profits.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        profits.setText("Details");
        profits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitsActionPerformed(evt);
            }
        });
        jPanel3.add(profits, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 59, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 450, 150));

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed
        ManageAreaJPanel manageNetworkJPanel = new ManageAreaJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageNetworkActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        ManageEnterpriseManagerJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseManagerJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdminActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged

    private void turnoversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoversActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (Area area : this.ecosystem.getAreaList()) {
            dataSet.setValue(area.getName(), area.getSalesamount());
        }
        JFreeChart chart = ChartFactory.createPieChart("Sales Amount", dataSet, true, true, true);

        ChartFrame chartFrame = new ChartFrame("Sales Amount", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }//GEN-LAST:event_turnoversActionPerformed

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (Area area : this.ecosystem.getAreaList()) {
            dataSet.setValue(area.getName(), area.getOrderamount());
        }
        JFreeChart chart = ChartFactory.createPieChart("Orders Amount", dataSet, true, true, true);

        ChartFrame chartFrame = new ChartFrame("Orders Amount", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }//GEN-LAST:event_ordersActionPerformed

    private void profitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitsActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (Area area : this.ecosystem.getAreaList()) {
            dataSet.setValue(area.getName(), area.getProfits());
        }
        JFreeChart chart = ChartFactory.createPieChart("profits", dataSet, true, true, true);

        ChartFrame chartFrame = new ChartFrame("Profits Details", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }//GEN-LAST:event_profitsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblSelectedNode;
    private javax.swing.JLabel orderamountslable;
    private javax.swing.JButton orders;
    private javax.swing.JButton profits;
    private javax.swing.JLabel profitslable;
    private javax.swing.JLabel salesamount;
    private javax.swing.JButton turnovers;
    // End of variables declaration//GEN-END:variables
}
