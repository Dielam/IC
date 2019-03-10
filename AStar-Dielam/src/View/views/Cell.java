/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.views;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Make up the board
 * @author Diego Laguna Martín
 */
public class Cell extends JButton {
    private int row;
    private int column;

    /**
     * Constructor
     */
    public Cell(){
        this.setFocusable(false);
    }
    
    /**
     * Get column
     * @return column
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * Set column
     * @param column 
     */
    public void setColumna(int column) {
        this.column = column;
    }
    
    /**
     * Get row
     * @return row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Set Row
     * @param row 
     */
    public void setRow(int row) {
        this.row = row;
    }
    
    /**
     * Set color of the goal cells
     */
    public void setGoalColor() {
        //ImageIcon imgMeta= new ImageIcon(this.getClass().getResource("/images/meta.png"));
        //this.setIcon(imgMeta);
        this.setBackground(Color.BLUE);
    }
    
    /**
     * Set color of the empty cells
     */
    public void setEmptyColor(){
        this.setBackground(Color.GRAY);
    }
    
    /**
     * Set color of the starts cells
     */
    public void setStartColor(){
        //ImageIcon imgMeta= new ImageIcon(this.getClass().getResource("/images/meta.png"));
        //this.setIcon(imgMeta);
        this.setBackground(Color.GREEN);
    }
    
    /**
     * Set color of the path cells
     */
    public void setPathColor(){
        setBackground(Color.DARK_GRAY);
    }
    
    /**
     * Set color of the obstacles cells
     */
    public void setObstacleColor(){
        //ImageIcon imgMeta= new ImageIcon(this.getClass().getResource("/images/meta.png"));
        //this.setIcon(imgMeta);
        this.setBackground(Color.RED);
    }
}
