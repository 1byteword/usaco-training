public class ConvexPolygon {

	public double findArea(int[] x, int[] y) {
		double res = 0.0;
		int l = x.length;
		for (int i = 0; i < l - 1; i++) {
			res += (x[i] * y[i + 1]);
		}
		res += (x[l - 1] * y[0]);
		
		for (int i = 0; i < l - 1; i++) {
			res -= (y[i] * x[i + 1]);
		}
		res -= (y[l - 1] * x[0]);
		
		return Math.abs(res) / 2.0;
	}

}
