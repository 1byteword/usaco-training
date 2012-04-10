public class KingdomReorganization {

	public int getCost(String[] kingdom, String[] build, String[] destroy) {
		int n = kingdom.length;
		int[][] cost = new int[n][n];

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (kingdom[i].charAt(j) == '1') {
					res += value(destroy[i].charAt(j));
					cost[i][j] = -value(destroy[i].charAt(j));
				} else {
					cost[i][j] = value(build[i].charAt(j));
				}
			}
		}
		return res / 2 + mst(cost, kingdom);
	}

	final static private int M = Integer.MAX_VALUE;

	private int mst(int[][] cost, String[] kingdom) {
		int n = kingdom.length;

		boolean[] inTree = new boolean[n];
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = M;
		}

		int res = 0;
		int treeSize = 0;
		dist[0] = 0;
		int checking = 0;
		inTree[checking] = true;
		treeSize++;

		while (treeSize < n) {
			int minDist = M;
			int minNode = -1;
			for (int i = 0; i < n; i++) {
				if (inTree[i]) continue;
				dist[i] = Math.min(dist[i], cost[i][checking]);
				if (dist[i] < minDist) {
					minDist = dist[i];
					minNode = i;
				}
			}
			checking = minNode;
			res += minDist;
			inTree[checking] = true;
			treeSize++;
		}

		return res;
	}

	private int value(char c) {
		if (c >= 'A' && c <= 'Z') {
			return c - 'A';
		}
		if (c >= 'a' && c <= 'z') {
			return c - 'a' + 26;
		}
		return M;
	}

}
