package mastermind;
/** The Mastermind class represents a text-based version of the Mastermind game
 * authors Lizzie Greene, David Heller, and Sean Placchetti
 * @version 1.0
 */

// import classes
import java.util.*;
import java.io.*;
import java.lang.*;

public class CodeBreaker {
    /** ask the player for their guess, and checks the number of rounds left  
 	* @param codeSplit The character array containing the current code inputed by one of the players
	* @param givenRounds The number of times a player can guess the arrangment of letters in the code  
	*/ 
	private static char[] guessSplit, gamma;
        private static String guess;
        private static int q;
	public static void codeBreaker(char[] codeSplit,int givenRounds,String Alphabet) {
		// get the guess from one of the players
		Scanner in = new Scanner(System.in);
                System.out.println("Character Pool: "+Alphabet+"");
		System.out.println("Enter your guess: ");
		q = 0;
                guess = in.next();
		// if rounds reach 0 exit else check the code and have the breaker guess again
                for(int t=0;t<Alphabet.length();t++){
                    for(int m=0;m<guess.length();m++){
                        if(guess.charAt(m)==Alphabet.charAt(t)){
                            q++;
                        }
                    }
                }
                guessSplit = guess.toCharArray();
                if(q != 4){
                        System.out.println("You've used characters not included in the pool, try again.");
                        codeBreaker(codeSplit,givenRounds,Alphabet);
                }else if(givenRounds == 1){
			System.out.println("You've run out of rounds!");
			System.exit(0);
		}else{
                        CodeChecker.codeChecker(codeSplit, guessSplit);
			codeBreaker(codeSplit,givenRounds-1,Alphabet);
		}
	}
}
