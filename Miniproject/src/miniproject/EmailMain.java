package miniproject;

import javax.swing.JFrame;

public class EmailMain {
    public static void main(String[] args) {
        // Create a window to show your Subproject form
        JFrame frame = new JFrame("Application Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setContentPane(new Subproject()); // use your existing Subproject panel
        frame.setVisible(true);
    }
}
