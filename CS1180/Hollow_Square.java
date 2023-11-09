// Joe Claborn

package Java.PracticeProblems;
import java.util.Scanner;


public class Hollow_Square {
public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // ask user for the height that they wish
        System.out.print("Enter Height: ");
        // take the user input
        int height = input.nextInt();
        // ask user for the character they wish to use
        System.out.print("Enter Character: ");
        // take the user input for the char they want to use
        char character = input.next().charAt(0);
        // run from the method and print into the terminal what they square looks like
        // based on the height the user entered and the char they wanted to use for the square
        square(height, character);
    }
    
    public static void square(int height, char character) {
        // this loop creates the hollow square that we want to have
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < height; j++) {
                if(i == 0 || i == height-1 || j == 0 || j == height-1) {
                System.out.print(character + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }
    }
}