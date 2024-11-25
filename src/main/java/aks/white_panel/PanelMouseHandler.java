package aks.white_panel;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PanelMouseHandler implements MouseListener, MouseMotionListener{

    ScreeniePanel sp;
    int endingX, endingY, aniEndingX, aniEndingY;
    PanelMouseHandler(ScreeniePanel sp){
        this.sp = sp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Starting x: " + e.getXOnScreen());
        System.out.println("Starting y: " + e.getYOnScreen());
        sp.rectX = e.getXOnScreen();
        sp.rectY = e.getYOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Ending x: " + e.getXOnScreen());
        System.out.println("Ending y: " + e.getYOnScreen());
        sp.rectWidth = Math.abs(e.getXOnScreen() - sp.rectX);
        sp.rectHeight = Math.abs(e.getYOnScreen() - sp.rectY);

        if((endingX = e.getXOnScreen()) < sp.rectX){
            sp.rectX = endingX;
        }
        if((endingY = e.getYOnScreen()) < sp.rectY){
            sp.rectY = endingY;
        }

        // take screenshot
        sp.takeScreenshot(new Rectangle(sp.rectX, sp.rectY, sp.rectWidth, sp.rectHeight));
        sp.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        sp.aniX = sp.rectX;
        sp.aniY = sp.rectY;
        sp.aniWidth = Math.abs(e.getXOnScreen() - sp.rectX);
        sp.aniHeight = Math.abs(e.getYOnScreen() - sp.rectY);
        if((aniEndingX = e.getXOnScreen()) < sp.aniX){
            sp.aniX = aniEndingX;
        }
        if((aniEndingY = e.getYOnScreen()) < sp.aniY){
            sp.aniY = aniEndingY;
        }
        // System.out.println("say yo to the local cat");
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
