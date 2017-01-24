/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author eas57
 */
public class OptionsController extends JFrame implements ActionListener {

    private OptionsModel o_model;
    private OptionsView o_view;
    private NameLabelPanel nameLabelPanel;

    OptionsController(OptionsModel o_model, OptionsView o_view, NameLabelPanel nameLabelPanel) {
        this.o_model = o_model;
        this.o_view = o_view;
        this.nameLabelPanel = nameLabelPanel;
        o_view.submitNames.addActionListener(this);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickSource = (JButton) e.getSource();        
        if (clickSource == o_view.getSubmitNamesButton()) {           
            o_model.setPlayer1Name(o_view.getPlayer1Name());
            o_model.setPlayer2Name(o_view.getPlayer2Name());
            nameLabelPanel.setOutputLabel(o_model.getPlayer1Name(),o_model.getPlayer2Name());
        }       
    }
}
