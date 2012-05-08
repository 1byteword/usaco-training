public class Hilbert {

	public int steps(int k, int x, int y) {
		if (k == 1) {
			if (x == 1) {
				if (y == 1)
					return 0;
				if (y == 2)
					return 1;
			}
			// x == 2
			if (y == 1)
				return 3;
			if (y == 2)
				return 2;
		}

		int b = 1 << (k - 1);
		int m = b * b;
		if (x > b) {
			if (y > b) {
				return 2 * m + steps(k - 1, x - b, y - b);
			} else {
				return 3 * m + steps(k - 1, b + 1 - y, 2 * b + 1 - x);
			}
		} else {
			if (y > b) {
				return m + steps(k - 1, x, y - b);
			} else {
				return steps(k - 1, y, x);
			}
		}
	}

}
