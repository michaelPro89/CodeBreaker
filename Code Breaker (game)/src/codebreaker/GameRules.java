

package codebreaker;

/**
 *
 * @author Michal Switala
 */
class GameRules
{
     
    //Data fields
     private boolean isCodeQuessed = false;
    private boolean isGameLoose = false;
    private final int LIFES = 8;  // here we have our maximum lifes player have
    private boolean gameStart = true;
    // Game rules are inside rules String
    private String rules = "\r \r \r \r \r \r \r \r \r \r \r \r \r \r\r \r \r \rWelcome to the Code Breaker Game!\n" + 
    "\n\r\r\rIn the begining there will be randomly generated code with 4 colors inside to quess. " + 
   " To win, you have to guess the code before your lifes will run out.\r\n"+	    			
    "\rThe only allowed colors are:\r\n" + 
    "\r\rR - Red, O - Orange, Y - Yellow, G - Green, B - Blue, I - Indigo, V - Violet. " + 

    "\n\n \r \r \r \r \r \r \r \r \r \r \r \r \r \r\r \r \r \r \r \r \r \r \r \r \r \r \r \r \r \r \r \r\r \r \r \r  \r \r \r  \r  § Rules. §\r\n" + 
    "\n-  You have only " +getLifes() +" lifes.\r\n"+ 
    "-  Your quess must have 4 colors inside ex. 'ROYG'.\r\n"+
    "-  You can only enter allowed colors.  \r\n"+
     "-  Your quess can't be duplicated.  \r\n"+
    "-  If your guess matches any color inside the code, it will  be displayed" + 
    " on the score-board, if not it will stay blank. " + 
    "\n-  If the color is correct but the position is wrong for one or " +
    "more colors, there will be shown a clue as to how many colors "+ 
    "there are in the player quess that are not in the correct position. "+
     "\n-  If your quess will match the code you win.";			


//Methods
public int getLifes ()
{
    return this.LIFES;
}

    public boolean isGameStart()
    {
        return this.gameStart;
    }

public String getRules ()
{
    
    return this.rules;
}
   
public void setRules (String rules)
{
    this.rules = rules;
    
}

       public boolean isCodeQuessed() {
        return isCodeQuessed;
    }

    public void setIsCodeQuessed(boolean isCodeQuessed) {
        this.isCodeQuessed = isCodeQuessed;
    }

    public void setIsGameLoose(boolean isGameLoose) {
        this.isGameLoose = isGameLoose;
    }

    public boolean isGameLoose() {
        return isGameLoose;
    }

}
