/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class CreditsView extends JPanel {
    private JLabel welcomeLabel;
    
    CreditsView(){
       welcomeLabel = new JLabel("Designed and Created by: Emily Schmittle");
       
       add(welcomeLabel);
    }
}
