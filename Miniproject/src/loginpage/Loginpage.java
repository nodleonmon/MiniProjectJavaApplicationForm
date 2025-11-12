package loginpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class Loginpage {

    private JLabel title, emailLabel, passLabel;
    private JTextField emailField;
    private JPasswordField passField;
    private JButton loginBtn, signInBtn;

    public Loginpage() {
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // window besar
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setLayout(null);

        AnimatedBackgroundPanel bgPanel = new AnimatedBackgroundPanel();
        bgPanel.setLayout(null);
        frame.setContentPane(bgPanel);

        // Components
        title = new JLabel("Welcome Back!");
        title.setForeground(Color.BLACK);
        bgPanel.add(title);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.BLACK);
        bgPanel.add(emailLabel);

        emailField = new JTextField();
        bgPanel.add(emailField);

        passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.BLACK);
        bgPanel.add(passField = new JPasswordField());
        bgPanel.add(passLabel);

        loginBtn = new JButton("Login");
        bgPanel.add(loginBtn);

        signInBtn = new JButton("Sign In");
        bgPanel.add(signInBtn);

        // Actions
        loginBtn.addActionListener(e -> {
            playClickSound();
            String email = emailField.getText();
            String password = new String(passField.getPassword());
            if(email.equals("admin@gmail.com") && password.equals("12345")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
            }
        });

        signInBtn.addActionListener(e -> {
            playClickSound();
            frame.dispose();
            new signuppage();
        });

        // Scaling listener
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
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

                loginBtn.setBounds(w/2 - w/12, h/2, w/6, h/15);
                loginBtn.setFont(new Font("Arial", Font.BOLD, btnFont));

                signInBtn.setBounds(w/2 - w/12, h/2 + h/12, w/6, h/15);
                signInBtn.setFont(new Font("Arial", Font.BOLD, btnFont));
            }
        });

        frame.setVisible(true);
    }

    private void playClickSound() {
        new Thread(() -> {
            try {
                File f = new File("src/loginpage/click.wav");
                if(f.exists()) {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(f));
                    clip.start();
                }
            } catch(Exception ex){ ex.printStackTrace(); }
        }).start();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Loginpage::new);
    }
}

// ======================= AnimatedBackgroundPanel =======================
class AnimatedBackgroundPanel extends JPanel implements ActionListener {
    private Image background;
    private int x = 0;
    private Timer timer;

    public AnimatedBackgroundPanel(){
        try { background = new ImageIcon("src/loginpage/coverBackground.png").getImage(); } 
        catch(Exception e){ System.out.println("Background not found"); }
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(background != null){
            int w = getWidth(), h = getHeight();
            g.drawImage(background, x, 0, w, h, this);
            g.drawImage(background, x+w, 0, w, h, this);
        } else {
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(new GradientPaint(0,0,Color.BLUE,getWidth(),getHeight(),Color.PINK));
            g2.fillRect(0,0,getWidth(),getHeight());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        x -= 1;
        if(x <= -getWidth()) x = 0;
        repaint();
    }
}
