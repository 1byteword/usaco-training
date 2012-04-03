public class TheTicketsDivTwo {

	public double find(int n, int m, int k) {
		return dice(m - 1, n, k);
	}

	double[][][] cache = new double[10 + 1][10 + 1][10 + 1];

	private double dice(int pos, int nf, int more) {

		if (cache[pos][nf][more] > 0) return cache[pos][nf][more];

		double res = 0.0;
		if (more == 0 || nf == 1) {
			res = pos == 0 ? 1 : 0;
		} else {
			if (pos == 0) {
				res += (1.0 / 6);
				res += dice(nf - 1, nf, more - 1) / 2;
			} else {
				res += dice(pos - 1, nf, more - 1) / 2;
				res += dice(pos - 1, nf - 1, more - 1) / 3;
			}
		}
		cache[pos][nf][more] = res;

		return res;
	}

}
