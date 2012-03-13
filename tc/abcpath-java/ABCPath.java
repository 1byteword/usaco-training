public class ABCPath {

	private static int[] di = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int[] dj = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };

	public int length(String[] grid) {

		int m = grid.length;
		int n = grid[0].length();

		boolean dp[][] = new boolean[m][n];

		for (char searching = 'A'; searching <= 'Z'; searching++) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i].charAt(j) == searching) {
						if (searching == 'A') {
							dp[i][j] = true;
						} else {
							for (int k = 0; k < di.length; k++) {
								int ni = i + di[k];
								int nj = j + dj[k];
								if (ni < 0 || ni >= m) continue;
								if (nj < 0 || nj >= n) continue;
								if (grid[ni].charAt(nj) == searching - 1 && dp[ni][nj]) {
									dp[i][j] = true;
									break;
								}
							}
						}
					}
				}
			}
		}

		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j]) {
					res = Math.max(res, grid[i].charAt(j) - 'A' + 1);
				}
			}
		}
		return res;
	}
	

}
