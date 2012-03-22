public class TheLockDivTwo {

	public String password(int n, int k) {
		if (k == 1) {
			StringBuilder sb = new StringBuilder(n);
			for (int i = 0; i < n; i++) {
				sb.append("0");
			}
			return sb.toString();
		}

		int half = 1 << (n - 1);
		if (k <= half) return "0" + password(n - 1, k);
		if (k == half + 1) return "1" + password(n - 1, half);
		k -= half;
		return "1" + password(n - 1, k - 1);
	}

}
