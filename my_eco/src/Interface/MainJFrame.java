/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Area.Area;
import Business.Employee.Employee;
import Business.Employee.Worker;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.Entities.WorkLine;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

/**
 *
 * @author Lingfeng
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
//    private JFrame frame = new JFrame("backgrounds");
//    private JPanel imagePanel;
//    private ImageIcon backgroud;
    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        showtime();
        refreshAll();
        this.setSize(888, 550);
        
//        initstate();

    }
    public void initstate(){
        for(Area area:this.system.getAreaList()){
        for(Enterprise enterprise: area.getEnterpriseDirectory().getEnterpriseList()){
            if(enterprise instanceof  ManufactureEnterprise){
                ManufactureEnterprise manufactureEnterprise = (ManufactureEnterprise) enterprise;
                manufactureEnterprise.getBuyOrdersdirectory().clear();
                manufactureEnterprise.getManufactureTasksdirectory().clear();
                manufactureEnterprise.getNeedMaterialTasks().clear();
                manufactureEnterprise.getNeedMaterialTasks().clear();
                manufactureEnterprise.getReceivedOrders().clear();
                manufactureEnterprise.getTodomaterialHashMap().clear();
                
            }if (enterprise instanceof  SalesEnterprise){
                SalesEnterprise salesEnterprise = (SalesEnterprise) enterprise;
                salesEnterprise.getSalesOrdersDirectoryArrayList().clear();
//                salesEnterprise.ge
            }
            
            
        }
    }
    }

    public void showtime() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTock();

            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

    }

    public void tickTock() {
        timelable.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }

    public void refreshAll() {
        //flush the system every 20 seconds
        Timer timer = new Timer(20000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flushManufactureEnterpriseTasks();
                flushManufactureEnterpriseWorkers();
                System.out.println("Refresh at " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

    }

    public void flushManufactureEnterpriseTasks() {

        for (ManufactureEnterprise manufactureEnterprise : this.system.getAllManufactureEnterprises().keySet()) {
            // for double check the worker 

            // for double check to remove all workable worker in lines;
            ArrayList<WorkLine> worklines = manufactureEnterprise.getFactory().getWorklines();
//            for(WorkLine workLine:worklines){
//                workLine.getWorkersArrayList().clear();
//            }
            // to add all flush task status
            for (ManufactureTask task : manufactureEnterprise.getManufactureTasksdirectory()) {

                for (SalesOrder order : manufactureEnterprise.getReceivedOrders()) {
                    if (order.isIsReadyToCustomer() == false) {

                        for (Product product : order.getItems().keySet()) {
                            if (!manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap().containsKey(product) || order.getItems().get(product) > manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap().get(product)) {
//                                break;
                                order.setIsReadyToCustomer(false);
                                break;
                            } else {
                                order.setIsReadyToCustomer(true);
                            }
                        }
                    }
                }
                if (task.getCompleted() == false && task.getTimeremains() > 0 && task.getStarteproductionDate() != null) {
                    long diff = new Date().getTime() - task.getStarteproductionDate().getTime();

                    int counts = (int) (TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS)) / 20;
//                    System.out.println("diff" + diff);
                    if (counts > 0) {
                        task.setHasexperincedDays(counts);
                        System.out.println("counts:" + counts);
                        System.out.println("day +1");
                        System.out.println(task.calculateTimeRemains());

                    }

//            System.out.println("seconds: " + TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS));
                }
                if (task.getCompleted() == false && task.getTimeremains() <= 0) {
                    task.setTimeremains(0);
                    task.setCompleted(Boolean.TRUE);

//                    for(manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap();
                    if (!manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap().containsKey(task.getProduct())) {
                        manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap().put(task.getProduct(), task.getCounts());
                    } else {
                        int abaliablnumber = manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap().get(task.getProduct());
                        abaliablnumber = abaliablnumber + task.getCounts();
                        manufactureEnterprise.getWarehouse().getAvaliableProductsHashMap().put(task.getProduct(), abaliablnumber);
                    }

                    for (Worker worker : task.getMenTakePartIn()) {
                        worker.setWorkable(Boolean.TRUE);
                        for (WorkLine workline : manufactureEnterprise.getFactory().getWorklines()) {
                            if (workline.getWorkersArrayList().contains(worker)) {
                                workline.getWorkersArrayList().remove(worker);
                            }
                        }
                    }

//                    task.getMenTakePartIn().clear();
                }
            }
        }
    }

    public void flushManufactureEnterpriseWorkers() {
        for (ManufactureEnterprise manufactureEnterprise : this.system.getAllManufactureEnterprises().keySet()) {
            for (Organization organization : manufactureEnterprise.getOrganizationDirectory().getOrganizationList()) {
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    if (employee instanceof Worker) {
                        Worker worker = (Worker) employee;

                        if (worker.isIsOnVacation() == false) {
                            for (ManufactureTask task : worker.getTaskList()) {
                                if (task.getCompleted() == false) {
                                    worker.setWorkable(false);
                                    break;
                                } else {
                                    worker.setWorkable(true);
                                }
                            }
                        }

                        if (worker.isWorkable() == true) {
                            for (WorkLine workLine : manufactureEnterprise.getFactory().getWorklines()) {
                                if (workLine.getWorkersArrayList().contains(workLine)) {
                                    workLine.getWorkersArrayList().remove(worker);
                                    System.out.println("remove" + worker.getName());
                                }
                            }
                        }

                        if (worker.isIsOnVacation() == true) {
                            if (worker.getReturnTime() < worker.getAbsensetime()) {
                                long diff = new Date().getTime() - worker.getOffstartDate().getTime();
                                int counts = (int) (TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS)) / 20;
                                if (counts > 0) {
                                    worker.setReturnTime(counts);
                                    if (worker.getReturnTime() >= worker.getAbsensetime()) {
                                        worker.setWorkable(Boolean.TRUE);
                                        worker.setIsOnVacation(false);
                                    }
                                }

                            }

                        }

                    }
                }
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();
        timelable = new javax.swing.JLabel();
        RoleLable = new javax.swing.JLabel();
        OrganizationLable = new javax.swing.JLabel();
        organizationlable = new javax.swing.JLabel();
        container = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("main6.jpg");
                img.paintIcon(this, g, 0, 0);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 155, 110, -1));
        jPanel1.add(userNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 49, 118, -1));
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 111, 118, -1));

        jLabel1.setText("User Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, -1, -1));

        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, -1, -1));
        jPanel1.add(loginJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 253, -1, -1));

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        timelable.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        timelable.setText("time");
        jPanel1.add(timelable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 120, -1));
        jPanel1.add(RoleLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 80, -1));
        jPanel1.add(OrganizationLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 50, -1));
        jPanel1.add(organizationlable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jSplitPane1.setLeftComponent(jPanel1);

        container.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);

        Enterprise inEnterprise = null;
        Organization inOrganization = null;

        if (userAccount == null) {
            //Step 2: Go inside each network and check each enterprise
            for (Area area : system.getAreaList()) {
                //Step 2.a: check against each enterprise
                for (Enterprise enterprise : area.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if (userAccount == null) {
                        //Step 3:check against each organization for each enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
//                                System.out.println(inOrganization.getName()+"999"+inEnterprise.getName());
                                break;
                            }
                        }
                        if (inOrganization != null) {
//                            System.out.println(inOrganization.getName()+"123");
                            break;
                        }
                    } else {
                        inEnterprise = enterprise;
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        } else {
//            System.out.println(inOrganization.getName() +"main jaframe");
            CardLayout layout = (CardLayout) container.getLayout();
            JPanel panel = userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system);
            container.add("workArea", panel);

            layout.next(container);
            if(!userAccount.getUsername().equals("sysadmin")){
                RoleLable.setText(userAccount.getEmployee().getHardRole());
                organizationlable.setText(userAccount.getEmployee().getHardOrg());
            }
            
        }

        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");
        
        RoleLable.setText("");
        organizationlable.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        blankJP.setOpaque(false);
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OrganizationLable;
    private javax.swing.JLabel RoleLable;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JLabel organizationlable;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel timelable;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
