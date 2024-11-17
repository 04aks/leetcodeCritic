package aks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ActionHandler implements ActionListener{

    Panel p;
    public ActionHandler(Panel p){

        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case Consts.BUTTON_ATTEMPT_COMMAND: uploadAttempt(); break;
            case Consts.BUTTON_IDEAL_COMMAND: uploadIdeal(); break;
            case Consts.BUTTON_GENERATE_COMMAND: generateTweet(); break;
        }
    }

    File chooseFile(String name, String extension){
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG image", "png"));

        int v = fileChooser.showOpenDialog(null);

        if(v == JFileChooser.APPROVE_OPTION){
            return new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        return null;
    }

    void uploadAttempt(){
        File attemptImagePath = chooseFile("PNG image", "png");
        if(attemptImagePath != null){
            p.attemptButton.setBackground(Color.green);
            p.tweet.setAttemptImage(attemptImagePath);
        }else{
            p.attemptButton.setBackground(Color.red);
        }
    }

    void uploadIdeal(){
        File idealImagePath = chooseFile("PNG image", "png");
        if(idealImagePath != null){
            p.idealButton.setBackground(Color.green);
            p.tweet.setIdealImage(idealImagePath);
        }else{
            p.idealButton.setBackground(Color.RED);
        }
    }

    void generateTweet(){
        System.out.println(p.tweet.getAttemptImage() + " / " + p.tweet.getIdealImage());
    }
    
}
