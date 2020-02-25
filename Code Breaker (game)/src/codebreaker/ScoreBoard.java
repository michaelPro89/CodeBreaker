

package codebreaker;

/**
 *
 * @author Michal Switala
 */
class ScoreBoard extends randomGenerator {

    //Here we have all data output needed for Score Board to display
    private String[] code = new String[PATCH_LENGTH];
    private  String[] userQuess = new String[PATCH_LENGTH];
    private int clues;
    private int lifes;

    //Methods
     public int getLifes() {

        return lifes;
    }

     public String [] getCode(){
         
         return this.code;
     }
     
    public String getLifesAsString() {

        Integer lifes = getLifes();
        String lifes2 = lifes.toString();

        return lifes2;
    }
    
    public String getCluesAsString() {

        Integer clues = getClues();
        String clues2 = clues.toString();

        return clues2;
    }
    public String getCodeAt(int index) {
        return this.code[index];
    }

    public void setCodeAt(int index, String color) {
        this.code[index] = color;
    }

    public void removeLife(int lifes) {
        this.lifes = this.lifes - lifes;
    }

    public int getClues() {
        return clues;
    }

    public String getUserQuessAt(int index) {
        return userQuess[index];
    }

    public void resetScoreBoard(int lifes, int clues, String code, String userQuess) {
        // assign blank values to displayed  code
        for (int x = 0; x < this.code.length; x++) {

            this.code[x] = code;

            System.out.println(this.code[x]);

        }
        // assign blank values to displayed  userQuess
        for (int x = 0; x < this.userQuess.length; x++) {

            this.userQuess[x] = userQuess;

        }
        // assign blank values to Clues
        this.clues = clues;
        this.lifes = lifes;

    }

    public void setClues(int clues) {
        this.clues = clues;
    }
    
   public void setLifes(int lifes) {
        this.lifes = lifes;
    }
    public void setUserQuessAt(int index, String userQuess) {
        this.userQuess[index] = " " + userQuess;
    }

}
