public class SteeplechaseTrack {

	public int maxComplexity(String[] fences, String[] tracks, int N) {
		int l = fences.length;
		int[] difficulty = new int[l];
		int[] fromStart = new int[l];
		int[] toEnd = new int[l];
		for (int i = 0; i < l; i++) {
			difficulty[i] = Integer.parseInt(String.valueOf(fences[i].charAt(0)));
			fromStart[i] = Integer.parseInt(String.valueOf(fences[i].charAt(1)));
			toEnd[i] = Integer.parseInt(String.valueOf(fences[i].charAt(2)));
		}
		int[][] track = new int[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				track[i][j] = Integer.parseInt(String.valueOf(tracks[i].charAt(j)));
			}
		}

		int[][] dp = new int[N][l];
		for (int f = 0; f < l; f++) {
			if (fromStart[f] > 0) {
				dp[0][f] = fromStart[f] + difficulty[f];
			}
		}
		for (int i = 1; i < N; i++) {
			for (int f = 0; f < l; f++) {
				for (int prev = 0; prev < l; prev++) {
					if (track[prev][f] > 0 && dp[i-1][prev] > 0) {
						dp[i][f] = Math.max(dp[i][f], dp[i - 1][prev] + track[prev][f] + difficulty[f]);
					}
				}
			}

		}
		int res = -1;
		for (int i = 0; i < N; i++) {
			for (int f = 0; f < l; f++) {
				if (toEnd[f] > 0 && dp[i][f] > 0) {
					res = Math.max(res, dp[i][f] + toEnd[f]);
				}
			}
		}

		return res;
	}
}
