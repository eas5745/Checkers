/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author eas57
 */
public class NavView extends JFrame{
    
    private NavModel model;
    private NavViewPanel nVpanel;
    
    NavView(NavModel model)
    {
        super("Primary View");
        this.model = model;
                          
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        nVpanel = new NavViewPanel();
        
        add(nVpanel);    
    }
    public void switchToInstructionsPanel(InstructionsView i_view)
    {
        nVpanel.removeSplash();
        nVpanel.removeMain();
        nVpanel.removeCredits();
        nVpanel.removeOptions();
        nVpanel.addInstructions(i_view);
    }
    public void switchToOptionsPanel(OptionsView o_view)
    {
        nVpanel.removeSplash();
        nVpanel.removeMain();
        nVpanel.removeInstructions();
        nVpanel.removeCredits();
        nVpanel.addOptions(o_view);        
    }
    
    public void switchToNameLabelPanel(NameLabelPanel nameLabelPanel)
    {
        nVpanel.removeSplash();
        nVpanel.removeOptions();
        nVpanel.removeInstructions();
        nVpanel.removeCredits();
        nVpanel.addNameLabel(nameLabelPanel);        
    }
    
    public void switchToCreditsPanel(CreditsView c_view)
    {
        nVpanel.removeSplash();
        nVpanel.removeOptions();
        nVpanel.removeInstructions();
        nVpanel.removeMain();
        nVpanel.addCredits(c_view);
    }
    
    public void addOptionsButtonListener(ActionListener al) 
    {    
        nVpanel.menu.optionsButton.addActionListener(al);
    }    
                    
    public void addMainButtonListener(ActionListener al) 
    {    
        nVpanel.menu.mainButton.addActionListener(al);
    }
    public void addInstructionsButtonListener(ActionListener al)
    {
        nVpanel.menu.instructionsButton.addActionListener(al);
    }
    public void addCreditsButtonListener(ActionListener al)
    {
        nVpanel.menu.creditsButton.addActionListener(al);
    }
    
}
