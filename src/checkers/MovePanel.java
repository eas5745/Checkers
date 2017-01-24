/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author eas57
 */
public class MovePanel extends JPanel implements ActionListener {
    private JSlider fromXLocationSlider;
    private JSlider fromYLocationSlider;
    private JSlider toXLocationSlider;
    private JSlider toYLocationSlider;
    JButton submit;
    JLabel outputLabel;
    private Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
    
    MovePanel() {
        
        JLabel move = new JLabel ("Move");  
        add(move);
        
        JLabel fromLocation = new JLabel ("From:");           
        add(fromLocation);
        
        fromXLocationSlider = new JSlider(JSlider.HORIZONTAL, 1, 8, 4);
        fromXLocationSlider.setMajorTickSpacing(1);
        fromXLocationSlider.setPaintTicks(true);
        fromXLocationSlider.setPaintLabels(true);
        add(fromXLocationSlider);
        
        fromYLocationSlider = new JSlider(JSlider.HORIZONTAL, 1, 8, 4);
        fromYLocationSlider.setPaintLabels(true);
        fromYLocationSlider.setPaintTicks(true);
        fromYLocationSlider.setMajorTickSpacing(1);    
        table.put (new Integer(1), new JLabel("A"));
        table.put (new Integer(2), new JLabel("B"));
        table.put (new Integer(3), new JLabel("C"));
        table.put (new Integer(4), new JLabel("D"));
        table.put (new Integer(5), new JLabel("E"));
        table.put (new Integer(6), new JLabel("F"));
        table.put (new Integer(7), new JLabel("G"));
        table.put (new Integer(8), new JLabel("H"));
        fromYLocationSlider.setLabelTable (table);
        add(fromYLocationSlider);
        
        JLabel toLocation = new JLabel ("To:");           
        add(toLocation);
        
        toXLocationSlider = new JSlider(JSlider.HORIZONTAL, 1, 8, 4);
        toXLocationSlider.setMajorTickSpacing(1);
        toXLocationSlider.setPaintTicks(true);
        toXLocationSlider.setPaintLabels(true);
        add(toXLocationSlider);
        
        toYLocationSlider = new JSlider(JSlider.HORIZONTAL, 1, 8, 4);
        toYLocationSlider.setMajorTickSpacing(1);
        toYLocationSlider.setPaintTicks(true);
        toYLocationSlider.setPaintLabels(true);
        toYLocationSlider.setLabelTable (table);
        add(toYLocationSlider);
        
        submit = new JButton ("Submit");
        submit.addActionListener(this);
        add(submit);
        
        outputLabel = new JLabel("Player 1's Turn");
        add(outputLabel);
        
        GridLayout grid = new GridLayout(9,1);
        setLayout(grid);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int fromYLocationSliderValue; 
        JLabel fromYLocationSliderLabel;
        int toYLocationSliderValue; 
        JLabel toYLocationSliderLabel;
        fromYLocationSliderValue = fromYLocationSlider.getValue();
        fromYLocationSliderLabel = table.get(fromYLocationSliderValue);
        toYLocationSliderValue = toYLocationSlider.getValue();
        toYLocationSliderLabel = table.get(toYLocationSliderValue);
        String turn = "";
        //turn = getPlayerTurn();
        JButton eventSource = (JButton)e.getSource();
        if (eventSource == getSubmit()) {    
            getOutputLabel().setText("From: " + fromXLocationSlider.getValue() + fromYLocationSliderLabel.getText() + " To: " + toXLocationSlider.getValue() + toYLocationSliderLabel.getText());       
        }
    }
    
    public JButton getSubmit() {
        return this.submit;
    }
    
    public int getFromXLocationSlider() {
        return fromXLocationSlider.getValue();
    }

    public int getFromYLocationSlider() {
        return fromYLocationSlider.getValue();
    }

    public int getToXLocationSlider() {
        return toXLocationSlider.getValue();
    }

    public int getToYLocationSlider() {
        return toYLocationSlider.getValue();
    }

    public JLabel getOutputLabel() {
        return this.outputLabel;
    }
}
