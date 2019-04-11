/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.id3;

import Business.elements.Attribute;
import Business.elements.Parser;
import Business.elements.Value;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ID3 algorithm 
 * @author Diego Laguna Martín
 */
public class Algorithm {
    
    private ArrayList<Attribute> attributes;
    private ArrayList<String[]> game;
    private Attribute result;
    private Parser parser;
    
    /**
     * Constructor
     */
    public Algorithm() {
        parser = new Parser();
        initAttributes();
        initGame();
        algorithmID3();
        System.out.println(this.result.getName());
    }

    /**
     * Get attributes
     * @return attributes
     */
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Set attributes
     * @param attributes 
     */
    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Get game
     * @return game
     */
    public ArrayList<String[]> getGame() {
        return game;
    }

    /**
     * Set game
     * @param game 
     */
    public void setGame(ArrayList<String[]> game) {
        this.game = game;
    }

    /**
     * Get result
     * @return result
     */
    public Attribute getResult() {
        return result;
    }

    /**
     * Set result
     * @param result 
     */
    public void setResult(Attribute result) {
        this.result = result;
    }

    /**
     * Get parser
     * @return parser
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * Set parser
     * @param parser 
     */
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    /**
     * Initializes the attributes
     */
    private void initAttributes() {
        String[] aux = parser.AttributesRead();
        attributes = new ArrayList<>();
        for (int i = 0; i < aux.length; i++) this.attributes.add(new Attribute(aux[i]));
    }

    /**
     * Initializes the game
     */
    private void initGame() {
        String[] aux;
        this.game = new ArrayList<>();
        
        while (parser.AreValues()) {
            aux = parser.ValuesRead();
            for (int i = 0; i < aux.length - 1; i++) {
                if (!this.attributes.get(i).containName(aux[i])) this.attributes.get(i).addName(aux[i]);
            }
            this.game.add(aux);
        }
    }

    /**
     * Execute the IDE3 algorithm
     */
    private void algorithmID3() {
        ArrayList<Attribute> attributes2 = (ArrayList<Attribute>) this.attributes.clone();
        ArrayList<String[]> game2 = (ArrayList<String[]>) this.game.clone();
        this.result = auxID3(attributes2, game2);
    }

    /**
     * Recursive function for the IDE3 algorithm
     * @param attributes
     * @param game
     * @return result
     */
    private Attribute auxID3(ArrayList<Attribute> attributes, ArrayList<String[]> game) {
        ArrayList<Attribute> auxAttributes = attributes;
        ArrayList<String[]> auxGame = game;
        int auxIdx = attributes.indexOf(bestMerit(attributes, game));     
        Attribute auxAttribute = attributes.get(auxIdx);
        Value auxValue;
        String[] auxString = new String[game.size()];
        
        auxAttributes.remove(auxAttribute);
        Iterator iter = auxAttribute.getValues().iterator();
        Iterator iter2 = game.iterator();
        
        while (iter.hasNext()) {
            auxValue = (Value) iter.next();
            auxGame = new ArrayList<>();
                        
            while (iter2.hasNext()) {
                auxString = (String[])iter2.next();
                                
                if (auxString[auxIdx].equals(auxValue.getName())) {
                    auxGame.add(addLineGame(auxString, auxIdx));                        
                }
            }
            
            if (auxString.length > 0){
            	auxValue.setAttribute(auxID3(auxAttributes, auxGame));
            }
            
        }
        return auxAttribute;
    }
    
    /**
     * Calculate the best merit
     * @param attribute
     * @param game
     * @return attribute with the best merit
     */
    private Attribute bestMerit(ArrayList<Attribute> attribute, ArrayList<String[]> game) {
        String[] auxGame;
        Attribute auxAttribute;
        Attribute auxSol = null;
        double auxMerit = Double.MAX_VALUE;
        Iterator iteratorGame = game.iterator();
        
        while (iteratorGame.hasNext()) {
            auxGame = (String[]) iteratorGame.next();
            
            for(int i = 0; i < auxGame.length - 1; i++){
                if (attribute.get(i).containName(auxGame[i])) {
                    //Positive
                    if (auxGame[auxGame.length - 1].equalsIgnoreCase("yes")) { 
                        int positive = attribute.get(i).getValue(auxGame[i]).getPositive();
                        positive++;
                        attribute.get(i).getValue(auxGame[i]).setPositive(positive);
                    } 
                    //Negative
                    else { 
                        int negative = attribute.get(i).getValue(auxGame[i]).getNegative();
                        negative++;
                        attribute.get(i).getValue(auxGame[i]).setNegative(negative);
                    }
                    //Counter++
                    attribute.get(i).getValue(auxGame[i]).increment();
                }
            }
        }
        Iterator iteratorAttribute = attribute.iterator();
        boolean isNan = false;
        
        while (iteratorAttribute.hasNext() && !isNan) {
            auxAttribute = (Attribute) iteratorAttribute.next();
            if(Double.isNaN(auxAttribute.merit())){                
                auxSol = auxAttribute;
                isNan = true;
            }                    
            else if (auxAttribute.merit() < auxMerit) {   
                auxSol = auxAttribute; 
                auxMerit = auxAttribute.merit();                        
            }            
        }        
        return auxSol; 
    }
    
    /**
     * Add a line of the game
     * @param s
     * @param idx
     * @return string
     */
    private String[] addLineGame(String[] s, int idx) {
        String[] aux;
        int j = 0;
        int size = s.length;
        String auxSt;
        aux = new String[size-1];
        
        for (int i = 0; i < s.length; i++) {
            if (i != idx) {
                auxSt = s[i];
                aux[j] = auxSt;
                j++;
            }
        }        
        return aux;
    }

    public boolean isPosible(String[] s) {
        Attribute at = this.result;
    	Value v = at.getValue(s[this.attributes.indexOf(at)]);
    	
    	while(!v.isEnd()){
            try{
    		at = at.getValue(s[this.attributes.indexOf(at)]).getAttribute();
                if(at.getName().equalsIgnoreCase("jugar")){
                    return true;
                }
    		v = at.getValue(s[this.attributes.indexOf(at)]);
            }catch(Exception e){
                return false;
            }
    	}
    	
    	if(v.isPositive()) return true;
        else return false;
    }

    
    
    
}
