// Joe Claborn
package Java.Labs;

import java.util.Scanner;

public class Simon_Says {

    public static Scanner input = new Scanner(System.in);
    public static String diffInput;
    public static String playAgain;
    public static int digitInput;
    public static int randNum;

    public static void main(String[] args) throws Exception {
    /*  To Do List:
        1. Prompt the user for the difficulty level of their choice
        2. Take in their input
        3. Output to each method correspondent to the difficulty the user chose
        4. Have Simon say the sequence it is asking
        5 Create 2000 lines of blank code to clear screen
        6 Use Thread.sleep(2000) to pause the console for 2 seconds
        7. Take the user input as the response to the sequence Simon said
        8. If user is correct, have Simon say they were correct, add 1 to their total for the round, then have Simon say another sequence
        adding one more color, digit, or character to it each round
        9. If the user input is wrong, have Simon tell the user they were incorrect, print out their score for the round
        and ask if they want to play again
        10. If user wants to play again, repeat steps 1-8 or 1-9(depending on if they were correct or incorrect respectively)
        11. If the user does not wish to play again, have Simon tell the user "Ok, goodbye!"
        12. Lastly, use System.exit(0) to exit out of the game
    */

        // start loop here
        while (true) {
            int score = 0;

            System.out.print("What difficulty level do you want: easy, medium, or hard? ");
            diffInput = input.nextLine();

            // If user inputs something that isn't a difficulty have them pick again
            while (!diffInput.equalsIgnoreCase("easy") && !diffInput.equalsIgnoreCase("medium")
                    && !diffInput.equalsIgnoreCase("hard")) {
                if (!diffInput.equalsIgnoreCase("easy") || !diffInput.equalsIgnoreCase("medium") 
                    || !diffInput.equalsIgnoreCase("hard")) {
                    System.out.println("That is not a valid difficulty level!");
                    System.out.print("What difficulty level do you want: easy, medium, or hard? ");
                    diffInput = input.nextLine();
                }
            }
            // If user picks easy difficulty
            if (diffInput.equalsIgnoreCase("easy")) {
                score = easy(score);
                // If user picks medium difficulty
            } else if (diffInput.equalsIgnoreCase("medium")) {
                score = medium(score);
            }
            // If user picks hard difficulty
            if (diffInput.equalsIgnoreCase("hard")) {
                score = hard(score);
            }
            // down here, you can ask if they want to play again
            System.out.print("Do you want to play again (yes or no)? ");
            playAgain = input.nextLine();
            while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
                if (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no"))
                System.out.println("That is not a valid answer!");
                System.out.print("Do you want to play again (yes or no)? ");
                playAgain = input.nextLine();
            } if (playAgain.equalsIgnoreCase("yes")) {
                continue;
            } else if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Ok, goodbye!");
                break;
                }
            }
        }

    // Method for easy difficulty
    public static int easy(int score) throws Exception {
        String sequence = "";
        String user = "";

        while (true) {
            // generate random number between 1 and 3
            randNum = (int) ((Math.random() * 3) + 1);
            if (randNum == 0) {
                sequence += "red";
            } else if (randNum == 1) {
                sequence += "blue";
            } else if (randNum == 2) {
                sequence += "green";
            } else if (randNum == 3) {
                sequence += "yellow";
            }
            // add this random number onto the sequence
            sequence += " ";
            System.out.println("Simon says: " + sequence); // say the whole sequence

            // Use this to make the program pause for 2 seconds between the simon says and
            // user input
            Thread.sleep(2000);
            // This creates 200 blank lines that clear the console before the user puts in their
            // answer to what Simon said(creates the memory part of the game)
            for (int i = 0; i < 200; i++) {
                System.out.println();
            }
            System.out.print("Input: ");
            user = input.nextLine(); // read in their guess as a String into "user"
            // if user is equal to sequence, print out that they were correct
            // and add 1 to their total score
            // use "replace" to ignore spaces that the user does not input in their response
            if (user.replace(" ", "").equalsIgnoreCase(sequence.replace(" ", ""))) {
                score++;
                System.out.println("Right! Your score is " + score + ".");
                // If the user was wrong tell them they were wrong and output
                // the amount they got correct for the round
            } else {
                System.out.println("Incorrect! Your score for this round was " + score + ".");
                // initialize the counter for amount correct back to 0 if the user was incorrect at the end of the round
                // break out of the loop if the user is incorrect
                break;
            }
        }
        return score;
    }
    // Method for medium difficulty
    public static int medium(int score) throws Exception {
        String sequence = "";
        String user = "";

        while (true) {
            // generate random number between 1 and 9
            randNum = (int) ((Math.random() * 9) + 1);
            // add this random number onto the sequence
            sequence += randNum + " ";
            System.out.println("Simon says: " + sequence); // say the whole sequence

            // Use this to make the program pause for 2 seconds between the simon says and
            // user input
            Thread.sleep(2000);
            // This creates 200 blank lines that clear the console before the user puts in their
            // answer to what Simon said(creates the memory part of the game)
            for (int i = 0; i < 200; i++) {
                System.out.println();
            }
            System.out.print("Input: ");
            user = input.nextLine(); // read in their guess as a String into "user"
            // if user is equal to sequence, print out that they were correct
            // and add 1 to their total score
            // use "replace" to ignore spaces that the user does not input in their response
            if (user.replace(" ", "").equalsIgnoreCase(sequence.replace(" ", ""))) {
                score++;
                System.out.println("Right! Your score is " + score + ".");
                // If the user was wrong tell them they were wrong and output
                // the amount they got correct for the round
            } else {
                System.out.println("Incorrect! Your score for this round was " + score + ".");
                // initialize the counter for amount correct back to 0 if the user was incorrect at the end of the round
                // break out of the loop if the user is incorrect
                break;
            }
        }
        return score;
    }
    // Method for hard difficulty
    public static int hard(int score) throws Exception {
        String sequence = "";
        String user = "";

        while (true) {
            // generate random number between 1 and 26
            randNum = (int) ((Math.random() * 25) + 1);
            char letter = 'a';
            letter = (char) (letter + randNum);
            // add this random number onto the sequence
            sequence += letter + " ";
            System.out.println("Simon says: " + sequence); // say the whole sequence

            // Use this to make the program pause for 2 seconds between the simon says and
            // user input
            Thread.sleep(2000);
            // This creates 200 blank lines that clear the console before the user puts in their
            // answer to what Simon said(creates the memory part of the game)
            for (int i = 0; i < 200; i++) {
                System.out.println();
            }
            System.out.print("Input: ");
            user = input.nextLine(); // read in their guess as a String into "user"
            // if user is equal to sequence, print out that they were correct
            // and add 1 to their total score
            // use "replace" to ignore spaces that the user does not input in their response
            if (user.replace(" ", "").equalsIgnoreCase(sequence.replace(" ", ""))) {
                score++;
                System.out.println("Right! Your score is " + score + ".");
                // If the user was wrong tell them they were wrong and output
                // the amount they got correct for the round
            } else {
                System.out.println("Incorrect! Your score for this round was " + score + ".");
                // initialize the counter for amount correct back to 0 if the user was incorrect at the end of the round
                // break out of the loop if the user is incorrect
                break;
            }
        }
        return score;
    }
}