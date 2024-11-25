package aks.white_panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMouseHandler implements MouseListener{

    ScreeniePanel sp;
    int endingX, endingY;
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

        sp.repaint();
    }
    
}
