package loginpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class signuppage {

    private JLabel title, emailLabel, passLabel, confirmLabel;
    private JTextField emailField;
    private JPasswordField passField, confirmField;
    private JButton signupBtn, backBtn;

    public signuppage() {
        JFrame frame = new JFrame("Sign Up Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // window besar
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setLayout(null);

        AnimatedBackgroundPanel bgPanel = new AnimatedBackgroundPanel();
        bgPanel.setLayout(null);
        frame.setContentPane(bgPanel);

        // Components
        title = new JLabel("Create Account");
        title.setForeground(Color.BLACK);
        bgPanel.add(title);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.BLACK);
        bgPanel.add(emailLabel);

        emailField = new JTextField();
        bgPanel.add(emailField);

        passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.BLACK);
        bgPanel.add(passLabel);

        passField = new JPasswordField();
        bgPanel.add(passField);

        confirmLabel = new JLabel("Confirm:");
        confirmLabel.setForeground(Color.BLACK);
        bgPanel.add(confirmLabel);

        confirmField = new JPasswordField();
        bgPanel.add(confirmField);

        signupBtn = new JButton("Sign Up");
        bgPanel.add(signupBtn);

        backBtn = new JButton("Back");
        bgPanel.add(backBtn);

        // Actions
        signupBtn.addActionListener(e -> {
            playClickSound();
            JOptionPane.showMessageDialog(frame, "Account Created!");
            frame.dispose();
            new Loginpage();
        });

        backBtn.addActionListener(e -> {
            playClickSound();
            frame.dispose();
            new Loginpage();
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

    private void playClickSound() {
        new Thread(() -> {
            try {
                File f = new File("src/loginpage/click.wav");
                if(f.exists()){
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(f));
                    clip.start();
                }
            } catch(Exception ex){ ex.printStackTrace(); }
        }).start();
    }
}
