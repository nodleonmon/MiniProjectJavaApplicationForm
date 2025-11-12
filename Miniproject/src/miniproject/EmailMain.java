package miniproject;

import javax.swing.JFrame;

public class EmailMain {
    public static void main(String[] args) {
        // Create a window to show your emailSubProject form
        JFrame frame = new JFrame("Application Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        frame.setLocationRelativeTo(null); // Center window
        frame.setSize(900, 700);
        frame.setContentPane(new emailSubProject()); // use your existing emailSubProject panel
        frame.setVisible(true);
    }
}
