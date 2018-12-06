/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.WorkerRole;

import Business.Employee.Worker;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author keweiji
 */
public class WorkerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WorkerWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;

    public WorkerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account) {
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageTaskBt = new javax.swing.JButton();
        manageLeavesBt = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageTaskBt.setText("Manage Tasks");
        manageTaskBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTaskBtActionPerformed(evt);
            }
        });
        add(manageTaskBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        manageLeavesBt.setText("Manage  leaves");
        manageLeavesBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLeavesBtActionPerformed(evt);
            }
        });
        add(manageLeavesBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageTaskBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTaskBtActionPerformed
        // TODO add your handling code here:
                Worker worker = (Worker) account.getEmployee();
//        WorkerLeavesManagePanel workerLeavePanel = new WorkerLeavesManagePanel(userProcessContainer, worker);
        WorkerTaskManagementJPanel workertaskPanel = new WorkerTaskManagementJPanel(userProcessContainer, worker);
        userProcessContainer.add("workerManageTaskPanel", workertaskPanel);
//        workertaskPanel.flushall();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageTaskBtActionPerformed

    private void manageLeavesBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLeavesBtActionPerformed
        // TODO add your handling code here:
        Worker worker = (Worker) account.getEmployee();
        WorkerLeavesManagePanel workerLeavePanel = new WorkerLeavesManagePanel(userProcessContainer, worker);
        userProcessContainer.add("workerManageLeavesPanel", workerLeavePanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageLeavesBtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton manageLeavesBt;
    private javax.swing.JButton manageTaskBt;
    // End of variables declaration//GEN-END:variables
}
