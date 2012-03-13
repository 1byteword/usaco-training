/*
ID: changhu1
LANG: JAVA
TASK: sprime
 */
import java.io.*;
import java.util.*;

public class sprime {

	int CUTOFF = 10000000; // 7-digit primes
	BitSet isComposite = new BitSet(CUTOFF + 1);
	long[] oneDigits = new long[] { 2, 3, 5, 7 };
	ArrayList<Long> res = new ArrayList<Long>();

	public long[] solve(int length) {
		isComposite = sift();

		if (length == 1) {
			return oneDigits;
		}

		for (long i : oneDigits) {
			dfs(i, length - 1);
		}
		return toArray(res);
	}

	private void dfs(long x, int length) {
		if (length == 0) {
			if (!isComposite(x)) {
				res.add(x);
			}
			return;
		}
		
		for (int i = 1; i <=9; i+= 2) {
			long newx = x * 10 + i;
			if (!isComposite(newx)) {
				dfs(newx, length - 1);
			}
		}
	}

	private boolean isComposite(long x) {
		if (x <= CUTOFF) return isComposite.get((int) x);
		for (int i = 2; i <= (int) Math.sqrt(x); i++) {
			if (x % i == 0) return true;
		}
		return false;
	}

	private long[] toArray(ArrayList<Long> res2) {
		long[] res = new long[res2.size()];
		for (int i = 0; i < res2.size(); i++) {
			res[i] = res2.get(i);
		}
		return res;
	}

	public BitSet sift() {
		int max = CUTOFF;
		int sqrt = (int) Math.sqrt(max);
		for (int m = 2; m <= sqrt; m++) {
			if (!isComposite.get(m)) {
				for (int k = m * m; k <= max; k += m)
					isComposite.set(k);
			}
		}
		return isComposite;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "sprime";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		int length = Integer.parseInt(f.readLine());
		long[] res = (new sprime()).solve(length);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (long r : res) {
			out.println(r);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}