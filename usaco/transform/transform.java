/*
ID: changhu1
LANG: JAVA
TASK: transform
 */
import java.io.*;
import java.util.*;

public class transform {

	// 0) 6, nop: (i, j) -> (i, j)
	// 1) 1, rot90: (i, j) -> (j, l-i)
	// 2) 2, rot180: (i, j) -> (j, l-i) -> (l-i, l-j)
	// 3) 3, rot270: (i, j) -> (j, l-i) -> (l-i, l-j) -> (l-j, i)
	// 4) 4, hrefl: (i, j) -> (i, l-j)
	// 5) 5, 4 + [1..3] (i, j) -> (i, l-j) -> l-j, l-i
	// 6) 5, 4 + [1..3] (i, j) -> (i, l-j) -> l-i, j
	// 7) 5, 4 + [1..3] (i, j) -> (i, l-j) -> j, i
	boolean[] candidates = new boolean[8];
	int[] types = new int[] {6, 1, 2, 3, 4, 5, 5, 5}; 
	String[] from = null;
	String[] to = null;

	public int solve(int n, String[] from, String[] to) {
		for (int i = 0; i < candidates.length; i++) {
			candidates[i] = true;
		}
		this.from = from;
		this.to = to;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				comp(0, i, j, i, j);
				comp(1, i, j, j, n - 1 - i);
				comp(2, i, j, n - 1 - i, n - 1 - j);
				comp(3, i, j, n - 1 - j, i);
				comp(4, i, j, i, n - 1 - j);
				comp(5, i, j, n - 1 - j, n - 1 - i);
				comp(6, i, j, n - 1 - i, j);
				comp(7, i, j, j, i);
			}
		}

		int res = 7;
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i]) {
				res = Math.min(res, types[i]);
			}
		}
		return res;
	}

	private void comp(int type, int i, int j, int toi, int toj) {
		candidates[type] &= (from[i].charAt(j) == to[toi].charAt(toj));
	}

	public static void main(String[] args) throws IOException {
		String problemName = "transform";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] from = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			from[i] = st.nextToken();
		}
		String[] to = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			to[i] = st.nextToken();
		}

		int res = (new transform()).solve(n, from, to);

		// output result
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}