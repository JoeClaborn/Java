// Joe Claborn

import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {
	// variable used for random number generation
	private static Random rng;

	// constructor that can be empty(no-arguments)
	public Chromosome() {
		rng = new Random();
	}

	// method that adds a copy of each of the items passed into this
	// Chromosome. Uses a random number to decide whether each item's
	// included field is set to true or false
	public Chromosome(ArrayList<Item> items) {
		rng = new Random();
		int rand = rng.nextInt(10) + 1;
		for (int i = 0; i < items.size(); i++) {
			Item item = new Item(items.get(i));
			if (rand <= 5) {
				item.setIncluded(false);
			} else {
				item.setIncluded(true);
			}
			this.add(item);
		}
	}

	// creates and returns a new "child" chromosome by performing
	// crossover operation on the "this" chromosome and the "other"
	// one that is passed in
	public Chromosome crossover(Chromosome other) {
		Chromosome child = new Chromosome();
		for (int i = 0; i < other.size(); i++) {
			int rand = rng.nextInt(10) + 1;
			if (rand < 5) {
				Item item = new Item(other.get(i));
				child.add(item);
			} else {
				Item item = new Item(get(i));
				child.add(item);
			}
		}
		return child;
	}

	// performs the mutation operation on this chromosome
	public void mutate() {
		for (int i = 0; i < this.size(); i++) {
			int rand = rng.nextInt(10) + 1;
			Item item = this.get(i);
			if (rand == 1) {
				item.setIncluded(!item.isIncluded());
			}
		}
	}

	// method to get the fitness of this chromosome. If the sum of
	// all the included items' weights are > 10, fitness = 0, otherwise
	// fitness is = the sum of all the included items' values
	public int getFitness() {
		double sum = 0;
		int valueSum = 0;
		for (int i = 0; i < this.size(); i++) {
			Item item = this.get(i);
			if (item.isIncluded() == true) {
				sum = item.getWeight() + sum;
				valueSum = item.getValue() + valueSum;
				if (sum > 10) {
					return 0;
				} 
			}
		}
		return valueSum;
	}

	// method to return -1 if "this" chromosome's fitness is > the "other's"
	// fitness, and +1 if "this" chromosome's fitness is < the "other" one's,
	// and 0 if fitness is the same
	public int compareTo(Chromosome other) {
		if (this.getFitness() > other.getFitness()) {
			return -1;
		} else if (this.getFitness() < other.getFitness()) {
			return 1;
		} else {
			return 0;
		}
	}

	// method to allow for the name, weight, and value of all this chromosome
	// whose included value = true followed by the fitness of the chromosome to
	// be displayed
	public String toString() {
		String s = "";
		for (int i = 0; i < this.size(); i++) {
			Item item = this.get(i);
			s += item.toString();
			s += "\n";
		}
		s += getFitness();
		return s;
	}
}