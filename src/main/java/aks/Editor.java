package aks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Editor {

    BufferedImage horribleAttempt, alrightAttempt, goodAttempt;
    
    Panel p;
    public Editor(Panel p){
        this.p = p;
        horribleAttempt = p.tweetUtilities.importImage("/aks/res/horrible.png");
        alrightAttempt = p.tweetUtilities.importImage("/aks/res/alright.png");
        goodAttempt = p.tweetUtilities.importImage("/aks/res/good.png");
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
            System.out.println("scale " + scale);
        }

        BufferedImage editedReactionImage = p.tweetUtilities.imageWithLowerOpacity(senkuReaction, 0.2f, scale);
        // Senku reaction coordinates
        int x = image.getWidth() - editedReactionImage.getWidth();
        int y = 0;
        System.out.println("image " + image.getWidth() + "   senku " + editedReactionImage.getWidth());
        g2.drawImage(editedReactionImage, x, y,  null);

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
