/*
ID: changhu1
LANG: JAVA
TASK: money
 */
import java.io.*;
import java.util.*;

public class money {

	public long solve(int N, int[] values) {
		
		int v = values.length;
		
		// number of ways to form N using values[0..v]
		long[][] dp = new long[v][N + 1]; 
		
		for (int n = 1; n <= N; n++) {
			if (n % values[0] == 0) {
				dp[0][n] = 1;
			}
		}
		
		for (int n = 1; n <= N; n++) {
			for (int i = 1; i < v; i++) {
				for (int j = 0; j * values[i] <= n; j++) {
					dp[i][n] += dp[i - 1][n - j * values[i]]; 
				}
				if (n % values[i] == 0) dp[i][n]++;
			}
			
		}
		
		return dp[v - 1][N];
		
	}

	public static void main(String[] args) throws IOException {
		String problemName = "money";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int v = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] values = new int[v];
		String line = f.readLine();
		int p = 0;
		while (line != null) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				values[p++] = Integer.parseInt(st.nextToken());
			}
			line = f.readLine();
		}
		
		long res = (new money()).solve(n, values);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}