public class BirdsCounting {

	public double computeProbability(int birdsNumber, int caughtPerDay, int daysNumber, int birdsMarked) {

		int maxMarked = Math.min(caughtPerDay * daysNumber, birdsNumber);
		if (birdsMarked > maxMarked) return 0.0;
		
		double[][] dp = new double[maxMarked + 1][daysNumber + 1];
		cache = new double[birdsNumber + 1][birdsNumber + 1];

		dp[caughtPerDay][1] = 1.0;

		for (int day = 2; day <= daysNumber; day++) {
			for (int marked = 0; marked <= maxMarked; marked++) {
				for (int prev = 0; prev <= marked; prev++) {
					dp[marked][day] += dp[prev][day - 1] * choose(caughtPerDay + prev - marked, prev) * choose(marked - prev, birdsNumber - prev)
							/ choose(caughtPerDay, birdsNumber);
				}
			}
		}

		return dp[birdsMarked][daysNumber];
	}

	double[][] cache;

	private double choose(int j, int i) {
		if (j < 0) return 0;
		if (i < j) return 0;
		
		if (j > i - j) return choose(i - j, i);
		if (cache[j][i] > 0) return cache[j][i];

		double res = 1;
		for (int k = 0; k < j; k++) {
			res *= (i - k);
			res /= (k + 1);
		}

		cache[j][i] = res;
		return res;
	}
}
