/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class NavViewSplashPanel extends JPanel{
    private JButton splashButton;
    NavViewSplashPanel()
    {
            splashButton = new JButton(new ImageIcon("src/images/Nittany Lion Checkers.png"));            
            add(splashButton);
           
    }    
}
