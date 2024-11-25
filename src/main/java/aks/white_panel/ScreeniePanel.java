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
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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

            String location = saveScreenshotLocation();
            // ensure location path ends with '.png'
            if(!location.endsWith(".png")){
                location += ".png";
            }
            File screenshot = new File(location);
            ImageIO.write(capture, "png", screenshot);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String saveScreenshotLocation(){
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save your Code screenshot");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG image", "png");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);

        int option = fileChooser.showSaveDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
            File saveLoc = fileChooser.getSelectedFile();
            System.out.println(saveLoc.getAbsolutePath());
            return saveLoc.getAbsolutePath();
            
        }else{
            System.out.println("so'ing went wrong");
        }

        return "";
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
