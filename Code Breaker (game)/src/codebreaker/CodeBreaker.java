
package codebreaker;

/**
 * Code breaker is a game where you have to quess the randomly generated code before you run out of lives.
 * 
 * @author Michal Switala
 * Copyright © 2021 belongs solely to Michal Switala.
 */

class CodeBreaker {


    
    public static void main(String args[]) {
          
        //Data & Objects
      
        OutputWindow outWindow = new OutputWindow("The Code Breaker V20");       
        InputWindow inWindow = new InputWindow("The Code Breaker V20");
        PlayerInput playerIn = new PlayerInput();
        GameLogic gLogic = new GameLogic();
        GameRules gameRules = new GameRules();
        ScoreBoard scoreBoard = new ScoreBoard();
        randomGenerator rg = new randomGenerator();
        InputValidator inputValid = new InputValidator();


        
        outWindow = gLogic.showOutputWindow(outWindow);
        outWindow = gLogic.showRules(outWindow, gameRules);
        outWindow = gLogic.askForGame(outWindow, "Do you want to start a game ?");

        while (gameRules.isGameStart()) {
            
           
            //Generate code patch to quess
            rg = gLogic.generateNumbers(rg);
            //Reset scoreboard 
            gLogic.resetScoreBoard(scoreBoard, gameRules);
            //display our score board and show input window
            gLogic.setScoreBoard(inWindow, scoreBoard);
            inWindow = gLogic.showInputWindow(inWindow);

           
            while (scoreBoard.getLifes() > 0) {
                // This code passes method  "waitForPlayerInput" of class inWindow, as parameter and this method returns player input
                //as string variable  which than is returned inside PlayerInput.setPlayerInput and stored inside PlayerInput.playerInput
                playerIn = gLogic.setInput(playerIn, inWindow, "Please enter your 4 code quess below:  ");
                // Now check player input here
                inputValid.readyToCheck = true;
                
                while (inputValid.readyToCheck) {
                    
                    //Check player input here and make sure player input has 4 letters atleast 
                    gLogic.checkLength(playerIn, inputValid);
                    while(inputValid.inputIsNot4Letters)
                    {     
                        playerIn = gLogic.setInput(playerIn, inWindow, "Your quess has to be 4 characters length. Try again.");
                        gLogic.checkLength(playerIn, inputValid);
                    }
                  
                    gLogic.checkColors(playerIn, inputValid, rg);
                    gLogic.checkDuplications(playerIn, inputValid);

                    // If player input contains invalid input, then its gonna display a proper message to the player indicating what is wrong 
                    if (inputValid.inputHasInvalidColors) {
                        playerIn = gLogic.setInput(playerIn, inWindow, "Following colors are allowed:  R,O,Y,G,B,I,V. Try again.");
                    } else if (inputValid.inputIsDuplicate) {
                        playerIn = gLogic.setInput(playerIn, inWindow, "Input '" + inputValid.getCheckInputAt(0).toUpperCase() + " "
                                + inputValid.getCheckInputAt(1).toUpperCase() + " " + inputValid.getCheckInputAt(2).toUpperCase() + " "
                                + inputValid.getCheckInputAt(3).toUpperCase() + "' is duplicated. Please try again.");

                    } //If player input is correct than change readyToCheck boolean to false
                    else if (!inputValid.inputIsNot4Letters && !inputValid.inputHasInvalidColors && !inputValid.inputIsDuplicate) {

                        //If input is valid, break the loop
                        inputValid.readyToCheck = false;
                    }

                    //change to false all of our checking-booleans
                    inputValid.inputHasInvalidColors = false;
                    inputValid.inputIsDuplicate = false;

                }

                playerIn = gLogic.saveToStoredInputs(playerIn, inputValid);
                gLogic.setQuessedCode(rg, inputValid, scoreBoard, playerIn);
                gLogic.setUserQuess(scoreBoard, inputValid);
                
                //Check clues and add them into scoreBoard
                gLogic.checkClues(inputValid, scoreBoard, rg);
                gLogic.countColors(inputValid,rg,scoreBoard);
                gLogic.addClues(inputValid, scoreBoard);

                //Check if player quessed the code here or lost all lifes
                gLogic.isWin(inputValid, rg, inWindow, playerIn, scoreBoard, gameRules);
                gLogic.isLoose(rg, scoreBoard, inWindow, gameRules);
                            
                // ask for a new game
                if (gameRules.isCodeQuessed() || gameRules.isGameLoose()) {

                    gLogic.playAgain(playerIn, inWindow, inputValid, scoreBoard, gameRules);
                } else {

                    inWindow.nextLine();
                    gLogic.setScoreBoard(inWindow, scoreBoard);

                }

            }

        }

      
    }

}
