/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseWorkQueues;



import Business.DeviceCategory.Device;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

import Business.WorkQueue.WorkRequest;
import java.net.Authenticator;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author sakshigoyal
 */
public class EmailCommunicationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmailCommunicationJPanel
     */
    private JPanel userContainer;
    private UserAccount user;
    private Enterprise enterprice;
    //private String[] message= {"Approved", "Disapproved"};
    private String email;
    private String deviceId;
    private int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public int quantity;
    private Device device;

    public EmailCommunicationJPanel(JPanel userContainer, UserAccount user, String email, String deviceId) {
        initComponents();
        this.userContainer = userContainer;
        this.user = user;
        this.email = email;
        this.deviceId = deviceId;
        this.device= device;
        emailId.setText(email);
        System.out.println("Outside Email Loop");

            System.out.println("Inside Email Loop");
            
        
        populate();
    }

    private void populate() {
        devQuantityComboBox.removeAllItems();
        for (int num1 : num) {
            devQuantityComboBox.addItem(num1);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sendEmailButton = new javax.swing.JButton();
        emailId = new javax.swing.JTextField();
        devQuantityComboBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(201, 218, 229));

        jLabel1.setText("Enterprise Send Mail");

        jLabel2.setText("Email Address:");

        jLabel3.setText("Device Quantity:");

        sendEmailButton.setText("Send");
        sendEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailButtonActionPerformed(evt);
            }
        });

        emailId.setBackground(java.awt.Color.lightGray);
        emailId.setEnabled(false);

        devQuantityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailId)
                            .addComponent(devQuantityComboBox, 0, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(sendEmailButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(devQuantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(sendEmailButton)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailButtonActionPerformed
        // TODO add your handling code here:
               try {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.user", user.getEmailId());
            props.put("mail.transport.protocol", "smtp");
            //props.put("mail.smtp.starttls.enable","true" );
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", 465);
            props.put("mail.smtp.socketFactory.fallback", "false");
            SMTPAuthenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(user.getEmailId()));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.trim()));
            msg.setSubject("Approval Status");
            quantity = (Integer) devQuantityComboBox.getSelectedItem();
            if(device.getDeviceId()== deviceId){
                device.setOrderQuantity(quantity);
                System.out.println("=============");
                System.out.println("Ordered quantity:"+ device.getOrderQuantity());
                System.out.println("=============");
            }
            msg.setText("We would like to place order for" + " " + quantity + " devices with device ID " + deviceId);
            // -- Set some other header information --
            msg.setHeader("MyMail", "Mr. XYZ");
            msg.setSentDate(new Date());
            // -- Send the message --
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", Integer.valueOf(465), user.getEmailId(), user.getPassword());
            transport.send(msg);
            JOptionPane.showMessageDialog(null, "Message Sent to:" + email);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Email Address");

        }
    }//GEN-LAST:event_sendEmailButtonActionPerformed
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            // specify your password here
            return new PasswordAuthentication(user.getEmailId(), user.getPassword());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox devQuantityComboBox;
    private javax.swing.JTextField emailId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton sendEmailButton;
    // End of variables declaration//GEN-END:variables
}
