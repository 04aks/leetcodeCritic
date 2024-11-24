package aks.white_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ScreeniePanel extends JPanel{
    
    PanelMouseHandler pmh = new PanelMouseHandler(this);
    ScreeniePanel(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        setBackground(new Color(255,255,255,50));
        addMouseListener(pmh);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        g2.setColor(new Color(0,0,0,80));
        g2.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());

        g2.setColor(Color.red);
        g2.drawRect(pmh.rectX, pmh.rectY, pmh.rectWidth, pmh.rectHeight);
    }
}
