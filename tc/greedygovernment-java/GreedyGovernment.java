
public class GreedyGovernment {

	private class Result {
		int route;
		int cost;

		public Result(int r, int c) {
			route = r;
			cost = c;
		}
	}

	String[] tolls;
	boolean[] used;
	int[][] pass;

	public double maxAverageCost(String[] tolls, int tollHike) {
		this.tolls = tolls;
		int n = tolls.length;
		used = new boolean[n];
		pass = new int[n][n];
		used[0] = true;
		Result result = dfs(0);
		if (result.route == 0) return 0.0;

		int maxPass = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxPass = Math.max(maxPass, pass[i][j]);
			}
		}
		return (double) (result.cost + maxPass * tollHike) / result.route;

	}

	private Result dfs(int node) {
		int N = tolls.length;
		if (node == N - 1) return new Result(1, 0);
		int r = 0;
		int c = 0;
		for (int n = 0; n < N; n++) {
			if (used[n]) continue;
			if (tolls[node].charAt(n) == 'X') continue;
			used[n] = true;
			Result rs = dfs(n);
			used[n] = false;
			if (rs.route == 0) continue;
			pass[node][n] += rs.route;
			r += rs.route;
			int toll = tolls[node].charAt(n) - '0';
			assert (toll >= 1 && toll <= 9);
			c += (rs.cost + rs.route * toll);
		}
		return new Result(r, c);
	}

}
