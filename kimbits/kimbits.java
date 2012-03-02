/*
ID: changhu1
LANG: JAVA
TASK: kimbits
 */
import java.io.*;
import java.util.*;

public class kimbits {

	public String solve(int n, int l, long k) {
		if (n == l) return printBinary(k - 1, n);
		if (k <= 3) return printBinary(k - 1, n);

		int n0 = n;
		long count = numbers(n0, l);
		while (count >= k) {
			n0--;
			count = numbers(n0, l);
		}

		long high;
		for (high = 1; high < (1 << (n - n0 + 1)); high++) {
			long newCount = numbers(n0, l - countBit(high));
			if (newCount + count >= k) {
				break;
			}
			count += newCount;
		}
		return printBinary(high, n - n0) + solve(n0, l - countBit(high), k - count);
		
	}

	private int countBit(long t) {
		int res = 0;
		while (t > 0) {
			res += (t & 1);
			t = t >> 1;
		}
		return res;
	}

	long numbers(int n, int l) {
		long res = 0;
		for (int i = 0; i <= l; i++) {
			res += nchoosek(n, i);
		}
		return res;
	}

	long nchoosek(int n, int k) {
		long res = 1;
		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}

	String printBinary(long i, int len) {
		StringBuilder res = new StringBuilder();
		while (i > 0) {
			res.insert(0, i & 1);
			i = i >> 1;
		}
		while (res.length() < len) {
			res.insert(0, "0");
		}
		return res.toString();
	}

	public static void main(String[] args) throws IOException {
		String problemName = "kimbits";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		String res = (new kimbits()).solve(n, l, k);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}