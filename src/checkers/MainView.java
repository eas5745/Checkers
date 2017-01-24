/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class MainView extends JPanel implements ActionListener {
    private MovePanel m_panel = new MovePanel();
    private String[][] gameBoard;
    private JLabel outputLabel;  
    private int turn = 0;
    private int player1Score = 0;
    private int player2Score = 0;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private String validMove = "";
    
    public MainView(MovePanel m_panel)
    {   
        gameBoard = populateBoard();
        this.m_panel = m_panel;
        m_panel.submit.addActionListener(this);
        showBoard(gameBoard, "Player 1's Turn");
    }

    public String[][] populateBoard(){
        
        String[][] orginialBoard = new String[9][9];
        
        for(int i=0; i < orginialBoard.length; i++){
            
            for(int j = 0; j < orginialBoard.length; j++){
                
                if(i == 1){
                    if (j % 2 == 0) {
                        orginialBoard[i][j] = "WC";
                    }                    
                } else if(i == 2){
                    if (j % 2 != 0) {
                        orginialBoard[i][j] = "WC";
                    }                    
                } else if(i == 3){
                    if (j % 2 == 0) {
                        orginialBoard[i][j] = "WC";
                    }                    
                } else if(i == 6){
                    if (j % 2 != 0) {
                        orginialBoard[i][j] = "BC";
                    }                    
                } else if(i == 7){
                    if (j % 2 == 0) {
                        orginialBoard[i][j] = "BC";
                    }                    
                } else if(i == 8){
                    if (j % 2 != 0) {
                        orginialBoard[i][j] = "BC";
                    }                    
                } else {
                    orginialBoard[i][j] = "empty";
                }                       
            }
        }
        
        orginialBoard[0][1] = "A";
        orginialBoard[0][2] = "B";
        orginialBoard[0][3] = "C";
        orginialBoard[0][4] = "D";
        orginialBoard[0][5] = "E";
        orginialBoard[0][6] = "F";
        orginialBoard[0][7] = "G";
        orginialBoard[0][8] = "H";
        orginialBoard[1][0] = "1";
        orginialBoard[2][0] = "2";
        orginialBoard[3][0] = "3";
        orginialBoard[4][0] = "4";
        orginialBoard[5][0] = "5";
        orginialBoard[6][0] = "6";
        orginialBoard[7][0] = "7";
        orginialBoard[8][0] = "8";  
        
        return orginialBoard;
    }
    
    public void showBoard(String[][] board, String playerTurn)
    {
        GridLayout grid = new GridLayout(10,9);
        setLayout(grid);
        String player1ScoreString = "Player 1: " + player1Score;
        String player2ScoreString = "Player 2: " + player2Score;
        JButton[][] boardSquares = new JButton[9][9];
        JLabel moveValidity = new JLabel(validMove);
        JLabel playerTurnLabel = new JLabel(playerTurn);
        JLabel player1ScoreLabel = new JLabel(player1ScoreString);
        JLabel player2ScoreLabel = new JLabel(player2ScoreString);
                     
        for (int i = 0; i < board.length ;i++)
        {
            for(int j = 0; j < board.length ;j++)
            {
                if(board[i][j] == "WC"){
                    boardSquares[i][j] = new JButton(new ImageIcon(((new ImageIcon("src/images/whiteChecker.png")).getImage()).getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH)));
                    if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                        boardSquares[i][j].setBackground(Color.DARK_GRAY);
                    } else {
                    boardSquares[i][j].setBackground(Color.WHITE);
                    }
                    add(boardSquares[i][j]);
                }else if(board[i][j] == "BC") {
                    boardSquares[i][j] = new JButton(new ImageIcon(((new ImageIcon("src/images/BlueChecker.png")).getImage()).getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH)));
                    if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                        boardSquares[i][j].setBackground(Color.DARK_GRAY);
                    } else {
                        boardSquares[i][j].setBackground(Color.WHITE);
                    }
                    add(boardSquares[i][j]);
                } else if(board[i][j] == "WK") {
                    boardSquares[i][j] = new JButton(new ImageIcon(((new ImageIcon("src/images/kingedWhiteChecker.png")).getImage()).getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH)));
                    if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                        boardSquares[i][j].setBackground(Color.DARK_GRAY);
                    } else {
                        boardSquares[i][j].setBackground(Color.WHITE);
                    }
                    add(boardSquares[i][j]);
                } else if(board[i][j] == "BK") {
                    boardSquares[i][j] = new JButton(new ImageIcon(((new ImageIcon("src/images/kingedBlueChecker.png")).getImage()).getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH)));
                    if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                        boardSquares[i][j].setBackground(Color.DARK_GRAY);
                    } else {
                        boardSquares[i][j].setBackground(Color.WHITE);
                    }
                    add(boardSquares[i][j]);
                }else if(board[i][j] == "empty") {
                    boardSquares[i][j] = new JButton();
                    if ((i == 0) || (j == 0)) {
                         boardSquares[i][j].setBackground(Color.LIGHT_GRAY);
                     }  else if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                         boardSquares[i][j].setBackground(Color.DARK_GRAY);
                     } else {
                         boardSquares[i][j].setBackground(Color.WHITE);
                    }
                    add(boardSquares[i][j]);
                }             
                else {
                        boardSquares[i][j] = new JButton(board[i][j]);
                    if ((i == 0) || (j == 0)) {
                         boardSquares[i][j].setBackground(Color.LIGHT_GRAY);
                     }  else if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                         boardSquares[i][j].setBackground(Color.DARK_GRAY);
                     } else {
                         boardSquares[i][j].setBackground(Color.WHITE);
                    }
                    add(boardSquares[i][j]);
                }
            }
        }
        add(moveValidity);
        add(playerTurnLabel);
        add(player1ScoreLabel);
        add(player2ScoreLabel);
    }
    
    public void removeBoard(){
        removeAll();
    }
    
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton)e.getSource();
        
        String playerTurn = "";
            if (eventSource == m_panel.getSubmit()) {
                removeBoard();
                x1 = m_panel.getFromXLocationSlider();
                x2 = m_panel.getToXLocationSlider();
                y1 = m_panel.getFromYLocationSlider();
                y2 = m_panel.getToYLocationSlider();

                //if player 2's turn
                if(turn % 2 != 0){
                    //piece is player 2's
                    if (gameBoard[x1][y1] == "WC") {
                        //move 1 space diagonally 
                        if ((x2 == x1 + 1) && ((y2 == y1 + 1) || (y2 == y1 - 1))) {
                            //piece on "to" location
                            if (gameBoard[x2][y2] != "empty"){
                                validMove = "Can't land on piece";                            
                            } 
                            //piece ends on other side of board - kinged
                            else if (x2 == 8){ 
                                kingPlayer2 ();
                                gameBoard[x1][y1] = "empty";
                                turn++;
                            } 
                            //move allowed
                            else {
                                gameBoard[x2][y2] = gameBoard[x1][y1];
                                gameBoard[x1][y1] = "empty";
                                validMove = "Valid move";
                                turn++;
                            }
                        } 
                        //move 2 places diagonally - jumping a piece
                        else if ((x2 == x1 + 2) && ((y2 == y1 + 2)) || (y2 == y1 - 2) ) {
                            //piece jumping is player 1
                            if (((gameBoard[x2 - 1][y2 - 1].indexOf('B') != -1) && (y2 == y1 + 2)) || ((gameBoard[x2 - 1][y2 + 1].indexOf('B') != -1) && (y2 == y1 - 2))) {
                                //lands on other side of board - kinged
                                if (x2 == 8) {
                                    kingPlayer2 ();
                                    gameBoard[x1][y1] = "empty";
                                    player2Score++;
                                    turn++;
                                    if ((y2 == y1 + 2)) {
                                        gameBoard[x2 - 1][y2 - 1] = "empty";
                                    } else {
                                        gameBoard[x2 - 1][y2 + 1] = "empty";
                                    }
                                } 
                                else if (gameBoard[x2][y2] != "empty"){
                                    validMove = "Can't land on piece";                            
                                }
                                //jumped player 1
                                else {
                                    validMove = "Jumped player 1";                                    
                                    player2Score++;
                                    turn++;
                                    gameBoard[x2][y2] = gameBoard[x1][y1];
                                    gameBoard[x1][y1] = "empty";
                                    if ((y2 == y1 + 2)) {
                                        gameBoard[x2 - 1][y2 - 1] = "empty";
                                    } else {
                                        gameBoard[x2 - 1][y2 + 1] = "empty";
                                }
                                }                                
                                
                            } else {
                                validMove = "Invalid move";
                            }   
                        } else {
                            validMove = "Invalid move";
                        }  
                    } else if (gameBoard[x1][y1] == "WK") {
                            if (((x2 == x1 + 1) || (x2 == x1 - 1) ) && ((y2 == y1 + 1) || (y2 == y1 - 1))) {
                                if (gameBoard[x2][y2] != "empty"){
                                    validMove = "Can't land on piece";                            
                                } else {
                                    gameBoard[x2][y2] = gameBoard[x1][y1];
                                    gameBoard[x1][y1] = "empty";
                                    validMove = "Valid move";
                                    turn++;
                                }
                            } else if (((x2 == x1 + 2) || (x2 == x1 - 2)) && ((y2 == y1 + 2)) || (y2 == y1 - 2) ) {
                            //piece jumping is player 1
                                if (((gameBoard[x2 - 1][y2 - 1].indexOf('B') != -1) && (y2 == y1 + 2)) || ((gameBoard[x2 - 1][y2 + 1].indexOf('B') != -1) && (y2 == y1 - 2)) || ((gameBoard[x2 + 1][y2 - 1].indexOf('B') != -1) && (y2 == y1 + 2)) || ((gameBoard[x2 + 1][y2 + 1].indexOf('B') != -1) && (y2 == y1 - 2))) {
                                    //lands on other side of board - kinged
                                    if (gameBoard[x2][y2] != "empty"){
                                        validMove = "Can't land on piece";                            
                                    }
                                    //jumped player 1
                                    else {
                                        validMove = "Jumped player 1";
                                        gameBoard[x2][y2] = gameBoard[x1][y1];
                                        if ((y2 == y1 + 2) && (x2 == x1 - 2)) {
                                        gameBoard[x2 + 1][y2 - 1] = "empty";
                                        } else if ((y2 == y1 - 2) && (x2 == x1 - 2)) {
                                            gameBoard[x2 + 1][y2 + 1] = "empty";
                                        } else if ((y2 == y1 - 2) && (x2 == x1 + 2)) {
                                            gameBoard[x2 - 1][y2 + 1] = "empty";
                                        } else {
                                            gameBoard[x2 - 1][y2 - 1] = "empty";
                                        }
                                        gameBoard[x1][y1] = "empty";
                                        player2Score++;
                                        turn++;
                                    }                     
                                } else {
                                    validMove = "Invalid move";
                                }   
                        } else {
                            validMove = "Invalid move";
                        }  
                    }
                    //piece is player 1's, not player 2's
                    else if (gameBoard[x1][y1] == "BK" || gameBoard[x1][y1] == "BC") {
                        validMove = "Not player 1's turn";
                    } else {
                        validMove = "No piece to move";
                    }
                } else if(turn % 2 == 0){                
                    if (gameBoard[x1][y1] == "BC") {
                        //move 1 space diagonally 
                        if ((x2 == x1 - 1) && ((y2 == y1 + 1) || (y2 == y1 - 1))) {
                            //piece on "to" location
                            if (gameBoard[x2][y2] != "empty"){
                                validMove = "Can't land on piece";                            
                            } 
                            //piece ends on other side of board - kinged
                            else if (x2 == 1){ 
                                kingPlayer1 ();
                                gameBoard[x1][y1] = "empty";
                                turn++;
                            } 
                            //move allowed
                            else {
                                gameBoard[x2][y2] = gameBoard[x1][y1];
                                gameBoard[x1][y1] = "empty";
                                validMove = "Valid move";
                                turn++;
                            }
                        } 
                        //move 2 places diagonally - jumping a piece
                        else if ((x2 == x1 - 2) && ((y2 == y1 + 2)) || (y2 == y1 - 2) ) {
                            //piece jumping is player 1
                            if (((gameBoard[x2 + 1][y2 - 1].indexOf('W') != -1) && (y2 == y1 + 2)) || ((gameBoard[x2 + 1][y2 + 1].indexOf('W') != -1) && (y2 == y1 - 2))) {
                                //lands on other side of board - kingd
                                if (x2 == 1) {
                                    kingPlayer1 ();
                                    gameBoard[x1][y1] = "empty";
                                    if ((y2 == y1 + 2)) {
                                        gameBoard[x2 + 1][y2 - 1] = "empty";
                                    } else {
                                        gameBoard[x2 + 1][y2 + 1] = "empty";
                                    }
                                    turn++;
                                    player1Score++;
                                } 
                                else if (gameBoard[x2][y2] != "empty"){
                                    validMove = "Can't land on piece";                            
                                }
                                //jumped player 2
                                else {
                                    validMove = "Jumped player 2";
                                    gameBoard[x2][y2] = gameBoard[x1][y1];
                                    if ((y2 == y1 + 2)) {
                                    gameBoard[x2 + 1][y2 - 1] = "empty";
                                    } else {
                                        gameBoard[x2 + 1][y2 + 1] = "empty";
                                    }
                                    gameBoard[x1][y1] = "empty";
                                    player1Score++;
                                    turn++;
                                    }                           
                            } else {
                                validMove = "Invalid move";
                            }   
                        } else {
                            validMove = "Invalid move";
                        }  
                    } else if (gameBoard[x1][y1] == "BK") {
                            if (((x2 == x1 + 1) || (x2 == x1 - 1) ) && ((y2 == y1 + 1) || (y2 == y1 - 1))) {
                                if (gameBoard[x2][y2] != "empty"){
                                    validMove = "Can't land on piece";                            
                                } else {
                                    gameBoard[x2][y2] = gameBoard[x1][y1];
                                    gameBoard[x1][y1] = "empty";
                                    validMove = "Valid move";
                                    turn++;
                                }
                            } else if (((x2 == x1 + 2) || (x2 == x1 - 2)) && ((y2 == y1 + 2)) || (y2 == y1 - 2) ) {
                            //piece jumping is player 1
                                if (((gameBoard[x2 - 1][y2 - 1].indexOf('W') != -1) && (y2 == y1 + 2)) || ((gameBoard[x2 - 1][y2 + 1].indexOf('W') != -1) && (y2 == y1 - 2)) || ((gameBoard[x2 + 1][y2 - 1].indexOf('W') != -1) && (y2 == y1 + 2)) || ((gameBoard[x2 + 1][y2 + 1].indexOf('W') != -1) && (y2 == y1 - 2))) {
                                    //lands on other side of board - kinged
                                    if (gameBoard[x2][y2] != "empty"){
                                        validMove = "Can't land on piece";                            
                                    }
                                    //jumped player 1
                                    else {
                                        validMove = "Jumped player 2";
                                        gameBoard[x2][y2] = gameBoard[x1][y1];
                                        if ((y2 == y1 + 2) && (x2 == x1 - 2)) {
                                            gameBoard[x2 + 1][y2 - 1] = "empty";
                                        } else if ((y2 == y1 - 2) && (x2 == x1 - 2)) {
                                            gameBoard[x2 + 1][y2 + 1] = "empty";
                                        } else if ((y2 == y1 - 2) && (x2 == x1 + 2)) {
                                            gameBoard[x2 - 1][y2 + 1] = "empty";
                                        } else {
                                            gameBoard[x2 - 1][y2 - 1] = "empty";
                                        }
                                        gameBoard[x1][y1] = "empty";
                                        player1Score++;
                                        turn++;
                                    }                              
                                } else {
                                    validMove = "Invalid move";
                                }   
                        } else {
                            validMove = "Invalid move";
                        }  
                    }
                    //piece is player 1's, not player 2's
                    else if (gameBoard[x1][y1] == "WK" || gameBoard[x1][y1] == "WC" ) {
                        validMove = "Not player 2's turn";
                    } else {
                        validMove = "No piece to move";
                    }
                }
                if ((player1Score == 12) || (player2Score == 12)) {
                    if (player1Score == 12) {
                        validMove = "Player 1 Wins";
                    } else {
                        validMove = "Player 2 Wins";
                    }
                }
                playerTurn = getPlayerTurn(turn);
                showBoard(gameBoard, playerTurn);
            }
    }
    
    public String getPlayerTurn(int turn){
        String player = "";
        if ((player1Score == 12) || (player2Score == 12)) {
            validMove = "Game over";
        } else if(turn % 2 != 0){
            player = "Player 2's Turn";
        } else {
            player = "Player 1's Turn";
        }
        return player;
    }
    public void kingPlayer2 () {
        validMove = "Piece kinged";
        gameBoard[x2][y2] = "WK";
        return;    
    }
    public void kingPlayer1 () {
        validMove = "Piece kinged";
        gameBoard[x2][y2] = "BK";
        return;    
    }
}