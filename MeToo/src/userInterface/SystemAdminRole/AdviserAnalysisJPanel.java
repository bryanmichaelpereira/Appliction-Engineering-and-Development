/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SystemAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
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
 *

 */
public class AdviserAnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdviserAnalysis
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Map<Integer, UserAccount> lawyers;
    private Map<Integer, Network> networks;
    private Map<Integer, Enterprise> enterprises;
    private Map<Integer, UserAccount> displayedLawyers;
    public AdviserAnalysisJPanel(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        
        lawyers = new HashMap<>();
        networks = new HashMap<>();
        enterprises = new HashMap<>();
        displayedLawyers = new HashMap<>();
        this.userProcessContainer = userProcessContainer;
//        this.account = account;
        populateSpecialtyComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        specialtyJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        networkJCmbBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        locationJComboBox = new javax.swing.JComboBox();
        applyJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 236, 236));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("ANALYSIS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

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

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("State");

        networkJCmbBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        networkJCmbBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJCmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJCmbBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("City");

        locationJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        locationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationJComboBoxActionPerformed(evt);
            }
        });

        applyJButton.setBackground(new java.awt.Color(51, 51, 51));
        applyJButton.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        applyJButton.setForeground(new java.awt.Color(0, 153, 153));
        applyJButton.setText("Apply");
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

        backJButton.setBackground(new java.awt.Color(51, 51, 51));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 51, 0));
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back Button Arrow Icon!!!! (3).jpg"))); // NOI18N
        backJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backJButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backJButtonMouseExited(evt);
            }
        });
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specialtyJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(networkJCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(networkJCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(applyJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(specialtyJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void specialtyJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialtyJComboBoxActionPerformed
        // TODO add your handling code here:
        if(specialtyJComboBox.getSelectedItem() != null) {
//            populateNetworkComboBox();
        }
    }//GEN-LAST:event_specialtyJComboBoxActionPerformed

    private void networkJCmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJCmbBoxActionPerformed
        // TODO add your handling code here:
        if(networkJCmbBox.getSelectedItem() != null) {
            populateLocationComboBox();
        }
    }//GEN-LAST:event_networkJCmbBoxActionPerformed

    private void locationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationJComboBoxActionPerformed

    private void applyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyJButtonActionPerformed
        // TODO add your handling code here:
//        DefaultTableModel model = (DefaultTableModel)lawyerListJTable.getModel();
//        model.setRowCount(0);
        float famDis=0;
        float harassAdv=0;
        float abuseAdv=0;
        float distressAdv=0;
        
        
        displayedLawyers.clear();
        if(specialtyJComboBox.getSelectedIndex() == 0 && networkJCmbBox.getSelectedIndex() == 0) {
            for(Integer i : lawyers.keySet()) {
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
                
//                Object[] row = new Object[5];
//                row[0] = lawyers.get(i);
//                row[1] = enterprises.get(i).getName();
//                row[2] = lawyers.get(i).getTotal();
//                row[3] = lawyers.get(i).getHelpful();
//                if(lawyers.get(i).getTotal() == 0) {
//                    row[4] = "0";
//                }
//                else {
//                    float percent = (float)lawyers.get(i).getHelpful() / (float)lawyers.get(i).getTotal();
////                    NumberFormat nt = NumberFormat.getPercentInstance();
////                    nt.setMinimumFractionDigits(2);
////                    row[4] = nt.format(percent);
//                }
                DefaultPieDataset dataset = new DefaultPieDataset();
                dataset.setValue("Family Dispute Advisor", famDis);
                dataset.setValue("Sexual Harrassment Advisor", harassAdv);
                dataset.setValue("Child Abuse Advisor", abuseAdv);
                dataset.setValue("Mental Health Advisor", distressAdv);
                makeChart(dataset);
//                model.addRow(row);
//                displayedLawyers.put(i, lawyers.get(i));
            }
        }
        else if(specialtyJComboBox.getSelectedIndex() != 0 && networkJCmbBox.getSelectedIndex() == 0) {
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
//                        NumberFormat nt = NumberFormat.getPercentInstance();
//                        nt.setMinimumFractionDigits(2);
//                        row[4] = nt.format(percent);
                    }

//                    model.addRow(row);
//                    displayedLawyers.put(i, lawyers.get(i));
                }
            }
        }
        else if(specialtyJComboBox.getSelectedIndex() == 0 && networkJCmbBox.getSelectedIndex() != 0) {
            if(locationJComboBox.getSelectedIndex() == 0) {
                for(Integer i : lawyers.keySet()) {
                    if(networks.get(i).equals(networkJCmbBox.getSelectedItem())) {
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
//                            NumberFormat nt = NumberFormat.getPercentInstance();
//                            nt.setMinimumFractionDigits(2);
//                            row[4] = nt.format(percent);
                        }

//                        model.addRow(row);
                        displayedLawyers.put(i, lawyers.get(i));
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
//                            NumberFormat nt = NumberFormat.getPercentInstance();
//                            nt.setMinimumFractionDigits(2);
//                            row[4] = nt.format(percent);
                        }

//                        model.addRow(row);
//                        displayedLawyers.put(i, lawyers.get(i));
                    }
                }
            }
        }
        else {
            if(locationJComboBox.getSelectedIndex() == 0) {
                for(Integer i : lawyers.keySet()) {
                    if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem()) &&
                        networks.get(i).equals(networkJCmbBox.getSelectedItem())) {
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
//                            NumberFormat nt = NumberFormat.getPercentInstance();
//                            nt.setMinimumFractionDigits(2);
//                            row[4] = nt.format(percent);
                        }

//                        model.addRow(row);
//                        displayedLawyers.put(i, lawyers.get(i));
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
//                            NumberFormat nt = NumberFormat.getPercentInstance();
//                            nt.setMinimumFractionDigits(2);
//                            row[4] = nt.format(percent);
                        }

//                        model.addRow(row);
//                        displayedLawyers.put(i, lawyers.get(i));
                    }
                }
            }
        }
    }//GEN-LAST:event_applyJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
//        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void backJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backJButtonMouseEntered
        // TODO add your handling code here:
        backJButton.setBackground(Color.ORANGE);
    }//GEN-LAST:event_backJButtonMouseEntered

    private void backJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backJButtonMouseExited
        // TODO add your handling code here:
        backJButton.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_backJButtonMouseExited

    private void applyJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyJButtonMouseEntered
        // TODO add your handling code here:
        applyJButton.setBackground(Color.ORANGE);
    }//GEN-LAST:event_applyJButtonMouseEntered

    private void applyJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyJButtonMouseExited
        // TODO add your handling code here:
        applyJButton.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_applyJButtonMouseExited

 private void populateNetworkComboBox() {
        networkJCmbBox.removeAllItems();
        networkJCmbBox.addItem("All");
        if(specialtyJComboBox.getSelectedIndex() == 0) {
            for(Network n : networks.values()) {
                boolean contained = false;
                for(int i=1; i<networkJCmbBox.getItemCount(); i++) {
                    if(networkJCmbBox.getItemAt(i).equals(n)) {
                        contained = true;
                        break;
                    }
                }
                if(!contained) {
                    networkJCmbBox.addItem(n);
                }
            }
        }
        else {
            for(Integer i : lawyers.keySet()) {
                if(lawyers.get(i).getEmployee().getSpecialty().equals(specialtyJComboBox.getSelectedItem())) {
                    boolean contained = false;
                    for(int j=1; j<networkJCmbBox.getItemCount(); j++) {
                        if(networkJCmbBox.getItemAt(j).equals(networks.get(i))) {
                            contained = true;
                            break;
                        }
                    }
                    if(!contained) {
                        networkJCmbBox.addItem(networks.get(i));
                    }
                }
            }
        }
    }
 
 private void populateLocationComboBox() {
        locationJComboBox.removeAllItems();
        locationJComboBox.addItem("All");
        if(networkJCmbBox.getSelectedIndex() == 0) {
            locationJComboBox.setEnabled(false);
        }
        else {
            locationJComboBox.setEnabled(true);
            if(specialtyJComboBox.getSelectedIndex() == 0) {
                for(Integer i : lawyers.keySet()) {
                    if(networks.get(i).equals(networkJCmbBox.getSelectedItem())) {
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
                            networks.get(i).equals(networkJCmbBox.getSelectedItem())) {
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
 
    private void populateSpecialtyComboBox() {
        specialtyJComboBox.removeAllItems();
        specialtyJComboBox.addItem("All");
        specialtyJComboBox.addItem("Family Dispute Advisor");
        specialtyJComboBox.addItem("Sexual Harrassment Advisor");
        specialtyJComboBox.addItem("Child Abuse Advisor");
        specialtyJComboBox.addItem("Mental Health Advisor");
        populateNetworkComboBox();
//        for(UserAccount u : lawyers.values()) {
//            int get_totalSatisfied=u.getTotal();
//            boolean contained = false;
//            for(int i=1; i<specialtyJComboBox.getItemCount(); i++) {
//                if(specialtyJComboBox.getItemAt(i).equals(u.getEmployee().getSpecialty())) {
//                    contained = true;
//                    break;
//                }
//            }
//            if(!contained) {
//                specialtyJComboBox.addItem(u.getEmployee().getSpecialty());
//            }
//        }
    }
    
    private void makeChart(DefaultPieDataset dataset)
    {
        JFreeChart chart= ChartFactory.createPieChart3D("Adviser Statistics", dataset, true, true, true);

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
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox locationJComboBox;
    private javax.swing.JComboBox networkJCmbBox;
    private javax.swing.JComboBox specialtyJComboBox;
    // End of variables declaration//GEN-END:variables
}
