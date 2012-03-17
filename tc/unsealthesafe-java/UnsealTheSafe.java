public class UnsealTheSafe {

	private static final int[][] neighbor = new int[][] { new int[] { 7 }, new int[] { 2, 4 }, new int[] { 1, 3, 5 }, new int[] { 2, 6 },
			new int[] { 1, 5, 7 }, new int[] { 2, 4, 6, 8 }, new int[] { 3, 5, 9 }, new int[] { 4, 8, 0 }, new int[] { 5, 7, 9 }, new int[] { 6, 8 } };

	public long countPasswords(int N) {
		long[][] dp = new long[N + 1][10];

		for (int j = 0; j < 10; j++) {
			dp[1][j] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k : neighbor[j]) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
		
		long res = 0;
		for (int j = 0; j < 10; j++) {
			res += dp[N][j] ;
		}
		
		
		return res;
	}

}
