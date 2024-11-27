package aks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import aks.ai.Gemini;
import aks.utils.TweetUtilities;

public class Panel extends JPanel{

    ActionHandler ah = new ActionHandler(this);
    JButton attemptButton, idealButton, attemptScreenshot, solutionScreenshot, generateButton;
    public Tweet tweet = new Tweet();
    public TweetUtilities tweetUtilities = new TweetUtilities();
    public Editor editor = new Editor(this);
    public Gemini gemini = new Gemini();
    public FilterJson filterJson = new FilterJson();

    Color red = new Color(255,0,0,50);
    Color green = new Color(0,255,0,50);

    static final int WIDTH = 850;
    static final int HEIGHT = 400;
    
    public Panel(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setLayout(new BorderLayout());

        // add(uploadPanel(), BorderLayout.NORTH);
        add(screenshotsPanel(), BorderLayout.NORTH);
        add(resultPanel(), BorderLayout.CENTER);
        add(generateButPanel(), BorderLayout.SOUTH);

    }

    public JPanel uploadPanel(){
        JPanel thisPanel = new JPanel();

        // ADD BUTTONS TO PANEL
        attemptButton = tweetUtilities.button(Consts.BUTTON_ATTEMPT_NAME, Consts.BUTTON_ATTEMPT_COMMAND, ah);
        thisPanel.add(attemptButton);

        idealButton = tweetUtilities.button(Consts.BUTTON_IDEAL_NAME, Consts.BUTTON_IDEAL_COMMAND, ah);
        thisPanel.add(idealButton);

        return thisPanel;
    }

    public JPanel screenshotsPanel(){
        JPanel center = new JPanel();

        attemptScreenshot = tweetUtilities.button(Consts.ATTEMPT_SCREENSHOT, Consts.ATTEMPT_SCREENSHOT_CMD, ah);
        center.add(attemptScreenshot);

        solutionScreenshot = tweetUtilities.button(Consts.SOLUTION_SCREENSHOT, Consts.SOLUTION_SCREENSHOT_CMD, ah);
        center.add(solutionScreenshot);

        return center;
    }

    public JPanel resultPanel(){
        return new WorkSpacePanel(this);
    }

    public JPanel generateButPanel(){
        JPanel footer = new JPanel();

        generateButton = tweetUtilities.button(Consts.BUTTON_GENERATE_NAME, Consts.BUTTON_GENERATE_COMMAND, ah);
        generateButton.setBackground(new Color(0,0,255,40));
        footer.add(generateButton);

        return footer;
    }

    
    
}
