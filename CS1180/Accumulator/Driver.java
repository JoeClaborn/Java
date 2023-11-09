// Joe Claborn
public class Driver {
	public static void main(String[] args) {
		Accumulator a1 = new Accumulator(1);
		Accumulator a2 = new Accumulator(100);
		
		System.out.println(a1.toString());

		a1.accumulate(50);

		a1.accumulateAgain(a2);
		System.out.println(a1.toString());
	}
}
