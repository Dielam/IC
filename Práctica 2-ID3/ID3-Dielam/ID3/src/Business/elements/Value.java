/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.elements;

import static java.lang.Math.log;

/**
 * Value
 * @author Diego Laguna Martín
 */
public class Value {
    
    private String name;
    private int positive;
    private int negative;
    private int quantity;
    private Attribute attribute;

    /**
     * Constructor
     */
    public Value() {
        this.name = "";
        this.positive = 0;
        this.negative = 0;
        this.quantity = 0;
        this.attribute = null;
    }

    /**
     * Constructor with params
     * @param name 
     */
    public Value(String name) {
        this.name = name;
        this.positive = 0;
        this.negative = 0;
        this.quantity = 0;
        this.attribute = null;
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
     * Get positive
     * @return positive
     */
    public int getPositive() {
        return positive;
    }

    /**
     * Set positive
     * @param positive 
     */
    public void setPositive(int positive) {
        this.positive = positive;
    }

    /**
     * Get negative
     * @return negative
     */
    public int getNegative() {
        return negative;
    }

    /**
     * Set negative
     * @param negative 
     */
    public void setNegative(int negative) {
        this.negative = negative;
    }

    /**
     * Get quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set quantity
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get attribute
     * @return 
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * Set attribute
     * @param attribute 
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
    
    /**
     * Does the calculation
     * @return operation result
     */
    public double infor() {
        double positives = nPositives();
        double negatives = nNegatives();
        return (-positives * (log(positives)/log(2))) - (negatives * (log(negatives)/log(2)));
    }
    
    /**
     * Calculate the number of positives
     * @return quantity of positives
     */
    public double nPositives() {
        double p = this.positive;
        double n = this.quantity;
        return p/n;
    }
    
    /**
     * Calculate the number of negatives
     * @return quantity of negatives
     */
    public double nNegatives() {
        double ne = this.negative;
        double n = this.quantity;
        return ne/n;
    }
    /**
     * Check if is positive
     * @return true if positive
     */
    public boolean isPositive() {
        return this.positive == this.quantity;
    }
    
    /**
     * Check if is the end
     * @return true if is the end
     */
    public boolean isEnd() {
        return (this.positive == this.quantity) || (this.negative == this.quantity);
    }

    /**
     * Increment the quantity
     */
    public void increment() {
        this.quantity++;
    }
    
}
