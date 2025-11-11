package miniproject;

import javafinalproject.homepage;
import javafinalproject.overviewpage;
import javafinalproject.quizpage;
import javax.swing.*;

public class Javafinalproject {

    public static void main(String[] args) {

        // Create the main frame
        JFrame MyFrame = new JFrame("Overview UCAS GMI");
        MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        MyFrame.setLocationRelativeTo(null); // Center window

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu homeMenu = new JMenu("Home");
        JMenu profileMenu = new JMenu("Profile");
        JMenu quizMenu = new JMenu("Quiz");

        // Create menu items
        JMenuItem goToOverview = new JMenuItem("Log Out");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem goToQuiz = new JMenuItem("Quiz");
        JMenuItem goToProfile = new JMenuItem("Profile");
        JMenuItem goToHomepage = new JMenuItem("Homepage");

        // Add items to the Home menu
        homeMenu.add(goToHomepage);
        homeMenu.addSeparator();
        homeMenu.add(goToOverview);
        homeMenu.addSeparator();
        homeMenu.add(exitItem);
        
        // Add items to the Quiz menu
        quizMenu.add(goToQuiz);
        quizMenu.addSeparator();
        
        // Add items to the Profile menu
        profileMenu.add(goToProfile);
        profileMenu.addSeparator();

        // Add menus to the menu bar
        menuBar.add(homeMenu);
        menuBar.add(profileMenu);
        menuBar.add(quizMenu);

        // Attach the menu bar to the frame
        MyFrame.setJMenuBar(menuBar);

        // Add your panel (overview page)
        MyFrame.add(new overviewpage());

        // Example actions for the menu
        exitItem.addActionListener(e -> System.exit(0));

        goToOverview.addActionListener(e -> {
            MyFrame.getContentPane().removeAll();  // Clear old content
            MyFrame.add(new overviewpage());       // Add a fresh overview page
            MyFrame.revalidate();
            MyFrame.repaint();
        });
        
        goToQuiz.addActionListener(e -> {
            MyFrame.getContentPane().removeAll();  // Clear old content
            MyFrame.add(new quizpage());       // Add a fresh overview page
            MyFrame.revalidate();
            MyFrame.repaint();
        });
        
        goToHomepage.addActionListener(e -> {
            MyFrame.getContentPane().removeAll();  // Clear old content
            MyFrame.add(new homepage());       // Add a fresh overview page
            MyFrame.revalidate();
            MyFrame.repaint();
        });

        // Show the frame
        MyFrame.setVisible(true);
    }
}
