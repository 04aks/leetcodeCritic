package aks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

    Panel p;
    public ActionHandler(Panel p){

        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case Consts.BUTTON_ATTEMPT_COMMAND: System.out.println("attempt"); break;
            case Consts.BUTTON_IDEAL_COMMAND: System.out.println("ideal"); break;
            case Consts.BUTTON_GENERATE_COMMAND: System.out.println("generate"); break;
        }
    }
    
}
