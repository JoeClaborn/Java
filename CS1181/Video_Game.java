// Joe Claborn

import java.awt.Font;
import javax.swing.*;

public class Video_Game {
	private int score = 0;

	public Video_Game() {

		// creates the Font for the different JFrames
		Font font = new Font("Serif", Font.BOLD, 16);

		// creates the image with a smiley face to show up if the user gets the number correct
		ImageIcon smileImg = new ImageIcon(getClass().getResource("smiley.png"));
		JLabel smileyLabel = new JLabel(smileImg);
		smileyLabel.setIcon(smileImg);
		smileyLabel.setVisible(false);

		// creates the image with a sad face to show up if the user gets the number incorrect
		ImageIcon sadImg = new ImageIcon(getClass().getResource("sad.png"));
		JLabel sadLabel = new JLabel(sadImg);
		sadLabel.setIcon(sadImg);
		sadLabel.setVisible(false);

		// creation of each of the JFrames for each part of the game
		JFrame secondFrame = new JFrame("Guess That Number");
		JFrame instructionFrame = new JFrame("Instructions");
		JFrame continueFrame = new JFrame("Continue?");
		JFrame doneFrame = new JFrame("Thanks For Playing!");

		// creation of the "instructionRoot" JPanel to be able to add things to the "instructionRoot"
		JPanel instructionRoot = new JPanel();
		BoxLayout instructionLayout = new BoxLayout(instructionRoot, BoxLayout.Y_AXIS);
		instructionRoot.setLayout(instructionLayout);

		// creation of the "secondRoot" JPanel to be able to add things to the "secondRoot"
		JPanel secondRoot = new JPanel();
		BoxLayout secondLayout = new BoxLayout(secondRoot, BoxLayout.Y_AXIS);
		secondRoot.setLayout(secondLayout);

		// creation of the "continueRoot" JPanel to be able to add things to the "continueRoot"
		JPanel continueRoot = new JPanel();
		BoxLayout continueLayout = new BoxLayout(continueRoot, BoxLayout.Y_AXIS);
		continueRoot.setLayout(continueLayout);

		// creation of the "doneRoot" JPanel to be able to add things to the "doneRoot"
		JPanel doneRoot = new JPanel();
		BoxLayout doneLayout = new BoxLayout(doneRoot, BoxLayout.Y_AXIS);
		doneRoot.setLayout(doneLayout);

		// creation of the "instructions" textArea that is used to provide the instructions of the game to the
		// user in a separate window
		String instructions = "Instructions: When prompted to enter a number between 1 and 10," 
		+ '\n' + "enter the correct number that you think the random number will be." + '\n' + "Goal: The goal of"
		+ " the game is to guess the random number that will" + '\n' + "be between 1 and 10 correctly.";
		JTextArea textArea = new JTextArea(instructions);
		textArea.setEditable(false);
		textArea.setFont(font);

		// creation of the "number" textArea that is used to provide a prompt within a separate window of the game
		String number = "Enter a number 1-10";
		JTextArea numberArea = new JTextArea(number);
		numberArea.setEditable(false);
		numberArea.setFont(font);

		// creation of the "user" JLabel that is used for the user to write an answer within the "uf" textField
		JLabel user = new JLabel("What do you think the number is?");
		user.setFont(font);
		JTextField uf = new JTextField(15);

		// creation of the "userContinue" JLabel that is used to prompt the user within a separate window if they
		// would like to continue playing the game
		String userContinue = "Would you like to continue playing?";
		JTextArea continueArea = new JTextArea(userContinue);
		continueArea.setEditable(false);
		continueArea.setFont(font);

		// creation of the "done" textArea that is used if the user does not want to continue playing the game as
		// a send-off message to the user in a separate window
		String done = "Thank You For Playing! Goodbye";
		JTextArea doneArea = new JTextArea(done);
		doneArea.setEditable(false);
		doneArea.setFont(font);

		JButton instructionButton = new JButton("Okay");

		// actionListener for the "instructionButton" that once it is pressed, it closes the "instructionFrame" and
		// sets the "secondFrame" to be visible which includes the "number" prompt on it
		instructionButton.addActionListener(e -> {
			instructionFrame.setVisible(false);
			secondFrame.setVisible(true);
		});

		JButton answerButton = new JButton("Results");
		JLabel message = new JLabel();

		// actionListener for "answerButton" that when clicked, will take the "userAns" that was given within the
		// "uf" JTextField and will parse it into an Integer so that it can be used in order to see if the user's
		// number that they guessed was correct or not through the use of an if-statement
		answerButton.addActionListener(e -> {
			// random number generator for the game between the numbers 1 and 10
			int random = (int) (Math.random() * 10) + 1;

			String userAns = uf.getText();
			int userNum = Integer.parseInt(userAns);

			if (userNum == random) {
				// if the user's guess was correct, increases their score by 1
				// and a smiley face image is shown to the user
				score++;
				message.setText("You're right! Your score is currently: " + score);
				smileyLabel.setVisible(true);
			} else if (userNum != random) {
				// if the user's guess was incorrect, tells them so and displays their score
				// and a sad face image is shown to the user
				message.setText("Sorry, that's incorrect. Your score is still: " + score);
				sadLabel.setVisible(true);
			}
		});

		JButton keepPlayingButton = new JButton("Keep Playing?");

		// actionListener for the "keepPlayingButton" that when it is pressed, will close the "secondFrame" and
		// will open the "continueFrame" which prompts the user if they want to continue playing or not and uses
		// the buttons "yesButton" and "noButton"
		keepPlayingButton.addActionListener(e -> {
			secondFrame.setVisible(false);
			continueFrame.setVisible(true);
		});

		JButton yesButton = new JButton("Yes");

		// actionListener for the "yesButton" for when it is clicked, it will close the "continueFrame" and will
		// set the "secondFrame"'s visibility to true and clear the fields for the "uf" and "message"
		// so that they are blank for the user to input their answer again to the prompt of guessing the correct
		// number. Also, the smiley face and sad face images are both set to be invisible again so that they
		// reset as well and re-appear based on the user's answer each time to guessing the number
		yesButton.addActionListener(e -> {
			continueFrame.setVisible(false);
			secondFrame.setVisible(true);
			smileyLabel.setVisible(false);
			sadLabel.setVisible(false);
			uf.setText("");
			message.setText("");
		});

		JButton noButton = new JButton("No");

		// actionListener for the "noButton" that when it is used, it will close the "continueFrame" and will open the
		// "doneFrame" that includes the "done" JTextArea message that is used to tell the user thanks for playing and 
		// goodbye
		noButton.addActionListener(e -> {
			continueFrame.setVisible(false);
			doneFrame.setVisible(true);
		});

		JButton exitButton = new JButton("Exit");

		// actionListener for the "exitButton" that is used on the last frame("doneFrame") that when it is used, exits out
		// of the game window completely
		exitButton.addActionListener(e -> {
			System.exit(0);
		});

		// adds the "textArea" prompt that includes the instructions of how to play the game and the
		// "instructionButton" that allows for the user to continue to the next window of the game to the
		// "instructionRoot" window
		instructionRoot.add(textArea);
		instructionRoot.add(instructionButton);

		// adds the "smileyLabel" image, "sadLabel" image, "numberArea" prompt, "user" JTextField, the "uf" area where the user's answer goes, the "answerButton"
		// and the "keepPlayingButton" to the "secondRoot" window
		secondRoot.add(smileyLabel);
		secondRoot.add(sadLabel);
		secondRoot.add(numberArea);
		secondRoot.add(user);
		secondRoot.add(uf);
		secondRoot.add(answerButton);
		secondRoot.add(keepPlayingButton);
		secondRoot.add(message);

		// adds the "userContinue" prompt and the "yesButton" and "noButton" to the "continueRoot" window
		// that are used for answering the prompt
		continueRoot.add(continueArea);
		continueRoot.add(yesButton);
		continueRoot.add(noButton);

		// adds the "doneArea" prompt and the "exitButton" to the "doneRoot" window for when the user uses
		// the "noButton" in the "contiueRoot" window of the game
		doneRoot.add(doneArea);
		doneRoot.add(exitButton);

		// adds the content from the rest of the constructor to each of the frames for display
		secondFrame.getContentPane().add(secondRoot);
		instructionFrame.getContentPane().add(instructionRoot);
		continueFrame.getContentPane().add(continueRoot);
		doneFrame.getContentPane().add(doneRoot);

		// sets the size, visibility, and the default close operations for all of the frames
		// within the game
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondFrame.setSize(500, 500);
		secondFrame.setVisible(false);

		instructionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		instructionFrame.setSize(500, 200);
		instructionFrame.setVisible(true);

		continueFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		continueFrame.setSize(500, 200);
		continueFrame.setVisible(false);

		doneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doneFrame.setSize(500, 200);
		doneFrame.setVisible(false);
	}

	public static void main(String[] args) {
		new Video_Game();
	}
}