/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.element;

import java.util.ArrayList;

/**
 * Path
 * @author Diego Laguna Martín
 */
public class Path {
    
    private final ArrayList<Node> Path = new ArrayList<Node>();
    
    /**
     * Get length of the path
     * @return size of the path
     */
    public int getLength() {
        return this.Path.size();
    }
    
    /**
     * Get coordinates of the path
     * @param index
     * @return coordinates of the path
     */
    public Node getCoordinatesPath(int index) {
        return this.Path.get(index);
    }
    
    /**
     * Get index x of the path
     * @param index
     * @return index x of the path
     */
    public int getX(int index) {
        return getCoordinatesPath(index).getX();
    }
    
    /**
     * Get index y of the path
     * @param index
     * @return index y of the path
     */
    public int getY(int index) {
        return getCoordinatesPath(index).getY();
    }
    
    /**
     * Add node to the end
     * @param n Node
     */
    public void addCordenadas(Node n) {
        this.Path.add(n);
    }

   /**
    * Prefix way point
    * @param n Node
    */
    public void prependWayPoint(Node n) {
        this.Path.add(0, n);
    }

   /**
    * Check if a position belongs to the path
    * @param x
    * @param y
    * @return true if the path contains it
    */
    public boolean contains(int x, int y) {
        for(Node node : this.Path) {
            if (node.getX() == x && node.getY() == y) return true;
        }
        return false;
    }
}
