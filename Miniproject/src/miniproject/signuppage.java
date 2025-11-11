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
            if (emailField.getText().indexOf("@") !=0){
                Database.database_functions.database_Add("Users", emailField.getText(), new String(passField.getPassword()));
                JOptionPane.showMessageDialog(frame, "Account Created!");

                 // Lepas mesej, tutup sign up dan buka login
                frame.dispose();
                new Loginpage();
            }
        });

        backBtn.addActionListener(e -> {
            playClickSound();
            frame.dispose(); // tutup sign up
            new Loginpage(); // buka balik login page
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
