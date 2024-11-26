package aks;

import javax.swing.JFrame;

public class Window {
    
    public static JFrame frame;
    public Window(){    
        frame = new JFrame("Tweet blue Print");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
