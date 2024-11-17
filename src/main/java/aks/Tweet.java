package aks;

import java.io.File;

public class Tweet {
    
    private File attemptImage;
    private File idealImage;
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
}
