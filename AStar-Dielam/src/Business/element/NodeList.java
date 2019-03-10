/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.element;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Ordenered node list
 * @author Diego Laguna Martín
 */
public class NodeList {
    
    private ArrayList<Node> list;
    
    /**
     * Constructor per default
     */
    public NodeList(){
        this.list = new ArrayList<Node>();
    }
    
    /**
     * Return the first element to the list
     * @return first node
     */
    public Node getFirst() {
            return list.get(0);
    }
    
    /**
     * Remove the list
     */
    public void clear() {
            list.clear();
    }
    
    /**
     * Add to the list
     * @param node 
     */
    public void add(Node node) {
            list.add(node);
            Collections.sort(list);
    }
    
    /**
     * Remove a node
     * @param n 
     */
    public void remove(Node n) {
            list.remove(n);
    }
    
    /**
     * Return the size of the list
     * @return size
     */
    public int size() {
            return list.size();
    }
    
    /**
     * Check if the node is in the list
     * @param n
     * @return true if contains
     */
    public boolean contains(Node n) {
            return list.contains(n);
    }
}
