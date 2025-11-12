package miniproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class signuppage {

    public signuppage() {
        JFrame frame = new JFrame("Sign Up Page");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // window besar
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setLayout(null);

        // 🌈 Gunakan panel animasi sebagai background utama
        AnimatedBackgroundPanel bgPanel = new AnimatedBackgroundPanel();
        bgPanel.setLayout(null);
        frame.setContentPane(bgPanel);

        // ✨ Title
        JLabel title = new JLabel("Create Account");
        title.setBounds(130, 20, 200, 30);
        title.setForeground(Color.BLACK);
        bgPanel.add(title);

        // 📧 Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 70, 100, 25);
        emailLabel.setForeground(Color.BLACK);
        bgPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 180, 25);
        bgPanel.add(emailField);

        // 🔒 Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 25);
        passLabel.setForeground(Color.BLACK);
        bgPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 180, 25);
        bgPanel.add(passField);

        // 🧍‍♂️ Confirm Password
        JLabel confirmLabel = new JLabel("Confirm:");
        confirmLabel.setBounds(50, 150, 100, 25);
        confirmLabel.setForeground(Color.BLACK);
        bgPanel.add(confirmLabel);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(150, 150, 180, 25);
        bgPanel.add(confirmField);

        // 🎵 Button Sign Up
        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(150, 190, 100, 30);
        bgPanel.add(signupBtn);

        // 🔙 Button Back ke Login
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 20, 80, 25);
        bgPanel.add(backBtn);

        // 🪄 Action Button
        signupBtn.addActionListener(e -> {
            playClickSound();
            int havesymbol = emailField.getText().indexOf("@");
            if ( havesymbol >0){
                Database.database_functions.database_Add("Users", emailField.getText(), new String(passField.getPassword()));
                JOptionPane.showMessageDialog(frame, "Account Created!");

                 // Lepas mesej, tutup sign up dan buka login
                frame.dispose();
                new Loginpage();
            }
            else{
                JOptionPane.showMessageDialog(frame, "Invalid Credentials! Does your email has '@'? ");
            }
        });

        backBtn.addActionListener(e -> {
            playClickSound();
            frame.dispose(); // tutup sign up
            new Loginpage(); // buka balik login page
        });
        
        // Scaling listener
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                int w = frame.getWidth();
                int h = frame.getHeight();

                int titleFont = Math.max(w/15, 24);
                int labelFont = Math.max(w/40, 16);
                int fieldFont = Math.max(w/50, 16);
                int btnFont = Math.max(w/35, 18);

                title.setBounds(w/4, h/15, w/2, h/12);
                title.setFont(new Font("Arial", Font.BOLD, titleFont));

                emailLabel.setBounds(w/10, h/5, w/4, h/20);
                emailLabel.setFont(new Font("Arial", Font.PLAIN, labelFont));
                emailField.setBounds(w/2 - w/6, h/5, w/3, h/20);
                emailField.setFont(new Font("Arial", Font.PLAIN, fieldFont));

                passLabel.setBounds(w/10, h/5 + h/12, w/4, h/20);
                passLabel.setFont(new Font("Arial", Font.PLAIN, labelFont));
                passField.setBounds(w/2 - w/6, h/5 + h/12, w/3, h/20);
                passField.setFont(new Font("Arial", Font.PLAIN, fieldFont));

                confirmLabel.setBounds(w/10, h/5 + h/6, w/4, h/20);
                confirmLabel.setFont(new Font("Arial", Font.PLAIN, labelFont));
                confirmField.setBounds(w/2 - w/6, h/5 + h/6, w/3, h/20);
                confirmField.setFont(new Font("Arial", Font.PLAIN, fieldFont));

                signupBtn.setBounds(w/2 - w/12, h/2, w/6, h/15);
                signupBtn.setFont(new Font("Arial", Font.BOLD, btnFont));

                backBtn.setBounds(20, 20, w/8, h/20);
                backBtn.setFont(new Font("Arial", Font.PLAIN, Math.max(btnFont-2,12)));
            }
        });

        frame.setVisible(true);
    }

    // 🔊 Reuse sound
    private void playClickSound() {
        new Thread(() -> {
            try {
                File soundFile = new File("src/loginpage/click.wav");
                if (soundFile.exists()) {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                }
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }).start();
    }
}
