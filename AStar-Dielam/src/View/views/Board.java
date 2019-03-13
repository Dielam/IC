/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Board made up with cells
 * @author Diego Laguna Martín
 */
public class Board extends JPanel {

    private int size;
    private int high;
    private Cell [][] board;

    public Board(int size, int high){
        this.size = size;
        this.high = high;
        initComponets();
    }

    /**
     * Get high
     * @return high
     */
    public int getHigh() {
            return high;
    }

    /**
     * Set high
     * @param high
     */
    public void setHigh(int high) {
            this.high = high;
    }

    /**
     * Get size
     * @return size
     */
    public int getTheSize() {
        return size;
    }
    
    /**
     * Set size
     * @param size 
     */
    public void setSize(int size) {
            this.size = size;
    }

    /**
     * Get Cell
     * @param x
     * @param y
     * @return Board[x][y]
     */
    public Cell getCell(int x, int y) {
            return board[x][y];
    }
    
    /**
     * Initializes the board
     */
    private void initComponets() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setName("Board");
        this.board = new Cell[size][high];
        this.setLayout(new GridLayout(size, high)); 
        //Board
        for( int x = 0; x < size; x++){
            for (int y = 0; y < high; y++){
                this.board[x][y] = new Cell(); 
                this.add(board[x][y]);
                this.board[x][y].setEmptyColor();
                this.board[x][y].setToolTipText(Integer.toString(x) + " , " + Integer.toString(y));
            }
        }
    }

    /**
     * Inicialize the listeners
     * @param e 
     */
    public void initListeners(EventListener e){
        for(int x = 0; x < size; x++){
            for(int y = 0; y < high; y++){
                this.board[x][y].addActionListener((ActionListener) e);
                this.board[x][y].setName("Map");
                this.board[x][y].setRow(x);
                this.board[x][y].setColumn(y);
            }
        }
    }
    
    /**
     * Draw the path cell in the board
     * @param x
     * @param y 
     */
    public void drawPathCell(int x, int y){		
            this.board[x][y].setPathColor();
    }
    
    /**
     * Draw the empty cell in the board
     * @param x
     * @param y 
     */
    public void drawEmptyCell(int x, int y){		
            this.board[x][y].setEmptyColor();
    }
    
   /**
    * Draw the obstacle cell in the board
    * @param x
    * @param y 
    */
    public void drawObstacleCell(int x, int y){		
            this.board[x][y].setObstacleColor();
    }
    
    /**
    * Draw the obstacle cell in the board
    * @param x
    * @param y 
    */
    public void drawGoalCell(int x, int y) {
            this.board[x][y].setGoalColor();
    }
    
    /**
    * Draw the obstacle cell in the board
    * @param x
    * @param y 
    */
    public void drawStartCell(int x, int y) {
            this.board[x][y].setStartColor();
    }

}
