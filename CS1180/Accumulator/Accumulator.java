// Joe Claborn
public class Accumulator {
	
	private double value;

	public Accumulator(double value) {
		this.value = value;
	}

	public double accumulate(double num) {
		value += num;
		return value;
	}

	public void accumulateAgain(Accumulator other) {
		value = other.value + value;
	}

	public String toString() {
		String s = "" + value;
		return s;
	}
}