public class TheCowDivTwo {

	private static final int M = 1000000007;

	public int find(int n, int k) {
		int[][][] dp = new int[2][k + 1][n];

		dp[0][1][0] = 1;

		for (int m = 1; m < n; m++) {
			for (int mod = 0; mod < n; mod++) {
				if (mod <= m) {
					dp[m % 2][1][mod] = 1;
				}
				for (int nums = 2; nums <= k; nums++) {
					dp[m % 2][nums][mod] = (dp[(m + 1) % 2][nums][mod] + dp[(m + 1) % 2][nums - 1][(n
							+ mod - m)
							% n])
							% M;
				}
			}
		}

		return dp[(n + 1) % 2][k][0];
	}
}
