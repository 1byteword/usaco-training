public class ActivateGame {

	String[] grid;
	boolean[][] inTree;
	int m, n;
	private final static int[] di = new int[] { -1, 1, 0, 0 };
	private final static int[] dj = new int[] { 0, 0, -1, 1 };


	public int findMaxScore(String[] grid) {
		this.grid = grid;
		m = grid.length;
		n = grid[0].length();
		inTree = new boolean[m][n];
		int res = 0;
		inTree[0][0] = true;
		
		boolean changed = true;
		while (changed) {
			changed = false;
			
			int maxi = -1;
			int maxj = -1;
			int maxDiff = -1;
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (inTree[i][j]) continue;
					
					int diff = -1;
					for (int k = 0; k < di.length; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						if (ni >= m || ni < 0 || nj >= n || nj < 0) continue;
						if (!inTree[ni][nj]) continue;
						diff = Math.max(diff,  Math.abs(value(i, j) - value(ni, nj)));
					}
					
					if (diff > -1) {
						if (maxDiff <= diff) {
							maxDiff = diff;
							maxi = i;
							maxj = j;
						}
					}
				}
			}
			if (maxDiff > -1) {
				changed = true;
				res += maxDiff;
				inTree[maxi][maxj] = true;
			}
		}
		return res;
	}


	private int value(int i, int j) {
		char c = grid[i].charAt(j);
		if (c >= '0' && c <= '9') return c - '0';
		if (c >= 'a' && c <= 'z') return c - 'a' + 10;
		if (c >= 'A' && c <= 'Z') return c - 'A' + 36;
		return -1000;
	}
}
