/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.elements;

import java.util.ArrayList;

/**
 *
 * Attribute
 * @author Diego Laguna Martín
 */
public class Attribute {
    
    private String name;
    private ArrayList<Value> values;
    
    /**
     * Constructor with params
     * @param name 
     */
    public Attribute(String name) {
        this.name = name;
        this.values = new ArrayList<>();
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get values
     * @return values
     */
    public ArrayList<Value> getValues() {
        return values;
    }

    /**
     * Set values
     * @param values 
     */
    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }
    
    /**
     * Get all the names
     * @return names
     */
    public ArrayList<String> getNames() {
     ArrayList<String> names = new ArrayList<>();
     for(int i = 0; i < values.size(); i++) names.add(values.get(i).getName());
     return names;
    }
    
    /**
     * Get the value of the name
     * @param name
     * @return value
     */
    public Value getValue(String name) {
        boolean ok = false;
        int i = 0;
        
        while(!ok){
            if(values.get(i).getName().equals(name)) ok = true;
            else i++;
        }
        return values.get(i);
    }
    
    /**
     * Add a name
     * @param name 
     */
    public void addName(String name) {
        this.values.add(new Value(name));
    }
    
    /**
     * Check if contain the name
     * @param name
     * @return 
     */
    public boolean containName(String name) {
        for (int i = 0; i < values.size(); i++){
            if (values.get(i).getName().equals(name)) return true;
        }
        return false;
    }
    
    /**
     * Calculate the merit of the values
     * @return merit
     */
    public double merit() {
        double merit = 0;        
        
        for(int i = 0; i < values.size(); i++) merit = merit + this.values.get(i).getQuantity() * this.values.get(i).infor();
        return merit;
    }
}
