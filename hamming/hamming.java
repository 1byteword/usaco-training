/*
ID: changhu1
LANG: JAVA
TASK: hamming
 */
import java.io.*;
import java.util.*;

public class hamming {

	public int[] solve(int n, int b, int d) {

		int[] res = new int[n];

		int p = 0;
		for (int word = 0; word < (1 << (b + 1)); word++) {
			boolean wordOkay = true;
			for (int j = 0; j < p; j++) {
				int existing = res[j];
				if (distance(word, existing) < d) {
					wordOkay = false;
					break;
				}
			}
			if (wordOkay) {
				res[p++] = word;
			}
			if (p == n) {
				break;
			}

		}

		return res;
	}

	private int distance(int word, int existing) {
		int res = 0;
		word = word ^ existing;
		while (word > 0) {
			res += (word & 1);
			word = word >> 1;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "hamming";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] res = (new hamming()).solve(n, b, d);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		String output = "";
		for (int i = 0; i < res.length; i++) {
			if (i >= 10 && i % 10 == 0) {
				out.println(output.trim());
				output = "";
			}
			output += (String.valueOf(res[i]) + " ");
		}
		if (output.length() > 0) out.println(output.trim());
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}