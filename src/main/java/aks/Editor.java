package aks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Editor {
    
    Panel p;
    public Editor(Panel p){

        this.p = p;
    }


    public BufferedImage editAttemptImage(File file){

        BufferedImage image = p.tweetUtilities.fileToBufferedImage(file);

        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(Color.red);
        g2.fillRoundRect(0, 0, 150, 50, 20, 20);
        g2.dispose();

        File imageFIle = new File("test.png");
        try {
            ImageIO.write(image, "png", imageFIle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
