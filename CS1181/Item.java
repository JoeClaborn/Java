// Joe Claborn

public class Item {
	// creation of global variables
	private final String name;
	private final double weight;
	private final int value;
	private boolean included;

	// constructor to initalize the values that are passed in
	public Item(String name, double weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}

	// method to initalize an item's field to be the same as the other item's
	public Item(Item other) {
		this.name = other.name;
		this.weight = other.weight;
		this.value = other.value;
	}

	// method to get the weight of an item
	public double getWeight() {
		return this.weight;
	}

	// method to get the value of an item
	public int getValue() {
		return this.value;
	}

	// method to get if an item is included or not
	public boolean isIncluded() {
		return this.included;
	}

	// method to set an item's included field
	public void setIncluded(boolean included) {
		this.included = included;
	}

	// method to allow for the string including an item's name, weight, and
	// value to be printed out
	public String toString() {
		String s = "<" + name + "> (" + "<" + weight + "> lbs, $<" + value + ">)";
		return s; 
	}
}