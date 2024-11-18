package aks.threads;

import java.awt.image.BufferedImage;
import javax.swing.SwingWorker;
import aks.Panel;

public class GenerateThread extends SwingWorker<Void, Void>{
    Panel p;
    public GenerateThread(Panel p){
        this.p = p;
    }
    
    @Override
    protected Void doInBackground() throws Exception {
        // we translate the image to base64 string (required by gemini) and rate the method from 1 to 3
        String json = p.gemini.geminiAssessment(p.tweetUtilities.encodeImageToBase64(p.tweet.getAttemptImage())).trim();
        String ranking = p.filterJson.getGeminiKey(json, "ranking");
        String feedback = p.filterJson.getGeminiKey(json, "feedback");
        // Edits and creates the image based on gemini ranking
        BufferedImage t = p.editor.editAttemptImage(p.tweet.getAttemptImage(), Integer.parseInt(ranking));
        BufferedImage a = p.editor.editIdealImage(p.tweet.getIdealImage());
        BufferedImage f = p.editor.feedbackImage(t, a, feedback);

        p.editor.mergePictures(t, a, f);
        return null;
    }
}
