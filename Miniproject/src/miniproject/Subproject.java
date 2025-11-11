/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package miniproject;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.File;
import javax.swing.JFileChooser;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author User
 */


public class Subproject extends javax.swing.JPanel {
    private File pictureFile = null;
    private File educationFile = null;
    private File supportCertFile = null;
    
    
    /**
     * Creates new form Subproject
     */
    public Subproject() {
        initComponents();
        ActionListener courseCheckListener = e -> checkDuplicateCourses();   
        jComboBox1.addActionListener(courseCheckListener);
        jComboBox2.addActionListener(courseCheckListener);
        jComboBox3.addActionListener(courseCheckListener);
    }
    
    private void checkDuplicateCourses() {
        String course1 = (String) jComboBox1.getSelectedItem();
        String course2 = (String) jComboBox2.getSelectedItem();
        String course3 = (String) jComboBox3.getSelectedItem();

        if (course1.equals(course2) || course1.equals(course3) || course2.equals(course3)) {
            JOptionPane.showMessageDialog(this, "Each course must be different!");
        }
    }
    
    private void initComponents() {

        setLayout(new BorderLayout());
        setBackground(new Color(250, 250, 255));

        JLabel title = new JLabel("Application Form", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 20),
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // === Row 1 === Full Name
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1;
        jTextField1 = new JTextField(20);
        formPanel.add(jTextField1, gbc);

        // === Row 2 === IC Number
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("IC Number:"), gbc);
        gbc.gridx = 1;
        jTextField2 = new JTextField(20);
        formPanel.add(jTextField2, gbc);

        // === Row 3 === Age
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        jTextField3 = new JTextField(10);
        formPanel.add(jTextField3, gbc);

        // === Row 4 === Gender
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.setBackground(Color.WHITE);
        jRadioButton1 = new JRadioButton("Male");
        jRadioButton2 = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(jRadioButton1);
        genderGroup.add(jRadioButton2);
        genderPanel.add(jRadioButton1);
        genderPanel.add(jRadioButton2);
        formPanel.add(genderPanel, gbc);

        // === Row 5 === Email
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Email Address:"), gbc);
        gbc.gridx = 1;
        jTextField4 = new JTextField(25);
        formPanel.add(jTextField4, gbc);

        // === Row 6 === Contact
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Contact Number:"), gbc);
        gbc.gridx = 1;
        jTextField5 = new JTextField(15);
        formPanel.add(jTextField5, gbc);

        // === Row 7 === Address
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Home Address:"), gbc);
        gbc.gridx = 1;
        jTextArea10 = new JTextArea(3, 20);
        jTextArea10.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jTextArea10.setWrapStyleWord(true);
        jTextArea10.setLineWrap(true);
        formPanel.add(new JScrollPane(jTextArea10), gbc);

        // === Row 8 === Course Choices
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Course Choices:"), gbc);
        gbc.gridx = 1;
        JPanel comboPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        comboPanel.setBackground(Color.WHITE);
        jComboBox1 = new JComboBox<>(courseOptions());
        jComboBox2 = new JComboBox<>(courseOptions());
        jComboBox3 = new JComboBox<>(courseOptions());
        comboPanel.add(jComboBox1);
        comboPanel.add(jComboBox2);
        comboPanel.add(jComboBox3);
        formPanel.add(comboPanel, gbc);

        // === Row 9 === Attachments ===
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Picture:"), gbc);
        gbc.gridx = 1;
        jButton2 = new JButton("Attach Picture");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        formPanel.add(jButton2, gbc);

        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Education Certificate:"), gbc);
        gbc.gridx = 1;
        jButton3 = new JButton("Attach Education Cert");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        formPanel.add(jButton3, gbc);

        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Support Certificate:"), gbc);
        gbc.gridx = 1;
        jButton4 = new JButton("Attach Support Cert");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        formPanel.add(jButton4, gbc);

        // === Submit Button ===
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        jButton1 = new JButton("Send Email");
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jButton1.setBackground(new Color(60, 130, 200));
        jButton1.setForeground(Color.WHITE);
        jButton1.setFocusPainted(false);
        jButton1.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        jButton1.addActionListener(this::jButton1ActionPerformed);
        formPanel.add(jButton1, gbc);

        add(formPanel, BorderLayout.CENTER);
    }
    
    private String[] courseOptions() {
        return new String[]{
                "CNC PRECISION TECHNOLOGY - MED",
                "MANUFACTURING SYSTEM - MED",
                "MACHINE TOOL MAINTENANCE - MED",
                "AUTOMATION & IOT - EED",
                "COMPUTER & NETWORK - EED",
                "ELECTRONIC SYSTEM & COMMUNICATION - EED"
        };
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        String fullName = jTextField1.getText();
        String icNumber = jTextField2.getText();
        String age = jTextField3.getText();
        String emailTo = jTextField4.getText();
        String contact = jTextField5.getText();
        String address = jTextArea10.getText();
        String gender = jRadioButton1.isSelected() ? "Male" : (jRadioButton2.isSelected() ? "Female" : "Not Selected");
        String course1 = (String) jComboBox1.getSelectedItem();
        String course2 = (String) jComboBox2.getSelectedItem();
        String course3 = (String) jComboBox3.getSelectedItem();
        
        if (course1.equals(course2) || course1.equals(course3) || course2.equals(course3)) {
            JOptionPane.showMessageDialog(this, "Each course must be different!");
            return;
        }

        String messageText = "Student Application Form Details:\n\n"
                + "Full Name: " + fullName + "\n"
                + "\nIC Number: " + icNumber + "\n"
                + "\nCourse Choices:\n" 
                + "1. " + course1 + "\n"
                + "2." + course2 + "\n"
                + "3." + course3 + "\n"
                + "\nGender: " + gender + "\n"
                + "\nAge: " + age + "\n"
                + "\nEmail: " + emailTo + "\n"
                + "\nContact: " + contact + "\n"
                + "\nAddress: " + address + "\n"
                + "\nAttachments:\n"
                + "- Picture\n"
                + "- Education Certificate\n"
                + "- Support Certificate (Optional)\n";
                        

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String myEmail = "muhammadnasrulizwan@gmail.com";
        final String myPassword = "ibae zsfj naor tnsz";

        Session session = javax.mail.Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myEmail, myPassword);
                }
            });

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(myEmail));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
        msg.setSubject("Your Application Form");

        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(messageText);
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textPart);
        
        if (pictureFile != null) {
            MimeBodyPart attach1 = new MimeBodyPart();
            attach1.attachFile("Picture" + pictureFile.getName());
            attach1.attachFile(pictureFile);
            multipart.addBodyPart(attach1);
        }
        if (educationFile != null) {
            MimeBodyPart attach2 = new MimeBodyPart();
            attach2.attachFile("Education Certificate" + educationFile.getName());
            attach2.attachFile(educationFile);
            multipart.addBodyPart(attach2);
        }
        if (supportCertFile != null) {
            MimeBodyPart attach3 = new MimeBodyPart();
            attach3.attachFile("Support Certificate" + supportCertFile.getName());
            attach3.attachFile(supportCertFile);
            multipart.addBodyPart(attach3);
        }

        msg.setContent(multipart);
        Transport.send(msg);
        JOptionPane.showMessageDialog(this, "Email sent successfully to " + emailTo);

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Failed to send email: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        educationFile = chooseFile("Select Education Certificate");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        educationFile = chooseFile("Select Education Certificate");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        supportCertFile = chooseFile("Select Support Certificate");
    }//GEN-LAST:event_jButton4ActionPerformed

    private File chooseFile(String title) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        int result = chooser.showOpenDialog(this);
        return (result == JFileChooser.APPROVE_OPTION) ? chooser.getSelectedFile() : null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
