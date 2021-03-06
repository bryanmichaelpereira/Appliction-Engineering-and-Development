/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ClientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.LawFirm;
import Business.Network.Network;
import Business.Organization.LawyerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 
 */
public class RetrieveLawyerJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    private Map<Integer, UserAccount> lawyers;
    private Map<Integer, Network> networks;
    private Map<Integer, Enterprise> enterprises;
    private Map<Integer, UserAccount> displayedLawyers;
    float famDis=0;
    float harassAdv=0;
    float abuseAdv=0;
    float distressAdv=0;
    String chartHeader="PIECHART";
    /**
     * Creates new form RetrieveLawyerJPanel
     */
    public RetrieveLawyerJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.system = system;
        
        lawyers = new HashMap<>();
        networks = new HashMap<>();
        enterprises = new HashMap<>();
        displayedLawyers = new HashMap<>();
        
        populateTable();
        populateSpecialtyComboBox();
        populateSortComboBox();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
        
        model.setRowCount(0);
        
        for(Network n : system.getNetworkList()){
            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if(e.getEnterpriseType().equals(LawFirm)) {
                    for(Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        if(o instanceof LawyerOrganization) {
                           for(UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                               Object[] row = new Object[5];
                               row[0] = ua;
                               row[1] = e.getName();
                               row[2] = ua.getTotal();
                               row[3] = ua.getHelpful();
                               if(ua.getTotal() == 0) {
                                   row[4] = "0";
                               }
                               else {
                                   float percent = (float)ua.getHelpful() / (float)ua.getTotal();
                                   NumberFormat nt = NumberFormat.getPercentInstance();
                                   nt.setMinimumFractionDigits(2);
                                   row[4] = nt.format(percent);
                               }
                               
                               model.addRow(row);
                               
                               lawyers.put(ua.getEmployee().getId(), ua);
                               networks.put(ua.getEmployee().getId(), n);
                               enterprises.put(ua.getEmployee().getId(), e);
                               displayedLawyers.put(ua.getEmployee().getId(), ua);
                               
                               
                           } 
                        }
                    }
                }
            }
        }
        
        for(Integer i : lawyers.keySet()) {
            //code for piechart binding at start
            if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                {
                    famDis= famDis + lawyers.get(i).getTotal();
                }
             else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                 {
                     harassAdv= harassAdv + lawyers.get(i).getTotal();
                 }
             else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                 {
                     abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                 }
             else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                {
                    distressAdv= distressAdv + lawyers.get(i).getTotal();
                }
            chartHeader="Clients Acroas all States";
        }
    }
    
    private void populateSpecialtyComboBox() {
        specialtyJComboBox.removeAllItems();
        specialtyJComboBox.addItem("All");
                specialtyJComboBox.addItem("Criminal");
                specialtyJComboBox.addItem("Marital");
                specialtyJComboBox.addItem("Public Interest");
                specialtyJComboBox.addItem("Mental Health");
                specialtyJComboBox.addItem("Sexual Assualt");
                specialtyJComboBox.addItem("Sexual Abuse");
        for(UserAccount u : lawyers.values()) {
            int get_totalSatisfied=u.getTotal();
            boolean contained = false;
            for(int i=1; i<specialtyJComboBox.getItemCount(); i++) {
                if(specialtyJComboBox.getItemAt(i).equals(u.getEmployee().getSpecialty())) {
                    contained = true;
                    break;
                }
            }
//            if(!contained) {
//                specialtyJComboBox.addItem(u.getEmployee().getSpecialty());
//            }
        }
    }
    
    private void populateNetworkComboBox() {
        networkJComboBox.removeAllItems();
        networkJComboBox.addItem("All");
        if(specialtyJComboBox.getSelectedIndex() == 0) {
            for(Network n : networks.values()) {
                boolean contained = false;
                for(int i=1; i<networkJComboBox.getItemCount(); i++) {
                    if(networkJComboBox.getItemAt(i).equals(n)) {
                        contained = true;
                        break;
                    }
                }
                if(!contained) {
                    networkJComboBox.addItem(n);
                }
            }
        }
        else {
            for(Integer i : lawyers.keySet()) {
                if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem())) {
                    boolean contained = false;
                    for(int j=1; j<networkJComboBox.getItemCount(); j++) {
                        if(networkJComboBox.getItemAt(j).equals(networks.get(i))) {
                            contained = true;
                            break;
                        }
                    }
                    if(!contained) {
                        networkJComboBox.addItem(networks.get(i));
                    }
                }
            }
        }
    }
    
    private void populateLocationComboBox() {
        locationJComboBox.removeAllItems();
        locationJComboBox.addItem("All");
        if(networkJComboBox.getSelectedIndex() == 0) {
            locationJComboBox.setEnabled(false);
        }
        else {
            locationJComboBox.setEnabled(true);
            if(specialtyJComboBox.getSelectedIndex() == 0) {
                for(Integer i : lawyers.keySet()) {
                    if(networks.get(i).equals(networkJComboBox.getSelectedItem())) {
                        boolean contained = false;
                        for(int j=1; j<locationJComboBox.getItemCount(); j++) {
                            if(locationJComboBox.getItemAt(j).equals(enterprises.get(i).getLocation())) {
                                contained = true;
                                break;
                            }
                        }
                        if(!contained) {
                            locationJComboBox.addItem(enterprises.get(i).getLocation());
                        }
                    }
                }
            }
            else {
                for(Integer i : lawyers.keySet()) {
                    if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem()) && 
                            networks.get(i).equals(networkJComboBox.getSelectedItem())) {
                        boolean contained = false;
                        for(int j=1; j<locationJComboBox.getItemCount(); j++) {
                            if(locationJComboBox.getItemAt(j).equals(enterprises.get(i).getLocation())) {
                                contained = true;
                                break;
                            }
                        }
                        if(!contained) {
                            locationJComboBox.addItem(enterprises.get(i).getLocation());
                        }
                    }
                }
            }
        }
    }
    
    private void populateSortComboBox() {
        sortJComboBox.removeAllItems();
        sortJComboBox.addItem("Default");
        sortJComboBox.addItem("Name");
        
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
        lawyerListJTable = new javax.swing.JTable();
        askJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        networkJComboBox = new javax.swing.JComboBox();
        locationJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        specialtyJComboBox = new javax.swing.JComboBox();
        applyJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sortJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 236, 236));

        lawyerListJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lawyerListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Law Firm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(lawyerListJTable);

        askJButton.setBackground(new java.awt.Color(51, 51, 51));
        askJButton.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        askJButton.setForeground(new java.awt.Color(0, 153, 153));
        askJButton.setText("Send Concern");
        askJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                askJButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                askJButtonMouseExited(evt);
            }
        });
        askJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back Button Arrow Icon!!!! (3).jpg"))); // NOI18N
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        networkJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        locationJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        locationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationJComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("State");

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("City");

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Specialty");

        specialtyJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        specialtyJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        specialtyJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialtyJComboBoxActionPerformed(evt);
            }
        });

        applyJButton.setBackground(new java.awt.Color(51, 51, 51));
        applyJButton.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        applyJButton.setForeground(new java.awt.Color(0, 153, 153));
        applyJButton.setText("Apply Filters");
        applyJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applyJButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applyJButtonMouseExited(evt);
            }
        });
        applyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyJButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("SEARCH LAWYERS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Sort by:");

        sortJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sortJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sortJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/images.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(applyJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(locationJComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(specialtyJComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(networkJComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(askJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sortJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(specialtyJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(applyJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(askJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void askJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askJButtonActionPerformed

        int selectedRow = lawyerListJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a lawyer to proceed.");
            return;
        }

        UserAccount lawyerAccount = (UserAccount)lawyerListJTable.getValueAt(selectedRow, 0);
        
        SendProblemJPanel spjp = new SendProblemJPanel(userProcessContainer, userAccount, lawyerAccount);
        userProcessContainer.add("SendProblemJPanel", spjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_askJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        // TODO add your handling code here:
        if(networkJComboBox.getSelectedItem() != null) {
            populateLocationComboBox(); 
        }
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void locationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationJComboBoxActionPerformed

    private void specialtyJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialtyJComboBoxActionPerformed
        // TODO add your handling code here:
        if(specialtyJComboBox.getSelectedItem() != null) {
            populateNetworkComboBox();
        }
    }//GEN-LAST:event_specialtyJComboBoxActionPerformed

    private void applyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyJButtonActionPerformed
        // TODO add your handling code here:
        famDis=0;
        harassAdv=0;
        abuseAdv=0;
        distressAdv=0;
        
        DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
        model.setRowCount(0);
        displayedLawyers.clear();
        if(specialtyJComboBox.getSelectedIndex() == 0 && networkJComboBox.getSelectedIndex() == 0) {
            for(Integer i : lawyers.keySet()) {
                Object[] row = new Object[5];
                row[0] = lawyers.get(i);
                row[1] = enterprises.get(i).getName();
                row[2] = lawyers.get(i).getTotal();
                row[3] = lawyers.get(i).getHelpful();
                if(lawyers.get(i).getTotal() == 0) {
                    row[4] = "0";
                }
                else {
                    float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                    NumberFormat nt = NumberFormat.getPercentInstance();
                    nt.setMinimumFractionDigits(2);
                    row[4] = nt.format(percent);
                }

                model.addRow(row);
                displayedLawyers.put(i, lawyers.get(i));
                
                if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                    {
                        famDis= famDis + lawyers.get(i).getTotal();
                    }
                else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                    {
                        harassAdv= harassAdv + lawyers.get(i).getTotal();
                    }
                else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                    {
                        abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                    }
                else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                    {
                        distressAdv= distressAdv + lawyers.get(i).getTotal();
                    }
                chartHeader="Clients Acroas all States";
            }
        }
        else if(specialtyJComboBox.getSelectedIndex() != 0 && networkJComboBox.getSelectedIndex() == 0) {
            for(Integer i : lawyers.keySet()) {
                if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem())) {
                    Object[] row = new Object[5];
                    row[0] = lawyers.get(i);
                    row[1] = enterprises.get(i).getName();
                    row[2] = lawyers.get(i).getTotal();
                    row[3] = lawyers.get(i).getHelpful();
                    if(lawyers.get(i).getTotal() == 0) {
                        row[4] = "0";
                    }
                    else {
                        float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        row[4] = nt.format(percent);
                    }

                    model.addRow(row);
                    displayedLawyers.put(i, lawyers.get(i));
                    if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                    {
                        famDis= famDis + lawyers.get(i).getTotal();
                    }
                    else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                    {
                        harassAdv= harassAdv + lawyers.get(i).getTotal();
                    }
                    else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                    {
                        abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                    }
                    else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                    {
                        distressAdv= distressAdv + lawyers.get(i).getTotal();
                    }
                    chartHeader= specialtyJComboBox.getSelectedItem().toString() + " Clients Acroas all States";
                }
            }
        }
        else if(specialtyJComboBox.getSelectedIndex() == 0 && networkJComboBox.getSelectedIndex() != 0) {
            if(locationJComboBox.getSelectedIndex() == 0) {
                for(Integer i : lawyers.keySet()) {
                    if(networks.get(i).equals(networkJComboBox.getSelectedItem())) {
                        Object[] row = new Object[5];
                        row[0] = lawyers.get(i);
                        row[1] = enterprises.get(i).getName();
                        row[2] = lawyers.get(i).getTotal();
                        row[3] = lawyers.get(i).getHelpful();
                        if(lawyers.get(i).getTotal() == 0) {
                            row[4] = "0";
                        }
                        else {
                            float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                            NumberFormat nt = NumberFormat.getPercentInstance();
                            nt.setMinimumFractionDigits(2);
                            row[4] = nt.format(percent);
                        }
                        
                        model.addRow(row);
                        displayedLawyers.put(i, lawyers.get(i));
                        if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                        {
                            famDis= famDis + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                        {
                            harassAdv= harassAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                        {
                            abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                        {
                            distressAdv= distressAdv + lawyers.get(i).getTotal();
                        }
                        chartHeader= " Clients Across "+ networkJComboBox.getSelectedItem().toString() + " state";

                    }
                }
            }
            else {
                for(Integer i : lawyers.keySet()) {
                    if(enterprises.get(i).getLocation().equals(locationJComboBox.getSelectedItem())) {
                        Object[] row = new Object[5];
                        row[0] = lawyers.get(i);
                        row[1] = enterprises.get(i).getName();
                        row[2] = lawyers.get(i).getTotal();
                        row[3] = lawyers.get(i).getHelpful();
                        if(lawyers.get(i).getTotal() == 0) {
                            row[4] = "0";
                        }
                        else {
                            float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                            NumberFormat nt = NumberFormat.getPercentInstance();
                            nt.setMinimumFractionDigits(2);
                            row[4] = nt.format(percent);
                        }

                        model.addRow(row);
                        displayedLawyers.put(i, lawyers.get(i));
                        if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                        {
                            famDis= famDis + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                        {
                            harassAdv= harassAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                        {
                            abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                        {
                            distressAdv= distressAdv + lawyers.get(i).getTotal();
                        }
                        chartHeader="Clients Across " + locationJComboBox.getSelectedItem() + " city";
                        
                    }
                }
            }
        }
        else {
            if(locationJComboBox.getSelectedIndex() == 0) {
                for(Integer i : lawyers.keySet()) {
                    if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem()) && 
                            networks.get(i).equals(networkJComboBox.getSelectedItem())) {
                        Object[] row = new Object[5];
                        row[0] = lawyers.get(i);
                        row[1] = enterprises.get(i).getName();
                        row[2] = lawyers.get(i).getTotal();
                        row[3] = lawyers.get(i).getHelpful();
                        if(lawyers.get(i).getTotal() == 0) {
                            row[4] = "0";
                        }
                        else {
                            float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                            NumberFormat nt = NumberFormat.getPercentInstance();
                            nt.setMinimumFractionDigits(2);
                            row[4] = nt.format(percent);
                        }

                        model.addRow(row);
                        displayedLawyers.put(i, lawyers.get(i));
                        if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                        {
                            famDis= famDis + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                        {
                            harassAdv= harassAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                        {
                            abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                        {
                            distressAdv= distressAdv + lawyers.get(i).getTotal();
                        }
                        
                        chartHeader= specialtyJComboBox.getSelectedItem().toString() + " Clients across " + networkJComboBox.getSelectedItem().toString() +" State";

                    }
                }
            }
            else {
                for(Integer i : lawyers.keySet()) {
                    if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem()) && 
                            enterprises.get(i).getLocation().equals(locationJComboBox.getSelectedItem())) {
                        Object[] row = new Object[5];
                        row[0] = lawyers.get(i);
                        row[1] = enterprises.get(i).getName();
                        row[2] = lawyers.get(i).getTotal();
                        row[3] = lawyers.get(i).getHelpful();
                        if(lawyers.get(i).getTotal() == 0) {
                            row[4] = "0";
                        }
                        else {
                            float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                            NumberFormat nt = NumberFormat.getPercentInstance();
                            nt.setMinimumFractionDigits(2);
                            row[4] = nt.format(percent);
                        }

                        model.addRow(row);
                        displayedLawyers.put(i, lawyers.get(i));
                        if(lawyers.get(i).getEmployee().getSpecialty().equals("Family Dispute Advisor")) 
                        {
                            famDis= famDis + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Sexual Harrassment Advisor")) 
                        {
                            harassAdv= harassAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Child Abuse Advisor")) 
                        {
                            abuseAdv= abuseAdv + lawyers.get(i).getTotal();
                        }
                        else if(lawyers.get(i).getEmployee().getSpecialty().equals("Mental Health Advisor")) 
                        {
                            distressAdv= distressAdv + lawyers.get(i).getTotal();
                        }
                        chartHeader= specialtyJComboBox.getSelectedItem().toString() + " Clients across " + locationJComboBox.getSelectedItem().toString() + " City";
                    }
                }
            }
        }
    }//GEN-LAST:event_applyJButtonActionPerformed

    private void sortJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortJComboBoxActionPerformed
        // TODO add your handling code here:
        switch(sortJComboBox.getSelectedIndex()) {
            case 0 : {
                DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
                model.setRowCount(0);
                for(Integer i : displayedLawyers.keySet()) {
                    Object[] row = new Object[5];
                    row[0] = lawyers.get(i);
                    row[1] = enterprises.get(i).getName();
                    row[2] = lawyers.get(i).getTotal();
                    row[3] = lawyers.get(i).getHelpful();
                    if(lawyers.get(i).getTotal() == 0) {
                        row[4] = "0";
                    }
                    else {
                        float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        row[4] = nt.format(percent);
                    }

                    model.addRow(row);
                }
                break;
            }
            case 1 : {
                List<Integer> lawyerList = new ArrayList<>(displayedLawyers.keySet());
                Collections.sort(lawyerList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer lawyerId1, Integer lawyerId2) {
                        return displayedLawyers.get(lawyerId1).toString().compareTo(displayedLawyers.get(lawyerId2).toString());
                    }
                });
                DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
                model.setRowCount(0);
                for(int i=0; i<lawyerList.size(); i++) {
                    int id = lawyerList.get(i);
                    Object[] row = new Object[5];
                    row[0] = lawyers.get(id);
                    row[1] = enterprises.get(id).getName();
                    row[2] = lawyers.get(id).getTotal();
                    row[3] = lawyers.get(id).getHelpful();
                    if(lawyers.get(id).getTotal() == 0) {
                        row[4] = "0";
                    }
                    else {
                        float percent = (float)lawyers.get(id).getHelpful() / (float)lawyers.get(id).getTotal();
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        row[4] = nt.format(percent);
                    }

                    model.addRow(row);
                }
                break;
            }
            case 2 : {
                List<Integer> lawyerList = new ArrayList<>(displayedLawyers.keySet());
                Collections.sort(lawyerList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer lawyerId1, Integer lawyerId2) {
                        return displayedLawyers.get(lawyerId2).getTotal() - displayedLawyers.get(lawyerId1).getTotal();
                    }
                });
                DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
                model.setRowCount(0);
                for(int i=0; i<lawyerList.size(); i++) {
                    int id = lawyerList.get(i);
                    Object[] row = new Object[5];
                    row[0] = lawyers.get(id);
                    row[1] = enterprises.get(id).getName();
                    row[2] = lawyers.get(id).getTotal();
                    row[3] = lawyers.get(id).getHelpful();
                    if(lawyers.get(id).getTotal() == 0) {
                        row[4] = "0";
                    }
                    else {
                        float percent = (float)lawyers.get(id).getHelpful() / (float)lawyers.get(id).getTotal();
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        row[4] = nt.format(percent);
                    }

                    model.addRow(row);
                }
                break;
            }
            case 3 : {
                List<Integer> lawyerList = new ArrayList<>(displayedLawyers.keySet());
                Collections.sort(lawyerList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer lawyerId1, Integer lawyerId2) {
                        return displayedLawyers.get(lawyerId2).getHelpful() - displayedLawyers.get(lawyerId1).getHelpful();
                    }
                });
                DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
                model.setRowCount(0);
                for(int i=0; i<lawyerList.size(); i++) {
                    int id = lawyerList.get(i);
                    Object[] row = new Object[5];
                    row[0] = lawyers.get(id);
                    row[1] = enterprises.get(id).getName();
                    row[2] = lawyers.get(id).getTotal();
                    row[3] = lawyers.get(id).getHelpful();
                    if(lawyers.get(id).getTotal() == 0) {
                        row[4] = "0";
                    }
                    else {
                        float percent = (float)lawyers.get(id).getHelpful() / (float)lawyers.get(id).getTotal();
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        row[4] = nt.format(percent);
                    }

                    model.addRow(row);
                }
                break;
            }
            case 4 : {
                List<Integer> lawyerList = new ArrayList<>(displayedLawyers.keySet());
                Collections.sort(lawyerList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer lawyerId1, Integer lawyerId2) {
                        float percentage1;
                        float percentage2;
                        if(displayedLawyers.get(lawyerId1).getTotal() == 0) {
                            percentage1 = 0;
                        }
                        else {
                            percentage1 = (float)displayedLawyers.get(lawyerId1).getHelpful() / (float)displayedLawyers.get(lawyerId1).getTotal();
                        }
                        if(displayedLawyers.get(lawyerId2).getTotal() == 0) {
                            percentage2 = 0;
                        }
                        else {
                            percentage2 = (float)displayedLawyers.get(lawyerId2).getHelpful() / (float)displayedLawyers.get(lawyerId2).getTotal();
                        }
                        return String.valueOf(percentage2).compareTo(String.valueOf(percentage1));
                    }
                });
                DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
                model.setRowCount(0);
                for(int i=0; i<lawyerList.size(); i++) {
                    int id = lawyerList.get(i);
                    Object[] row = new Object[5];
                    row[0] = lawyers.get(id);
                    row[1] = enterprises.get(id).getName();
                    row[2] = lawyers.get(id).getTotal();
                    row[3] = lawyers.get(id).getHelpful();
                    if(lawyers.get(id).getTotal() == 0) {
                        row[4] = "0";
                    }
                    else {
                        float percent = (float)lawyers.get(id).getHelpful() / (float)lawyers.get(id).getTotal();
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        row[4] = nt.format(percent);
                    }

                    model.addRow(row);
                }
                break;
            }
        }
    }//GEN-LAST:event_sortJComboBoxActionPerformed

    private void applyJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyJButtonMouseEntered
        // TODO add your handling code here:
        applyJButton.setBackground(Color.ORANGE);
    }//GEN-LAST:event_applyJButtonMouseEntered

    private void applyJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyJButtonMouseExited
        // TODO add your handling code here:
        applyJButton.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_applyJButtonMouseExited

    private void askJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_askJButtonMouseEntered
        // TODO add your handling code here:
        askJButton.setBackground(Color.ORANGE);
    }//GEN-LAST:event_askJButtonMouseEntered

    private void askJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_askJButtonMouseExited
        // TODO add your handling code here:
        askJButton.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_askJButtonMouseExited
    
    private void makeChart(DefaultPieDataset dataset)
    {
        JFreeChart chart= ChartFactory.createPieChart3D(chartHeader, dataset, true, true, true);

        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.GRAY);
        PiePlot3D plot= (PiePlot3D)chart.getPlot();
        plot.setStartAngle(90);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.7f);
        ChartFrame frame = new ChartFrame("Pie Chart for Advisor", chart);
        frame.setVisible(true);
        frame.setSize(650, 550);

        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("Advisor_Report.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 500, info);

        } catch (Exception e) {

        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyJButton;
    private javax.swing.JButton askJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lawyerListJTable;
    private javax.swing.JComboBox locationJComboBox;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JComboBox sortJComboBox;
    private javax.swing.JComboBox specialtyJComboBox;
    // End of variables declaration//GEN-END:variables
   

    
}
