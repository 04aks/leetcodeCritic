package aks;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
            new Window();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}