/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.element;

/**
 *
 * @author Diego Laguna Martín
 */
public class Coordinates {
    
    private int x;
    private int y;
    
    /**
     * Constructor with params
     * @param x
     * @param y 
     */
    public Coordinates(int x, int y){
        super();
        this.x = x;
        this.y = y;
    
    }
    
    /**
     * Get x
     * @return x
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Set x
     * @param x 
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * Get y
     * @return y
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Set y
     * @param y 
     */
    public void setY(int y){
        this.y = y;
    }
}
