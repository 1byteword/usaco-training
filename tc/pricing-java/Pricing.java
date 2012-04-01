import java.util.Arrays;

public class Pricing {

	public int maxSales(int[] x) {
		int l = x.length;
		int[][] dp = new int[l][4];

		Arrays.sort(x);
		dp[0][0] = x[l - 1];
		int res = dp[0][0];
		for (int i = 1; i < l; i++) {
			int p = x[l - 1 - i];
			dp[i][0] = p * (i + 1);
			for (int j = 1; j < 4; j++) {
				for (int k = 0; k < i; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + p * (i - k));
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}

}
