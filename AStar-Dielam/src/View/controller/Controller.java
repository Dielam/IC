/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.controller;

import Business.aStar.Algorithm;
import Business.element.Map;
import Business.element.Chronometer;
import Business.heuristic.Heuristic;
import Business.transfer.Transfer;

/**
 *
 * @author Diego Laguna Martín
 */
public class Controller {
    
    private Algorithm path;
    private Heuristic heuristic;
    private Map map;
    private Chronometer chrono;
    
    /**
     * Inizialize the controller
     * @param size
     * @param high 
     */
    public Controller(int size, int high) {
        map = new Map(size, high);
        heuristic = new Heuristic();
        path = new Algorithm(map, heuristic);
        chrono = new Chronometer();
    }
    
    /**
     * Respond to the event with its corresponding action
     * @param evento
     * @param datos
     * @return 
     */
    public Object action(int event, Object data) {
        switch (event) {
            case Event.CALCULATE_MINIMUM_PATH:{
                    Transfer transfer = (Transfer) data;
                    chrono.start();
                    path.MinimumPath(transfer.getStart(), transfer.getEnd(), transfer.getObstacleMap());
                    chrono.stop();
                    transfer = new Transfer();
                    transfer.setTime(chrono.getElapsedTime());
                    data = transfer;
                };
                break;
            case Event.GET_MINIMUM_PATH: data = path.getMinimumPath();
                break;	
            default:
                break;
        }
        return data;
    }
		
}
