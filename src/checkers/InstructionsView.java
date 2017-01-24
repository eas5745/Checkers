/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class InstructionsView extends JPanel {
    JButton movements;
    JButton movementDiagram;
    JButton capturingPieces;
    JButton capturingPiecesDiagram;
    JButton kingedPieces;
    JButton kingedPiecesDiagram;
    JButton winning;
    JButton trophyDiagram;
    InstructionsView() {       
        movements = new JButton(new ImageIcon(((new ImageIcon("src/images/movements.png")).getImage()).getScaledInstance(600, 180, java.awt.Image.SCALE_SMOOTH)));
        movements.setBackground(Color.WHITE);
        add(movements);
        
        movementDiagram = new JButton(new ImageIcon(((new ImageIcon("src/images/movementDiagram.png")).getImage()).getScaledInstance(500, 180, java.awt.Image.SCALE_SMOOTH)));
        movementDiagram.setBackground(Color.WHITE);
        add(movementDiagram);
        
        capturingPieces = new JButton(new ImageIcon(((new ImageIcon("src/images/capturingPieces.png")).getImage()).getScaledInstance(600, 180, java.awt.Image.SCALE_SMOOTH)));
        capturingPieces.setBackground(Color.WHITE);
        add(capturingPieces);
        
        capturingPiecesDiagram = new JButton(new ImageIcon(((new ImageIcon("src/images/jumping a piece.png")).getImage()).getScaledInstance(500, 180, java.awt.Image.SCALE_SMOOTH)));
        capturingPiecesDiagram.setBackground(Color.WHITE);
        add(capturingPiecesDiagram);
        
        kingedPieces = new JButton(new ImageIcon(((new ImageIcon("src/images/kingedPieces.png")).getImage()).getScaledInstance(600, 180, java.awt.Image.SCALE_SMOOTH)));
        kingedPieces.setBackground(Color.WHITE);
        add(kingedPieces);
        
        kingedPiecesDiagram = new JButton(new ImageIcon(((new ImageIcon("src/images/kingedPiecesDiagram.png")).getImage()).getScaledInstance(500, 180, java.awt.Image.SCALE_SMOOTH)));
        kingedPiecesDiagram.setBackground(Color.WHITE);
        add(kingedPiecesDiagram);
        
        winning = new JButton(new ImageIcon(((new ImageIcon("src/images/winning.png")).getImage()).getScaledInstance(600, 180, java.awt.Image.SCALE_SMOOTH)));
        winning.setBackground(Color.WHITE);
        add(winning);
        
        trophyDiagram = new JButton(new ImageIcon(((new ImageIcon("src/images/trophyDiagram.png")).getImage()).getScaledInstance(300, 180, java.awt.Image.SCALE_SMOOTH)));
        trophyDiagram.setBackground(Color.WHITE);
        add(trophyDiagram);
        
        GridLayout grid = new GridLayout(4,2);
        setLayout(grid);
        
    }
}
