

public class CoinReversing {

	public double expectedHeads(int N, int[] a) {
		int l = a.length;
		cache = new double[N + 1][N + 1];

		// dp[i][j] = at step i + 1 with heads j
		double[][] dp = new double[l + 1][N + 1];

		dp[0][N] = 1.0;

		for (int step = 0; step < l; step++) {
			int x = a[step];
			for (int heads = 0; heads <= N; heads++) {
				double p = dp[step][heads];
				if (p == 0.0) continue;

				for (int i = 0; i <= x; i++) {
					int tails = N - heads;
					if (i > heads) continue;
					if (x - i > tails) continue;
					double pNew = choose(heads, i) * choose(tails, x - i) / choose(N, x);
					dp[step + 1][heads + x - 2 * i] +=  pNew * p;
				}

			}
		}

		double res = 0.0;
		for (int heads = 0; heads <= N; heads++) {
			res += (heads * dp[l][heads]);
		}

		return res;
	}

	double[][] cache;
	private double choose(int n, int k) {
		k = Math.min(k, n - k);
		if (cache[n][k] > 0.0) return cache[n][k];

		double res = 1.0;
		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		cache[n][k] = res;

		return res;
	}

}
