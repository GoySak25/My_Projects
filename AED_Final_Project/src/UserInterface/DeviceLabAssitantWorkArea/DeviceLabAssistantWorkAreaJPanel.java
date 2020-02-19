/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DeviceLabAssitantWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AuthorizationOrganization;
import Business.Organization.DeviceLabOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AllWorkRequests;
import Business.WorkQueue.DeviceLabLevelWorkRequest;
import Business.WorkQueue.DoctorLevelWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author divinity
 */
public class DeviceLabAssistantWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private DeviceLabOrganization deviceLabOrganization;

    public DeviceLabAssistantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.deviceLabOrganization = (DeviceLabOrganization) organization;
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        System.out.println("before populate");
        populateTable();
        System.out.println("after populate");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        System.out.println("population device table id:");
        for (WorkRequest request : deviceLabOrganization.getWorkQueue().getWorkRequestList()) {
            System.out.println("population device table id: in loop: ");
            Object[] row = new Object[4];
            row[0] = request;
            //System.out.println(request.getDevice().getDeviceName());
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            System.out.println("Request id:"+ request.getRequestId());
            row[3] = request.getStatus();

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        processJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        fwdToDoctor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(234, 225, 226));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        workRequestJTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(workRequestJTable);

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        fwdToDoctor.setText("Forward to Doctor");
        fwdToDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fwdToDoctorActionPerformed(evt);
            }
        });

        jLabel1.setText("Lab Assistant WorkArea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(assignJButton)
                            .addGap(39, 39, 39)
                            .addComponent(processJButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fwdToDoctor))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshJButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(58, 58, 58))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {assignJButton, fwdToDoctor, processJButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(refreshJButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignJButton)
                    .addComponent(fwdToDoctor)
                    .addComponent(processJButton))
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a VALID Request !!");

        } else {
                 WorkRequest request1 = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if ((request1.getReceiver() == null)) {
                JOptionPane.showMessageDialog(null, "Can't be processed first assign the Request");
            } else {
                DeviceLabLevelWorkRequest request = (DeviceLabLevelWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

                request.setStatus("Processing");

                ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request , business);
                userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
    }//GEN-LAST:event_processJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }
        //System.out.println("hello in assignment");

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == null) {
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Request Already Sent");
        }


    }//GEN-LAST:event_assignJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void fwdToDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fwdToDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            //System.out.println("found row as null");
            JOptionPane.showMessageDialog(null, "Please select a request to be forwarded");
            return;

        }
        WorkRequest requestObjForDeviceLab = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        DoctorLevelWorkRequest requestObjForDoctor = new DoctorLevelWorkRequest();
        //Devrequest = (DeviceLabLevelWorkRequest)request;

        if (requestObjForDeviceLab.getStatus().equalsIgnoreCase("Rejected")) {
            JOptionPane.showMessageDialog(null, "The device test result failed and Request is Rejected");
        } else {
            requestObjForDoctor.setDevice(requestObjForDeviceLab.getDevice());
            requestObjForDoctor.setEnterprise(requestObjForDeviceLab.getEnterprise());
            requestObjForDoctor.setSender(userAccount);
            requestObjForDoctor.setStatus("To Be Processed");
            requestObjForDoctor.setParentId(requestObjForDeviceLab.getRequestId());
            requestObjForDeviceLab.setStatus("Pending Doctor Approval");

            business.getAllWorkList().add(requestObjForDoctor);
            
            Organization org = null;
            Enterprise enterprise1 = null;

            for (Network net : business.getNetworkList()) {
                for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                    if (ent.equals(requestObjForDoctor.getEnterprise())) {
                        for (Organization org1 : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (org1 instanceof DoctorOrganization) {
                                org = org1;
                                enterprise1 = ent;
                                break;
                            }
                        }
                        if (org != null && enterprise1 != null) {
                            org.getWorkQueue().getWorkRequestList().add(requestObjForDoctor);
                            userAccount.getWorkQueue().getWorkRequestList().add(requestObjForDeviceLab);
                            System.out.println("org selected 123" + org);
                            //System.out.println(dev);
                        }
                    }
                }

            }
        }
    }//GEN-LAST:event_fwdToDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton fwdToDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
