/*
ID: changhu1
LANG: JAVA
TASK: fact4
 */
import java.io.*;
import java.util.*;

public class fact4 {

	private final int MAX = 4220;
	private int[] five = new int[MAX + 1];
	private int[] two = new int[MAX + 1];

	public int solve(int n) {

		int res = 1;
		// insight: twos always more than fives
		int twos = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0) {
				five[i] = five[i / 5] + 1;
			}
			if (i % 2 == 0) {
				two[i] = two[i / 2] + 1;
			}
			twos += two[i];
			twos -= five[i];

			res = (int) (i / Math.pow(2, two[i]) / Math.pow(5, five[i]) * res % 10);
		}

		res = (int) (Math.pow(2, twos) % 10 * res) % 10;
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "fact4";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int res = (new fact4()).solve(n);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}