/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Parser
 * @author Diego Laguna Martín
 */
public class Parser {
    
    private Scanner attributes;
    private Scanner values;
    
    /**
     * Constructor
     */
    public Parser() {
        try {
            attributes = new Scanner(new File("Attributes.txt"));
        } 
        catch (FileNotFoundException ex) {
            System.out.println("ERROR");
        }
        try {
            values = new Scanner(new File("Game.txt"));
        } 
        catch (FileNotFoundException ex) {
            System.out.println("ERROR");
        }
    }
    
    /**
     * Attributes reading
     * @return attributes
     */
    public String[] AttributesRead() {
        return attributes.nextLine().split(",");
    }

    /**
     * Values reading
     * @return values
     */
    public String[] ValuesRead(){
        return values.nextLine().split(",");
    }
    
    /**
     * Check for values
     * @return true if there are values
     */
    public boolean AreValues(){
        return values.hasNext();
    }
 
}
