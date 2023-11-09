// Joe Claborn
import java.util.Scanner;

public class Trivia_Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*        
        
        Step 1: Set the amountCorrect variable = 0 since no questions have been asked yet
        
        Step 2-5: Ask the user the questions throughout the trivia game,
        if they get one correct, add + 1 to amountCorrect(the amount of questions the user got correct so far)
        
        Step 6: Take the variable amountCorrect and divide it by 5 to get the amount of questions the user got correct
        divided by the total amount of questions. This gives us the total score overall
        
        Step 7: Take the total score from Step 6 and put it into a roundedScore variable
        that will then take that score and times it by 100 to make it a whole number
        
        Step 8: Output the final result to the user and use typecasting to turn the roundedScore variable
        into an (int)

        */

        // amountCorrect is = to the amount the user got correct 
        // set variable amountCorrect = to 0 to start off with because no questions have been asked yet
        int amountCorrect = 0;
        
        // ask user when Spider-Man Homecoming released
        System.out.print("When did Spider-Man Homecoming release to theaters?");
        int userAnswer1 = input.nextInt();
        
        // skip the <enter> that comes after the user input
        // reference for where I found the answer to this
        // https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
        input.nextLine();

        // range +/- 2 for the year the movie came out
        if(userAnswer1 >= 2015 && userAnswer1 <= 2019) {
            System.out.println("Correct!");
            // do amountCorrect + 1 for each answer that is correct to increase the value of amountCorrect by 1 for each correct answer
            amountCorrect = amountCorrect + 1;
        } else {
            System.out.println("Incorrect");
        }
        
        // ask user where Houston is located in the U.S
        System.out.print("Where is Houston located in the United States?");
        String userAnswer2 = input.nextLine();
        String answer2 = "Texas";

        // use the compareToIgnoreCase to ignore if the answer is in lower case and still give the correct output
        if(userAnswer2.compareToIgnoreCase(answer2) == 0) {
            System.out.println("Correct!");
            // do amountCorrect + 1 for each answer that is correct to increase the value of amountCorrect by 1 for each correct answer
            amountCorrect = amountCorrect + 1;
        } else {
            System.out.println("Incorrect");
        }

        // ask user how many teams are in the NFL
        System.out.print("How many teams are there in the NFL?");
        int userAnswer3 = input.nextInt();
        int answer3 = 32;

        if(userAnswer3 == answer3) {
            System.out.println("Correct!");
            // do amountCorrect + 1 for each answer that is correct to increase the value of amountCorrect by 1 for each correct answer
            amountCorrect = amountCorrect + 1;
        } else {
            System.out.println("Incorrect");
        }

        // ask user how many states are in the U.S
        System.out.println("How many states are in the United States?");
        int userAnswer4 = input.nextInt();
        int answer4 = 50;

        if(userAnswer4 == answer4) {
            System.out.println("Correct!"); 
            // do amountCorrect + 1 for each answer that is correct to increase the value of amountCorrect by 1 for each correct answer
            amountCorrect = amountCorrect + 1;
        } else {
            System.out.println("Incorrect");
        }

        // ask user how many teams are in the MLB
        System.out.println("How many teams are there in the MLB?");
        int userAnswer5 = input.nextInt();
        int answer5 = 30;

        if(userAnswer5 == answer5) {
            System.out.println("Correct!");
            // do amountCorrect + 1 for each answer that is correct to increase the value of amountCorrect by 1 for each correct answer
            amountCorrect = amountCorrect + 1;
        } else {
            System.out.println("Incorrect");
        }

        // do amountCorrect(amount of questions correct) / 5(total amount of questions asked) in the form of a double
        // to get the decimal number of amount correct
        double score = (double) amountCorrect / 5;

        // convert the number that was got in the "score" variable and * it by 100
        // to get the number as a whole number with a decimal place
        double roundedScore = score * 100;

        // output the final result to the user of what their final score was out of 5, and type cast
        // "int" in front of the roundedScore varialbe to get that number as a whole number(integer)
        // to output as a % value
        System.out.println("Your score is " + amountCorrect + " out of 5 which is " + (int) roundedScore + "%");

        // close the user input to end the game
        input.close();
    }
}