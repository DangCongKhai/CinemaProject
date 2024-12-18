package customer_panel;

import controller.LoginController;
import database.Database;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Customer;

import static util.Util.hashPassword;

public final class EditInfoPanel extends javax.swing.JPanel {
    private final static Connection conn = Database.getInstance();
    private final static LoginController signInController = LoginController.getInstance();
    private static String currentName = "";
    private static ButtonModel currentGender;
    private static String currentBirthday = "";
    
    private Customer customer;

//    public static void setCurrentGender(ButtonModel currentGender) {
//        EditInfoPanel.currentGender = currentGender;
//    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        populateCustomerInfo();
    }
    
    public EditInfoPanel() {
        initComponents();
        addPasswordListeners();
        addTextFieldListeners();
        addRBtnListeners();
        setCustomer(customer);
    }
    public EditInfoPanel(Customer customer) {
        initComponents();
        addPasswordListeners();
        addTextFieldListeners();
        addRBtnListeners();
        setCustomer(customer);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpGender = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbNewPassword = new javax.swing.JLabel();
        lbConfirmPassword = new javax.swing.JLabel();
        tfNewPassword = new javax.swing.JPasswordField();
        tfConfirmPassword = new javax.swing.JPasswordField();
        lbMatchNewPassword = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        btnUpdate = new cms.component.btnSignInOut();
        btnExitEdit = new cms.component.btnSignInOut();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        rbtnOther = new javax.swing.JRadioButton();
        lbBirthday = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        tfBirthday = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        btnEditInformation = new cms.component.btnSignInOut();
        jPanel2 = new javax.swing.JPanel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(620, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(620, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 600));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 55, 93));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Information");

        lbName.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(24, 55, 93));
        lbName.setText("Name:");

        tfName.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tfName.setMaximumSize(new java.awt.Dimension(400, 25));
        tfName.setMinimumSize(new java.awt.Dimension(400, 25));
        tfName.setPreferredSize(new java.awt.Dimension(400, 25));

        lbEmail.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(24, 55, 93));
        lbEmail.setText("Email:");

        tfEmail.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tfEmail.setMaximumSize(new java.awt.Dimension(400, 25));
        tfEmail.setMinimumSize(new java.awt.Dimension(400, 25));
        tfEmail.setPreferredSize(new java.awt.Dimension(400, 25));

        lbNewPassword.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbNewPassword.setForeground(new java.awt.Color(24, 55, 93));
        lbNewPassword.setText("New Password:");

        lbConfirmPassword.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbConfirmPassword.setForeground(new java.awt.Color(24, 55, 93));
        lbConfirmPassword.setText("Confirm Password:");

        tfNewPassword.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tfNewPassword.setMaximumSize(new java.awt.Dimension(400, 25));
        tfNewPassword.setMinimumSize(new java.awt.Dimension(400, 25));
        tfNewPassword.setPreferredSize(new java.awt.Dimension(400, 25));

        tfConfirmPassword.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tfConfirmPassword.setMaximumSize(new java.awt.Dimension(400, 25));
        tfConfirmPassword.setMinimumSize(new java.awt.Dimension(400, 25));
        tfConfirmPassword.setPreferredSize(new java.awt.Dimension(400, 25));

        lbMatchNewPassword.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        lbMatchNewPassword.setForeground(new java.awt.Color(255, 0, 51));
        lbMatchNewPassword.setText("The confirm password does not match!");

        lbGender.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbGender.setForeground(new java.awt.Color(24, 55, 93));
        lbGender.setText("Gender:");

        btnUpdate.setBackground(new java.awt.Color(223, 177, 96));
        btnUpdate.setBorder(null);
        btnUpdate.setText("Update");
        btnUpdate.setColor(new java.awt.Color(223, 177, 96));
        btnUpdate.setColorClick(new java.awt.Color(213, 64, 80));
        btnUpdate.setColorOver(new java.awt.Color(213, 64, 80));
        btnUpdate.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        btnUpdate.setRadius(0);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExitEdit.setBorder(null);
        btnExitEdit.setText("Exit Edit");
        btnExitEdit.setColor(new java.awt.Color(125, 225, 154));
        btnExitEdit.setColorClick(new java.awt.Color(93, 202, 209));
        btnExitEdit.setColorOver(new java.awt.Color(93, 202, 209));
        btnExitEdit.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        btnExitEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExitEdit.setRadius(0);
        btnExitEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitEditActionPerformed(evt);
            }
        });

        btngrpGender.add(rbtnMale);
        rbtnMale.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        rbtnMale.setText("Male");
        rbtnMale.setBorder(null);

        btngrpGender.add(rbtnFemale);
        rbtnFemale.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        rbtnFemale.setText("Female");
        rbtnFemale.setBorder(null);

        btngrpGender.add(rbtnOther);
        rbtnOther.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        rbtnOther.setText("Other");
        rbtnOther.setBorder(null);

        lbBirthday.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbBirthday.setForeground(new java.awt.Color(24, 55, 93));
        lbBirthday.setText("Birthday");

        lbPassword.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(24, 55, 93));
        lbPassword.setText("Password:");

        tfBirthday.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tfBirthday.setMaximumSize(new java.awt.Dimension(400, 25));
        tfBirthday.setMinimumSize(new java.awt.Dimension(400, 25));
        tfBirthday.setPreferredSize(new java.awt.Dimension(400, 25));

        tfPassword.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tfPassword.setMaximumSize(new java.awt.Dimension(400, 25));
        tfPassword.setMinimumSize(new java.awt.Dimension(400, 25));
        tfPassword.setPreferredSize(new java.awt.Dimension(400, 25));

        btnEditInformation.setBackground(new java.awt.Color(93, 202, 209));
        btnEditInformation.setBorder(null);
        btnEditInformation.setText("Edit Information");
        btnEditInformation.setColor(new java.awt.Color(93, 202, 209));
        btnEditInformation.setColorClick(new java.awt.Color(125, 225, 154));
        btnEditInformation.setColorOver(new java.awt.Color(125, 225, 154));
        btnEditInformation.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        btnEditInformation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditInformation.setRadius(0);
        btnEditInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditInformationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNewPassword)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbConfirmPassword)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbMatchNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                        .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFemale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnOther)))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnExitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(244, 244, 244))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGender)
                    .addComponent(rbtnMale)
                    .addComponent(rbtnFemale)
                    .addComponent(rbtnOther))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBirthday))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNewPassword)
                    .addComponent(tfNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConfirmPassword)
                    .addComponent(tfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMatchNewPassword)
                .addGap(33, 33, 33)
                .addComponent(btnEditInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tfName.setEditable(false);
        tfName.setEnabled(false);
        tfEmail.setEditable(false);
        tfEmail.setEnabled(false);
        lbNewPassword.setVisible(false);
        lbConfirmPassword.setVisible(false);
        tfNewPassword.setEditable(false);
        tfNewPassword.setEnabled(false);
        tfNewPassword.setVisible(false);
        tfConfirmPassword.setEditable(false);
        tfConfirmPassword.setEnabled(false);
        tfConfirmPassword.setVisible(false);
        lbMatchNewPassword.setVisible(false);
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnExitEdit.setEnabled(false);
        btnExitEdit.setVisible(false);
        rbtnMale.setEnabled(false);
        rbtnFemale.setEnabled(false);
        rbtnOther.setEnabled(false);
        lbPassword.setVisible(false);
        tfBirthday.setEditable(false);
        tfBirthday.setEnabled(false);
        tfPassword.setVisible(false);
        tfPassword.setEditable(false);
        tfPassword.setEnabled(false);

        jPanel2.setMaximumSize(new java.awt.Dimension(320, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(320, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(320, 600));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void populateCustomerInfo() {
        if (customer != null) {
            tfName.setText(customer.getName());
            tfEmail.setText(customer.getEmail());
            tfBirthday.setText(customer.getBirth_date());
            if (customer.getGender() == null){
                return;
            }
            switch (customer.getGender().toLowerCase()) {
                case "male":
                    rbtnMale.setSelected(true);
                    break;
                case "female":
                    rbtnFemale.setSelected(true);
                    break;
                case "other":
                    rbtnOther.setSelected(true);
                    break;
                default:
                    btngrpGender.clearSelection();
                    break;
            }
        }
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "Update your information?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == JOptionPane.YES_OPTION) { 
            String name = tfName.getText();
            String newPassword = new String(tfNewPassword.getPassword());
            String confirmPassword = new String(tfConfirmPassword.getPassword());
            String currentPassword = new String(tfPassword.getPassword());
            String email = tfEmail.getText();

            if (!newPassword.isEmpty() || !confirmPassword.isEmpty()) {
                if (newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "New password is empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Confirm password is empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!newPassword.equals(confirmPassword))  {
                    JOptionPane.showMessageDialog(this, "Confirm password must match the new password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (newPassword.equals(currentPassword)) {
                    JOptionPane.showMessageDialog(this, "New password cannot be the same as current password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } 

            String gender = null;
            if (rbtnMale.isSelected()) {
                gender = "Male";
            } else if (rbtnFemale.isSelected()) {
                gender = "Female";
            } else if (rbtnOther.isSelected()) {
                gender = "Other";
            } else {
                JOptionPane.showMessageDialog(this, "You forgot to choose the gender", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            customer.setGender(gender);
            customer.setName(name);
            String birth_day = tfBirthday.getText();
            customer.setBirth_date(birth_day);

            try {
                int accountID = signInController.login(email, currentPassword);
                if (accountID == -1) {
                    JOptionPane.showMessageDialog(this, "Incorrect current password", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (updateProfile(name, newPassword, gender, birth_day, accountID)) {
                        JOptionPane.showMessageDialog(this, "Profile updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        returnToDefaultEdit();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to update profile", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEditInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditInformationActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "Edit your information?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == JOptionPane.YES_OPTION) {
            lbPassword.setVisible(true);
            tfPassword.setVisible(true);
            lbNewPassword.setVisible(true);
            lbConfirmPassword.setVisible(true);
            tfNewPassword.setVisible(true);
            tfConfirmPassword.setVisible(true);
            tfNewPassword.setEditable(true);
            tfNewPassword.setEnabled(true);
            tfConfirmPassword.setEditable(true);
            tfConfirmPassword.setEnabled(true);
            rbtnMale.setEnabled(true);
            rbtnFemale.setEnabled(true);
            rbtnOther.setEnabled(true);
            tfName.setEditable(true);
            tfName.setEnabled(true);
            tfPassword.setEditable(true);
            tfPassword.setEnabled(true);
            tfBirthday.setEnabled(true);
            tfBirthday.setEditable(true);
            btnExitEdit.setEnabled(true);
            btnExitEdit.setVisible(true);
            btnUpdate.setVisible(true);
            btnEditInformation.setVisible(false);

            currentName = customer.getName();
            currentGender = btngrpGender.getSelection();
            currentBirthday = customer.getBirth_date();
        }
    }//GEN-LAST:event_btnEditInformationActionPerformed

    private void btnExitEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitEditActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == JOptionPane.YES_OPTION) {
            returnToDefaultEdit();
        }
    }//GEN-LAST:event_btnExitEditActionPerformed
    private void returnToDefaultEdit(){
        tfName.setEditable(false);
        tfName.setEnabled(false);
        rbtnMale.setEnabled(false);
        rbtnFemale.setEnabled(false);
        rbtnOther.setEnabled(false);
        tfBirthday.setEnabled(false);
        tfBirthday.setEditable(false);
        tfPassword.setEditable(false);
        tfPassword.setEnabled(false);
        lbPassword.setVisible(false);
        tfPassword.setVisible(false);
        lbNewPassword.setVisible(false);
        tfNewPassword.setVisible(false);
        tfNewPassword.setEditable(false);
        tfNewPassword.setEnabled(false);
        lbConfirmPassword.setVisible(false);
        tfConfirmPassword.setVisible(false);
        tfConfirmPassword.setEditable(false);
        tfConfirmPassword.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnExitEdit.setEnabled(false);
        btnExitEdit.setVisible(false);
        lbMatchNewPassword.setVisible(false);
        btnEditInformation.setVisible(true);

        tfName.setText(customer.getName());
        switch (customer.getGender().toLowerCase()) {
            case "male":
                rbtnMale.setSelected(true);
                break;
            case "female":
                rbtnFemale.setSelected(true);
                break;
            case "other":
                rbtnOther.setSelected(true);
                break;
            default:
                btngrpGender.clearSelection();
        }
        tfBirthday.setText(customer.getBirth_date());
    }
    public boolean updateProfile(String name, String password, String gender, String birthday, int accountID) throws SQLException {
        String hashedPassword = password.isEmpty() ? "" : hashPassword(password);
        StringBuilder userQuery = new StringBuilder("UPDATE [User] SET ");
        StringBuilder accountQuery = new StringBuilder("UPDATE [Account] SET ");
        boolean updateUser = false;
        boolean updateAccount = false;

        if (name != null && !name.isEmpty()) {
            userQuery.append("Name = ?");
            updateUser = true;
        }

        if (gender != null && !gender.isEmpty()) {
            if (updateUser) userQuery.append(", ");
            userQuery.append("Gender = ?");
            updateUser = true;
        }

        if (birthday != null && !birthday.isEmpty()) {
            if (updateUser) userQuery.append(", ");
            userQuery.append("Birthday = ?");
            updateUser = true;
        }

        if (!hashedPassword.isEmpty()) {
            accountQuery.append("Password = ?");
            updateAccount = true;
        }

        if (updateUser) {
            userQuery.append(" WHERE AccountID = ?");
        }

        if (updateAccount) {
            accountQuery.append(" WHERE AccountID = ?");
        }

        conn.setAutoCommit(false); // start transaction

        try (PreparedStatement userStmt = updateUser ? conn.prepareStatement(userQuery.toString()) : null;
             PreparedStatement accountStmt = updateAccount ? conn.prepareStatement(accountQuery.toString()) : null) {

            int paramIndex = 1;

            if (updateUser) {
                if (name != null && !name.isEmpty()) userStmt.setString(paramIndex++, name);
                if (gender != null && !gender.isEmpty()) userStmt.setString(paramIndex++, gender);
                if (birthday != null && !birthday.isEmpty()) userStmt.setString(paramIndex++, birthday);
                userStmt.setInt(paramIndex, accountID);
            }

            if (updateAccount) {
                accountStmt.setString(1, hashedPassword);
                accountStmt.setInt(2, accountID);
            }

            int userRowsAffected = updateUser ? userStmt.executeUpdate() : 0;
            int accountRowsAffected = updateAccount ? accountStmt.executeUpdate() : 0;

            if ((updateUser && userRowsAffected > 0) || (updateAccount && accountRowsAffected > 0)) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    public void addPasswordListeners() {
        DocumentListener passwordListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validatePasswords();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validatePasswords();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validatePasswords();
            }
            
            private void validatePasswords() {
                String newPassword = new String(tfNewPassword.getPassword());
                String confirmPassword = new String(tfConfirmPassword.getPassword());
                
                if (newPassword.equals(confirmPassword) && (!newPassword.isEmpty())) {
                    lbMatchNewPassword.setText("Matched!");
                    lbMatchNewPassword.setForeground(new Color(0, 204, 51));
                } else {
                    lbMatchNewPassword.setText("Does not match!");
                    lbMatchNewPassword.setForeground(new Color(255, 0, 51));
                }
                lbMatchNewPassword.setVisible(true);
            }
        };
        tfConfirmPassword.getDocument().addDocumentListener(passwordListener);
        tfNewPassword.getDocument().addDocumentListener(passwordListener);
    }

    private void addTextFieldListeners() {
        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkForChanges();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkForChanges();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkForChanges();
            }
        };
        tfName.getDocument().addDocumentListener(docListener);
        tfBirthday.getDocument().addDocumentListener(docListener);
        tfNewPassword.getDocument().addDocumentListener(docListener);
        tfConfirmPassword.getDocument().addDocumentListener(docListener);
        rbtnMale.addActionListener(e -> checkForChanges());
        rbtnFemale.addActionListener(e -> checkForChanges());
        rbtnOther.addActionListener(e -> checkForChanges());
    }

    private void checkForChanges() {
        boolean isChanged = !tfName.getText().trim().equals(currentName) ||
                            !tfName.getText().trim().equals("") ||
                            !tfBirthday.getText().trim().equals(currentBirthday) ||
                            !tfBirthday.getText().trim().equals("") ||
                            new String(tfNewPassword.getPassword()).equals(new String(tfConfirmPassword.getPassword()));

        btnUpdate.setEnabled(isChanged);
//        if (tfPassword.getPassword().length == 0) btnUpdate.setEnabled(false);
    }
    
    private void addRBtnListeners() {
        ActionListener rbtnListenr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btngrpGender.getSelection() == null || btngrpGender.getSelection() == currentGender) {
                    btnUpdate.setEnabled(false);
                } else {
                    btnUpdate.setEnabled(true);
                }
            }
            
        };
        rbtnMale.addActionListener(rbtnListenr);
        rbtnFemale.addActionListener(rbtnListenr);
        rbtnOther.addActionListener(rbtnListenr);
        
        if (btngrpGender.getSelection() == null || btngrpGender.getSelection() == currentGender) {
            btnUpdate.setEnabled(false);
        } else {
            btnUpdate.setEnabled(true);
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cms.component.btnSignInOut btnEditInformation;
    private cms.component.btnSignInOut btnExitEdit;
    private cms.component.btnSignInOut btnUpdate;
    private javax.swing.ButtonGroup btngrpGender;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbConfirmPassword;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbMatchNewPassword;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNewPassword;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JRadioButton rbtnOther;
    private javax.swing.JTextField tfBirthday;
    private javax.swing.JPasswordField tfConfirmPassword;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfName;
    private javax.swing.JPasswordField tfNewPassword;
    private javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables
}
