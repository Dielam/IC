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
public class Heuristic implements HeuristicInterface{

    @Override
    public float DistanceToGoal(int startX, int startY, int goalX, int goalY) {
        //Distance in the x
        float x = goalX - startX;
        //Distance in the y
        float y = goalY - startY;
        //Pythagoras theorem
        return (float) Math.sqrt((x*x)+(y*y));
    }
}
