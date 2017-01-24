/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class NavViewBottomMenuPanel extends JPanel{
    JButton mainButton;
    JButton optionsButton;
    JButton instructionsButton;
    JButton creditsButton;  
    public NavViewBottomMenuPanel() {
        super();       
        mainButton = new JButton("Main");
        optionsButton = new JButton("Options");
        instructionsButton = new JButton("Instructions");
        creditsButton = new JButton("Credits");
                                  
        add(mainButton);
        add(optionsButton);
        add(instructionsButton);
        add(creditsButton);   
        

    }          
}
