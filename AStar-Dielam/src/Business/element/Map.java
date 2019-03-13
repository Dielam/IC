/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.element;

import java.util.ArrayList;

/**
 * Map
 * @author Diego Laguna Martín
 */
public class Map {
    
    private int size;
    private int high;
    private ArrayList<ArrayList<Node>> map;
    private int InitialX;
    private int InitialY;
    private int FinalX;
    private int FinalY;
    private int[][] obstacles;
    
    /**
     * Constructor
     * @param size
     * @param high 
     */
    public Map(int size, int high){
        this.size = size;
        this.high = high;
        this.obstacles = new int[size + 1][high + 1];
        MapCreator();
        BorderMapCreator();
    }
    
    /**
     * Get size
     * @return size
     */
    public int getSize() {
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
     * Get map
     * @return map
     */
    public ArrayList<ArrayList<Node>> getMap() {
        return map;
    }
    
    /**
     * Get initial X
     * @return InitialX
     */
    public int getInitialX() {
        return InitialX;
    }
    /**
     * Set initial x
     * @param InitialX 
     */
    public void setInitialX(int InitialX) {
        this.InitialX = InitialX;
    }
    
    /**
     * Get initial x
     * @return InitialY
     */
    public int getInitialY() {
        return InitialY;
    }
    
    /**
     * Set initial y
     * @param InitialY 
     */
    public void setInitialY(int InitialY) {
        this.InitialY = InitialY;
    }
    /**
     * Get final x
     * @return FinalX
     */
    public int getFinalX() {
        return FinalX;
    }
    
    /**
     * Set final x
     * @param FinalX 
     */
    public void setFinalX(int FinalX) {
        this.FinalX = FinalX;
    }
    
    /**
     * Get final y
     * @return FinalY
     */
    public int getFinalY() {
        return FinalY;
    }
    
    /**
     * Set final y
     * @param FinalY 
     */
    public void setFinalY(int FinalY) {
        this.FinalY = FinalY;
    }
    
    /**
     * Set obstacle
     * @param x
     * @param y
     * @param isObstical 
     */
    public void setObstacle(int x, int y, boolean isObstical) {
        this.map.get(x).get(y).setObstical(isObstical);
    }
    
    /**
     * Get obstacles
     * @return obstacles
     */
    public int[][] getObstacles() {
        return obstacles;
    }
    
    /**
     * Set obstacles
     * @param obstacles 
     */
    public void setObstacles(int[][] obstacles) {
        this.obstacles = obstacles;
	MapCreator();
        BorderMapCreator();
    }
    
    /**
     * Get node
     * @param x
     * @param y
     * @return node
     */
    public Node getNode(int x, int y) {
        return this.map.get(x).get(y);
    }
    
    /**
     * Get initial node
     * @return initial node
     */
    public Node getInitialNode(){
        return map.get(this.InitialX).get(this.InitialY);
    }
    
    /**
     * Set initial node
     * @param x
     * @param y 
     */
    public void setInitialNode(int x, int y) {
        this.map.get(this.InitialX).get(this.InitialY).setStart(false);
        this.map.get(x).get(y).setStart(true);
        this.InitialX = x;
        this.InitialY = y;
    }
    
    /**
     * Get final node
     * @return final node
     */
    public Node getFinalNode() {
        return this.map.get(this.FinalX).get(this.FinalY);
    }
    
    /**
     * Set final node
     * @param x
     * @param y 
     */
    public void setFinalNode(int x, int y) {
        this.map.get(this.FinalX).get(this.FinalY).setGoal(false);
        this.map.get(x).get(y).setGoal(true);
        this.FinalX = x;
        this.FinalY = y;
    }
    
    /**
     * Get distance between nodes
     * @param node1
     * @param node2
     * @return distance between node1 and node2
     */
    public float getDistanceBetween(Node node1, Node node2) {
        //if the nodes are on top or next to each other, return 1
        if (node1.getX() == node2.getX() || node1.getY() == node2.getY()) return 1*(this.size + this.high);
        //if they are diagonal to each other return diagonal distance: sqrt(1^2+1^2)
        else return (float) 1.7*(this.size + this.high);
    }
    
    /**
     * Create the map
     */
    private void MapCreator() {
        Node node;
        map = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < size; i++){
            map.add(new ArrayList<Node>());
            for(int j = 0; j < high; j++){
                node = new Node(i, j);
                if(obstacles[i][j] == 1) node.setObstical(true);
                map.get(i).add(node);
            }
        }
    }
    
    /**
     * Create the ends of the map
     */
    private void BorderMapCreator() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < high; j++){
                Node node = map.get(i).get(j);
                if(j != 0) node.setNorth(map.get(i).get(j-1));
                if(j != 0 && i != size - 1) node.setNorthEast(map.get(i+1).get(j-1));
                if(i != size - 1) node.setEast(map.get(i+1).get(j));
                if(i != size - 1 && j != high - 1) node.setSouthEast(map.get(i+1).get(j+1));
                if(j != high - 1) node.setSouth(map.get(i).get(j+1));
                if(i != 0 && j != high - 1) node.setSouthWest(map.get(i-1).get(j+1));
                if(i != 0) node.setWest(map.get(i-1).get(j));
                if(i != 0 && j != 0) node.setNorthWest(map.get(i-1).get(j-1));
            }
        }
    }
    
    /**
     * Remove the map
     */
    public void clear(){
        this.InitialX = 0;
        this.InitialY = 0;
        this.FinalX = 0;
        this.FinalY = 0;
        MapCreator();
        BorderMapCreator();
    }
    
}
