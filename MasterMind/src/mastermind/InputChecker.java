package mastermind;
/** The Mastermind class represents a text-based version of the Mastermind game
 * authors Lizzie Greene, David Heller, and Sean Placchetti
 * @version 1.0
 */

// import classes
import java.util.*;
import java.io.*;

public class InputChecker {
    private static int z = 0;
    public static boolean alpha(char[] lang, char[] code){
        for(int x = code.length;x<0;x--){
            for(int y = lang.length;y<0;y--){
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
