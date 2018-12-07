/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ProductionDirectorWorkArea;

import Interface.ManagerWorkArea.*;
import Business.Employee.Worker;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.Warehouse;
import Business.Enterprise.Entities.WorkLine;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.ProductOrganization;
import Business.Organization.Organization;
import Interface.CustomerServiceDirectorWorkArea.CustomerOrganizationDirectorWorkAreaJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class MainCompanyManufactureTaskAssignPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainCompanyManufactureTaskAssignPanel
     */
    private JPanel userProcessContainer;
    private ManufactureEnterprise manufactureEnterprise;
//    private ProductOrganization productionOrganization;

    public MainCompanyManufactureTaskAssignPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.manufactureEnterprise = (ManufactureEnterprise) enterprise;
//        this.productionOrganization = productOrganization;
        populateAlltables();
    }

    public void populateAlltables() {
        populatetasktable();
        populateworkerstable();
        populatelinestable();
    }

    public void populatetasktable() {
        DefaultTableModel model = (DefaultTableModel) taskjTable1.getModel();
        model.setRowCount(0);
        ArrayList<ManufactureTask> tasks = this.manufactureEnterprise.getManufactureTasksdirectory();
        if (!tasks.isEmpty()) {
            for (ManufactureTask task : tasks) {
                if (task.getExcuted() == false && task.getCompleted() == false) {
                    Object[] row = new Object[4];
                    row[0] = task;
                    row[1] = task.getCounts();
                    row[2] = task.getProduct();
                    row[3] = task.getMenTakePartIn().size();
                    model.addRow(row);
                }
            }
        }

    }

    public void populateworkerstable() {
        DefaultTableModel model = (DefaultTableModel) workersAvaliavlejTable2.getModel();
        model.setRowCount(0);
        System.out.println(this.manufactureEnterprise.getTopemployeeDirectory().getEmployeeList().toString());
        System.out.println(this.manufactureEnterprise.getTopemployeeDirectory().getworkerArrayList().toString());
        for (Worker worker : this.manufactureEnterprise.getTopemployeeDirectory().getworkerArrayList()) {
            if (worker.isWorkable()) {
                Object[] row = new Object[2];
                row[0] = worker;
                row[1] = worker.getName();
                model.addRow(row);
            }
        }
    }

    public void populatelinestable() {
        DefaultTableModel model = (DefaultTableModel) linesjTable2.getModel();
        model.setRowCount(0);
        for (WorkLine line : manufactureEnterprise.getFactory().getWorklines()) {
            Object[] row = new Object[2];
            row[0] = line;
            row[1] = line.getCapcity() - line.getWorkersArrayList().size();

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
        taskjTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        workersAvaliavlejTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        linesjTable2 = new javax.swing.JTable();
        assignBT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        startjButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        checkjButton4 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taskjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task id", "Amounts", "Products", "People"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(taskjTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 650, 100));

        workersAvaliavlejTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Worker Id", "Worker Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(workersAvaliavlejTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, 110));

        linesjTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Line #", "Vacant Palce"
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
        jScrollPane3.setViewportView(linesjTable2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 310, 110));

        assignBT.setText("Assigns to ");
        assignBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBTActionPerformed(evt);
            }
        });
        add(assignBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 150, -1));

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        startjButton2.setText("Start this Task");
        startjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startjButton2ActionPerformed(evt);
            }
        });
        add(startjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 170, 40));

        jLabel1.setText("Unstarted tasks:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel2.setText("Workable worers:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setText("Lines:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jButton3.setText("Lines Detail");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        checkjButton4.setBackground(new java.awt.Color(153, 255, 255));
        checkjButton4.setText("Check material for this task");
        checkjButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkjButton4ActionPerformed(evt);
            }
        });
        add(checkjButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 40));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 289, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        userProcessContainer.remove(this);
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.previous(userProcessContainer);
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProductionDirectorWorkAreaJPanel manufactureDirectorWorkAreaJPanel = (ProductionDirectorWorkAreaJPanel) component;
        manufactureDirectorWorkAreaJPanel.populatetables();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void assignBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBTActionPerformed
        // TODO add your handling code here:

        try {
            int taskindex = taskjTable1.getSelectedRow();
            ManufactureTask task = (ManufactureTask) taskjTable1.getValueAt(taskindex, 0);

            int workerindex = workersAvaliavlejTable2.getSelectedRow();
            Worker worker = (Worker) workersAvaliavlejTable2.getValueAt(workerindex, 0);

            int lineindex = linesjTable2.getSelectedRow();
            WorkLine line = (WorkLine) linesjTable2.getValueAt(lineindex, 0);
            System.out.println("select successfully");
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to assign Task " + task.getTaskid() + " to Worker " + worker.getId() + " at Workline " + line.getLinenumber() + " ?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                worker.getTaskList().add(task);
                task.getMenTakePartIn().add(worker);
                worker.setWorkable(false);
//                task.setExcuted(true);
                line.addworker(worker);
                populateAlltables();
                JOptionPane.showMessageDialog(null, "task assigns sucessfully");
            }

        } catch (Exception e) {
//     
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_assignBTActionPerformed

    private void startjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startjButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int taskindex = taskjTable1.getSelectedRow();
            ManufactureTask task = (ManufactureTask) taskjTable1.getValueAt(taskindex, 0);
            Product product = (Product) taskjTable1.getValueAt(taskindex, 2);
            int amounts = (int) taskjTable1.getValueAt(taskindex, 1);
            if (task.getMenTakePartIn().size() > 0) {

                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to staryt Task " + task.getTaskid() + " with " + task.getMenTakePartIn().size() + " worker working it??", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
//                    task.setCreatedtimeDate(DateFormat.getDateTimeInstance().format(new Date()));
                    Warehouse warehouse = this.manufactureEnterprise.getWarehouse();
                    //check the warehouse if there is enough material
                    for (Material material : product.getPeoductStructure().keySet()) {
                        if (!warehouse.getAvaliableMaterialHashMap().containsKey(material) || warehouse.getAvaliableMaterialHashMap().get(material) < product.getPeoductStructure().get(material) * amounts) {
                            JOptionPane.showMessageDialog(null, "sorry, not enough material, please let Purchase organization get materials first");
                            return;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "launch the task successfully!");
                    
                    for (Material material : product.getPeoductStructure().keySet()) {
                        int amountsavaliable = warehouse.getAvaliableMaterialHashMap().get(material);
                        int newamounts = amountsavaliable - product.getPeoductStructure().get(material) * amounts;
                        this.manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().put(material, newamounts);
                    }
                    task.setStarteproductionDate(new Date());
                    task.setExcuted(true);
                    populateAlltables();

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_startjButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        WorkLinesDetailsPanel workLinesDetailsPanel = new WorkLinesDetailsPanel(userProcessContainer, manufactureEnterprise);

        userProcessContainer.add("manageOrganizationJPanel", workLinesDetailsPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void checkjButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkjButton4ActionPerformed
        // TODO add your handling code here:
        int taskindex = taskjTable1.getSelectedRow();
        ManufactureTask task = (ManufactureTask) taskjTable1.getValueAt(taskindex, 0);
        Product product = (Product) taskjTable1.getValueAt(taskindex, 2);
        int amounts = (int) taskjTable1.getValueAt(taskindex, 1);
        Warehouse warehouse = this.manufactureEnterprise.getWarehouse();
        System.out.println(warehouse.getAvaliableMaterialHashMap().toString() +"12312321");
        //check the warehouse if there is enough material
        for (Material material : product.getPeoductStructure().keySet()) {
            if (!warehouse.getAvaliableMaterialHashMap().containsKey(material) || warehouse.getAvaliableMaterialHashMap().get(material) < product.getPeoductStructure().get(material) * amounts) {
                System.out.println("WareHouse:" + material.getNameString() + warehouse.getAvaliableMaterialHashMap().get(material));
                System.out.println("need:" + material.getNameString() + product.getPeoductStructure().get(material) * amounts);

                JOptionPane.showMessageDialog(null, "sorry, not enough material, please let Purchase organization get materials first");
                task.setIsCalculated(false);
                this.manufactureEnterprise.getNeedMaterialTasks().add(task);
                
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "There is enough material in warehouse!! ");
    }//GEN-LAST:event_checkjButton4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
              int taskindex = taskjTable1.getSelectedRow();
        ManufactureTask task = (ManufactureTask) taskjTable1.getValueAt(taskindex, 0);
        Product product = (Product) taskjTable1.getValueAt(taskindex, 2);
        int amounts = (int) taskjTable1.getValueAt(taskindex, 1);
        Warehouse warehouse = this.manufactureEnterprise.getWarehouse();
                for (Material material : product.getPeoductStructure().keySet()) {
            
                 warehouse.getAvaliableMaterialHashMap().put(material, product.getPeoductStructure().get(material) * 20);
//                System.out.println("need:" + material.getNameString() + product.getPeoductStructure().get(material) * amounts);

                JOptionPane.showMessageDialog(null, "sorry, not enough material, please let Purchase organization get materials first");
//                return;
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBT;
    private javax.swing.JButton checkjButton4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable linesjTable2;
    private javax.swing.JButton startjButton2;
    private javax.swing.JTable taskjTable1;
    private javax.swing.JTable workersAvaliavlejTable2;
    // End of variables declaration//GEN-END:variables
}
