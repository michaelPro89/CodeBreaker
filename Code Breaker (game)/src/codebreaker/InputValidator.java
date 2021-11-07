
package codebreaker;

import java.util.ArrayList;

/**
 * Code breaker is a game where you have to quess the randomly generated code before you run out of lives.
 * 
 * @author Michal Switala
 * Copyright © 2021 belongs solely to Michal Switala.
 *
 * You can reach me out on : https://github.com/michaelPro89
 */
class InputValidator 
{
    
    //Data field
    private String[] checkInput = new String[4];
    public boolean inputIsValid = true;
    private StringBuffer ccBuffer = new StringBuffer(" ");
    private String correctColors = " ";
    public boolean inputIsNot4Letters;
    public boolean inputIsDuplicate;
    public boolean inputHasInvalidColors;
    public boolean inputHasAnyClue;
    public boolean readyToCheck;
    private int clueCounter = 0;
    private int countingR = 0;
    private int countingO = 0;
    private int countingY = 0;
    private int countingG = 0;
    private int countingB = 0;
    private int countingI = 0;
    private int countingV = 0;
    private int computerPatchR;
    private int computerPatchO;
    private int computerPatchY;
    private int computerPatchG;
    private int computerPatchB;
    private int computerPatchI;
    private int computerPatchV;
   
      
    
    
    public boolean isInputWrong(String input) {

        boolean wrong = false;

        switch (input) {
            case "yes":  // checks 'yes' input
                wrong = false;
                break;

            case "Yes":  // checks 'Yes' input
                wrong = false;
                break;

            case "No":
                wrong = false;
                break;
            case "no":
                wrong = false;
                break;

            default:
                wrong = true;
                break;
        }

        return wrong;
    }
      
      
    public void checkInputLength(String userQuess) {

        try {

            //allocates user input to 4 String array, if input is 3 or less than it throws error11
            this.checkInput[0] = userQuess.substring(0, 1);
            this.checkInput[1] = userQuess.substring(1, 2);
            this.checkInput[2] = userQuess.substring(2, 3);
            this.checkInput[3] = userQuess.substring(3, 4);
        
            this.inputIsNot4Letters = false;     
            
        } catch (Exception e) {

            this.inputIsNot4Letters = true;

        }

    }
    
    

    public String[] getCheckInput() {
        return checkInput;
    }
    
      public String getCheckInputAt(int x) {
        return checkInput[x];
    }
    
      public void checkColors(PlayerInput playerIn, InputValidator inputValid,  randomGenerator rg )
    {

        //Local variables
        String charToCheck = "_";
        boolean charInvalid = false;

        //Here we check if player input have atleast 1 not allowed color inside
        for (int x = 0; x < inputValid.getCheckInput().length; x++) {

            try {
                charToCheck = inputValid.getCheckInput()[x].toUpperCase();

            } catch (Exception e) {
                // set to true if there is "nothing" inside a single char to display message
                inputValid.inputIsNot4Letters = true;

            }

            if      (!charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[0])
                    && !charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[1])
                    && !charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[2])
                    && !charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[3])
                    && !charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[4])
                    && !charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[5])
                    && !charToCheck.equalsIgnoreCase(rg.ARRAY_OF_COLORS[6]))
            {
                inputValid.inputHasInvalidColors = true;
                break;
            }

        }

    }
      
      
    public void checkDuplicate(PlayerInput playerIn, InputValidator inputValid) {
       
        //local variables
        String currentInput;

        ArrayList storedInputs = playerIn.getAllPlayerQuesses();

        //Store only 4 first letters from player input
        currentInput = this.checkInput[0].toUpperCase() + this.checkInput[1].toUpperCase() + this.checkInput[2].toUpperCase() + this.checkInput[3].toUpperCase();  // debug, change it later
        // Debug
        System.out.println("Current input of player is : " + currentInput);

        if (storedInputs.contains(currentInput)) {
            inputValid.inputIsDuplicate = true;
        }
        System.out.println("Does input is duplicated ? : " + inputValid.inputIsDuplicate);
    }

 
 //Here we are checking how many colors are correct but are in wrong positions
 public void checkClues(ScoreBoard scoreBoard, randomGenerator rg, InputValidator inputValid)
 {
     
        // Local variables
        String check = " ";       
        // Delete all from Buffer before adding new colors
        this.ccBuffer.delete(0, 255);
      
        
        for (int c=0; c==0; c++)                
     {
         check = inputValid.getCheckInput()[c];

         if (check.equalsIgnoreCase(rg.getComputerPatchAt(1))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(2))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(3))) {
             ccBuffer.append(check);
         }

     }
        
     for (int c = 1; c == 1; c++) {

         check = inputValid.getCheckInput()[c];

         if (check.equalsIgnoreCase(rg.getComputerPatchAt(0))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(2))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(3))) {
             ccBuffer.append(check);
         }

     }

     for (int c = 2; c == 2; c++) {
         check = inputValid.getCheckInput()[c];

         if (check.equalsIgnoreCase(rg.getComputerPatchAt(0))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(1))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(3))) {
             ccBuffer.append(check);
         }

     }
     for (int c = 3; c == 3; c++) {
         check = inputValid.getCheckInput()[c];

         if (check.equalsIgnoreCase(rg.getComputerPatchAt(0))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(1))) {
             ccBuffer.append(check);
         }
         if (check.equalsIgnoreCase(rg.getComputerPatchAt(2))) {
             ccBuffer.append(check);
         }

     }
 }       
        
 
 public void countPatchColors(String [ ] patch, String [ ] code){
     
        
     
     for (int x = 0; x < patch.length; x++) {
         
           String c = patch[x];
           String displayedCodeAt = code[x];
           
        System.out.println(" CHAR C IS > > > "  +c);
        
            if (c.equalsIgnoreCase("r") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchR++;
            }
            if (c.equalsIgnoreCase("o") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchO++;
            }
            if (c.equalsIgnoreCase("y") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchY++;
            }
            if (c.equalsIgnoreCase("g") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchG++;
            }
            if (c.equalsIgnoreCase("b") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchB++;
            }
            if (c.equalsIgnoreCase("i") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchI++;
            }
            if (c.equalsIgnoreCase("v") && !c.equalsIgnoreCase(displayedCodeAt)) {
                this.computerPatchV++;
            }

        }
     
     
     //debug
     System.out.println(" computer patch has R : "  +this.computerPatchR);
 }

 //Here we count our correct colors
       public void countCorrectColors()
       {
     
        //Converts StringBuffer into a String
        this.correctColors = this.ccBuffer.toString();

        //debug code
        System.out.println("The string buffer has this clue colors inside: " + correctColors);

        for (int x = 0; x < correctColors.length(); x++) {

            char c = correctColors.toLowerCase().charAt(x);
            System.out.println("char is: " + c);

            if (c == 'r') {
                this.countingR++;
            }
            if (c == 'o') {
                this.countingO++;
            }
            if (c == 'y') {
                this.countingY++;
            }
            if (c == 'g') {
                this.countingG++;
            }
            if (c == 'b') {
                this.countingB++;
            }
            if (c == 'i') {
                this.countingI++;
            }
            if (c == 'v') {
                this.countingV++;
            }

        }

    }
 
      //Here we count and add our number of  clues
 public void addClues()
 {
        //reset clues
     this.clueCounter = 0;
     
     
     // algorithm that counts clues for R color
     if (this.countingR >= 1 && this.computerPatchR == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingR >= 2 && this.computerPatchR == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingR >= 3 && this.computerPatchR == 3) {

         this.clueCounter = this.clueCounter + 3;
     }

               
     // algorithm that counts clues for O color
     if (this.countingO >= 1 && this.computerPatchO == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingO >= 2 && this.computerPatchO == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingO >= 3 && this.computerPatchO == 3) {

         this.clueCounter = this.clueCounter + 3;
     }

        
     // algorithm that counts clues for Y color
     if (this.countingY >= 1 && this.computerPatchY == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingY >= 2 && this.computerPatchY == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingY >= 3 && this.computerPatchY == 3) {

         this.clueCounter = this.clueCounter + 3;
     }

       
     // algorithm that counts clues for G color
     if (this.countingG >= 1 && this.computerPatchG == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingG >= 2 && this.computerPatchG == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingG >= 3 && this.computerPatchG == 3) {

         this.clueCounter = this.clueCounter + 3;
     }
        

        
     // algorithm that counts clues for B color
     if (this.countingB >= 1 && this.computerPatchB == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingB >= 2 && this.computerPatchB == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingB >= 3 && this.computerPatchB  == 3) {

         this.clueCounter = this.clueCounter + 3;
     }

        
     // algorithm that counts clues for I color
     if (this.countingI >= 1 && this.computerPatchI == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingI >= 2 && this.computerPatchI == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingI >= 3 && this.computerPatchI == 3) {

         this.clueCounter = this.clueCounter + 3;
     }

        
     // algorithm that counts clues for V color
     if (this.countingV >= 1 && this.computerPatchV == 1) {
         this.clueCounter = this.clueCounter + 1;

     } else if (this.countingV >= 2 && this.computerPatchV == 2) {

         this.clueCounter = this.clueCounter + 2;
     } else if (this.countingV >= 3 && this.computerPatchV == 3) {

         this.clueCounter = this.clueCounter + 3;
     }

     
      System.out.println("counting color of R is: " + this.countingR);
     System.out.println("counting color of O is: " + this.countingO);
     System.out.println("counting color of Y is: " + this.countingY);
     System.out.println("counting color of G is: " + this.countingG);
     System.out.println("counting color of B is: " + this.countingB);
     System.out.println("counting color of I is: " + this.countingI);
     System.out.println("counting color of V is: " + this.countingV);
     System.out.println("clueConter: " + this.clueCounter);

     //Reset counters
     this.countingR = 0;
     this.countingO = 0;
     this.countingY = 0;
     this.countingG = 0;
     this.countingB = 0;
     this.countingI = 0;
     this.countingV = 0;
     
     this.computerPatchR = 0;
     this.computerPatchO = 0;
     this.computerPatchY = 0;
     this.computerPatchG = 0;
     this.computerPatchB = 0;
     this.computerPatchI = 0;
     this.computerPatchV = 0;

 }



    public int getClueCounter() {
        return clueCounter;
    }
        
 
 
         
}
