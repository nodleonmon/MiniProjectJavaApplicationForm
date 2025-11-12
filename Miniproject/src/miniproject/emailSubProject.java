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
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author User
 */


public class emailSubProject extends javax.swing.JPanel {
    private File pictureFile = null;
    private File educationFile = null;
    private File supportCertFile = null;
    
    private JLabel pictureLabel;
    private JLabel educationLabel;
    private JLabel supportCertLabel;
    
    
    /**
     * Creates new form Subproject
     */
    public emailSubProject() {
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
    setBackground(new Color(245, 245, 250));

    // ===== TITLE PANEL =====
    JPanel titlePanel = new JPanel(new BorderLayout());
    titlePanel.setBackground(new Color(173, 216, 230));
    titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    JLabel title = new JLabel("Student Application Form", SwingConstants.CENTER);
    title.setFont(new Font("Segoe UI", Font.BOLD, 28));
    title.setForeground(Color.WHITE);
    titlePanel.add(title, BorderLayout.CENTER);
    add(titlePanel, BorderLayout.NORTH);
    
    JPanel formPanel = new JPanel(new GridBagLayout()) {
    private Image backgroundImage = new ImageIcon(getClass().getResource("/miniproject/gambar/coverBackground.png")).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Lukis gambar latar (stretch ikut saiz panel)
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
};

    formPanel.setOpaque(false);
    formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.weighty = 1;

    // ===== LEFT PANEL =====
    JPanel leftPanel = new JPanel(new GridBagLayout());
    leftPanel.setOpaque(false);
    GridBagConstraints lgbc = new GridBagConstraints();
    lgbc.insets = new Insets(5, 2, 5, 2);
    lgbc.fill = GridBagConstraints.HORIZONTAL;
    lgbc.weightx = 1;
    int lrow = 0;

    // Full Name
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("Full Name:"), lgbc);
    lgbc.gridx = 1;
    jTextField1 = new JTextField(20);
    leftPanel.add(jTextField1, lgbc);
    lrow++;

    // IC Number
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("IC Number:"), lgbc);
    lgbc.gridx = 1;
    jTextField2 = new JTextField(15);
    leftPanel.add(jTextField2, lgbc);
    lrow++;

    // Age
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("Age:"), lgbc);
    lgbc.gridx = 1;
    jTextField3 = new JTextField(5);
    leftPanel.add(jTextField3, lgbc);
    lrow++;

    // Gender
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("Gender:"), lgbc);
    lgbc.gridx = 1;
    JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
    genderPanel.setOpaque(false);
    jRadioButton1 = new JRadioButton("Male"); jRadioButton1.setOpaque(false);
    jRadioButton2 = new JRadioButton("Female"); jRadioButton2.setOpaque(false);
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(jRadioButton1); genderGroup.add(jRadioButton2);
    genderPanel.add(jRadioButton1); genderPanel.add(jRadioButton2);
    leftPanel.add(genderPanel, lgbc);
    lrow++;

    // Email
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("Email Address:"), lgbc);
    lgbc.gridx = 1;
    jTextField4 = new JTextField(25);
    leftPanel.add(jTextField4, lgbc);
    lrow++;

    // Contact
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("Contact Number:"), lgbc);
    lgbc.gridx = 1;
    jTextField5 = new JTextField(15);
    leftPanel.add(jTextField5, lgbc);
    lrow++;

    // Address
    lgbc.gridx = 0; lgbc.gridy = lrow;
    leftPanel.add(new JLabel("Home Address:"), lgbc);
    lgbc.gridx = 1;
    jTextArea10 = new JTextArea(4, 20);
    jTextArea10.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    jTextArea10.setLineWrap(true);
    jTextArea10.setWrapStyleWord(true);
    leftPanel.add(new JScrollPane(jTextArea10), lgbc);
    lrow++;

    // ===== RIGHT PANEL =====
    JPanel rightPanel = new JPanel(new GridBagLayout());
    rightPanel.setOpaque(false);
    GridBagConstraints rgbc = new GridBagConstraints();
    rgbc.insets = new Insets(5, 2, 5, 2);
    rgbc.fill = GridBagConstraints.HORIZONTAL;
    rgbc.weightx = 1;
    int rrow = 0;

    // Course Choices
    rgbc.gridx = 0; rgbc.gridy = rrow;
    rightPanel.add(new JLabel("Course Choices:"), rgbc);
    rgbc.gridx = 1;
    JPanel comboPanel = new JPanel(new GridLayout(3,1,5,5));
    comboPanel.setOpaque(false);
    jComboBox1 = new JComboBox<>(courseOptions());
    jComboBox2 = new JComboBox<>(courseOptions());
    jComboBox3 = new JComboBox<>(courseOptions());
    comboPanel.add(jComboBox1); comboPanel.add(jComboBox2); comboPanel.add(jComboBox3);
    rightPanel.add(comboPanel, rgbc);
    rrow++;

    // Attachments
    rgbc.gridx = 0; rgbc.gridy = rrow;
    rightPanel.add(new JLabel("Picture:"), rgbc);
    rgbc.gridx = 1;
    jButton2 = new JButton("Attach Picture");
    jButton2.addActionListener(this::jButton2ActionPerformed);
    rightPanel.add(jButton2, rgbc);
    rrow++;
    pictureLabel = new JLabel("No file selected"); pictureLabel.setForeground(Color.GRAY);
    rgbc.gridx = 1; rgbc.gridy = rrow; rightPanel.add(pictureLabel, rgbc); rrow++;

    rgbc.gridx = 0; rgbc.gridy = rrow;
    rightPanel.add(new JLabel("Education Certificate:"), rgbc);
    rgbc.gridx = 1;
    jButton3 = new JButton("Attach Education Cert");
    jButton3.addActionListener(this::jButton3ActionPerformed);
    rightPanel.add(jButton3, rgbc);
    rrow++;
    educationLabel = new JLabel("No file selected"); educationLabel.setForeground(Color.GRAY);
    rgbc.gridx = 1; rgbc.gridy = rrow; rightPanel.add(educationLabel, rgbc); rrow++;

    rgbc.gridx = 0; rgbc.gridy = rrow;
    rightPanel.add(new JLabel("Support Certificate:"), rgbc);
    rgbc.gridx = 1;
    jButton4 = new JButton("Attach Support Cert");
    jButton4.addActionListener(this::jButton4ActionPerformed);
    rightPanel.add(jButton4, rgbc);
    rrow++;
    supportCertLabel = new JLabel("No file selected"); supportCertLabel.setForeground(Color.GRAY);
    rgbc.gridx = 1; rgbc.gridy = rrow; rightPanel.add(supportCertLabel, rgbc); rrow++;

    gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.5; formPanel.add(leftPanel, gbc);
    gbc.gridx = 1; gbc.weightx = 0.5; formPanel.add(rightPanel, gbc);

    // Submit Button
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(new Color(173, 216, 230));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    jButton1 = new JButton("Send Email");
    jButton1.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jButton1.setBackground(Color.WHITE);
    jButton1.setFocusPainted(false);
    jButton1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    jButton1.setPreferredSize(new Dimension(160,45));
    jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    jButton1.addActionListener(this::jButton1ActionPerformed);
    buttonPanel.add(jButton1);

    // Add form panel to center
    JScrollPane scrollPane = new JScrollPane(formPanel);
    scrollPane.setOpaque(false);
    scrollPane.getViewport().setOpaque(false);
    scrollPane.setBorder(null);
    add(scrollPane, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
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
        // check and reset empty textfield    
        boolean valid = true;
        JTextField[] textFields = { jTextField1, jTextField2, jTextField3, jTextField4, jTextField5 };
        JTextArea[] textAreas = { jTextArea10};
        
        for (JTextField field : textFields) {
            if (field.getText().trim().isEmpty()) {
                field.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valid = false;
            } else {
                field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        
        // check empty textfield
        for (JTextArea area : textAreas) {
            if (area.getText().trim().isEmpty()) {
                area.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valid = false;
            } else {
                area.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        
        // check picture file and education certificate
        if (pictureFile == null) {
            pictureLabel.setForeground(Color.RED);
            valid = false;
        } else {
            pictureLabel.setForeground(Color.GRAY);
        }
        
        if (educationFile == null) {
            educationLabel.setForeground(Color.RED);
            valid = false;
        } else {
            educationLabel.setForeground(Color.GRAY);
        }
        
        if (!valid) {
            JOptionPane.showMessageDialog(this,
                    "Please fill all the mandatory information", "Incomplete information", JOptionPane.WARNING_MESSAGE);
            return;
        }
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
        
        //(String Table, String Name, String IC_Num, int Age , String Profile_pic,
        //                            String Education, String Edu_Attac, String Course1, String Course2, String Course3,
        //                            String Phone_Num, String Email, String Address, String Supporting_Att)
        Database.database_functions.database_Add("Biodata", fullName, icNumber, new Integer(age), pictureLabel.getText(), educationLabel.getText(), educationLabel.getText(), course1, course2, course3, contact, emailTo, address, supportCertLabel.getText());
        
        String messageText = "<html>"
        + "<head>"
        + "<style>"
        + "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #333; margin:0; padding:0; }"
        + ".container { width: 100%; background-color: #f4f4f4; padding: 20px 0; }"
        + ".content { max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }"
        + ".header { background-color: #2E86C1; color: #ffffff; padding: 15px; border-radius: 6px 6px 0 0; text-align: center; font-size: 20px; font-weight: bold; }"
        + ".section { margin-top: 20px; }"
        + ".section-title { font-size: 16px; font-weight: bold; margin-bottom: 10px; color: #2E86C1; }"
        + "table { width: 100%; border-collapse: collapse; }"
        + "td { padding: 8px 5px; vertical-align: top; }"
        + "td.label { font-weight: bold; width: 180px; color: #555; }"
        + "ol, ul { margin: 5px 0 0 20px; }"
        + ".footer { margin-top: 20px; font-size: 0.9em; color: #666; }"
        + "</style>"
        + "</head>"
        + "<body>"
        + "<div class='container'>"
        + "<div class='content'>"
        + "<div class='header'>Application Received</div>"
        + "<div class='section'>"
        + "<p>Dear " + fullName + ",</p>"
        + "<p>Thank you for submitting your application form. Below are the details you have provided:</p>"
        + "<table>"
        + "<tr><td class='label'>Full Name:</td><td>" + fullName + "</td></tr>"
        + "<tr><td class='label'>IC Number:</td><td>" + icNumber + "</td></tr>"
        + "<tr><td class='label'>Gender:</td><td>" + gender + "</td></tr>"
        + "<tr><td class='label'>Age:</td><td>" + age + "</td></tr>"
        /*+ "<tr><td class='label'>Email:</td><td>" + emailTo + "</td></tr>"*/
        + "<tr><td class='label'>Contact:</td><td>" + contact + "</td></tr>"
        + "<tr><td class='label'>Address:</td><td>" + address + "</td></tr>"
        + "<tr><td class='label'>Course Choices:</td><td>"
        + "<ol>"
        + "<li>" + course1 + "</li>"
        + "<li>" + course2 + "</li>"
        + "<li>" + course3 + "</li>"
        + "</ol></td></tr>"
        + "</table>"
        + "</div>"
        + "<div class='section'>"
        + "<div class='section-title'>Attachments</div>"
        + "<ul>"
        + "<li>Picture</li>"
        + "<li>Education Certificate</li>"
        + "<li>Support Certificate (Optional)</li>"
        + "</ul>"
        + "</div>"
        + "<p class='footer'>This email is to confirm that your application has been received and is under review. Please keep it for your records.</p>"
        + "<p class='footer'>Best regards,<br>Admissions Team</p>"
        + "</div>"
        + "</div>"
        + "</body>"
        + "</html>";


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String myEmail = "muhammadnasrulizwan@gmail.com";
        final String myPassword = "hnjd nejw hhwk zoqw";

        Session session = javax.mail.Session.getInstance(props,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, myPassword);
                }
            });

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(myEmail));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
        msg.setSubject("University College Applied Science German-\n" +
                       "Malaysia Institute (UCAS GMI)");

        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent(messageText, "text/html; charset=utf-8");
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textPart);
        
        if (pictureFile != null && pictureFile.exists()) {
            MimeBodyPart attach1 = new MimeBodyPart();
            attach1.attachFile(pictureFile);
            attach1.setFileName("Picture_" + pictureFile.getName());
            multipart.addBodyPart(attach1);
        }
        if (educationFile != null && educationFile.exists()) {
            MimeBodyPart attach2 = new MimeBodyPart();
            attach2.attachFile(educationFile);
            attach2.setFileName("Education_" + educationFile.getName());
            multipart.addBodyPart(attach2);
        }
        if (supportCertFile != null && supportCertFile.exists()) {
            MimeBodyPart attach3 = new MimeBodyPart();
            attach3.attachFile(supportCertFile);
            attach3.setFileName("Support_" + supportCertFile.getName());
            multipart.addBodyPart(attach3);
        }


        msg.setContent(multipart);
        Transport.send(msg);
        JOptionPane.showMessageDialog(this, "Email sent successfully to " + emailTo, 
                                       "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to send email: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        pictureFile = chooseFile("Select Education Certificate");
        if (pictureFile != null) pictureLabel.setText(pictureFile.getAbsolutePath());
        else pictureLabel.setText("No file selected");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        educationFile = chooseFile("Select Education Certificate");
        if (educationFile != null) educationLabel.setText(educationFile.getAbsolutePath());
        else educationLabel.setText("Noo file selected");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        supportCertFile = chooseFile("Select Support Certificate");
        if (supportCertFile != null) supportCertLabel.setText(supportCertFile.getAbsolutePath());
        else supportCertLabel.setText("Noo file selected");
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
