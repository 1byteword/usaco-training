public class ParallelProgramming {

	public int minTime(int[] time, String[] prec) {
		int l = time.length;
		int[][] dp = new int[l][l]; // dp[x][y] = time running y as x-th

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				dp[i][j] = -1;
			}
		}

		for (int i = 0; i < l; i++) {
			boolean independent = true;
			for (int j = 0; j < l; j++) {
				if (prec[j].charAt(i) == 'Y') {
					independent = false;
					break;
				}
			}
			if (independent) {
				dp[0][i] = time[i];
			}
		}

		for (int i = 1; i < l; i++) {
			for (int task = 0; task < l; task++) {
				if (dp[i - 1][task] > -1) {
					dp[i][task] = dp[i - 1][task];
				} else {
					for (int j = 0; j < l; j++) {
						if (prec[j].charAt(task) == 'Y') {
							if (dp[i - 1][j] == -1) {
								dp[i][task] = -1;
								break;
							} else {
								dp[i][task] = Math.max(dp[i][task],
										dp[i - 1][j] + time[task]);
							}
						}
					}

				}

			}
		}

		int res = -1;
		for (int i = 0; i < l; i++) {
			if (dp[l - 1][i] == -1)
				return -1;
			res = Math.max(res, dp[l - 1][i]);
		}

		return res;
	}

}
