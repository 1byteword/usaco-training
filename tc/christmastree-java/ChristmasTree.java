public class ChristmasTree {

	long[][][][] dp;
	long[] fac = new long[11];

	public long decorationWays(int n, int red, int green, int blue) {
		fac[1] = 1;
		for (int i = 2; i <= 10; i++) {
			fac[i] = fac[i - 1] * i;
		}
		
		dp = new long[n + 1][red + 1][green + 1][blue + 1];

		for (int r = 0; r <= red; r++) {
			for (int g = 0; g <= green; g++) {
				for (int b = 0; b <= blue; b++) {
					dp[1][r][g][b] = Math.min(r, 1) + Math.min(g, 1) + Math.min(b, 1);
				}
			}
		}

		for (int level = 2; level <= n; level++) {
			for (int r = 0; r <= red; r++) {
				for (int g = 0; g <= green; g++) {
					for (int b = 0; b <= blue; b++) {
						long s = 0L;
						int use;

						if (level % 3 == 0) {
							use = level / 3;
							if (r >= use && g >= use && b >= use) {
								s += (dp[level - 1][r - use][g - use][b - use] * (fac[level] / fac[use] / fac[use] /fac[use]));
							}
						}

						if (level % 2 == 0) {
							use = level / 2;
							if (r >= use && g >= use) {
								s += (dp[level - 1][r - use][g - use][b]  * (fac[level] / fac[use] / fac[use]));
							}
							if (g >= use && b >= use) {
								s +=( dp[level - 1][r][g - use][b - use] * (fac[level] / fac[use] / fac[use]));
							}
							if (r >= use && b >= use) {
								s += ( dp[level - 1][r - use][g][b - use] * (fac[level] / fac[use] / fac[use]));
							}
						}

						if (r >= level) {
							s += dp[level - 1][r - level][g][b];
						}
						if (g >= level) {
							s += dp[level - 1][r][g - level][b];
						}
						if (b >= level) {
							s += dp[level - 1][r][g][b - level];
						}

						dp[level][r][g][b] = s;
					}
				}

			}
		}

		return dp[n][red][green][blue];
	}
}
