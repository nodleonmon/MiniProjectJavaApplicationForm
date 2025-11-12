package miniproject;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class Loginpage {

    // 🔹 Constructor (supaya boleh buka dari SignUp)
    public Loginpage() {
        JFrame frame = new JFrame("Login Page"); 
        frame.setSize(400, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(null);

        // 🔹 Tambah panel background animasi
        AnimatedBackgroundPanel bgPanel = new AnimatedBackgroundPanel();
        bgPanel.setLayout(null);
        frame.setContentPane(bgPanel);

        JLabel title = new JLabel("Welcome Back!"); 
        title.setBounds(130, 20, 200, 30); 
        title.setForeground(Color.BLACK);
        frame.add(title); 

        JLabel emailLabel = new JLabel("Email:"); 
        emailLabel.setBounds(50, 70, 100, 25); 
        emailLabel.setForeground(Color.BLACK);
        frame.add(emailLabel); 

        JTextField emailField = new JTextField(); 
        emailField.setBounds(150, 70, 180, 25); 
        frame.add(emailField); 

        JLabel passLabel = new JLabel("Password:"); 
        passLabel.setBounds(50, 110, 100, 25); 
        passLabel.setForeground(Color.BLACK);
        frame.add(passLabel); 

        JPasswordField passField = new JPasswordField(); 
        passField.setBounds(150, 110, 180, 25); 
        frame.add(passField); 

        JButton loginBtn = new JButton("Login"); 
        loginBtn.setBounds(150, 150, 100, 30); 
        frame.add(loginBtn); 

        JButton signInBtn = new JButton("Sign In"); 
        signInBtn.setBounds(150, 190, 100, 30); 
        frame.add(signInBtn);

        // 🔊 Bunyi klik bila tekan login
        loginBtn.addActionListener(e -> { 
            playClickSound();
            String email = emailField.getText(); 
            String password = new String(passField.getPassword()); 
            String[] db_result = Database.database_functions.database_search("Users", email, password);
            
            if((db_result[1] != null) && (db_result[2] != null)) { 
                JOptionPane.showMessageDialog(frame, "Login Successful! Welcome Back " + db_result[1] + "!" ); 
                miniproject.Javafinalproject.main(null);
            } else { 
                JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
            }
        });

        // 🔊 Bunyi klik bila tekan Sign In + buka SignUpPage
        signInBtn.addActionListener(e -> { 
            playClickSound();
            frame.dispose(); // tutup login page
            new signuppage(); // buka sign up page
        });

        frame.setVisible(true);
    }

    // 🔉 Method main bunyi click.wav
    private void playClickSound() {
        new Thread(() -> {
            try {
                File soundFile = new File("src/loginpage/click.wav");
                if (soundFile.exists()) {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } else {
                    System.out.println("Sound file not found!");
                }
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }).start();
    }

    // 🔰 Mula dari sini
    public static void main(String[] args) {
        new Loginpage();
    }
}

// 🌌 Animasi background sama
class AnimatedBackgroundPanel extends JPanel implements ActionListener {
    private Image background;
    private int x = 0;
    private Timer timer;

    public AnimatedBackgroundPanel() {
        try {
            background = new ImageIcon("src/loginpage/coverBackground.png").getImage();
        } catch (Exception e) {
            System.out.println("Background image not found.");
        }
        timer = new Timer(10, this); 
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            int w = getWidth();
            int h = getHeight();
            g.drawImage(background, x, 0, w, h, this);
            g.drawImage(background, x + w, 0, w, h, this);
        } else {
            Graphics2D g2 = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.PINK);
            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x -= 1;
        if (x <= -getWidth()) {
            x = 0;
        }
        repaint();
    }
}
