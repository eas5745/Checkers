/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author eas57
 */
public class NavController {
    private NavModel n_model;
    private NavView n_view;
    
    //Instance Variables for Options Model, View, and Controller
    private OptionsModel o_model;
    private OptionsView o_view;
    private OptionsController o_Controller;       
    // TODO: Create instances of your MainModel and MainController once you implement them
    private CreditsView c_view;
    private InstructionsView i_view;
    private NameLabelPanel nameLabelPanel;
    private MovePanel m_panel;
    
    public NavController(NavModel n_model, NavView n_view ) {
        this.n_model = n_model;
        this.n_view = n_view;
        o_model = new OptionsModel();
        nameLabelPanel = new NameLabelPanel();
        m_panel = new MovePanel();
        o_view = new OptionsView();
        o_Controller = new OptionsController(o_model, o_view, nameLabelPanel); 
        
       
        c_view = new CreditsView();
        i_view = new InstructionsView();
                
        n_view.addOptionsButtonListener(new OptionsButtonListener());
        n_view.addMainButtonListener(new MainButtonListener());
        n_view.addInstructionsButtonListener(new InstructionsButtonListener());
        n_view.addCreditsButtonListener(new CreditsButtonListener());
    }
    class OptionsButtonListener implements ActionListener {            
        public void actionPerformed(ActionEvent e)
        {            
            //Pass an Options View object to our Navigation View
            n_view.switchToOptionsPanel(o_view);
        }
    }     
 
    class MainButtonListener implements ActionListener {            
        public void actionPerformed(ActionEvent e)
        {            
            //Pass a Main View object to our Navigation View
            n_view.switchToNameLabelPanel(nameLabelPanel);
        }
    }
    class InstructionsButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            n_view.switchToInstructionsPanel(i_view);
        }
    }
    
    class CreditsButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            n_view.switchToCreditsPanel(c_view);
        }
    }
  
}
