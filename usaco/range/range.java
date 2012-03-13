/*
ID: changhu1
LANG: JAVA
TASK: range
 */
import java.io.*;
import java.util.*;

public class range {

	private static final int N = 250;

	public String[] solve(String[] map) {

		int n = map.length;
		byte[][][] dp = new byte[n][n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i].charAt(j) == '0') continue;
				dp[i][j][1] = 1;
				int maxHeight;
				for (maxHeight = 1; i - maxHeight + 1 >= 0; maxHeight++) {
					if (map[i - maxHeight + 1].charAt(j) == '0') break;
				}
				maxHeight--;
				int maxWidth;
				for (maxWidth = 1; j - maxWidth + 1 >= 0; maxWidth++) {
					if (map[i].charAt(j - maxWidth + 1) == '0') break;
				}
				maxWidth--;
				if (i > 0 && j > 0) {
					for (int l = 2; l <= Math.min(maxHeight, maxWidth); l++) {
						dp[i][j][l] += dp[i - 1][j - 1][l - 1];
					}
				}
			}
		}

		// count and output
		ArrayList<String> res = new ArrayList<String>();
		for (int l = 2; l <= n; l++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum += dp[i][j][l];
				}
			}
			if (sum > 0) res.add(String.format("%d %d", l, sum));
		}
		return res.toArray(new String[0]);

	}

	public static void main(String[] args) throws IOException {
		String problemName = "range";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] map = new String[n];
		for (int i = 0; i < n; i++) {
			map[i] = f.readLine();
		}
		String[] res = (new range()).solve(map);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}
