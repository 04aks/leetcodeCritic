package aks.white_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ScreeniePanel extends JPanel{
    
    PanelMouseHandler pmh = new PanelMouseHandler(this);
    int rectX, rectY, rectWidth, rectHeight;
    ScreeniePanel(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        setOpaque(false);
        addMouseListener(pmh);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        g2.setColor(new Color(0,0,0,50));
        g2.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());

        g2.setColor(Color.red);
        g2.drawRect(rectX, rectY, rectWidth, rectHeight);

        g2.dispose();
    }
}
