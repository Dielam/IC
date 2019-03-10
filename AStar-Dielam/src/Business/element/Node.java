/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.element;

import java.util.ArrayList;

/**
 *
 * @author Diego Laguna Martín
 */
public class Node implements Comparable<Node> {
    
    private Map map;
    private Node north;
    private Node northEast;
    private Node east;
    private Node southEast;
    private Node south;
    private Node southWest;
    private Node west;
    private Node northWest;
    private ArrayList<Node> neighborList;
    private boolean visited;
    private float distanceFromStart;
    private float heuristicDistanceFromGoal;
    private Node previousNode;
    private int x;
    private int y;
    private boolean isObstacle;
    public boolean isStart;
    public boolean isGoal;
    
    /**
     * Constructor with 2 params
     * @param x
     * @param y 
     */
    Node(int x, int y) {
        neighborList = new ArrayList<Node>();
        this.x = x;
        this.y = y;
        this.visited = false;
        this.distanceFromStart = Integer.MAX_VALUE;
        this.setIsObstacle(false);
        this.isStart = false;
        this.isGoal = false;
    }
    
    /**
     * Constructor with all params
     * @param x
     * @param y
     * @param visited
     * @param distanceFromStart
     * @param isObstical
     * @param isStart
     * @param isGoal 
     */
    public Node (int x, int y, boolean visited, int distanceFromStart, boolean isObstical, boolean isStart, boolean isGoal) {
        this.neighborList = new ArrayList<Node>();
        this.x = x;
        this.y = y;
        this.visited = visited;
        this.distanceFromStart = distanceFromStart;
        this.setIsObstacle(isObstical);
        this.isStart = isStart;
        this.isGoal = isGoal;
    }
    
    /**
     * Get map
     * @return map
     */
    public Map getMap() {
        return map;
    }
    
    /**
     * Get north
     * @return north
     */
    public Node getNorth() {
        return north;
    }
    
    /**
     * Set north
     * @param North 
     */
    public void setNorth(Node north) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.north)) neighborList.remove(this.north);
        neighborList.add(north);
        //Set the new node
        this.north = north;
    }
    
    /**
     * Get north east
     * @return NorthEast
     */
    public Node getNorthEast() {
        return northEast;
    }
    
    /**
     * Set north east
     * @param northEast 
     */
    public void setNorthEast(Node northEast) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.northEast)) neighborList.remove(this.northEast);
        neighborList.add(northEast);
        //Set the new node
        this.northEast = northEast;
    }
    
    /**
     * Get east
     * @return East
     */
    public Node getEast() {
        return east;
    }
    
    /**
     * Set east
     * @param east 
     */
    public void setEast(Node east) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.east)) neighborList.remove(this.east);
        neighborList.add(east);
        //Set the new node
        this.east = east;
    }
    
    /**
     * Get south east
     * @return SouthEast
     */
    public Node getSouthEast() {
        return southEast;
    }
    
    /**
     * Set south east
     * @param southEast 
     */
    public void setSouthEast(Node southEast) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.southEast)) neighborList.remove(this.southEast);
        neighborList.add(southEast);
        //Set the new node
        this.southEast = southEast;
    }
    
    /**
     * Get south
     * @return South 
     */
    public Node getSouth() {
        return south;
    }
    
    /**
     * Set south
     * @param south 
     */
    public void setSouth(Node south) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.south)) neighborList.remove(this.south);
        neighborList.add(south);
        //Set the new node
        this.south = south;
    }
    
    /**
     * Get south west
     * @return SouthWest
     */
    public Node getSouthWest() {
        return southWest;
    }
    
    /**
     * Set south west
     * @param southWest 
     */
    public void setSouthWest(Node southWest) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.southWest)) neighborList.remove(this.southWest);
        neighborList.add(southWest);
        //Set the new node
        this.southWest = southWest;
    }
    
    /**
     * Get west
     * @return West
     */
    public Node getWest() {
        return west;
    }
    
    /**
     * Set west
     * @param west 
     */
    public void setWest(Node west) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.west)) neighborList.remove(this.west);
        neighborList.add(west);
        //Set the new node
        this.west = west;
    }
    
    /**
     * Get north west
     * @return NorthWest
     */
    public Node getNorthWest() {
        return northWest;
    }
    
    /**
     * Set north west
     * @param northWest 
     */
    public void setNorthWest(Node northWest) {
        //Replace the old node with the new one in the neighborList
        if (neighborList.contains(this.northWest)) neighborList.remove(this.northWest);
        neighborList.add(northWest);
        //Set the new node
        this.northWest = northWest;
    }
    
    /**
     * Get neighbor list
     * @return NeighborList
     */
    public ArrayList<Node> getNeighborList() {
        return neighborList;
    }
    
    /**
     * Set neighbor list
     * @param neighborList 
     */
    public void setNeighborList(ArrayList<Node> neighborList) {
        this.neighborList = neighborList;
    }
    
    /**
     * Check if it has been visited
     * @return true if it was visited
     */
    public boolean isVisited() {
        return visited;
    }
    
    /**
     * Set if is visited
     * @param visited 
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    /**
     * Get distance from start
     * @return DistanceFromStart
     */
    public float getDistanceFromStart() {
        return distanceFromStart;
    }
    
    /**
     * Set distance from start
     * @param distanceFromStart 
     */
    public void setDistanceFromStart(float distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }
    
    /**
     * Get heuristic distance from goal
     * @return HeuristicDistanceFromGoal
     */
    public float getHeuristicDistanceFromGoal() {
        return heuristicDistanceFromGoal;
    }
    
    /**
     * Set heuristic distance from goal
     * @param heuristicDistanceFromGoal 
     */
    public void setHeuristicDistanceFromGoal(float heuristicDistanceFromGoal) {
        this.heuristicDistanceFromGoal = heuristicDistanceFromGoal;
    }
    
    /**
     * Get previous node
     * @return PreviousNode
     */
    public Node getPreviousNode() {
        return previousNode;
    }
    
    /**
     * Set previous node
     * @param previousNode 
     */
    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
    
    /**
     * Get x
     * @return x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Set x
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Get y
     * @return y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Set y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Check if it is an obstacle
     * @return true if it is an obstacle
     */
    public boolean isObstacle() {
        return isObstacle;
    }
    
    /**
     * Set if is an obstacle
     * @param isObstacle 
     */
    public void setIsObstacle(boolean isObstacle) {
        this.isObstacle = isObstacle;
    }
    
    /**
     * Check if it is the start
     * @return true if it is the start
     */
    public boolean isStart() {
        return isStart;
    }
    
    /**
     * Set if is a start
     * @param isStart 
     */
    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }
    
    /**
     * Check if it is the goal
     * @return true if it is the goal
     */
    public boolean isGoal() {
        return isGoal;
    }
    
    /**
     * Set if is a goal
     * @param isGoal 
     */
    public void setIsGoal(boolean isGoal) {
        this.isGoal = isGoal;
    }
    
    
    @Override
    public int compareTo(Node o) {
        float thisTotalDistanceFromGoal = heuristicDistanceFromGoal + distanceFromStart;
        float otherTotalDistanceFromGoal = o.getHeuristicDistanceFromGoal() + o.getDistanceFromStart();

        if (thisTotalDistanceFromGoal < otherTotalDistanceFromGoal) {
                return -1;
        } else if (thisTotalDistanceFromGoal > otherTotalDistanceFromGoal) {
                return 1;
        } else {
                return 0;
        }
    }
    
    public boolean equals(Node node) {
        return (node.x == x) && (node.y == y);
    }
    
    public boolean isObstical() {
        return isObstacle();
    }

    void setObstical(boolean b) {
        setIsObstacle(b);
    }

    void setStart(boolean b) {
        setIsStart(b);
    }

    void setGoal(boolean b) {
        setIsGoal(b);
    }
    
}
