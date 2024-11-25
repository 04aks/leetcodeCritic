package aks.white_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ScreeniePanel extends JPanel{
    
    PanelMouseHandler pmh = new PanelMouseHandler(this);
    int rectX, rectY, rectWidth, rectHeight;
    Color panelColor = new Color(0,0,0,50);
    ScreeniePanel(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        setOpaque(false);
        addMouseListener(pmh);
    }

    public void takeScreenshot(Rectangle rectangle){

        try{
            Robot robot = new Robot();
            BufferedImage capture = robot.createScreenCapture(rectangle);

            File screenshot = new File("capture.png");
            ImageIO.write(capture, "png", screenshot);

            System.out.println("created prolly");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        g2.setColor(panelColor);
        g2.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());

        g2.setColor(Color.red);
        g2.drawRect(rectX, rectY, rectWidth, rectHeight);

        g2.dispose();
    }
}
