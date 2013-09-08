/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Sean Placchetti
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) {
    String first = "Bob";
    String last = "Smith";
    String full = first + " " + last;
    System.out.println("Hello " + full + "!");
    System.out.print("Your name has ");
    System.out.print(first.length( ) + last.length( ));
    System.out.println(" letters.");
  }
}
