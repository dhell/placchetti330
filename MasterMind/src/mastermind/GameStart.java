package mastermind;

/** The Mastermind class represents a text-based version of the Mastermind game
 * authors Lizzie Greene, David Heller, and Sean Placchetti
 * @version 1.0
 */

// import classes
import java.util.*;
import java.io.*;
import java.lang.*;

public class GameStart {
        private static int elements, givenRounds;
        private static char[] codeSplit, beta, gamma;
        private static String alpha,lambda;
        private static char[] readCode() {
		// this allows a player to type the code without the other seeing it
		Console console = System.console();
    		System.out.println("Enter code:");
    		return console.readPassword();
	}
    /** runs the game */
	public static void gameStart(){
                
		alpha = "abcdefghijklmnopqrstuvwxyz";
                beta = alpha.toCharArray();
                Scanner in = new Scanner(System.in);   
		//need to check if below 26 and above 0
		System.out.println("Enter amount of elements: ");
		elements = in.nextInt();
                gamma = java.util.Arrays.copyOfRange(beta, 0, elements);
		lambda = new String(gamma);
		//need to check if above 0
		System.out.println("Enter number of rounds: ");
		givenRounds = in.nextInt();
		//need to check if 4 letters that are included in number of elements
		//can't be Z in code if number of elements is 20
                System.out.println("Please enter the code below and ");
                System.out.println("be sure the code contains the");
                System.out.println("following characters:"+lambda+"");
		// get the code from one of the players	
		codeSplit = readCode();
		if(InputChecker.alpha(gamma, codeSplit)){
                    CodeBreaker.codeBreaker(codeSplit,givenRounds,lambda);
                } else {
                    System.out.println("You must chose from the pool of letters, try again.");
                    gameStart();	
                }	
		// lets one of the players guess the code
	}
}
