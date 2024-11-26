package aks.white_panel;

import java.awt.Color;
import javax.swing.JFrame;

import aks.Panel;

public class Screenie {
    
    public JFrame frame;
    Panel p;
    public Screenie(Panel p){
        this.p = p;
        frame = new JFrame("Tweet blue Print");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        ScreeniePanel sp = new ScreeniePanel(frame, p);
        frame.add(sp);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        sp.startScreenieThread();
    }
}
