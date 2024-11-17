package aks.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

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

    public String encodeImageToBase64(File file){
        try{
            byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            return Base64.getEncoder().encodeToString(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
