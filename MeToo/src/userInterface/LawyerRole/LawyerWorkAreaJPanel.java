/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.LawyerRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *

 */
public class LawyerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    /**
     * Creates new form LawyerWorkAreaJPanel
     */
    public LawyerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        valueLabel.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueLabel = new javax.swing.JLabel();
        manageProblemJButton = new javax.swing.JButton();
        scheduleJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 236, 236));

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        manageProblemJButton.setBackground(new java.awt.Color(51, 51, 51));
        manageProblemJButton.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        manageProblemJButton.setForeground(new java.awt.Color(255, 51, 51));
        manageProblemJButton.setText("Manage Concerns");
        manageProblemJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageProblemJButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageProblemJButtonMouseExited(evt);
            }
        });
        manageProblemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProblemJButtonActionPerformed(evt);
            }
        });

        scheduleJButton.setBackground(new java.awt.Color(51, 51, 51));
        scheduleJButton.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        scheduleJButton.setForeground(new java.awt.Color(255, 51, 51));
        scheduleJButton.setText("Manage Schedule");
        scheduleJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scheduleJButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scheduleJButtonMouseExited(evt);
            }
        });
        scheduleJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleJButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("LAWYER DASHBOARD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lawyer.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(manageProblemJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(scheduleJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(629, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageProblemJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduleJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageProblemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProblemJButtonActionPerformed

        ManageProblemJPanel mpjp = new ManageProblemJPanel(userProcessContainer, account);
        userProcessContainer.add("ManageProblemJPanel", mpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProblemJButtonActionPerformed

    private void scheduleJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleJButtonActionPerformed
        // TODO add your handling code here:
        ManageScheduleJPanel msjp = new ManageScheduleJPanel(userProcessContainer, account);
        userProcessContainer.add("ManageScheduleJPanel", msjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_scheduleJButtonActionPerformed

    private void manageProblemJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageProblemJButtonMouseEntered
        // TODO add your handling code here:
        scheduleJButton.setBackground(Color.ORANGE);
    }//GEN-LAST:event_manageProblemJButtonMouseEntered

    private void manageProblemJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageProblemJButtonMouseExited
        // TODO add your handling code here:
        scheduleJButton.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_manageProblemJButtonMouseExited

    private void scheduleJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleJButtonMouseEntered
        // TODO add your handling code here:
        scheduleJButton.setBackground(Color.ORANGE);
    }//GEN-LAST:event_scheduleJButtonMouseEntered

    private void scheduleJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleJButtonMouseExited
        // TODO add your handling code here:
        scheduleJButton.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_scheduleJButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton manageProblemJButton;
    private javax.swing.JButton scheduleJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
