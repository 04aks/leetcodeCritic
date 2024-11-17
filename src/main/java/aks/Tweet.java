package aks;

import java.awt.image.BufferedImage;
import java.io.File;

public class Tweet {
    
    private File attemptImage;
    private BufferedImage attemptPNG;

    private File idealImage;
    private BufferedImage idealPNG;

    private String header = "Ideal - Attempt \n\nIssue in my code: ";


    public void setAttemptImage(File attemptImage) {
        this.attemptImage = attemptImage;
    }
    public File getAttemptImage() {
        return attemptImage;
    }

    public void setIdealImage(File idealImage) {
        this.idealImage = idealImage;
    }
    public File getIdealImage() {
        return idealImage;
    }

    public String getHeader() {
        return header;
    }

    public BufferedImage getAttemptPNG() {
        return attemptPNG;
    }
    public void setAttemptPNG(BufferedImage attemptPNG) {
        this.attemptPNG = attemptPNG;
    }

    public BufferedImage getIdealPNG() {
        return idealPNG;
    }
    public void setIdealPNG(BufferedImage idealPNG) {
        this.idealPNG = idealPNG;
    }
}
