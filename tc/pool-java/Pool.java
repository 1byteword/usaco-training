public class Pool {

	private static final int[] to1 = new int[] { 0, 1, 1, 0, 8, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1 };
	private static final int[] to2 = new int[] { 1, 0, 0, 1, 8, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

	public int rackMoves(int[] x) {
		int l = x.length;
		int[] from = new int[l];
		for (int i = 0; i < l; i++) {
			from[i] = x[i] < 8 ? 0 : (x[i] > 8 ? 1 : 8);
		}

		return Math.min(rack(from, to1), rack(from, to2));
	}

	private int rack(int[] from, int[] to) {
		int l = from.length;
		int toEight = -1;
		int fromEight = -1;
		int res = 0;
		for (int i = 0; i < l; i++) {
			if (from[i] == 8 && to[i] != 8) {
				toEight = to[i];
			} else if (to[i] == 8 && from[i] != 8) {
				fromEight = from[i];
			} else if (from[i] != to[i]) {
				res += 1;
			}
		}

		res /= 2;
		res += fromEight == -1 ? 0 : fromEight != toEight ? 2 : 1;

		return res;
	}

}
