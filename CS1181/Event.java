// Joe Claborn

public class Event implements Comparable<Event> {

	private double time;
	private Customer c;

	public Event(double time, Customer c) {
		this.time = time;
		this.c = c;
	}

	@Override
	public int compareTo(Event t) {

		if (this.time == t.time) {
			return 0;
		} else if (this.time > t.time) {
			return 1;
		} else {
			return -1;
		}
	}
}