package mastermind;

/** The Mastermind class represents a text-based version of the Mastermind game
 * authors Lizzie Greene, David Heller, and Sean Placchetti
 * @version 1.0
 */

// import classes
import java.util.*;
import java.io.*;

public class CodeChecker {
    /** checks to see if the player's guess was right
 	* @param codeSplit The character array containing the current code inputed by one of the players
 	* @param guessSplit The character array containing the current guess inputed by one of the players
 	*/
        private static int partialCount, exactCount;
          
	public static void codeChecker(char[] codeSplit, char[] guessSplit){
                exactCount = 0;
		partialCount = 0;
		
		//checks for exact spots
		for(int i = 0; i < 4; i++){
			if(guessSplit[i] == codeSplit[i]){
				exactCount = exactCount + 1;
			}
			//checks for partial spots
			for(int j = 0; j < 4; j++){
				if(guessSplit[i] == codeSplit[j]){
					partialCount = partialCount + 1;
				}
			}
		}
		
		// check sto see if the player has guessed correctly	
		if(exactCount == 4){
			System.out.println("You've guessed correctly!");
			System.exit(0);
		}else{
			System.out.printf("You have %d exactly correct\n",exactCount);
			System.out.printf("You have %d partially correct\n",partialCount-exactCount);
		}
	}

   // CodeChecker(char[] codeSplit, char[] guessSplit) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
}
