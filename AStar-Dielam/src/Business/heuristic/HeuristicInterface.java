/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.heuristic;

/**
 *
 * @author Diego Laguna Martín
 */
public interface HeuristicInterface {
    
    /**
     * Try to guess at the distance to which the next node of the goal is. 
     * If this distance is the minimum, this node will be chosen.
     * @param startX 
     * @param startY
     * @param goalX
     * @param goalY
     * @return cost associated with the given position
     */
    public float DistanceToGoal(int startX, int startY, int goalX, int goalY);
}
