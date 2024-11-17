package aks.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

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
}
