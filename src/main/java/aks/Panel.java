package aks;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import aks.ai.Gemini;
import aks.utils.TweetUtilities;

public class Panel extends JPanel{

    ActionHandler ah = new ActionHandler(this);
    JButton attemptButton, idealButton, generateButton;
    Tweet tweet = new Tweet();
    TweetUtilities tweetUtilities = new TweetUtilities();
    Editor editor = new Editor(this);
    Gemini gemini = new Gemini();
    
    public Panel(){
        // ADD BUTTONS TO PANEL
        attemptButton = button(Consts.BUTTON_ATTEMPT_NAME, Consts.BUTTON_ATTEMPT_COMMAND, ah);
        add(attemptButton);

        idealButton = button(Consts.BUTTON_IDEAL_NAME, Consts.BUTTON_IDEAL_COMMAND, ah);
        add(idealButton);

        generateButton = button(Consts.BUTTON_GENERATE_NAME, Consts.BUTTON_GENERATE_COMMAND, ah);
        add(generateButton);
    }

    public JButton button(String title, String actionCommand, ActionListener al){
        JButton button = new JButton(title);
        button.setFocusable(false);
        button.setActionCommand(actionCommand);
        button.addActionListener(al);

        return button;
    }
    
}
