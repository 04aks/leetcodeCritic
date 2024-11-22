package aks.utils;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TweetUtilities {
    
    public TweetUtilities(){

    }

    public BufferedImage fileToBufferedImage(File file){
        BufferedImage image = null;
        try{
            InputStream is = new FileInputStream(file);
        
            image = ImageIO.read(is);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }

    public String encodeImageToBase64(File file){
        try{
            byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            return Base64.getEncoder().encodeToString(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public BufferedImage importImage(String path){
        BufferedImage image = null;
        InputStream is = getClass().getResourceAsStream(path);
        try{
            image = ImageIO.read(is);
            is.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage imageWithLowerOpacity(BufferedImage image, float alpha, double scale){
        
        int newWidth = (int) (image.getWidth() * scale);
        int newHeight = (int) (image.getHeight() * scale);

        BufferedImage lowerTransparency = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = lowerTransparency.createGraphics();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2.dispose();

        return lowerTransparency;
    }

    public Font importFont(String path){
        Font font = null;
        InputStream is = getClass().getResourceAsStream(path);
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch(Exception e){
            e.printStackTrace();
        }
        return font;
    }

    public File chooseFile(String name, String extension){
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG image", "png"));

        int v = fileChooser.showOpenDialog(null);

        if(v == JFileChooser.APPROVE_OPTION){
            return new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        return null;
    }

    public JButton button(String title, String actionCommand, ActionListener al){
        JButton button = new JButton(title);
        button.setFocusable(false);
        button.setActionCommand(actionCommand);
        button.addActionListener(al);

        return button;
    }
}
