
package codebreaker;

import java.awt.Desktop;
import java.net.URL;

/**
 *
 * @author Michal Switala
 */
class GameLogic {

    public void resetScoreBoard(ScoreBoard scoreBoard, GameRules gameRules) {
        //Reset lifes, clues ,code and user quess  over here 
        scoreBoard.resetScoreBoard(gameRules.getLifes(), 0, " _ ", " _ ");
    }

    public randomGenerator generateNumbers(randomGenerator rg) {
        rg.getNumbers();
        return rg;
    }

    public void setScoreBoard(InputWindow inWindow, ScoreBoard scoreBoard) {

        inWindow.setLifes(scoreBoard.getLifesAsString()); // we have to pass String overhere instead of int
        inWindow.setClues(scoreBoard.getCluesAsString());  // we have to pass String overhere instead of int
        inWindow.addText("Code:" + " " + scoreBoard.getCodeAt(0) + " " + scoreBoard.getCodeAt(1) + " " + scoreBoard.getCodeAt(2)
                + " " + scoreBoard.getCodeAt(3) + "     " +"Your quess:" + " " + scoreBoard.getUserQuessAt(0) + " " + scoreBoard.getUserQuessAt(1) + " " + scoreBoard.getUserQuessAt(2)
                + " " + scoreBoard.getUserQuessAt(3) + " ");

    }


    public OutputWindow showOutputWindow(OutputWindow outWindow) {
        outWindow.showWindow();
        return outWindow;
    }

    public InputWindow showInputWindow(InputWindow inWindow) {
        inWindow.showWindow();
        return inWindow;
    }

    public OutputWindow showRules(OutputWindow outWindow, GameRules gameRules) {
        outWindow.nextLine();
        outWindow.addText(gameRules.getRules());

        return outWindow;
    }

    public OutputWindow askForGame(OutputWindow outWindow, String question) {
        outWindow.setMessageLabel(question);
        outWindow.waitForDecision();

        return outWindow;
    }

    public PlayerInput setInput(PlayerInput playerIn, InputWindow inWindow, String message) {
        playerIn.setPlayerInput(inWindow.waitForPlayerInput(message));

        return playerIn;
    }

    public void setUserQuess(ScoreBoard scoreBoard, InputValidator inputValid) {
        scoreBoard.setUserQuessAt(0, inputValid.getCheckInputAt(0).toUpperCase());
        scoreBoard.setUserQuessAt(1, inputValid.getCheckInputAt(1).toUpperCase());
        scoreBoard.setUserQuessAt(2, inputValid.getCheckInputAt(2).toUpperCase());
        scoreBoard.setUserQuessAt(3, inputValid.getCheckInputAt(3).toUpperCase());

    }

    public void checkLength(PlayerInput playerIn, InputValidator inputValid) {

        inputValid.checkInputLength(playerIn.getPlayerInput());

    }

    public void checkColors(PlayerInput playerIn, InputValidator inputValid, randomGenerator rg) {
        inputValid.checkColors(playerIn, inputValid, rg);
    }

    public InputWindow showScoreBoard(InputWindow InWindow, String addScoreBoard) {
        return InWindow;
    }

    public void checkDuplications(PlayerInput playerIn, InputValidator inputValid) {
        inputValid.checkDuplicate(playerIn, inputValid);
    }

    public void checkClues(InputValidator inputValid, ScoreBoard scoreBoard, randomGenerator rg) {
        inputValid.checkClues(scoreBoard, rg, inputValid);
    }

    public void countColors(InputValidator inputValid, randomGenerator rg, ScoreBoard sb) {

        inputValid.countPatchColors(rg.getComputerPatch(), sb.getCode());
        inputValid.countCorrectColors();

    }

    public void addClues(InputValidator inputValid, ScoreBoard scoreBoard) {
        inputValid.addClues();
        scoreBoard.setClues(inputValid.getClueCounter());

    }

    public void setQuessedCode(randomGenerator rg, InputValidator inputValid, ScoreBoard scoreBoard, PlayerInput playerIn) {

        for (int x = 0; x < rg.getComputerPatch().length; x++) {

            // If player input match generated comptuer patch - set it as code and print it on scoreboard later on
            if (rg.getComputerPatchAt(x).equalsIgnoreCase(inputValid.getCheckInputAt(x))) {

                String color = rg.getComputerPatchAt(x);
                scoreBoard.setCodeAt(x, color);

            }

        }

    }

    public PlayerInput saveToStoredInputs(PlayerInput playerIn, InputValidator inputValid) {
        // save each player input in array to check duplicates later
        // debug DO IT LATER - MAKE METHOD TO CLEAN ARRAY BEFORE NEW GAME OR USE arraylist instead its more eazzy
        //playerIn.storedPlayerInputs[playerIn.getInputCounter()] = playerIn.getPlayerInput().toUpperCase();
        playerIn.addPlayerQuess(inputValid.getCheckInputAt(0).toUpperCase() + inputValid.getCheckInputAt(1).toUpperCase() + inputValid.getCheckInputAt(2).toUpperCase() + inputValid.getCheckInputAt(3).toUpperCase());
        //debug
        System.out.println("Current added player input to ArrayList is : " + inputValid.getCheckInputAt(0).toUpperCase()
                + inputValid.getCheckInputAt(1).toUpperCase() + inputValid.getCheckInputAt(2).toUpperCase() + inputValid.getCheckInputAt(3).toUpperCase());
        // this method is adding each input count every time
        // playerIn.setInputCounter(1);

        return playerIn;

    }

    //   If player quessed here the code,then print out message, else remove 1 life and place "isLoose" method after this to control lifes amount.
    public void isWin(InputValidator inputValid, randomGenerator rg, InputWindow inWindow, PlayerInput playerIn, ScoreBoard scoreBoard, GameRules gr) {

        if (scoreBoard.getCodeAt(0).equalsIgnoreCase(rg.getComputerPatchAt(0))
                && scoreBoard.getCodeAt(1).equalsIgnoreCase(rg.getComputerPatchAt(1))
                && scoreBoard.getCodeAt(2).equalsIgnoreCase(rg.getComputerPatchAt(2))
                && scoreBoard.getCodeAt(3).equalsIgnoreCase(rg.getComputerPatchAt(3))) {

            inWindow.nextLine();
            // update the score board and display it
            setScoreBoard(inWindow, scoreBoard);
            inWindow.nextLine();
            inWindow.nextLine();
            inWindow.addText("YOU WON!");
            inWindow.nextLine();
            inWindow.addText("The correct code was: " + rg.getComputerPatchAt(0) + " " + rg.getComputerPatchAt(1)
                    + " " + rg.getComputerPatchAt(2) + " " + rg.getComputerPatchAt(3));

                
            // ask for a new game
            gr.setIsCodeQuessed(true);

        } else {
            // if not quessed the code then remove 1 life
            removeLife(scoreBoard, 1);
        }

    }
    
    
    public void openURL(String url, InputWindow inWindow) {
        
        inWindow.nextLine();
        inWindow.nextLine();
        inWindow.addText("- opening exclusive URL for the winner -");
     
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            inWindow.nextLine();
            inWindow.addText("The URL is not in correct format. " + e.toString());

        }
    }

    public void removeLife(ScoreBoard sb, int life) {

        sb.removeLife(life);

    }

    public void playAgain(PlayerInput playerIn, InputWindow input, InputValidator inValidator, ScoreBoard scoreBoard, GameRules gr) {

        playerIn.setPlayerInput(input.waitForPlayerInput("Do you want to play again ? type Yes or No:"));

        // check this and do i later
        while (inValidator.isInputWrong(playerIn.getPlayerInput())) {

            playerIn.setPlayerInput(input.waitForPlayerInput("You have to write either Yes, No or press Exit (Esc). "));

        }

        if (playerIn.getPlayerInput().equalsIgnoreCase("yes") || playerIn.getPlayerInput().equalsIgnoreCase("Yes")) {
            // set lifes to 0 so we can get out of the inner loop and start again the game
            // reset all other stats also
            scoreBoard.setLifes(0);
            input.clearWindow();
            gr.setIsCodeQuessed(false);
            gr.setIsGameLoose(false);
            playerIn.clearStoredQuesses();

        } else {
            System.exit(0);
        }

    }

    public void isLoose(randomGenerator rg, ScoreBoard scoreBoard, InputWindow inWindow, GameRules gr) {
        if (scoreBoard.getLifes() == 0) {

            inWindow.nextLine();
            // update the score board and display it
            setScoreBoard(inWindow, scoreBoard);
            inWindow.nextLine();
            inWindow.nextLine();
            inWindow.addText("YOU LOSE!");
            inWindow.nextLine();
            inWindow.addText("The correct code was: " + rg.getComputerPatchAt(0) + " " + rg.getComputerPatchAt(1)
                    + " " + rg.getComputerPatchAt(2) + " " + rg.getComputerPatchAt(3));

            // ask for a new game
            gr.setIsGameLoose(true);
        }

    }

}
