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
        drawText(g2, "ATTEMPT", 10, image);

        g2.dispose();

        // File imageFIle = new File("test.png");
        // try {
        //     ImageIO.write(image, "png", imageFIle);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        return image;
    }

    public BufferedImage editIdealImage(File file){
        BufferedImage originalImage = p.tweetUtilities.fileToBufferedImage(file);
        
        BufferedImage image = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        g2.drawImage(originalImage, 0, 0, null);
        g2.setColor(Color.GREEN);
        g2.drawRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);
        g2.setColor(new Color(0, 255, 0, 40));
        drawText(g2, "SOLUTION", 10, image);

        g2.dispose();   

        return image;
    }

    public void mergeBothPictures(BufferedImage attempt, BufferedImage solution){

        int totalHeight = Math.max(attempt.getHeight(), solution.getHeight()); 
        int totalWidth = attempt.getWidth() + solution.getWidth();

        // if(attemptWidth>=attemptHeight && attemptWidth >= solutionWidth){
        //     totalHeight = Math.max(attemptHeight, solutionHeight);
        //     totalWidth = attemptWidth + solutionWidth;
        // }else{
        //     totalHeight = attemptHeight + solutionHeight;
        //     totalWidth = Math.max(attemptWidth, attemptHeight);
        // }

        BufferedImage image = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        
        //SOLUTION
        int solutionX = 0;
        int solutionY = (totalHeight - solution.getHeight())/2;
        g2.drawImage(solution, solutionX, solutionY, null);

        //ATTEMPT
        int attemptX = solution.getWidth();
        int attemptY = (totalHeight - attempt.getHeight())/2;
        g2.drawImage(attempt, attemptX, attemptY, null);

        g2.dispose();
        File file = new File("merged.png");
        try{    
            ImageIO.write(image, "png", file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void drawText(Graphics2D g2, String text ,int fontSize, BufferedImage parent){
        g2.setFont(font);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, parent.getWidth()/10));
        String title = text;
        FontMetrics fm = g2.getFontMetrics();
        // Center the text horizontally 
        int textX = (parent.getWidth() - fm.stringWidth(title)) / 2 ;
        g2.drawString(text, textX, parent.getHeight()/2);
    }
}
