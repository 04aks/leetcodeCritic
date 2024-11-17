package aks;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Editor {

    BufferedImage horribleAttempt, alrightAttempt, goodAttempt;
    Font font;
    
    Panel p;
    public Editor(Panel p){
        this.p = p;
        horribleAttempt = p.tweetUtilities.importImage("/aks/res/horrible.png");
        alrightAttempt = p.tweetUtilities.importImage("/aks/res/alright.png");
        goodAttempt = p.tweetUtilities.importImage("/aks/res/good.png");
        font = p.tweetUtilities.importFont("/aks/res/font/impact.ttf");
    }


    public BufferedImage editAttemptImage(File file, int geminiRanking){

        BufferedImage image = p.tweetUtilities.fileToBufferedImage(file);
        BufferedImage senkuReaction = null;

        Graphics2D g2 = (Graphics2D) image.createGraphics();

        //SELECT IMAGE BASED ON THE GEMINI RANKING (AI)
        switch(geminiRanking){
            case 1: senkuReaction = horribleAttempt; break;
            case 2: senkuReaction = alrightAttempt; break;
            case 3: senkuReaction = goodAttempt; break;
        }


        
        // SCALE DOWN SENKU IMAGE IF ITS LARGER THAN THE {ATTEMPT SCREENSHOT}
        int imageHeight = image.getHeight();
        int senkuReactionHeight = senkuReaction.getHeight();
        double scale = 1;
        if(senkuReactionHeight > imageHeight){
            scale = (double) imageHeight/senkuReactionHeight;
        }

        BufferedImage editedReactionImage = p.tweetUtilities.imageWithLowerOpacity(senkuReaction, 0.2f, scale);
        // Senku reaction coordinates (Bottom Right)
        int x = image.getWidth() - editedReactionImage.getWidth();
        int y = imageHeight - editedReactionImage.getHeight();
        g2.drawImage(editedReactionImage, x, y,  null);

        // Frame
        g2.setColor(Color.RED);
        g2.drawRect(0, 0, image.getWidth() -1, image.getHeight() - 1);
        //TITLE
        g2.setColor(new Color(255,0,0,40));
        g2.setFont(font);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, image.getWidth()/10));
        String title = "ATTEMPT";
        FontMetrics fm = g2.getFontMetrics();
        // Center the text horizontally 
        int textX = (image.getWidth() - fm.stringWidth(title)) / 2 ;
        g2.drawString("ATTEMPT", textX, imageHeight/2);

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
