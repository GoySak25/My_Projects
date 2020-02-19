/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AuthorizationWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AuthorizationOrganization;
import Business.Organization.DeviceLabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DeviceLabLevelWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.EnterpriseWorkQueues.EmailCommunicationJPanel;
import UserInterface.EnterpriseWorkQueues.OrganisationEmailJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author divinity
 */
public class AuthorizationWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private AuthorizationOrganization authOrganization;
    private Organization org;

    public AuthorizationWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.authOrganization = (AuthorizationOrganization) organization;
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        System.out.println("My Papa " + enterprise.getName());
        populateTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : authOrganization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];

            row[0] = request;
            //System.out.println(request.getDevice().getDeviceName());
            row[1] = request.getSender().getEmployee().getName();
            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[2] = request.getStatus();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        sendEmailButton = new javax.swing.JButton();
        placeOrderBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(234, 225, 226));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device", "Sender", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        workRequestJTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(workRequestJTable);

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Forward To Lab");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sendEmailButton.setText("Send Email");
        sendEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailButtonActionPerformed(evt);
            }
        });

        placeOrderBtn.setText("Status Update/Place Order");
        placeOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Authorization Workarea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(placeOrderBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sendEmailButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(refreshJButton)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, placeOrderBtn, sendEmailButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(refreshJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeOrderBtn)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendEmailButton)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }
        WorkRequest requestObjForAuthenticator = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        DeviceLabLevelWorkRequest requestObjForDeviceLab = new DeviceLabLevelWorkRequest();
        //Devrequest = (DeviceLabLevelWorkRequest)request;

        requestObjForDeviceLab.setDevice(requestObjForAuthenticator.getDevice());
        requestObjForDeviceLab.setEnterprise(requestObjForAuthenticator.getEnterprise());
        requestObjForDeviceLab.setSender(userAccount);
        requestObjForDeviceLab.setStatus("To Be Processed");
        requestObjForDeviceLab.setParentId(requestObjForAuthenticator.getRequestId());
        requestObjForAuthenticator.setStatus("Sent to Lab");
        business.getAllWorkList().add(requestObjForDeviceLab);

        //request.setStatus("Sent to Lab");
        Organization org = null;
        Enterprise enterprise1 = null;

        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.equals(requestObjForDeviceLab.getEnterprise())) {
                    for (Organization org1 : ent.getOrganizationDirectory().getOrganizationList()) {
                        if (org1 instanceof DeviceLabOrganization) {
                            org = org1;
                            enterprise1 = ent;
                            break;
                        }
                    }
                    if (org != null && enterprise1 != null) {
                        org.getWorkQueue().getWorkRequestList().add(requestObjForDeviceLab);
                        userAccount.getWorkQueue().getWorkRequestList().add(requestObjForAuthenticator);
                        JOptionPane.showMessageDialog(null, "Device is sent for Testing");
                        //System.out.println(dev);

                    }
                }
            }

        }
        populateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sendEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailButtonActionPerformed
        // TODO add your handling code here:
        OrganisationEmailJPanel orgEmailCommunication = new OrganisationEmailJPanel(userProcessContainer, userAccount, enterprise, org);
        userProcessContainer.add("orgEmailCommunication", orgEmailCommunication);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_sendEmailButtonActionPerformed

    private void placeOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderBtnActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }

        WorkRequest requestObjForAuthenticator = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        ChangeStatusforSalesPerson(requestObjForAuthenticator);
        sendEmailMethod(requestObjForAuthenticator);


    }//GEN-LAST:event_placeOrderBtnActionPerformed
    public void ChangeStatusforSalesPerson(WorkRequest req) {
        String authortyParentId = req.getParentId();
        for (WorkRequest request : business.getAllWorkList()) {
            System.out.println("Request id for device  " + request.getRequestId());
            if (request.getRequestId().equalsIgnoreCase(authortyParentId)) {
                System.out.println("Match found");
                System.out.println("Old device status " + request.getStatus());
                if (req.getStatus().equals("Approved")) {
                    //req.setStatus("Order Placed");
                    request.setStatus("Order Placed");
                    ChangeStatusforManufacturer(request);
                } else if (req.getStatus().equals("Order Placed")) {
                    JOptionPane.showMessageDialog(null, "Order already placed !");
                } else {
                    request.setStatus(req.getStatus());
                }

            }
        }
    }

    public void ChangeStatusforManufacturer(WorkRequest req) {
        String authortyParentId = req.getParentId();
        for (WorkRequest request : business.getAllWorkList()) {
            System.out.println("Request id for device  " + request.getRequestId());
            if (request.getRequestId().equalsIgnoreCase(authortyParentId)) {
                System.out.println("Match found");
                System.out.println("Old device status " + request.getStatus());
                request.setStatus(req.getStatus());
            }
        }
    }

    private void sendEmailMethod(WorkRequest req) {
        String email = req.getSender().getEmailId().toString();
        String devId = req.getDevice().getDeviceId();
        if (req.getStatus().equalsIgnoreCase("Approved")) {
            EmailCommunicationJPanel emailCommunication = new EmailCommunicationJPanel(userProcessContainer, userAccount, email, devId);
            userProcessContainer.add("emailCommunication", emailCommunication);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            req.setStatus("Order Placed");
        } else {
            JOptionPane.showMessageDialog(null, "Request is not approved yet");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton placeOrderBtn;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton sendEmailButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}