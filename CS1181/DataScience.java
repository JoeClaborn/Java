// Joe Claborn

import java.util.*;
import java.io.*;

public class DataScience {
	
	public static void main(String[] args) throws Exception {
		ArrayList<Customer> list2 = readData();
	}

	public static ArrayList<Customer> readData() throws Exception {
		Scanner in = new Scanner(new File("arrival simple.txt"));
		ArrayList<Customer> list = new ArrayList<Customer>();

		while(in.hasNextLine()) {
			double arrTime = in.nextDouble();
			int numItems = in.nextInt();
			double timePerItem = in.nextDouble();

			Customer c1 = new Customer(arrTime, numItems, timePerItem);
			list.add(c1);
		}
		return list;
	}
}