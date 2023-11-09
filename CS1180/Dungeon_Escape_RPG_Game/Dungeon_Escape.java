// Joe Claborn
import java.util.Scanner;

class Dungeon_Escape {
	/* TO DO
		1: Have the user name their character
		2: Have the user choose how big they want the size of the game to be
		(within 5 and 10 inclusive)
		3: Ask the user which way that they wish to go
		4: If the user gives an invalid answer, re-ask them
		5: If the user can move, take away 2 of their health per move, and check if they
		"smell" any monsters nearby
		6: If the user runs into a monster have them fight
		7: Prompt the user if they wish to run away throuhgout combat and if they do not, test if the
		monster was able to run away based on a random number
		8: If the user is victorious over the monster, say that it has died and continue the game
		9: If the user dies at any point in the game, tell the the user that and exit the game
		10: If the user getst to the south-east corner of the map, tell the user they have escaped
	*/

	// creates the variables that are needed for the constructor
	private String name;
	private int health;
	private int maxDamage;
	private int row;
	private int col;
	private String run;

	// initalizes all of the variables within the constructor by using "this"
	public Dungeon_Escape(String name, int health, int maxDamage, int row, int col, String run) {
		this.name = name;
		this.health = health;
		this.maxDamage = maxDamage;
		this.row = row;
		this.col = col;
		this.run = run;
	}

	// method for when the player character and monsters fight
	public void fight(Dungeon_Escape other) {
		int randNum = (int) ((Math.random() * maxDamage) + 1);
		System.out.println(this.name + " hits for " + randNum);
		other.health = other.health - randNum;
	}

	// method to test if the player character is alive
	public boolean isAlive() {
		if (health > 0) {
			return true;
		} else {
			return false;
		}
	}

	// method to test if the player character wants to run away mid-fight from the monster
	public boolean runAway() {
		Scanner input = new Scanner(System.in);
		System.out.print("Would you like to run away? ");
		run = input.nextLine();
		if (!run.equalsIgnoreCase("yes") && !run.equalsIgnoreCase("no")) {
			System.out.println("That is not a valid answer!");
			System.out.print("Would you like to run away? ");
			run = input.nextLine();
		} else if (run.equalsIgnoreCase("yes")) {
			return true;
		}
		return false;
	}

	// method that rolls a random number to give a 50/50 chance to if the monster will run away during combat
	public boolean monsterRun() {
		double monsterRandNum = Math.random();
		if (monsterRandNum < 0.5) {
			return true;
		} else {
			return false;
		}
	}

	// method to test if the player character has successfully escaped the dungeon
	public boolean hasEscaped(int dungeonSize) {
		if (this.row == dungeonSize - 1 && this.col == dungeonSize - 1) {
			return true;
		}
		return false;
	}

	// method to test if the player character is in the same room as a monster
	public boolean inSameRoom(Dungeon_Escape other) {
		if (this.row == other.row && this.col == other.col) {
			return true;
		} else {
			return false;
		}
	}

	// method to test if there are monsters in adjacent rooms to the player character
	//(north, south, east, west)
	public boolean inAdjacentRoom(Dungeon_Escape other) {
		if (this.row == other.row) {
			if (this.col == other.col + 1 || this.col == other.col - 1) {
				return true;
			}
		} else if (this.col == other.col) {
			if (this.row == other.row + 1 || this.row == other.row - 1) {
				return true;
			}
		}
		return false;
	}

	// method to test if the player can move or not and where they will be at in relation to their move
	public boolean move(String direction, int dungeonSize) {
		// checks if the player can move north once at the topmost side of the board
		if (direction.equalsIgnoreCase("north") && row == 0) {
			System.out.println("You can't move that way");
			return false;
			// checks if the player can move south once at the bottommost side of the board
		} else if (direction.equalsIgnoreCase("south") && row == dungeonSize - 1) {
			System.out.println("You can't move that way");
			return false;
			// checks if the player can move left once at the leftmost side of the board
		} else if (direction.equalsIgnoreCase("west") && col == 0) {
			System.out.println("You can't move that way");
			return false;
			// checks if the player can move right once at the rightmost side of the board
		} else if (direction.equalsIgnoreCase("east") && col == dungeonSize - 1) {
			System.out.println("You can't move that way");
			return false;
		}

		// used to increament/decreament the row and col of the player based on where they wish to move
		if (direction.equalsIgnoreCase("north")) {
			row--;
		} else if (direction.equalsIgnoreCase("east")) {
			col++;
		} else if (direction.equalsIgnoreCase("south")) {
			row++;
		} else if (direction.equalsIgnoreCase("west")) {
			col--;
		}
		this.health = this.health - 2;
		return true;
	}

	// method to create the string that prints out based on where the player character is and how much health they
	// have at each movepoint/turn
	public String toString() {
		String s = name + " at " + row + ", " + col + " with " + health + " health";
		return s;
	}

	// gets the amount of health the player character has(getter method)
	public int getHealth() {
		return this.health;
	}

	// sets the amount of health that the player character has(setter method)
	public void setHealth(int health) {
		this.health = health;
	}
}