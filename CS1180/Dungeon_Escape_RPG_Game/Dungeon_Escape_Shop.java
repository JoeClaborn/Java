// Joe Claborn
import java.util.Scanner;
import java.util.ArrayList;

class Dungeon_Escape_Shop {
	// creates a global scanner for user input
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// sets variables equal to the methods that have return values so that
		// the return value can be used later
		Dungeon_Escape p1 = makePlayer();
		int dungeonSize = getDungeonSize();

		// creates an arrayList equal to the makeMonsters method so that the
		// arrayList can be used at a later time when needed
		ArrayList<Dungeon_Escape> monsters = makeMonsters(dungeonSize);

		// creates a loop that while its boolean type is true, the game will run
		while (true) {
			// print out the string each round with the player row, col, and health value
			System.out.println(p1.toString());

			// call the move method
			move(p1, monsters, dungeonSize);

		}
	}

	// method that creates the player character and sets their name based on what
	// the user wanted the name to be
	public static Dungeon_Escape makePlayer() {
		System.out.print("What is your name, heroic adventurer? ");
		String name = input.nextLine();
		Dungeon_Escape character = new Dungeon_Escape(name, 100, 10, 0, 0, "");
		// retuns the player character
		return character;
	}

	// method that gets the game's dungeon size based on how big the user wants the
	// size to be
	public static int getDungeonSize() {
		System.out.print("How wide of a dungeon do you want to face (5-10)? ");
		int dungeonSize = input.nextInt();
		input.nextLine();
		// checks if the user has put a value that is invalid, if they have,
		// asks the user again
		if (dungeonSize < 5 || dungeonSize > 10) {
			System.out.println("That is not a valid dungeon size!");
			System.out.print("How wide of a dungeon do you want to face (5-10)? ");
			dungeonSize = input.nextInt();
		}
		// retuns the value of the size that the user wanted
		return dungeonSize;
	}

	// method that is used to create the monsters and store them in an arrayList
	public static ArrayList<Dungeon_Escape> makeMonsters(int dungeonSize) {
		// create the arrayList for storing
		ArrayList<Dungeon_Escape> monsters = new ArrayList<>();
		int monsterNum = 1;
		// loop through how big the dungeon size is with the amount of monsters being equal
		// to the amount of rooms / 6 (one monster per 6 rooms)
		for (int i = 0; i < (dungeonSize * dungeonSize) / 6; i++) {
			// create a random number based on the size of the game where the monsters can be
			// located for both the row and col
			int rowRand = (int) ((Math.random() * dungeonSize));
			int colRand = (int) ((Math.random() * dungeonSize));
			// check that if the monster is not in the starting point for the player character (0,0), then
			// allow it to be placed on the board, otherwise, re-roll it's row and col number so
			// that it is not in the starting point for the player character
			if (rowRand != 0 && colRand != 0) {
				String monsterName = "Monster " + monsterNum;
				monsters.add(new Dungeon_Escape(monsterName, 25, 5, rowRand, colRand, ""));
				monsterNum++;
			} else {
				continue;
			}
		}
		// return the arrayList that is storing the monsters within the game board
		return monsters;
	}

	// method that allows for all of the moving and anything that relates to it, to occur
	public static void move(Dungeon_Escape p1, ArrayList<Dungeon_Escape> monsters, int dungeonSize) {
		// prompts user which way they want to move
		System.out.print("Which way do you want to go (north, east, south, west)? ");
		String direction = input.nextLine();
		// checks to see if the user has put in anything else that is not "north, south, east, or west", if so, tell them they
		// cannot move that way(invalid input) and ask again
		while (!direction.equalsIgnoreCase("north") && !direction.equalsIgnoreCase("east") && !direction.equalsIgnoreCase("south") && !direction.equalsIgnoreCase("west")) {
			System.out.println("You can't move that way!");
			System.out.print("Which way do you want to go (north, east, south, west)? ");
			direction = input.nextLine();
		}
		// call the move method from the "Dungeon_Escape" class with the p1 (player character)
		p1.move(direction, dungeonSize);

		// check to see if the player character has escaped the dungeon based on the "hasEscaped" method
		// from the "Dungeon_Escape" class
		if (p1.hasEscaped(dungeonSize) == true) {
			System.out.println("You have escaped the dungeon!!");
			System.exit(0);
		}

		// loops through the "monsters" arrayList size and checks to see that if
		// the player character is in the same room as one of the monsters, then
		// call the "fight" method from the "Dungeon_Escape" class that will be
		// utilized until either the player character is dead or the monsters
		for (int i = 0; i < monsters.size(); i++) {
			if (p1.inSameRoom(monsters.get(i))) {
				// creates a loop that while both the player character and the monster
				// in the same room as the player character is alive, then use the "fight"
				// method to have the do combat
				while (p1.isAlive() == true && monsters.get(i).isAlive()) {
					p1.fight(monsters.get(i));
					monsters.get(i).fight(p1);
					// checks within the loop if the player character wanted to run away from battle
					// based on the "runAway" method and if the user put "yes" to wanting to run away
					if (p1.runAway() == true) {
						System.out.println("You Ran!");
						break;
						// if the user did not want to run away, check if the monsters random number allowed
						// for it to run away from the player character
					} else if (monsters.get(i).monsterRun() == true) {
						System.out.println("The monster ran!");
						break;
					} else {
						continue;
					}
				}
			}
			// checks to see if the monster is alive, and if it is not, then remove it from
			// the arrayList so that the player character would no longer run into it
			if (!monsters.get(i).isAlive()) {
				System.out.println("The Monster has been Defeated!");
				monsters.remove(monsters.get(i));
			}
		}

		// loop through all monsters and count how many are adjacent to p1
		int monsterCount = 0;
		for (int i = 0; i < monsters.size(); i++) {
			if (p1.inAdjacentRoom(monsters.get(i))) {
				monsterCount++;
			}
		}
		// print out how many monsters are nearby based on the "inAdjacentRoom" method
		System.out.println("You smell " + monsterCount + " monster(s) nearby.");

		// check to see if the player character is alive by using the "isAlive" method
		// and calling it with p1. If that method has a boolean return type of false,
		// then print out that the user has died and exit the game
		if (p1.isAlive() == false) {
			System.out.println("You have died.");
			System.exit(0);
		}
	}
}