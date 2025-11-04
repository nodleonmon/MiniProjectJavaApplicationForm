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
        // TODO code application logic here
        JFrame MyFrame = new JFrame("My First Window");
            MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MyFrame.add(new Subproject());
            MyFrame.setSize(400,400);
            MyFrame.setVisible(true);
    }
    
}
