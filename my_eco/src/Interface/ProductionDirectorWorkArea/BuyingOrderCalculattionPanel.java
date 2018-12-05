/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ProductionDirectorWorkArea;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.Entities.Warehouse;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.SalesOrganization;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class BuyingOrderCalculattionPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuyingOrderCalculattionPanel
     */
    private JPanel userProcessContainer;
//    private SalesEnterprise mainenterprise;
    private ManufactureEnterprise manufactureEnterprise;
//    private ArrayList<SalesOrder> todoOrders;
    private HashMap<Product, Integer> todoproducts;
    private HashMap<Material, Integer> todomaterial;
    private HashMap<Product, Integer> productsInWarehouse;
    private HashMap<Material, Integer> materialInWarehouse;

    public BuyingOrderCalculattionPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
//        this.mainenterprise = enterprise;
        this.manufactureEnterprise = (ManufactureEnterprise) enterprise;
        this.todoproducts = new HashMap<Product, Integer>();
        this.productsInWarehouse = new HashMap<Product, Integer>();
        this.materialInWarehouse = new HashMap<Material, Integer>();
        System.out.println(manufactureEnterprise.getName());
//        this.tobuyproducts = new HashMap<Product,Integer>();
        populateall();
    }

    public void populateall() {
        populatewarehouse();
        populateorders();
        populatetask();
    }

    public void populatetask() {
        DefaultTableModel model = (DefaultTableModel) taskjTable3.getModel();
        model.setRowCount(0);
//        System.out.println(this.salesAndBuysOrganization.getName());
        for (Material material : this.manufactureEnterprise.getTodomaterialHashMap().keySet()) {
            Object[] row = new Object[2];
            row[0] = material.getNameString();
            row[1] = this.manufactureEnterprise.getTodomaterialHashMap().get(material);
            model.addRow(row);
        }

    }

    public void populateorders() {
        DefaultTableModel model = (DefaultTableModel) salesOrderjTable2.getModel();
        model.setRowCount(0);
        for (SalesOrder salesOrder : this.manufactureEnterprise.getReceivedOrders()) {
            if (salesOrder.isIscalcutated() == false) {
//                this.todoOrders.add(salesOrder);
//                    Object[] row = new Object[]
                for (Product product : salesOrder.getItems().keySet()) {
                    if (!this.todoproducts.containsKey(product)) {
                        this.todoproducts.put(product, salesOrder.getItems().get(product));
                    } else {
                        int number = this.todoproducts.get(product);
                        number += salesOrder.getItems().get(product);
                        this.todoproducts.put(product, number);
                    }
                    Object[] row = new Object[3];
                    row[0] = salesOrder.getOrderid();
                    row[1] = product.getNameString();
                    row[2] = salesOrder.getItems().get(product);
                    model.addRow(row);

                }
            }
        }
    }

    public void populatewarehouse() {
        Warehouse warehouse = this.manufactureEnterprise.getWarehouse();
        DefaultTableModel model = (DefaultTableModel) warehousejTable1.getModel();
        model.setRowCount(0);
        HashMap<Material, Integer> avaliavlematerials = warehouse.getAvaliableMaterialHashMap();
        HashMap<Product, Integer> avaliavleproducts = warehouse.getAvaliableProductsHashMap();
        for (Product product : avaliavleproducts.keySet()) {
            Object[] row = new Object[2];
            row[0] = product.getNameString();
            row[1] = avaliavleproducts.get(product);
            this.productsInWarehouse.put(product, avaliavleproducts.get(product));
            model.addRow(row);
        }
        for (Material material : avaliavlematerials.keySet()) {
            Object[] row = new Object[2];
            row[0] = material.getNameString();
            row[1] = avaliavlematerials.get(material);
            this.materialInWarehouse.put(material, avaliavlematerials.get(material));
            model.addRow(row);
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
        warehousejTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        salesOrderjTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taskjTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warehousejTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Name", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(warehousejTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 200));

        salesOrderjTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order id", "Product Name", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(salesOrderjTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 260, 200));

        jLabel1.setText("Ware House:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        jLabel2.setText("Current  Received Slaes Orders:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 200, -1));

        jButton1.setText("One clik to calculate all!! ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 180, 40));

        taskjTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Material Name", "Amount to Buy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(taskjTable3);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, 100));

        jLabel3.setText("Buy tasks:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 70, -1));

        jButton2.setText("<<back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HashMap<Material, Integer> ret_temp = new HashMap<Material, Integer>();
        // to reduce the amount avaliable in the warehouse
        for (Product product : this.todoproducts.keySet()) {
            if (this.productsInWarehouse.containsKey(product)) {
                int number_avaliable = productsInWarehouse.get(product);
//                this.todoproducts.put(product, WIDTH)
                int number2buy = this.todoproducts.get(product);
                number2buy = number2buy < number_avaliable ? 0 : number2buy - number_avaliable;
                this.todoproducts.put(product, number2buy);
            }
        }

        for (Product product : this.todoproducts.keySet()) {
            HashMap<Material, Integer> hashMap = product.getPeoductStructure();
            int number_to_buy = this.todoproducts.get(product);
            for (Material material : hashMap.keySet()) {
                int components_number = hashMap.get(material);
                components_number *= number_to_buy;
                ret_temp.put(material, components_number);
//                hashMap.put(material, components_number);
            }
        }

        for (Material material : ret_temp.keySet()) {

            if (materialInWarehouse.containsKey(material)) {
                int material_need_number = ret_temp.get(material);
                int material_avaliable = materialInWarehouse.get(material);
//                material_need_number = material_need_number < material_avaliable? 0:material_need_number - material_avaliable;
//                ret_temp.put(material, material_need_number);

                HashMap<Material, Integer> sub_material = material.getMaterialStructure();
                for (Material m : sub_material.keySet()) {
                    int sub_sub_need = material_avaliable * sub_material.get(m);
                    int sub_need = ret_temp.get(m);
                    sub_need = sub_need < sub_sub_need ? 0 : sub_need - sub_sub_need;
                    ret_temp.put(m, sub_need);
                }
            }
        }
        // add to organization's todo materialmap
        HashMap<Material, Integer> todomaterialMap = this.manufactureEnterprise.getTodomaterialHashMap();
        for (Material material : ret_temp.keySet()) {
            if (todomaterialMap.containsKey(material)) {
                int number = todomaterialMap.get(material);
                number = number + ret_temp.get(material);
                todomaterialMap.put(material, number);

            } else {
                todomaterialMap.put(material, ret_temp.get(material));
            }
        }

        for (SalesOrder salesOrder : this.manufactureEnterprise.getReceivedOrders()) {
            salesOrder.setIscalcutated(true);
        }
        populateorders();
        populatetask();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable salesOrderjTable2;
    private javax.swing.JTable taskjTable3;
    private javax.swing.JTable warehousejTable1;
    // End of variables declaration//GEN-END:variables
}
