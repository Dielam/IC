/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.aStar;

import Business.element.Coordinates;
import Business.element.Map;
import Business.element.Node;
import Business.element.NodeList;
import Business.element.Path;
import Business.heuristic.HeuristicInterface;
import java.util.ArrayList;

/**
 *
 * @author Diego Laguna Martín
 */
public class Algorithm {
    
    private Map map;
    private HeuristicInterface heuristic;
    private ArrayList<Node> closeList;
    private NodeList openList;
    private Path minimumPath;
    
    /**
     * Constructor
     * @param map
     * @param heuristic 
     */
    public Algorithm(Map map, HeuristicInterface heuristic) {
        this.map = map;
        this.heuristic = heuristic;
        this.closeList = new ArrayList<Node>();
        this.openList = new NodeList();
    }
    
    /**
     * Return the map
     * @return map
     */
    public Map getMap() {
        return map;
    }
    
    /**
     * Set map
     * @param map 
     */
    public void setMap(Map map) {
        this.map = map;
    }
    
    /**
     * Get heuristic interface
     * @return HeuristicInterface
     */
    public HeuristicInterface getHeuristic() {
        return heuristic;
    }
    
    /**
     * Set heuristic interface
     * @param heuristic 
     */
    public void setHeuristic(HeuristicInterface heuristic) {
        this.heuristic = heuristic;
    }
    
    /**
     * Get close list
     * @return closeList
     */
    public ArrayList<Node> getCloseList() {
        return closeList;
    }
    
    /**
     * Set close list
     * @param closeList 
     */
    public void setCloseList(ArrayList<Node> closeList) {
        this.closeList = closeList;
    }
    
    /**
     * Get open list
     * @return openList
     */
    public NodeList getOpenList() {
        return openList;
    }
    
    /**
     * Set open list
     * @param openList 
     */
    public void setOpenList(NodeList openList) {
        this.openList = openList;
    }
    
    /**
     * Get minimum path
     * @return minimumPath
     */
    public Path getMinimumPath() {
        return minimumPath;
    }
    
    /**
     * Set minimum path
     * @param minimumPath 
     */
    public void setMinimumPath(Path minimumPath) {
        this.minimumPath = minimumPath;
    }
    
    /**
     * Calculate the minimum path
     * @param coord_Inicio
     * @param coord_Fin
     * @param obstacleMap
     * @return null
     */
    public Path MinimumPath(Coordinates Initial_coord, Coordinates Final_coord, int[][] obstacleMap ) {
        this.map.setInitialNode(Initial_coord.getX(), Initial_coord.getY());
        this.map.setFinalNode(Final_coord.getX(), Final_coord.getY());
        this.map.setObstacles(obstacleMap);
        this.closeList = new ArrayList<Node>();
        this.openList = new NodeList();

        if (map.getNode(Final_coord.getX(), Final_coord.getY()).isObstacle()) return null;
        
        map.getInitialNode().setDistanceFromStart(0);
        closeList.clear();
        openList.clear();
        openList.add(map.getInitialNode());

        while(openList.size() != 0){
            Node current = openList.getFirst();
            if(current.getX() == map.getFinalX() && current.getY() == map.getFinalY()) return rebuildPath(current);
            openList.remove(current);
            closeList.add(current);
            for(Node neighbor : current.getNeighborList()) {
                boolean bestNeighbor;
                if (closeList.contains(neighbor)) continue;
                if (!neighbor.isObstacle()) {
                    float distanceNeighbor = (current.getDistanceFromStart() + map.getDistanceBetween(current, neighbor));
                    if(!openList.contains(neighbor)) {
                        openList.add(neighbor);
                        bestNeighbor = true;
                    } 
                    else if(distanceNeighbor < current.getDistanceFromStart()) bestNeighbor = true;
                    else bestNeighbor = false;
                    if (bestNeighbor) {
                        neighbor.setPreviousNode(current);
                        neighbor.setDistanceFromStart(distanceNeighbor);
                        neighbor.setHeuristicDistanceFromGoal(heuristic.DistanceToGoal(neighbor.getX(), neighbor.getY(), map.getFinalX(), map.getFinalY()));
                    }
                }
            }
        }
        return null;
    }
        
    /**
     * Draw the path
     */    
    public void drawPath() {
        Node node;
        for(int x = 0; x < map.getSize(); x++) {
            if (x == 0) {
                for (int i = 0; i <= map.getSize(); i++) System.out.print("-");
                System.out.println();   
            }
            System.out.print("|");
            for(int y = 0; y < map.getHigh(); y++) {
                node = map.getNode(x, y);
                if (node.isObstacle()) System.out.print("O");
                else if (node.isStart) System.out.print("I");
                else if (node.isGoal) System.out.print("F");
                else if (minimumPath.contains(node.getX(), node.getY())) System.out.print("*");
                else System.out.print(" ");
                if (y == map.getHigh()) System.out.print("_");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int i = 0; i <= map.getSize(); i++)
            System.out.print("-");
    }
    
    /**
     * Update the minimum path
     * @param node
     * @return path
     */
    private Path rebuildPath(Node node) {
        Path path = new Path();
        while(node.getPreviousNode() != null){
            path.prependWayPoint(node);
            node = node.getPreviousNode();
        }
        this.minimumPath = path;
        return path;
    }
}
