/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafinalproject;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author USER
 */
public class Javafinalproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    JFrame MyFrame = new JFrame("Overview UCAS GMI");
    MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MyFrame.add(new overviewpage());
    MyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
    MyFrame.setLocationRelativeTo(null); // Center
    MyFrame.setVisible(true);
}

    
}
