/*
ID: changhu1
LANG: JAVA
TASK: milk
 */
import java.io.*;
import java.util.*;

public class milk {
	
	class Farmer implements Comparable<Farmer> {
		int price;
		int amount;
		
		public Farmer(int price, int amount) {
			this.price = price;
			this.amount = amount;
		}

		public int compareTo(Farmer other) {
			return   price - other.price;
		}
		
		public String toString() {
			return String.format("<%d, %d>", price, amount);
		}
		
	}

	public int solve(int total, int farmers, int[] prices, int[] amounts) {
		ArrayList<Farmer> fs = new ArrayList<milk.Farmer>();
		for (int i = 0; i < farmers; i++) {
			fs.add(new Farmer(prices[i], amounts[i]));
		}
		Collections.sort(fs);
		int totalPrice = 0;
		for (Farmer f : fs) {
			if (f.amount > total) {
				totalPrice += (total * f.price);
				break;
			}
			totalPrice += (f.amount * f.price);
			total -= f.amount;
		}
		
		return totalPrice;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "milk";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int total = Integer.parseInt(st.nextToken());
		int farmers = Integer.parseInt(st.nextToken());
		int[] prices = new int[farmers];
		int[] amounts = new int[farmers];
		for (int i = 0; i < farmers; i++) {
			st = new StringTokenizer(f.readLine());
			prices[i] = Integer.parseInt(st.nextToken());
			amounts[i] = Integer.parseInt(st.nextToken());
		}

		int res = (new milk()).solve(total, farmers, prices, amounts);

		// output result
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}