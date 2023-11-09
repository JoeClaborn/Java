// Joe Claborn
package PracticeProblems;

import java.util.Scanner;

public class Prime_Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // set foundPrimes = 0 so that it can be +1, until it == n
        int foundPrimes = 0;

        // set testNum =2, where 2 is the starting point for n to be % by increasing by 1
        int testNum = 2;
        
        // prompt the user for the amount of prime numbers they want to see(variable n)
        System.out.print("What is the value of n: ");
        int n = input.nextInt();
        if(n < 0) {
            System.out.println("Error: n cannot be negative.");
            System.exit(0);
        }

        // while 2 to infinity
        while(foundPrimes < n) {
        
        // test 2 to infinity inside calculator
        // the <= sign makes it to where the calculator is no longer offest by 1
        // counter++ makes the counter number go up +1 each loop time
            for(int counter = 2; counter <= testNum; counter++) {
                if(testNum == 2 ) {
                    foundPrimes++;
                    System.out.print(testNum + " ");
                    //System.out.println(testNum + " is a prime number.");
                    //  2 is a prime
                } else if(testNum != counter &&
                            testNum % counter == 0) {
                    //System.out.print(testNum + " is not a prime number.");
                    break;
                } else {
            // If calculator says "is prime"
            // foundPrimes++;
            // System.out.print("");
                    if(testNum == counter) {
                        foundPrimes++;
                        System.out.print(testNum + " ");
                        //System.out.println(testNum + " is a prime number.");
                    }
                }
            }
            testNum++;  // starts at 2 --> infinity
            input.close();
        }
    }
}