/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ClientRole;

import Business.Application.Application;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ClientOrganization;
import Business.Organization.ExaminerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *

 */
public class ApplyForNPOJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ApplyForNPOJPanel
     */
    
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount useraccount;
    private Enterprise enterprise;
    private ClientOrganization corg;
    private Network network;

    
    public ApplyForNPOJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, ClientOrganization corg, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.useraccount = account;
        this.corg = corg;
        this.enterprise = enterprise;
        this.network = network;
        
        if(useraccount.getApplication()==null) {
            useraccount.setApplication(new Application());
            updateBtn.setEnabled(false);
        }
        else {
            displayInfo(useraccount);
        }
        
        if(useraccount.getApplication().getStatus()==null) {
            valueLbl.setText("Pending...");
        }
        else {
        valueLbl.setText(useraccount.getApplication().getStatus());
        }
        
        /*if(useraccount.getApplication().getStatus().equals("Application Approved")){
            applyBtn.setEnabled(false);
            updateBtn.setEnabled(false);
        }
        else*/ {
            applyBtn.setEnabled(true);
            updateBtn.setEnabled(true);
        }
    }

    private void displayInfo (UserAccount useraccount) {
       
        fnameTxt.setText(useraccount.getApplication().getFname());
        fnameTxt.setEnabled(false);
        lnameTxt.setText(useraccount.getApplication().getLname());
        lnameTxt.setEnabled(false);
        mnameTxt.setText(useraccount.getApplication().getMname());
        mnameTxt.setEnabled(false);
        aline1Txt.setText(useraccount.getApplication().getAline1());
        aline1Txt.setEnabled(false);
//        aline2Txt.setText(useraccount.getApplication().getAline2());
//        aline2Txt.setEnabled(false);
        cityTxt.setText(useraccount.getApplication().getCity());
        cityTxt.setEnabled(false);
        stateTxt.setText(useraccount.getApplication().getState());
        stateTxt.setEnabled(false);
        problemDescriptionTxt.setText(useraccount.getApplication().getProblemDescription());
        problemDescriptionTxt.setEnabled(false);
//        incomeTxt.setText(convertInteger(useraccount.getApplication().getIncome()));
//        incomeTxt.setEnabled(false);
//        zipTxt.setText(convertInteger(useraccount.getApplication().getZip()));
//        zipTxt.setEnabled(false);
//        numberTxt.setText(convertInteger(useraccount.getApplication().getNumber()));
        ImageIcon icon = new ImageIcon((useraccount.getApplication().getPicturePath()));
        icon.setImage(icon.getImage().getScaledInstance(162, 102, Image.SCALE_DEFAULT));
        imageLbl.setIcon(icon);
        uploadBtn.setEnabled(false);
        
    }
    
    public static String convertInteger(int i) {
        return Integer.toString(i);
    }
    
    private void updateApplication() {
        useraccount.getApplication().setFname(fnameTxt.getText());
        useraccount.getApplication().setMname(mnameTxt.getText());
        useraccount.getApplication().setLname(lnameTxt.getText());
        useraccount.getApplication().setAline1(aline1Txt.getText());
//        useraccount.getApplication().setAline2(aline2Txt.getText());
        useraccount.getApplication().setCity(cityTxt.getText());
        useraccount.getApplication().setState(stateTxt.getText());
        useraccount.getApplication().setProblemDescription(problemDescriptionTxt.getText());
        useraccount.getApplication().setApplicant(useraccount);
//        ImageIcon icon = new ImageIcon((useraccount.getApplication().getPicturePath()));
//        icon.setImage(icon.getImage().getScaledInstance(162, 102, Image.SCALE_DEFAULT));
//        imageLbl.setIcon(icon);
        
/*        try {
            int income = Integer.parseInt(incomeTxt.getText());
            useraccount.getApplication().setIncome(income);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Income must be a number.");
            return;
        }

        try {
            int zip = Integer.parseInt(incomeTxt.getText());
            useraccount.getApplication().setZip(zip);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Zip Code must be a number.");
            return;
        }
*/     
        JOptionPane.showMessageDialog(null,"Application Successfully Submitted");
        
        fnameTxt.setText("");
        lnameTxt.setText("");
        mnameTxt.setText("");
        aline1Txt.setText("");
//        aline2Txt.setText("");
        cityTxt.setText("");
        stateTxt.setText("");
//        zipTxt.setText("");
        problemDescriptionTxt.setText("");
//        incomeTxt.setText("");
//        numberTxt.setText("");
        imageLbl.setText("");
        
        fnameTxt.setEditable(true);
        lnameTxt.setEditable(true);
        mnameTxt.setEditable(true);
        aline1Txt.setEditable(true);
//        aline2Txt.setEditable(true);
        cityTxt.setEditable(true);
        stateTxt.setEditable(true);
//        zipTxt.setEditable(true);
//        incomeTxt.setEditable(true);
        problemDescriptionTxt.setEditable(true);
        uploadBtn.setEnabled(true);
//        numberTxt.setEditable(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JTextField();
        mnameTxt = new javax.swing.JTextField();
        lnameTxt = new javax.swing.JTextField();
        aline1Txt = new javax.swing.JTextField();
        cityTxt = new javax.swing.JTextField();
        stateTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        problemDescriptionTxt = new javax.swing.JTextField();
        applyBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        valueLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        uploadBtn = new javax.swing.JButton();
        imageLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 236, 236));

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Middle Name");

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Address");

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("City");

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("State");

        fnameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameTxtActionPerformed(evt);
            }
        });

        mnameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lnameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTxtActionPerformed(evt);
            }
        });

        cityTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        stateTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Problem Description");

        problemDescriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                problemDescriptionTxtActionPerformed(evt);
            }
        });

        applyBtn.setBackground(new java.awt.Color(51, 51, 51));
        applyBtn.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        applyBtn.setForeground(new java.awt.Color(255, 51, 51));
        applyBtn.setText("Apply");
        applyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applyBtnMouseExited(evt);
            }
        });
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back Button Arrow Icon!!!! (3).jpg"))); // NOI18N
        backBtn.setPreferredSize(new java.awt.Dimension(65, 43));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(51, 51, 51));
        updateBtn.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 51, 51));
        updateBtn.setText("Update");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtnMouseExited(evt);
            }
        });
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Status");

        valueLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Upload Supporting Documents");

        uploadBtn.setBackground(new java.awt.Color(51, 51, 51));
        uploadBtn.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        uploadBtn.setForeground(new java.awt.Color(255, 51, 51));
        uploadBtn.setText("Upload");
        uploadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uploadBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uploadBtnMouseExited(evt);
            }
        });
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("APPLICATION");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/examinerere.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(problemDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aline1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(stateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(valueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aline1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(problemDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(381, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameTxtActionPerformed

    private void problemDescriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_problemDescriptionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_problemDescriptionTxtActionPerformed

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        // TODO add your handling code here:
        Organization org = null;
        for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            for (Organization o : e.getOrganizationDirectory().getOrganizationList()){
                if (o instanceof ExaminerOrganization){
                    org = o;
                    break;
                }
            }
            if (org!=null){
                if(org.getApplicationDirectory().getApplicationList().contains(useraccount.getApplication())) {
                    int i = org.getApplicationDirectory().getApplicationList().indexOf(useraccount.getApplication());
                    updateApplication();
                    org.getApplicationDirectory().getApplicationList().set(i, useraccount.getApplication());
                }
                else {
                    updateApplication();
                    org.getApplicationDirectory().getApplicationList().add(useraccount.getApplication());
                }
                break;
            }
        }
    }//GEN-LAST:event_applyBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.userProcessContainer.remove(this);
        CardLayout layout= (CardLayout)this.userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        UpdateApplicationJPanel uajp =new UpdateApplicationJPanel (userProcessContainer,useraccount,corg, enterprise,network,system);
        userProcessContainer.add("UpdateApplicationJPanel", uajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
    }//GEN-LAST:event_updateBtnActionPerformed

    private void lnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTxtActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        useraccount.getApplication().setPicturePath(chooser.getSelectedFile().getAbsolutePath());
        ImageIcon icon = new ImageIcon(useraccount.getApplication().getPicturePath());
        icon.setImage(icon.getImage().getScaledInstance(162, 102, Image.SCALE_DEFAULT));
        imageLbl.setIcon(icon);
        
       
    }//GEN-LAST:event_uploadBtnActionPerformed

    private void uploadBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadBtnMouseEntered
        // TODO add your handling code here:
        uploadBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_uploadBtnMouseEntered

    private void uploadBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadBtnMouseExited
        // TODO add your handling code here:\
        uploadBtn.setBackground(Color.darkGray);
    }//GEN-LAST:event_uploadBtnMouseExited

    private void updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseEntered
        // TODO add your handling code here:
        updateBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_updateBtnMouseEntered

    private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseExited
        // TODO add your handling code here:
        updateBtn.setBackground(Color.darkGray);
    }//GEN-LAST:event_updateBtnMouseExited

    private void applyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyBtnMouseEntered
        // TODO add your handling code here:
        applyBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_applyBtnMouseEntered

    private void applyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyBtnMouseExited
        // TODO add your handling code here:
        applyBtn.setBackground(Color.darkGray);

    }//GEN-LAST:event_applyBtnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aline1Txt;
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField cityTxt;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lnameTxt;
    private javax.swing.JTextField mnameTxt;
    private javax.swing.JTextField problemDescriptionTxt;
    private javax.swing.JTextField stateTxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton uploadBtn;
    private javax.swing.JLabel valueLbl;
    // End of variables declaration//GEN-END:variables
}
