import java.util.Arrays;

public class AutoMarket {

	class Auto implements Comparable<Auto> {
		int cost;
		int features;
		int fixTimes;

		public Auto(int cost, int features, int fixTimes) {
			this.cost = cost;
			this.features = features;
			this.fixTimes = fixTimes;
		}

		public int compareTo(Auto other) {
			return this.cost - other.cost;
		}

		public boolean lemonerThan(Auto other) {
			if (cost <= other.cost) return false;
			if (features >= other.features) return false;
			if (fixTimes <= other.fixTimes) return false;
			return true;
		}

	}

	public int maxSet(int[] cost, int[] features, int[] fixTimes) {
		int l = cost.length;
		Auto[] autos = new Auto[l];
		for (int i = 0; i < l; i++) {
			autos[i] = new Auto(cost[i], features[i], fixTimes[i]);
		}
		Arrays.sort(autos);
		
		int[] dp = new int[l];
		
		for (int i = 0; i < l; i++) {
			dp[i] = 1;
		}
		
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < i; j++) {
				if (autos[i].lemonerThan(autos[j])) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < l; i++) {
					res = Math.max(dp[i], res);
		}
		

		return res;
	}

}
