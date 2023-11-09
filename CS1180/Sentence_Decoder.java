// Joe Claborn
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Sentence_Decoder {
	/*
		TODO:
		Step 1: Read in a sentence from a file
		Step 2: Choose a random sentence from the file
		Step 3: Store the chosen sentence into an array
		Step 4: Create an array for the real alphabet
		Step 5: Permute the alphabet into a new array
		Step 6: Encrypt the sentence read in based on the permuted alphabet
		Step 7: Prompt user if they want to guess a letter(1) or the sentence(2)
		Step 8: Tell the user if they are correct or not based on the letter guess
		Step 9: If the letter guess is correct, replace that letter in the encrypted sentence
		Step 10: If they are incorrect tell the user that
		Step 11: In both cases, repeat step 7
		Step 12: If the user guesses the sentence and is correct, tell them they are correct
		and print out the number of correct and incorrect guesses they had
		Step 13: If they are incorrect on their sentence guess, tell them that
		Step 14: In both cases, ask if the user wants to play again
		Step 15: If the user wants to play again, replay the game in a new round repeating all steps above
		Step 16: If the user does not want to play again, tell them "bye" and exit the game
	*/

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		// creates an arrayList to keep track of encrypted letters guessed
		ArrayList<Character> guessedEncryptedLetters = new ArrayList<>();

		// creates an arrayList to keep track of actual letters guessed
		ArrayList<Character> guessedActualLetters = new ArrayList<>();

		// creates a scanner to read in the file with the sentences
		Scanner in = new Scanner(new File("Sentences.txt"));

		ArrayList<String> sentenceFromFile = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			sentenceFromFile.add(line);
		}

		// sets correct and incorrect to 0
		int correct = 0;
		int incorrect = 0;

		//  THIS IS THE START OF SENTENCE GAME
		while (true) {

			// checks if there are anymore sentences left in the file
			// if there is not, tell the user that and exit the game
			if (sentenceFromFile.size() == 0) {
				System.out.println("There are no more usable sentences!");
				System.exit(0);
			}

			// create a variable that allows for a random sentence to be picked from the file
			int random = (int) (Math.random() * sentenceFromFile.size());

			// print out the random sentence
			String sent = sentenceFromFile.get(random);

			// remove that file from the possible sentences left list
			sentenceFromFile.remove(random);

			// create an array for the normal alphabet
			char[] realAlphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
			
			char[] newAlphabet = new char[realAlphabet.length];

			// run through the new alphabet to find indexs
			for (int i = 0; i < realAlphabet.length; i++) {
				newAlphabet[i] = realAlphabet[i];
			}

			// create an arrayList variable to find the characters within the new alphabet
			ArrayList<Character> temp = new ArrayList<>();

			for (char c : newAlphabet) {
				temp.add(c);
			}

			// shuffle the alphabet that was added to the arrayList
			Collections.shuffle(temp);

			// put each index of letters into the arrayList temp to add those to the index
			// of the arrayList
			for (int i = 0; i < temp.size(); i++) {
				newAlphabet[i] = temp.get(i);
			}
			// print out the shuffled alphabet
			System.out.println(Arrays.toString(newAlphabet));

			String codedSent = "";
			// loop though each character in the sentence and pull out each
			// char from every index and add each of those index to the codedSent
			// then loop through the realAlphabet and for each index within that
			// set it equal to the index of that letter within codedSent based on
			// the newAlphabet 
			for (int i = 0; i < sent.length(); i++) {
				char x = sent.charAt(i);
				if (x == ' ') {
					codedSent += x;
				}
				for (int j = 0; j < realAlphabet.length; j++) {
					if (realAlphabet[j] == x) {
						codedSent += newAlphabet[j];
					}
				}
			}

			while(true) {
				int inputGuess = guess();

				// if the user wants to guess a letter, then call the corresponding method
				if (inputGuess == 1) {
					System.out.print("Encrypted letter? ");
					String encryptedLetter = input.nextLine();
					char encryptedLetterChar = encryptedLetter.charAt(0);

					System.out.print("Actual letter? ");
					String actualLetter = input.nextLine();
					char actualLetterChar = actualLetter.charAt(0);
					
					boolean name = letterGuess(newAlphabet, realAlphabet, guessedEncryptedLetters, guessedActualLetters, encryptedLetterChar, actualLetterChar);
					if (name) {
						correct++;
						codedSent = codedSent.replace(encryptedLetterChar, actualLetterChar);
					} else {
						incorrect++;
					}
					// if the user wants to guess the sentence, then call the corresponding method
				} else if (inputGuess == 2) {
					sentenceGuess(sent, correct, incorrect);
					break;					
				}
			} // End of while - End of current round
			// if keepPlaying method returns value is false, then the game will end
			// if keepPLaying method returns a true value, then the game will restart with a new sentence
			if(!keepPlaying()) {
				break;
			} else {
				correct = 0;
				incorrect = 0;
			}
		} // End of while - End of Game 
	}

	// method for when the user is asked if they want to guess a letter or a sentence
	public static int guess() throws Exception {

		System.out.print("Do you want to 1) guess a letter or 2) guess the sentence? ");
		int guess = input.nextInt();
		input.nextLine();

		while (guess != 1 && guess != 2) {
			if (guess != 1 || guess != 2) {
				System.out.println("Error: that is not a valid input");
				System.out.print("Do you want to 1) guess a letter or 2) guess the sentence? ");
				guess = input.nextInt();
				input.nextLine();
			}
		}
		return guess;
	}

	// method for if the user wants to guess a letter of the sentence/codedsentence
	public static boolean letterGuess(char[] newAlphabet, char[] realAlphabet, ArrayList<Character> guessedEncryptedLetters, ArrayList<Character> guessedActualLetters, char encryptedLetterChar, char actualLetterChar) throws Exception {

		if (guessedEncryptedLetters.contains(encryptedLetterChar)) {
			System.out.println("You have already decoded that letter!");
		}

		if (guessedActualLetters.contains(actualLetterChar)) {
			System.out.println("You have already guessed that letter!");
			return false;
		}

		// loop through the newAlphabet and find the index where the
		// encryptedLetter is. check that the letter at the index in the
		// realAlphabet is equal to actualLetterChar.
		for (int j = 0; j < newAlphabet.length; j++) {
			if (newAlphabet[j] == encryptedLetterChar) {
				if (realAlphabet[j] == actualLetterChar) {
					guessedEncryptedLetters.add(encryptedLetterChar);
					guessedActualLetters.add(actualLetterChar);
					System.out.println("That's right!");
					return true;
				} else {
					System.out.println("Sorry, that is incorrect.");
					return false;
				}
			}
		}
		return false;
	}

	// method for if the user wants to guess the sentence
	public static boolean sentenceGuess(String sent, int correct, int incorrect) {

		System.out.print("Ok, what do you think the sentence is? ");
		String sentGuess = input.nextLine();
		
		// if the user is right, output that they are correct while also showing how many correct
		// and incorrect letter guesses they had for the round
		if (sentGuess.equalsIgnoreCase(sent)) {
			System.out.println("That's right! It took you " + correct + " correct and " + incorrect + " incorrect letter guesses.");
		} else {
			System.out.println("Be more cautious next time.");
		}
		return false;
	}

	// method for if the user wants to continue playing or not
	public static boolean keepPlaying() {
		System.out.print("Do you want to play another game? (yes or no)? ");
		String playAgain = input.nextLine();

		while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
			if (!playAgain.equalsIgnoreCase("yes") || !playAgain.equalsIgnoreCase("no")) {
				System.out.println("Error: that is not a valid choice");
				System.out.print("Do you want to play another game (yes or no)? ");
				playAgain = input.next();
			}
		}
		// if the user wants to continue playing, return true and start a new round of the game
		if (playAgain.equalsIgnoreCase("yes")) {
			return true;
			// if the user does not want to continue playing, then return false and tell the user
			// "bye" and exit the game
		} else if (playAgain.equalsIgnoreCase("no")) {
			System.out.println("Okay, goodbye!");
			System.exit(0);
		}
		return false;
	}
}