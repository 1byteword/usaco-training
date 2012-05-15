public class Untypeset {

	public int evaluate(String[] expression) {
		int m = expression.length;
		int n = expression[0].length();
		return eval(expression, 0, 0, m, n);

	}

	private int eval(String[] expression, int x0, int y0, int x1, int y1) {

		for (int j = y0; j < y1; j++) {
			boolean space = true;
			for (int i = x0; i < x1; i++) {
				char charAt = expression[i].charAt(j);
				if (charAt != ' ') {
					space = false;
					break;
				}
			}
			if (space) {
				y0++;
			} else {
				break;
			}
		}

		for (int j = y1 - 1; j >= y0; j--) {
			boolean space = true;
			for (int i = x0; i < x1; i++) {
				char charAt = expression[i].charAt(j);
				if (charAt != ' ') {
					space = false;
					break;
				}
			}
			if (space) {
				y1--;
			} else {
				break;
			}
		}
		
		for (int j = y0; j < y1; j++) {
			boolean space = true;
			boolean plus = false;
			for (int i = x0; i < x1; i++) {
				char charAt = expression[i].charAt(j);
				if (charAt != ' ' && charAt != '+') {
					space = false;
				}
				if (charAt == '+') {
					plus = true;
				}
			}
			if (space && plus) {
				int res = eval(expression, x0, y0, x1, j - 1)
						+ eval(expression, x0, j + 2, x1, y1);
				return res;
			}
		}

		for (int i = x0; i < x1; i++) {
			boolean hline = true;
			for (int j = y0; j < y1; j++) {
				if (expression[i].charAt(j) != '-') {
					hline = false;
					break;
				}
			}
			if (hline) {
				int res = eval(expression, x0, y0, i, y1)
						/ eval(expression, i + 1, y0, x1, y1);
				return res;
			}
		}

		for (int i = x0; i < x1; i++) {
			String s = expression[i].substring(y0, y1).trim();
			if (s.length() > 0) {
				return Integer.parseInt(s);
			}
		}

		return -1;

	}
}
