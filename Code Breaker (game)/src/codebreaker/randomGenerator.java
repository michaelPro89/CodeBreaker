
package codebreaker;


import java.security.SecureRandom;

/**
 * Code breaker is a game where you have to quess the randomly generated code before you run out of lives.
 * 
 * @author Michal Switala
 * Copyright © 2021 belongs solely to Michal Switala.
 *
 * You can reach me out on : https://github.com/michaelPro89
 */
class randomGenerator 
{
    
        //Here we have our array of available colors
        final String [  ] ARRAY_OF_COLORS  = {"R","O","Y","G","B","I","V"};
        //Here we have stored length of our code to be quessed
        final public  int PATCH_LENGTH= 4;
        final private String [  ] computerPatch = new String [this.PATCH_LENGTH];
        private SecureRandom numberGenerator = new SecureRandom(); 
	
        //Constructor
        randomGenerator()        {      }

        // Methods
        public String [ ] getNumbers() 
                
	{
                    
                                  int randomNumber;

                        for (int x=0; x<this.computerPatch.length; x++) 
                        {
                            randomNumber = numberGenerator.nextInt(this.ARRAY_OF_COLORS.length);
                        	
                            this.computerPatch[x] = this.ARRAY_OF_COLORS[randomNumber];

                        System.out.println(this.computerPatch[x]);
                        }
                	
	return this.computerPatch;
	} 
        
        public String getComputerPatchAt(int index)
        {
            return this.computerPatch[index];
        }
            public String [] getComputerPatch()
        {
            return this.computerPatch;
        }
        
}
