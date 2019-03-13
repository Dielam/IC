/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.element;

/**
 * Chronometer
 * @author Diego Laguna Martín
 */
public class Chronometer {
    
    private long timeStart;
    private long timeStop;
    private boolean onWay;
    
    /**
     * Constructor 
     */
    public Chronometer() {
        this.timeStart = 0;
        this.timeStop = 0;
        this.onWay = false;
    }
    
    /**
     * Chronometer starts
     */
    public void start() {
        this.timeStart = System.currentTimeMillis();
        this.onWay = true;
    }
    
    /**
     * Chronometer stops
     */
    public void stop() {
            this.timeStop = System.currentTimeMillis();
            this.onWay = false;
    }

    /**
     * Return elapsed time
     * @return elapsedTime
     */
    public long getElapsedTime() {
        long elapsedTime;
        if (onWay) elapsedTime = (System.currentTimeMillis() - timeStart);
        else elapsedTime = (timeStop - timeStart);
        return elapsedTime;
    }

}
