package m.stermind;
/** The Mastermind class represents a text-based version of the Mastermind game
 * authors Lizzie Greene, David Heller, and Sean Placchetti
 * @version 1.0
 */

// import classes
import java.util.*;
import java.io.*;

public class CodeBreaker {
    /** ask the player for their guess, and checks the number of rounds left  
 	* @param codeSplit The character array containing the current code inputed by one of the players
	* @param givenRounds The number of times a player can guess the arrangment of letters in the code  
	*/ 
	
	public static void codeBreaker(char[] codeSplit,int givenRounds) {
		// get the guess from one of the players
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter your guess: ");
		String guess = in.next();
		char[] guessSplit = guess.toCharArray();
		
		// if rounds reach 0 exit else check the code and have the breaker guess again
		if(givenRounds == 1){
			System.out.println("You've run out of rounds!");
			System.exit(0);
		}else{
                        CodeChecker.codeChecker(codeSplit, guessSplit);
			codeBreaker(codeSplit,givenRounds-1);
			}
		}
}
