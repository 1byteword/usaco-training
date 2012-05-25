

public class SRMSystemTestPhase {

	private static final int M = 1000000007;

	private class Entry implements Comparable<Entry> {

		private static final int PASSED = 0;
		private static final int CHALLENGED = 1;
		private static final int FAILED = 2;

		private int[] results = new int[3];
		private int passed, failed, challenged;

		public Entry(int n) {
			for (int i = 0; i < 3; i++) {
				int r = (n % 3);
				results[i] = r;
				switch (r) {
				case PASSED:
					passed++;
					break;
				case FAILED:
					failed++;
					break;
				case CHALLENGED:
					challenged++;
					break;
				}
				n /= 3;
			}
		}

		public boolean match(String pattern) {
			for (int i = 0; i < 3; i++) {
				char c = pattern.charAt(i);
				if (c == 'N') {
					if ( results[i] != FAILED) {
						return false;
					}
				}
			}
			return true;
		}

		public int compareTo(Entry other) {
			if (passed != other.passed)
				return other.passed - passed;
			if (challenged != other.challenged)
				return challenged - other.challenged;
			return 0;
		}
	}

	public int countWays(String[] description) {
		final Entry[] patterns = new Entry[27];
		for (int p = 0; p < 27; p++) {
			patterns[p] = new Entry(p);
		}

		int l = description.length;
		int[][] dp = new int[27][l]; // Dp(x,y) : pattern x at line y
		for (int p = 0; p < 27; p++) {
			if (patterns[p].match(description[0])) {
				dp[p][0] = 1;
			}
		}
		
		for (int i = 1; i < l; i++) {
			for (int p = 0; p < 27; p++) {
				if (!patterns[p].match(description[i])) continue;
				for (int prev = 0; prev < 27; prev++) {
					if (patterns[p].compareTo(patterns[prev]) >= 0) {
						dp[p][i] = (dp[p][i] + dp[prev][i - 1]) % M;
					}
				}
				
			}
		}

		int res = 0;
		for (int p = 0; p < 27; p++) {
			res = (res + dp[p][l - 1]) % M;
		}
		
		return res;
	}
}
