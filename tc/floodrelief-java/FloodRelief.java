public class FloodRelief {

	private int[][] map;
	private int m, n;
	private  String[] heights;

	public int minimumPumps(String[] heights) {
		m = heights.length;
		n = heights[0].length();
		this.heights = heights;

		int component = 0;
		map = new int[m][n];

		boolean changed = true;
		while (changed) {
			changed = false;

			int mini = -1;
			int minj = -1;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > 0) continue;
					changed = true;
					int h = heights[i].charAt(j);
					if (min > h) {
						min = h;
						mini = i;
						minj = j;
					}
				}
			}
			if (changed) {
				flood(mini, minj, ++component);
			}
		}
		return component ;
	}

	private static int[] di = new int[] { 0, 0, -1, 1 };
	private static int[] dj = new int[] { -1, 1, 0, 0 };
	private void flood(int i, int j, int c) {
		map[i][j] = c;
		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni < 0 || ni == m || nj < 0 || nj == n) continue;
			if (map[ni][nj] > 0) continue;
			if (heights[ni].charAt(nj) >= heights[i].charAt(j)) {
				flood(ni, nj, c);
			}
		}
	}
}
