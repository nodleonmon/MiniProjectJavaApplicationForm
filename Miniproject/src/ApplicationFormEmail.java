import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class StudentFormEmail extends JFrame {

    // GUI components
    private JTextField txtName, txtIC, txtAge, txtEmail, txtContact;
    private JTextArea txtAddress;
    private JComboBox<String> comboCourse;
    private JRadioButton rMale, rFemale;
    private JLabel lblPic, lblEdu, lblSupport;

    // File variables
    private File pictureFile = null;
    private File educationFile = null;
    private File supportFile = null;

    public StudentFormEmail() {
        setTitle("Student Application Form");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // --- Form Fields ---
        JLabel lbl1 = new JLabel("Full Name:");
        lbl1.setBounds(30, 30, 100, 25);
        add(lbl1);
        txtName = new JTextField();
        txtName.setBounds(150, 30, 200, 25);
        add(txtName);

        JLabel lbl2 = new JLabel("IC Number:");
        lbl2.setBounds(30, 70, 100, 25);
        add(lbl2);
        txtIC = new JTextField();
        txtIC.setBounds(150, 70, 200, 25);
        add(txtIC);

        JLabel lbl3 = new JLabel("Course:");
        lbl3.setBounds(30, 110, 100, 25);
        add(lbl3);
        comboCourse = new JComboBox<>(new String[]{"Select Course", "Computer", "Electrical", "Mechanical"});
        comboCourse.setBounds(150, 110, 200, 25);
        add(comboCourse);

        JLabel lbl4 = new JLabel("Gender:");
        lbl4.setBounds(30, 150, 100, 25);
        add(lbl4);
        rMale = new JRadioButton("Male");
        rMale.setBounds(150, 150, 80, 25);
        add(rMale);
        rFemale = new JRadioButton("Female");
        rFemale.setBounds(230, 150, 80, 25);
        add(rFemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rMale);
        bg.add(rFemale);

        JLabel lbl5 = new JLabel("Age:");
        lbl5.setBounds(30, 190, 100, 25);
        add(lbl5);
        txtAge = new JTextField();
        txtAge.setBounds(150, 190, 200, 25);
        add(txtAge);

        JLabel lbl6 = new JLabel("Email:");
        lbl6.setBounds(30, 230, 100, 25);
        add(lbl6);
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 230, 200, 25);
        add(txtEmail);

        JLabel lbl7 = new JLabel("Contact:");
        lbl7.setBounds(30, 270, 100, 25);
        add(lbl7);
        txtContact = new JTextField();
        txtContact.setBounds(150, 270, 200, 25);
        add(txtContact);

        JLabel lbl8 = new JLabel("Address:");
        lbl8.setBounds(30, 310, 100, 25);
        add(lbl8);
        txtAddress = new JTextArea();
        JScrollPane sp = new JScrollPane(txtAddress);
        sp.setBounds(150, 310, 200, 60);
        add(sp);

        // --- Attachment Buttons ---
        JButton btnPic = new JButton("Add Picture");
        btnPic.setBounds(30, 390, 120, 25);
        add(btnPic);
        lblPic = new JLabel("No file selected");
        lblPic.setBounds(160, 390, 200, 25);
        add(lblPic);

        JButton btnEdu = new JButton("Add Education");
        btnEdu.setBounds(30, 420, 120, 25);
        add(btnEdu);
        lblEdu = new JLabel("No file selected");
        lblEdu.setBounds(160, 420, 200, 25);
        add(lblEdu);

        JButton btnSupport = new JButton("Add Support");
        btnSupport.setBounds(30, 450, 120, 25);
        add(btnSupport);
        lblSupport = new JLabel("No file selected");
        lblSupport.setBounds(160, 450, 200, 25);
        add(lblSupport);

        // --- Email Button ---
        JButton btnSend = new JButton("Send Email");
        btnSend.setBounds(150, 500, 150, 30);
        add(btnSend);

        // --- Button Actions ---
        btnPic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select Picture File (PDF or Image)");
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    pictureFile = chooser.getSelectedFile();
                    lblPic.setText(pictureFile.getName());
                }
            }
        });

        btnEdu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select Education Certificate");
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    educationFile = chooser.getSelectedFile();
                    lblEdu.setText(educationFile.getName());
                }
            }
        });

        btnSupport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select Support Certificate");
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    supportFile = chooser.getSelectedFile();
                    lblSupport.setText(supportFile.getName());
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        try {
            String fullName = txtName.getText();
            String ic = txtIC.getText();
            String age = txtAge.getText();
            String emailTo = txtEmail.getText();
            String contact = txtContact.getText();
            String address = txtAddress.getText();
            String gender = rMale.isSelected() ? "Male" : (rFemale.isSelected() ? "Female" : "Not Selected");
            String course = (String) comboCourse.getSelectedItem();

            String messageText = "STUDENT APPLICATION FORM\n\n"
                    + "Full Name: " + fullName + "\n"
                    + "IC Number: " + ic + "\n"
                    + "Course: " + course + "\n"
                    + "Gender: " + gender + "\n"
                    + "Age: " + age + "\n"
                    + "Email: " + emailTo + "\n"
                    + "Contact: " + contact + "\n"
                    + "Address: " + address + "\n";

            // === Gmail setup ===
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            final String myEmail = "yourgmail@gmail.com";
            final String myPassword = "your_app_password_here"; // app password (16 chars)

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myEmail, myPassword);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject("Student Application Form");

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(messageText);
            multipart.addBodyPart(textPart);

            // Attachments
            if (pictureFile != null) {
                MimeBodyPart attach1 = new MimeBodyPart();
                attach1.attachFile(pictureFile);
                multipart.addBodyPart(attach1);
            }
            if (educationFile != null) {
                MimeBodyPart attach2 = new MimeBodyPart();
                attach2.attachFile(educationFile);
                multipart.addBodyPart(attach2);
            }
            if (supportFile != null) {
                MimeBodyPart attach3 = new MimeBodyPart();
                attach3.attachFile(supportFile);
                multipart.addBodyPart(attach3);
            }

            message.setContent(multipart);

            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Email sent successfully to " + emailTo);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentFormEmail().setVisible(true);
    }
}
