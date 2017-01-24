/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eas57
 */
public class OptionsView extends JPanel{
    private JTextField player1Name;
    private JTextField player2Name;
    JButton submitNames;
    
    OptionsView() {
        player1Name = new JTextField("--Enter Player 1 Name --");
        player2Name = new JTextField("--Enter Player 2 Name--");
        submitNames = new JButton ("Submit Names");
               
        add(player1Name);
        add(player2Name);
        add(submitNames);
        
        GridLayout grid = new GridLayout(3,1);
        setLayout(grid);
    }
    
    public JButton getSubmitNamesButton () {
        return this.submitNames;
    }
        
    public void addSubmitButtonListener(ActionListener al) 
    {    
        submitNames.addActionListener(al);
    }

    public String getPlayer1Name() {
        return player1Name.getText();
    }

    public String getPlayer2Name() {
        return player2Name.getText();
    }
}
