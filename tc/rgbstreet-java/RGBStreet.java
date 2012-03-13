public class RGBStreet {

	public int estimateCost(String[] houses) {
		int n = houses.length;

		int[][] accu_cost = new int[n][3];

		for (int i = 0; i < 3; i++) {
			accu_cost[0][i] = Integer.parseInt(houses[0].split(" ")[i]);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int cost = Integer.parseInt(houses[i].split(" ")[j]);
				accu_cost[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (k == j) continue;
					accu_cost[i][j] = Math.min(accu_cost[i][j], accu_cost[i - 1][k] + cost);
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			res = Math.min(res, accu_cost[n - 1][i]);
		}

		return res;
	}

}
