public class ReverseUnnaturalBaseConversion {

	private class Result {
		int r;
		int x;

		public Result(int x, int r) {
			this.x = x;
			this.r = r;
		}
	}

	public String convertToBase(int a, int b) {
		if (a == 0) return "0";
		if (b > 0 && a < 0) return "-" + convertToBase(-a, b);

		String res = "";
		while (a != 0) {
			Result result = div(a, b);
			res = String.valueOf(result.r) + res;
			a = result.x;
		}

		return res;
	}

	private Result div(int a, int b) {
		int r, x;
		if (b > 0) {
			x = a / b;
		} else {
			if (a > 0) {
				x = a / b;
			} else {
				if (a % b == 0) {
					x = a / b;
				} else {
					x = a / b + 1;
				}
			}
		}

		r = a - b * x;
		return new Result(x, r);
	}

}
