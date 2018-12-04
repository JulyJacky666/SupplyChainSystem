/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.WorkerRole;

import Business.Employee.Worker;
import Business.Enterprise.Entities.ManufactureTask;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class WorkerTaskManagementJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WorkerTaskManagementJPanel
     */
    JPanel userProcessContainer;
//    UserAccount account;
    Worker worker ; 

    public WorkerTaskManagementJPanel(JPanel userProcessContainer, Worker worker) {
        this.userProcessContainer = userProcessContainer;
        this.worker = worker;
        initComponents();
        populatedoingtable();
        populatetodotable();
    }

    public void populatedoingtable() {
                DefaultTableModel model = (DefaultTableModel) doingtable.getModel();
        model.setRowCount(0);
        for (ManufactureTask task: worker.getTaskList()){
            if (task.getCompleted() ==false && task.getExcuted()==true){
                Object[] row = new Object[4];
                row[0] = String.valueOf(task.getTaskid());
                row[1] = String.valueOf(task.getCounts());
                row[2] = String.valueOf(task.getProduct().getNameString());
                row[3] = task.calculateTimeRemains();
                
                model.addRow(row);
            }
        }

    }

    public void populatetodotable() {
        DefaultTableModel model = (DefaultTableModel) completedtable.getModel();
        model.setRowCount(0);
        for (ManufactureTask task: worker.getTaskList()){
            if (task.getCompleted() ==true){
                Object[] row = new Object[3];
                row[0] = String.valueOf(task.getTaskid());
                row[1] = String.valueOf(task.getCounts());
                row[2] = String.valueOf(task.getProduct().getNameString());
                
                model.addRow(row);
            }
        }
        
    }
       public void flushall() {
        //flush the system every 20 seconds
        Timer timer = new Timer(20000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        populatedoingtable();
        populatetodotable();
                System.out.println("20s");
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

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
        doingtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        completedtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        showsjButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doingtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task id", "numbers", "Product", "Estimated times"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(doingtable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 450, 60));

        jLabel1.setText("You have these tasks completed:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel2.setText("You are in this task currently:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        completedtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Task id", "numbers", "Product"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(completedtable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 320, 90));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        showsjButton2.setText("Show detail");
        showsjButton2.setEnabled(false);
        showsjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showsjButton2ActionPerformed(evt);
            }
        });
        add(showsjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
               userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showsjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showsjButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showsjButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable completedtable;
    private javax.swing.JTable doingtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton showsjButton2;
    // End of variables declaration//GEN-END:variables
}
