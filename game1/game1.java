/*
ID: changhu1
LANG: JAVA
TASK: game1
 */
import java.io.*;
import java.util.*;

public class game1 {

	int[][][] cache;
	int[] numbers;

	// DFS with cache, which is in effect DP
	public int[] solve(int[] nums) {
		numbers = nums;
		int l = nums.length;
		cache = new int[l][l][2];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				cache[i][j][0] = cache[i][j][1] = -1;
			}
		}

		return dfs(0, l - 1);

	}

	private int[] dfs(int start, int end) {
		if (cache[start][end][0] > -1) return cache[start][end];

		int turn = (numbers.length - (end - start + 1)) % 2;

		int[] res;
		if (end - start + 1 == 2) {
			res = new int[2];
			res[turn] += Math.max(numbers[start], numbers[end]);
			res[1 - turn] += Math.min(numbers[start], numbers[end]);
			
			cache[start][end][0] = res[0];
			cache[start][end][1] = res[1];
			return res;
		}

		int[] rightSums = dfs(start, end - 1);
		rightSums[turn] += numbers[end];

		int[] leftSums = dfs(start + 1, end);
		leftSums[turn] += numbers[start];

		if (leftSums[turn] > rightSums[turn]) {
			res = leftSums;
		} else {
			res =  rightSums;
		}
		cache[start][end][0] = res[0];
		cache[start][end][1] = res[1];
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "game1";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] numbers = new int[n];
		String line = f.readLine();
		int p = 0;
		while (line != null) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				numbers[p++] = Integer.parseInt(st.nextToken());
			}
			line = f.readLine();
		}
		int[] res = (new game1()).solve(numbers);
		assert (res.length == 2);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(String.format("%d %d", res[0], res[1]));
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}
