/*
ID: changhu1
LANG: JAVA
TASK: runround
 */
import java.io.*;
import java.util.*;

public class runround {

	long res = 987654321;
	long m;
	boolean[] hasDigit = new boolean[10];

	public long solve(long m) {
		this.m = m;
		for (int i = 1; i <= 9; i++) {
			hasDigit[i] = true;
			dfs(i);
			hasDigit[i] = false;
		}
		return res;
	}

	private void dfs(long num) {
		if (num > res) {
			return;
		}
		if (num > m) {
			if (runaround(num)) {
				res = Math.min(res, num);
			}
		}
		for (int i = 1; i <= 9; i++) {
			if (hasDigit[i]) continue;
			hasDigit[i] = true;
			dfs(num * 10 + i);
			hasDigit[i] = false;
		}

	}

	private boolean runaround(long num) {
		int[] nums = toArray(num);
		int l = nums.length;
		boolean[] touched = new boolean[l];
		int i = 0;
		while (!touched[i]) {
			touched[i] = true;
			i = (i + nums[i]) % l;
		}
		if (i > 0) return false;
		for (int p = 0; p < l; p++) {
			if (!touched[p]) return false;
		}
		return true;
	}

	private int[] toArray(long num) {
		String s = String.valueOf(num);
		int l = s.length();
		int[] res = new int[l];
		char[] chars = s.toCharArray();
		for (int i = 0; i < l; i++) {
			res[i] = Integer.parseInt(String.valueOf(chars[i]));
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "runround";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		long res = (new runround()).solve(m);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}