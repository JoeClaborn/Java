//Joe Claborn
import java.util.Scanner;

public class UpTo100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create variables for the loop
        int runningTotal = 0;
        int userAnswers = -1;

        // run a while loop for if the total is less than 100, add the user inputs together until
        // the inputs add to be greater than 100
        while(runningTotal < 100) {
            System.out.print("Enter a number: ");
            int userNum = input.nextInt();
            // add +1 to userAnswer each time an input is given
            userAnswers++;
            // reset the runningTotal variable to the new amount based on how much is added per input
            runningTotal = runningTotal + userNum;
        }
        // output how many times the user inputted a number until the total was greather than 100
        System.out.println("You entered " + userAnswers + " values before the total was greater than 100.");
        System.exit(0);
        input.close();
    }
}