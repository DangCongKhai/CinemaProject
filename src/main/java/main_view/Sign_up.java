/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main_view;

import controller.SignUpController;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Sign_up extends javax.swing.JFrame {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[\\w.+\\-]+@(gmail\\.com|\\w*.edu.vn)$", Pattern.CASE_INSENSITIVE);
    private static final String api_key = "12d42e1d76da6625d532fb7eca3d1d570f6956a4";
    private static final String API_URL = "https://api.hunter.io/v2/email-verifier?email=";
    private static SignUpController sign_up_controller = SignUpController.getInstance();
    /**
     * Creates new form Sign_up
     */
    public Sign_up() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        tf_email = new javax.swing.JTextField();
        tf_confirm = new javax.swing.JPasswordField();
        jButton_login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 600));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");

        tf_password.setBackground(new java.awt.Color(0, 51, 102));
        tf_password.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        tf_password.setForeground(new java.awt.Color(255, 255, 255));
        tf_password.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        tf_email.setBackground(new java.awt.Color(0, 51, 102));
        tf_email.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        tf_email.setForeground(new java.awt.Color(255, 255, 255));
        tf_email.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        tf_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_emailActionPerformed(evt);
            }
        });

        tf_confirm.setBackground(new java.awt.Color(0, 51, 102));
        tf_confirm.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        tf_confirm.setForeground(new java.awt.Color(255, 255, 255));
        tf_confirm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Password:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton_login.setBackground(new java.awt.Color(0, 0, 0));
        jButton_login.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jButton_login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_login.setText("Sign up");
        jButton_login.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_loginMouseClicked(evt);
            }
        });
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("log in");
        jLabel2.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Already a member?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_email)
                        .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(429, 429, 429))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailActionPerformed

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed

        String email = tf_email.getText();
        if (!validEmail(email)){
            JOptionPane.showMessageDialog(this, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if (!isRealEmail(email)){
//            JOptionPane.showMessageDialog(this, "This email cannot be sent to", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        
        String password = new String(tf_password.getPassword());
        if (password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Password is empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String confirm = new String(tf_confirm.getPassword());
        if (confirm.isEmpty()){
            JOptionPane.showMessageDialog(this, "Comfirm password is empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!password.equals(confirm)){
            JOptionPane.showMessageDialog(this, "Comfirm password must match with password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if(sign_up_controller.signUpAccount(email, password)){
                JOptionPane.showMessageDialog(this, "Sucessful sign up", "Success sign up", JOptionPane.PLAIN_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this, email + " is existed", "Fail to sign up", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
//            Logger.getLogger(Sign_up.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_loginActionPerformed

    private void jButton_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_loginMouseClicked

    }//GEN-LAST:event_jButton_loginMouseClicked
    private boolean validEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }
    private boolean isRealEmail(String email){
        try{
            
            URL url = new URL(API_URL + email + "&api_key=" + api_key );
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200){
               Scanner scanner = new Scanner(url.openStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                
                // Here, you'd parse the JSON response to check if the email is deliverable.
                // This example assumes you check the JSON response field as per the API's documentation.
                // For example, response might include a "result" field with values like "deliverable"
                return response.toString().contains("\"result\":\"deliverable\"");
                // How to work with JSON file in java
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
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
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tf_confirm;
    private javax.swing.JTextField tf_email;
    private javax.swing.JPasswordField tf_password;
    // End of variables declaration//GEN-END:variables
}
