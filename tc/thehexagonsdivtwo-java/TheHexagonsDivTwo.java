import java.util.Arrays;

public class TheHexagonsDivTwo {

	int n, k, center;
	long res = 0;
	int[] ring = new int[6], mods;

	public long count(int n, int k) {
		this.n = n;
		this.k = k;
		mods = new int[k];
		for (int i = 1; i <= n; i++) {
			mods[i % k]++;
		}
		for (int i = 0; i < k; i++) {
			center = i;
			dfs(0);
		}
		return res / 6;
	}

	void dfs(int p) {
		if (p == 6) {
			int[] temp = new int[k];
			for (int i = 0; i < k; i++)
				temp[i] = mods[i];

			long t = temp[center];
			for (int i = 0; i < 6; i++) {
				long x = temp[ring[i]];
				t *= x;
				temp[ring[i]]--;
			}
			res += t;
		} else {
			for (int i = 0; i < k; i++) {
				ring[p] = i;
				if (ring[p] == center)
					continue;
				if (p > 0 && ring[p] == ring[(p - 1 + 6) % 6])
					continue;
				if (p == 5 && ring[p] == ring[0])
					continue;
				dfs(p + 1);
			}
		}

	}
}
