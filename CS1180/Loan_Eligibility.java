// Joe Claborn
import java.util.Scanner;

public class Loan_Eligibility {
    public static void main(String[] args) {
        /*
            Step 1: Ask user the loan amount

            Step 2: Ask user the down payment amount

            Step 3: Ask user how long they've been in their current job

            Step 4: Ask user their annual income

            Step 5: Calculate if the person is eligible for the loan or not
            based on their given inputs

            Step 6: Output if the user is eligible for the loan or not
        */
        Scanner input = new Scanner(System.in);
        
        // asks user for the loan amount they wish to be granted
        System.out.print("What is the loan amount?");
        int loanAmount = input.nextInt();

        // asks user what their down payment value will be
        System.out.print("What is the down payment?");
        int downPayment = input.nextInt();

        // skips the <enter> key input after the String input for the previous question
        input.nextLine();

        // asks user if they've held their current job for a minimum of 1 year
        System.out.print("Have you held your current job for at least a year?");
        String job = input.nextLine();

        // asks the user what their annual salary is at their current job
        System.out.print("What is your annual salary?");
        int annualSalary = input.nextInt();

        // skips the <enter> key input after the String input for the previous question
        input.nextLine();
        
        // the calculation with || and && operators to figure out if the user is eligible for the loan or not
        if(downPayment >= loanAmount * .20 || job.equalsIgnoreCase("yes") && annualSalary >= loanAmount / 2) {
            System.out.println("You are eligible for this loan.");
        } else {
            System.out.println("You are not eligible for this loan.");
        }
        input.close();
    }
}