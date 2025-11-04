/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniproject;

import javafinalproject.overviewpage;
import javax.swing.JFrame;

/**
 *
 * @author Razman and mawi and some peopleand others and nasirul and aqippower 
 */
public class Miniproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame MyFrame = new JFrame("Overview UCAS GMI");
        MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyFrame.add(new overviewpage());
        MyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        MyFrame.setLocationRelativeTo(null); // Center
        MyFrame.setVisible(true);
    }

}
