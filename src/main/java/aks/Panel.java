package aks;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import aks.ai.Gemini;
import aks.utils.TweetUtilities;

public class Panel extends JPanel{

    ActionHandler ah = new ActionHandler(this);
    JButton attemptButton, idealButton, generateButton;
    public Tweet tweet = new Tweet();
    public TweetUtilities tweetUtilities = new TweetUtilities();
    public Editor editor = new Editor(this);
    public Gemini gemini = new Gemini();
    public FilterJson filterJson = new FilterJson();

    Color red = new Color(255,0,0,50);
    Color green = new Color(0,255,0,50);
    
    public Panel(){
        // ADD BUTTONS TO PANEL
        attemptButton = tweetUtilities.button(Consts.BUTTON_ATTEMPT_NAME, Consts.BUTTON_ATTEMPT_COMMAND, ah);
        add(attemptButton);

        idealButton = tweetUtilities.button(Consts.BUTTON_IDEAL_NAME, Consts.BUTTON_IDEAL_COMMAND, ah);
        add(idealButton);

        generateButton = tweetUtilities.button(Consts.BUTTON_GENERATE_NAME, Consts.BUTTON_GENERATE_COMMAND, ah);
        add(generateButton);
    }

    
    
}
