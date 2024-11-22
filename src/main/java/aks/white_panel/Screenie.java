package aks.white_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screenie {
    
    JFrame frame;
    public Screenie(){
        frame = new JFrame("Tweet blue Print");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        frame.add(panel());
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    JPanel panel(){
        JPanel panel = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setPreferredSize(screenSize);
        panel.setBackground(new Color(255,255,255,50));

        return panel;
    }
}
