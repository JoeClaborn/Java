// Joe Claborn
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A_File_Is_Worth_Many_Words {

	public static void main(String[] args) throws Exception {
		// assign newFile and wordCountFile to be undefined for use of initalization to
		// output
		// each method
		File newFile;

		Scanner input = new Scanner(System.in);
		// prompt user for the name of the file
		System.out.print("What is the name of the file? ");
		// take the user's input into the file name
		String fileName = input.nextLine();
		// prompt user for what they want to print for the file
		System.out.print("What would you like to print to the file? ");
		// take the user's input into the file for
		// what they want to print to it
		String s = input.nextLine();

		// check if the file name contains .txt
		// if it does not, add .txt to the file name
		if (!fileName.contains(".txt")) {
			fileName += ".txt";
		}

		// call the writeText method
		newFile = writeText(fileName, s);

		// call the wordCount method
		int wordCountFile = countWords(newFile);
		System.out.println(fileName + " contains " + wordCountFile + " word(s).");
		input.close();
	}

	public static File writeText(String filename, String s) throws FileNotFoundException {
		File fileName = new File(filename);
		PrintWriter pw = new PrintWriter(fileName);
		pw.print(s);
		pw.close();
		return fileName;
	}

	public static int countWords(File f) throws FileNotFoundException {		
		// initalize the variable wordCount to 0
		int wordCount = 0;

		// read in the file that the user named in main and the string that was read in from
		// the user in main
		Scanner fileReader = new Scanner(f);
		// loop to run for while there is a whitespace, increase the total
		// amount of words by 1 each time
		// keep a running total of the amount of words

		while (fileReader.hasNext()) {
			fileReader.next();
			wordCount++; 
		}
		fileReader.close();
		return wordCount;
	}
}