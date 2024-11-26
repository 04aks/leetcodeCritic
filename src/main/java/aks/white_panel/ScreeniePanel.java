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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import aks.Panel;
import aks.Window;

public class ScreeniePanel extends JPanel implements Runnable{
    
    PanelMouseHandler pmh = new PanelMouseHandler(this);
    int startingX, startingY;
    int rectX, rectY, rectWidth, rectHeight;
    int FPS = 60;
    Color panelColor = new Color(0,0,0,70);
    Thread screenieThread;
    JFrame frame;
    Panel p;
    ScreeniePanel(JFrame frame, Panel p){
        this.p = p;
        this.frame = frame;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        setOpaque(false);
        addMouseListener(pmh);
        addMouseMotionListener(pmh);
    }

    public void resetRectangle(){
        rectX = 0;
        rectY = 0;
        rectWidth = 0;
        rectHeight = 0;
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
            
            // close the screenshot panel
            frame.dispose();
            // display the main JFrame again
            Window.frame.setState(JFrame.NORMAL);

        }catch(Exception e){
            resetRectangle();
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
            resetRectangle();
        }

        return "";
    }

    public void startScreenieThread(){
        screenieThread = new Thread(this);
        screenieThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(screenieThread != null){
            update();
            repaint();

            try{

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            nextDrawTime += drawInterval;
        }
    }

    public void update(){
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        g2.setColor(panelColor);
        g2.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());

        g2.setColor(Color.CYAN);
        g2.drawRect(rectX, rectY, rectWidth, rectHeight);

        if(p.tweet.getAttemptPNG() != null){
            g2.drawImage(p.tweet.getAttemptPNG(), 0, 0, null);
        }

        g2.dispose();
    }
}
