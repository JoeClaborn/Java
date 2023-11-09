// Joe Claborn
import java.util.Scanner;

public class Every_Nth_Item {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// creates an array with 10 values
		int[] arr = new int[10];
		System.out.print("The array contains ");
		// runs through the index of the array until the length(which is 10)
		for (int i = 0; i < arr.length; i++) {
			// takes the arrays index and sets the values to random numbers between
			// 1 and 20
			arr[i] = (int) (Math.random() * 20) + 1;
			System.out.print(arr[i] + " ");
		}

		System.out.println();
		// prompt the user for a number between 1 and 10
		// to pull out the value of n that they give from
		// the arrays index in each spot
		System.out.print("What is the value of N? ");
		int n = input.nextInt();

		// run through the index of the array again
		for (int i = 0; i < arr.length; i++) {
			// check the divisibility of the index based on n to give the value within the index\
			// of the array that needs to be displayed
			if ((i + 1) % n == 0) {
				System.out.print(arr[i] + " ");
			}
		}

		// check if n is an acceptable value(a value between 1 and 10)
		if (n < 1 || n > 10) {
			// if the value is not between 1 and 10, display an error message
			System.out.println("Error: the value must be between 1 and 10");
		}
	input.close();
	}
}