/**
 * Code breaker is a game where you have to quess the randomly generated code before you run out of lives.
 * 
 * @author Michal Switala
 * Copyright © 2021 belongs solely to Michal Switala.
 *
 * You can reach me out on : https://github.com/michaelPro89
 */
package codebreaker;

import java.util.ArrayList;

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



