
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;

import java.util.ArrayList;

/**
 *
 * @author Michal Switala
 */
class PlayerInput 
{
    
    
    private String playerInput;
    private int inputCounter;
    private  ArrayList  allPlayerQuesses = new ArrayList();
          


       //Methods
     public Object getPlayerQuessAt(int index) {
         
        return allPlayerQuesses.get(index);
    }

    public ArrayList getAllPlayerQuesses() {
        return allPlayerQuesses;
    }

    public void addPlayerQuess(String quess) {
        this.allPlayerQuesses.add(quess);

    }

    public void clearStoredQuesses() {

        this.allPlayerQuesses.clear();
    }

    public int getInputCounter() {
        return inputCounter;
    }

    public void setInputCounter(int addNumber) 
    {
      
        this.inputCounter = this.inputCounter+ addNumber;
    }
    
    public String getPlayerInput()
    { 
        return this.playerInput;
    }

        
    public void setPlayerInput(String input)
    {
      
        this.playerInput = input;
    }
       
    
    
}



