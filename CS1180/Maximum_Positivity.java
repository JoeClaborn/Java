// Joe Claborn
import java.io.File;
import java.util.Scanner;

public class Maximum_Positivity {
	public static void main(String[] args) throws Exception {

		// create a scanner to read in the file
		Scanner in = new Scanner(new File("test.txt"));

		// read in the rows from the file's array
		int rows = in.nextInt();
		// read in the columns from the file's array
		int cols = in.nextInt();

		// create a multi-dimensional array that takes in the amount of rows and columns
		// from the array within the file read
		char[][] arr = new char[rows][cols];

		// iterate through both the rows and columns of the array and find the character at each index
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = in.next().charAt(0);
			}
		}

		// set counter and newCounter to 0
		int counter = 0;
		int newCounter = 0;

		// iterate through the rows of the array in the file
		for (int i = 0; i < rows; i++) {
			// reset counter to 0 after each iteration of a row
			counter = 0;
			// iterate throguh the columns of the array within the file
			for (int j = 0; j < cols; j++) {
				// if the index within the row or column equal a '+', then add one to the counter
				if (arr[i][j] == '+') {
					counter++;
					// if the counter is greater than the previous counter was, then set the old counter to the new one
					if (counter > newCounter) {
						newCounter = counter;
					}
				}
			}
		}
		// print out what the greatest amount of '+' in a row are
		System.out.print("The output is: " + newCounter);
	}
}