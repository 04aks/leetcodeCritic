package aks;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;

import aks.white_panel.Screenie;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
            // new Window();
            new Screenie();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}