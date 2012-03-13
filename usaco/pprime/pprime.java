/*
ID: changhu1
LANG: JAVA
TASK: pprime
 */
import java.io.*;
import java.util.*;

public class pprime {

	int CUTOFF = 10000000;
	BitSet isComposite = new BitSet(CUTOFF + 1);

	public long[] solve(int min, int max) {
		ArrayList<Long> res = new ArrayList<Long>();
		isComposite = sift(CUTOFF);

		for (int i = min; i <= Math.min(max, CUTOFF); i++) {
			if (isComposite(i)) continue;
			if (isPal(i)) res.add((long) i);
		}


		/* generate 8 digit palindrome: */
		for (int d1 = 1; d1 <= 9; d1 += 2) { /* only odd; evens aren't so prime */
			for (int d2 = 0; d2 <= 9; d2++) {
				for (int d3 = 0; d3 <= 9; d3++) {
					for (int d4 = 0; d4 <= 9; d3++) {
						long i  = 10000001 * d1 + 1000010 * d2 + 100100 * d3 + 11000 * d4;
						if (i > max) break;
						if (isComposite(i)) continue;
						res.add(i);
						
					}
				}
			}
		}

		return toArray(res);
	}

	private boolean isComposite(long x) {
		if (x <= CUTOFF) return isComposite.get((int) x);
		for (int i = 2; i <= (int) Math.sqrt(x); i++) {
			if (x % i == 0) return true;
		}
		return false;
	}

	private boolean isPal(int x) {
		if (x / 10 == 0) return true;
		String s = String.valueOf(x);
		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
		}
		return true;
	}

	private long[] toArray(ArrayList<Long> res2) {
		long[] res = new long[res2.size()];
		for (int i = 0; i < res2.size(); i++) {
			res[i] = res2.get(i);
		}
		return res;
	}

	public BitSet sift(int max) {
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
		String problemName = "pprime";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		long[] res = (new pprime()).solve(min, max);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (long r : res) {
			out.println(r);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}