/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class NameLabelPanel extends JPanel{
    private JLabel outputLabelPlayer1;
    private JLabel outputLabelPlayer2;
    
    NameLabelPanel () {
        outputLabelPlayer1 = new JLabel("Player 1 (Blue): ");
        add(outputLabelPlayer1);
        
        outputLabelPlayer2 = new JLabel("Player 2 (White): ");
        add(outputLabelPlayer2);
        
        GridLayout grid = new GridLayout(2,1);
        setLayout(grid);
    }
    
    public void setOutputLabel(String player1Name, String player2Name)
    {
        outputLabelPlayer1.setText("Player 1 (Blue) Name: " + player1Name);
        outputLabelPlayer2.setText("Player 2 (White) Name: " + player2Name);
    }
}
