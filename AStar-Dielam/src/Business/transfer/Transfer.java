/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.transfer;

import Business.element.Coordinates;

/**
 *
 * @author Diego Laguna Martín
 */
public class Transfer {
    private Coordinates start;
    private Coordinates end;
    private int[][] obstacleMap;
    private long time;
    
    /**
     * Default constructor
     */
    public Transfer(){}
    
    /**
     * Constructor with params
     * @param start
     * @param end
     * @param obstacleMap 
     */
    public Transfer(Coordinates start, Coordinates end, int[][] obstacleMap) {	
        this.start = start;
        this.end = end;
        this.obstacleMap = obstacleMap;
    }
    
    /**
     * Get start
     * @return start
     */
    public Coordinates getStart() {
        return start;
    }
    
    /**
     * Set start
     * @param start 
     */
    public void setStart(Coordinates start) {
        this.start = start;
    }
    
    /**
     * Get end
     * @return end
     */
    public Coordinates getEnd() {
        return end;
    }
    
    /**
     * Set end
     * @param end 
     */
    public void setEnd(Coordinates end) {
        this.end = end;
    }
    
    /**
     * Get obstacleMap
     * @return obstacleMap
     */
    public int[][] getObstacleMap() {
        return obstacleMap;
    }
    
    /**
     * Set obstacleMap
     * @param obstacleMap 
     */
    public void setObstacleMap(int[][] obstacleMap) {
        this.obstacleMap = obstacleMap;
    }
    
    /**
     * Get time
     * @return time
     */
    public long getTime() {
        return time;
    }
    
    /**
     * Set time
     * @param time 
     */
    public void setTime(long time) {
        this.time = time;
    }
}
