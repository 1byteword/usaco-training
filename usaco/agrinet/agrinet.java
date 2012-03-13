/*
ID: changhu1
LANG: JAVA
TASK: agrinet
 */
import java.io.*;
import java.util.*;

public class agrinet {

	int[][] map;
	HashSet<Integer> tree = new HashSet<Integer>();

	public int solve(int n, int[][] map) {
		this.map = map;

		// mst - prim
		int treeCost = 0;
		int[] distances = new int[n];
		distances[0] = 0;
		for (int i = 1; i < n; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		while (tree.size() < n) {
			int checking = findMin(distances);
			treeCost += distances[checking];
			tree.add(checking);

			for (int point : neighbors(checking)) {
				distances[point] = Math.min(distances[point], map[checking][point]);
			}
		}

		return treeCost;

	}

	private int findMin(int[] distances) {
		int res = 0;
		int value = Integer.MAX_VALUE;
		for (int i = 0; i < distances.length; i++) {
			if (tree.contains(i)) continue;
			if (value > distances[i]) {
				res = i;
				value = distances[i];
			}
		}
		return res;
	}

	private ArrayList<Integer> neighbors(int point) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < map[point].length; i++) {
			if (tree.contains(i)) continue;
			int d = map[point][i];
			if (d < Integer.MAX_VALUE && d > 0) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "agrinet";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < n; j++) {
				if (st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} else {
					st = new StringTokenizer(f.readLine());
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int res = (new agrinet()).solve(n, map);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}