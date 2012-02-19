/*
ID: changhu1
LANG: JAVA
TASK: sort3
 */
import java.io.*;
import java.util.*;

public class sort3 {

	public int solve(int[] unsorted) {
		int[][] map = new int[4][4];
		int l = unsorted.length;
		int[] sorted = Arrays.copyOf(unsorted, l);
		Arrays.sort(sorted);
		for (int i = 0; i < l; i++) {
			int from = unsorted[i];
			int to = sorted[i];
			if (from != to) {
				map[from][to]++;
			}
		}

		int res = 0;
		for (int from = 1; from <= 3; from++) {
			for (int to = from + 1; to <= 3; to++) {
				int exchange = Math.min(map[from][to], map[to][from]);
				res += exchange;
				map[from][to] -= exchange;
				map[to][from] -= exchange;
			}
		}

		for (int to = 2; to <= 3; to++) {
			res += (2 * map[1][to]);
		}

		return res;

	}

	public static void main(String[] args) throws IOException {
		String problemName = "sort3";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] unsorted = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			unsorted[i] = Integer.parseInt(st.nextToken());
		}

		int res = (new sort3()).solve(unsorted);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}