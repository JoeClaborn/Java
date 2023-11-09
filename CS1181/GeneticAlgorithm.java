// Joe Claborn

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GeneticAlgorithm {
	// reads in data file with the format shown below and creates and returns an
	// ArrayList of Item objects
	public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
		// creates an ArrayList called "item"
		ArrayList<Item> item = new ArrayList<Item>();

		// sets a File variable = the file that is being read from (items.txt)
		File file = new File("items.txt");
		// opens a new scanner to read the file above
		Scanner scan = new Scanner(file);

		// variables that are used to be passed into the while loop below and that are
		// added to the ArrayList within in the loop
		String name;
		double weight;
		int value;

		// loop that iterates while the file that was read in has text on the next line
		// it passes the variables above into the "item" ArrayList defined above
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] arr = line.split(", ");
			name = arr[0];
			weight = Double.parseDouble(arr[1]);
			value = Integer.parseInt(arr[2]);
			Item item1 = new Item(name, weight, value);
			item.add(item1);
		}
		// closes the scanner
		scan.close();
		// returns the ArrayList of "item"
		return item;
	}

	// creates and returns an ArrayList of "populationSize Chromosome" objects that
	// each contain
	// the items, with their "included" field randomly set to true or false
	public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
		ArrayList<Chromosome> size = new ArrayList<Chromosome>();

		for (int i = 0; i < items.size(); i++) {
			Chromosome c = new Chromosome(items);
			size.add(c);
		}
		return size;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// sets a variable that is of ArrayList<Item> type = to the readData method and the file
		// that was read in
		ArrayList<Item> rd = readData("items.txt");
		// sets a variable that is of ArrayList<Chromosome> type = to the initializePop method
		// that takes the parameters "rd" and the populationSize
		ArrayList<Chromosome> currentGen = initializePopulation(rd, 10);

		// repeats everything encased within this for loop 20 times
		for (int j = 0; j < 20; j++) {
			// creation of an ArrayList that is of type <Chromosome>
			ArrayList<Chromosome> nextGen = new ArrayList<Chromosome>();

			// loop that iterates througn the size of the currentGen population
			// and adds each item(individual) to the nextGen population
			for (int i = 0; i < currentGen.size(); i++) {
				nextGen.add(currentGen.get(i));
			}

			// shuffles the nextGen population before the new child items are added
			Collections.shuffle(nextGen);

			// loop that iterates through the size of the currentGen population
			// and creates a new child that is based on the crossover of the item(individual)
			// at the current index(i) and the item(individual) in the next index(i + 1) and adds
			// the crossover child to the nextGen population
			for (int i = 0; i < currentGen.size(); i++) {
				Chromosome child = nextGen.get(i).crossover(nextGen.get(i + 1));
				nextGen.add(child);
			}

			// shuffles the nextGen population after the new child items(individuals) are added
			Collections.shuffle(nextGen);

			// loop that iterates through the size of the nextGen ArrayList that 
			// randomly chooses 10% of the items(individuals) within the list and exposes them
			// to the mutation method from the "Chromosome" object
			for (int i = 0; i < nextGen.size() / 10; i++) {
				nextGen.get(i).mutate();
			}

			// sorts the nextGen ArrayList to have the best items(individuals) at
			// the top of the list
			Collections.sort(nextGen);

			// clears the population of the currentGen ArrayList
			currentGen.clear();

			// loop that repeats 10 times and adds the top ten of the best items(individuals)
			// of the nextGen population back into the currentGen population
			for (int i = 0; i < 10; i++) {
				currentGen.add(nextGen.get(i));
			}
		}
		// sorts the currentGen population again to have the best item(individual) at the top
		Collections.sort(currentGen);
		// print out the first index(0) of the currentGen population to the console to show the
		// fittest one to the user
		System.out.println(currentGen.get(0));
	}
}