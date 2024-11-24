package aks.white_panel;

import java.awt.Color;
import javax.swing.JFrame;

public class Screenie {
    
    JFrame frame;
    public Screenie(){
        frame = new JFrame("Tweet blue Print");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        ScreeniePanel sp = new ScreeniePanel();
        frame.add(sp);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
