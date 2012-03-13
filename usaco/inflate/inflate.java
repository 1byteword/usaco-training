/*
ID: changhu1
LANG: JAVA
TASK: inflate
 */
import java.io.*;
import java.util.*;

public class inflate {

	public int solve(int time, int[] points, int[] minutes) {
		int[] dp = new int[time + 1];
		
		for (int t = 1; t <= time; t++) {
			for (int i = 0;i < points.length;i++) {
				if (t - minutes[i] < 0) continue;
				dp[t] = Math.max(dp[t], dp[t - minutes[i]] + points[i]);
			}
		}
		
		return dp[time];
	}

	public static void main(String[] args) throws IOException {
		String problemName = "inflate";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] points = new int[n];
		int[] minutes = new int[n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(f.readLine());
			points[i] = Integer.parseInt(st.nextToken());
			minutes[i] = Integer.parseInt(st.nextToken());
		}


		int res = (new inflate()).solve(m, points, minutes);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}