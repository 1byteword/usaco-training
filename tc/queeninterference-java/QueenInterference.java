import java.util.ArrayList;

public class QueenInterference {

	final private static int N = 1000;
	final private long[] rnum = new long[N];

	public int numSteps(int n) {
		rinit();

		// col = 1..n, row[col] = 1..n
		// row[0] = not used
		int[] row = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			row[i] = rnext(n);
		}

		int res = 0;

		while (true) {
			ArrayList<Integer> reachable = reach(row);
			if (reachable.size() == 0) break;
			int currentCol = reachable.get(rnext(reachable.size()) - 1);

			ArrayList<Integer> fewestRow = fewsetReachable(currentCol, row);

			int q = 1;
			if (fewestRow.size() > 1) {
				q = rnext(fewestRow.size());
			}

			row[currentCol] = fewestRow.get(q - 1);
			res++;
		}

		return res;
	}

	private ArrayList<Integer> fewsetReachable(int currentCol, int[] row) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = row.length - 1;

		int[] reachable = new int[n + 1];

		int min = n;
		for (int fromRow = 1; fromRow <= n; fromRow++) {
			for (int to = 1; to <= n; to++) {
				if (currentCol == to) continue;
				if (fromRow == row[to] || Math.abs(to - currentCol) == Math.abs(row[to] - fromRow)) {
					reachable[fromRow]++;
				}
			}
			min = Math.min(min, reachable[fromRow]);
		}
		for (int fromRow = 1; fromRow <= n; fromRow++) {
			if (reachable[fromRow] == min) {
				res.add(fromRow);
			}
		}
		return res;
	}

	private ArrayList<Integer> reach(int[] row) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		int n = row.length - 1;
		for (int from = 1; from <= n; from++) {
			for (int to = 1; to <= n; to++) {
				if (from == to) continue;
				if (row[from] == row[to] || Math.abs(to - from) == Math.abs(row[to] - row[from])) {
					res.add(from);
					break;
				}
			}
		}

		return res;
	}

	private void rinit() {
		rnum[0] = 1;
		for (int i = 1; i < N; i++) {
			rnum[i] = (16807 * rnum[i - 1]) % 2147483647L;
		}
		rpos = 0;
	}

	int rpos = 0;

	private int rnext(int up) {
		return (int) ((rnum[rpos++] % up) + 1);
	}



}
