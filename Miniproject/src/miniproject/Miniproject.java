/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniproject;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Miniproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Application Form");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 700);
            frame.setContentPane(new emailSubProject());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
}
