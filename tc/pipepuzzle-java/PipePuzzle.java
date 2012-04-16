public class PipePuzzle {

	// N, W, S, E
	int[] di = new int[] { -1, 0, 1, 0 };
	int[] dj = new int[] { 0, -1, 0, 1 };

	String[] pipes;
	boolean[][] used = new boolean[20][20];
	int m, n;

	public int longest(String[] pipes) {
		this.pipes = pipes;
		m = pipes.length;
		n = pipes[0].length();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pipes[i].charAt(j) == 'N') {
					return dfs(i, j, 0);
				} else if (pipes[i].charAt(j) == 'W') {
					return dfs(i, j, 1);
				} else if (pipes[i].charAt(j) == 'S') {
					return dfs(i, j, 2);
				} else if (pipes[i].charAt(j) == 'E') {
					return dfs(i, j, 3);
				}
			}
		}
		
		return -1;
	}

	private int dfs(int i, int j, int dir) {
		int ni = i + di[dir];
		int nj = j + dj[dir];
		if (ni < 0 || nj < 0 || ni >= m || nj >= n) return 0;
		if ((pipes[ni].charAt(nj) != '+') && used[ni][nj]) return 0;

		used[i][j] = true;
		int res = 0;
		if (pipes[ni].charAt(nj) == 'L') {
			res = 1 + dfs(ni, nj, (dir + 1) % 4);
			res = Math.max(res, 1 + dfs(ni, nj, (dir + 3) % 4));
		} else {
			res = 1 + dfs(ni, nj, dir);
		}
		used[i][j] = false;
		return res;
	}

}
