public class ChangingSounds {

	public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel) {
		int n = changeIntervals.length;
		boolean[][] dp = new boolean[n + 1][maxLevel +1];
		for (int i = 0; i < n + 1; i++){
			for (int j = 0; j < maxLevel + 1; j++) {
				dp[i][j] = false;
			}
		}
		
		dp[0][beginLevel] = true;
		
		for (int i = 1; i < n + 1; i++){
			for (int j = 0; j < maxLevel + 1; j++) {
				int change = changeIntervals[i - 1];
				if (j + change <= maxLevel ) {
					dp[i][j] |= dp[i - 1][j + change];	
				}
				if (j - change >= 0 ) {
					dp[i][j] |= dp[i - 1][j - change];	
				}
			}
		}
		
		int res  = -1;
		for (int i = 0; i < maxLevel + 1; i++) {
			if (dp[n][i]) res = i;
		}
		return res;
	}

}
