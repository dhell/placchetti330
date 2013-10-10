package mastermind;
/** The Mastermind class represents a text-based version of the Mastermind game
 * authors Lizzie Greene, David Heller, and Sean Placchetti
 * @version 1.0
 */

// import classes
import java.util.*;
import java.io.*;
import java.lang.*;

public class InputChecker {
    private static int z = 0;
    /**
     *
     * @param lang
     * @param code
     * @return
     */
    public static boolean alpha(char[] lang, char[] code){
        for(int x=0;x<code.length;x++){
            for(int y=0;y<lang.length;y++){
                if(code[x] == lang[y]){
                    z++;
                }
            }
        }
        if(z == 4){
            return true;
        } else {
            return false;
        }
    }
}
