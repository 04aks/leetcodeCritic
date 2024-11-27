package aks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class WorkSpacePanel extends JPanel{

    Panel p;
    public WorkSpacePanel(Panel p){
        this.p = p;
        setBackground(Color.MAGENTA);
    }    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        if(p.tweet.getAttemptPNG() != null){
            BufferedImage attempt = p.tweet.getAttemptPNG();
            int x = (Panel.WIDTH - attempt.getWidth())/2;
            g2.drawImage(p.tweet.getAttemptPNG(), x, 0, null);
        }
        if(p.tweet.getIdealPNG() != null){
            BufferedImage sol = p.tweet.getIdealPNG();
            int x = (Panel.WIDTH - sol.getWidth())/2;
            g2.drawImage(p.tweet.getIdealPNG(), x, 0, null);
        }
    }
}
