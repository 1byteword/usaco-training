import java.util.ArrayList;

public class QuasiLatinSquares {
	int n, d;
	boolean found;
	int[][] sqr;
	boolean[][] usedRow;
	boolean[][] usedCol;

	public String[] makeSquare(int n, int d) {
		this.n = n;
		this.d = d;
		sqr = new int[d][d];
		usedRow = new boolean[d][d];
		usedCol = new boolean[d][d];
		square(0, 0);

		int offset = n - d;
		int[][] res = new int[n][n];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				res[offset + i][offset + j] = sqr[i][j];
			}
		}

		for (int i = 0; i < offset; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = res[offset][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < offset; j++) {
				res[i][j] = res[i][offset];
			}
		}

		return toString(res);
	}

	private void square(int r, int c) {
		if (c == d) {
			c = 0;
			r++;
		}
		if (r == d) {
			found = true;
			return;
		}
		if (r == 0) {
			sqr[0][c] = c;
			usedCol[c][c] = true;
		}
		if (c == 0) {
			sqr[r][0] = r;
			usedRow[r][r] = true;
		}

		if (r > 0 && c > 0) {
			// put r, c
			for (int put = 0; put < d; put++) {
				if (usedRow[r][put] || usedCol[c][put] || found) {
					continue;
				}
				sqr[r][c] = put;
				usedRow[r][put] = true;
				usedCol[c][put] = true;
				square(r, c + 1);
				usedRow[r][put] = false;
				usedCol[c][put] = false;
			}
		} else {
			square(r, c + 1);
		}
	}

	private static String[] toString(int[][] arr) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
			}
			res.add(sb.toString().trim());
		}
		return res.toArray(new String[0]);
	}

}
