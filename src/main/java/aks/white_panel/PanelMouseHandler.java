package aks.white_panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMouseHandler implements MouseListener{

    ScreeniePanel sp;
    int rectX, rectY, rectWidth, rectHeight;
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
        rectX = e.getXOnScreen();
        rectY = e.getYOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Ending x: " + e.getXOnScreen());
        System.out.println("Ending y: " + e.getYOnScreen());
        rectWidth = Math.abs(e.getXOnScreen() - rectX);
        rectHeight = Math.abs(e.getYOnScreen() - rectY);
        sp.repaint();
    }
    
}
