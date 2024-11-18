package aks.threads;

import java.io.File;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import aks.Panel;
import aks.Tweet;
import java.awt.Color;

public class OpenSolutionFileThread extends SwingWorker<File, Void>{


    Panel p;
    Tweet tweet;
    JButton button;
    Color successColor;
    Color failedColor;
    public OpenSolutionFileThread(Panel p, Tweet tweet, JButton button, Color successColor, Color failedColor){
        this.p = p;
        this.tweet = tweet;
        this.button = button;
        this.successColor = successColor;
        this.failedColor = failedColor;
    }

    @Override
    protected File doInBackground(){

        File imagePath = p.tweetUtilities.chooseFile("PNG image", "png");
        if(imagePath != null){
            button.setBackground(successColor);
            tweet.setIdealImage(imagePath);
        }else{
            button.setBackground(failedColor);
            tweet.setIdealImage(null);
        }

        return imagePath;
    }
    
}
