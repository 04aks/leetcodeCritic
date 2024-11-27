package aks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import aks.threads.GenerateThread;
import aks.threads.OpenFileThread;
import aks.threads.OpenSolutionFileThread;
import aks.white_panel.Screenie;

public class ActionHandler implements ActionListener{

    Panel p;
    Screenie screenie;
    public ActionHandler(Panel p){

        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case Consts.BUTTON_ATTEMPT_COMMAND: uploadAttempt(); break;
            case Consts.BUTTON_IDEAL_COMMAND: uploadIdeal(); break;
            case Consts.BUTTON_GENERATE_COMMAND: generateTweet(); break;
            case Consts.ATTEMPT_SCREENSHOT_CMD: takeAttemptScreenshot(); break;
            case Consts.SOLUTION_SCREENSHOT_CMD: takeSolutionScreenshot(); break;
        }
    }

    void uploadAttempt(){
        OpenFileThread openFileThread = new OpenFileThread(p, p.tweet, p.attemptButton, p.green, p.red);
        openFileThread.execute();
    }

    void uploadIdeal(){
        OpenSolutionFileThread openSolutionFileThread = new OpenSolutionFileThread(p, p.tweet, p.idealButton, p.green, p.red);
        openSolutionFileThread.execute();
    }

    void generateTweet(){
        if(p.tweet.getAttemptImage() != null && p.tweet.getIdealImage() != null){
            
            GenerateThread generateThread = new GenerateThread(p);
            generateThread.execute();
        }
    }
    
    void takeAttemptScreenshot(){
        Window.frame.setState(JFrame.ICONIFIED);
        screenie = new Screenie(p, Consts.ATTEMPT_SCREENSHOT_CMD);
    }

    void takeSolutionScreenshot(){
        Window.frame.setState(JFrame.ICONIFIED);
        screenie = new Screenie(p, Consts.SOLUTION_SCREENSHOT_CMD);
    }
    
}
