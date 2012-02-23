/*
ID: changhu1
LANG: JAVA
TASK: nocows
 */
import java.io.*;
import java.util.*;

public class nocows {

	public int solve(int N, int K) {
		int[][] dp = new int[N + 1][K + 1];
		dp[1][1] = 1;

		for (int n = 2; n <= N; n++) {
			for (int k = 1; k <= K; k++) {
				int sum = 0;

				for (int nLeft = 1; nLeft < n - 1; nLeft++) {
					for (int kRight = 1; kRight < k - 1; kRight++) {
						sum += (2 * dp[nLeft][k - 1] * dp[n - 1 - nLeft][kRight] % 9901);
					}
					sum += (dp[nLeft][k - 1] * dp[n - 1 - nLeft][k - 1] % 9901);
				}

				dp[n][k] = (sum % 9901);
			}
		}

		return dp[N][K];
	}

	public static void main(String[] args) throws IOException {
		String problemName = "nocows";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int res = (new nocows()).solve(n, k);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}