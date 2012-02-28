/*
ID: changhu1
LANG: JAVA
TASK: humble
 */
import java.io.*;
import java.util.*;

public class humble {

	public long solve(int n, long[] primes) {

		ArrayList<Long> humbles = new ArrayList<Long>();
		humbles.add(1L);
		
		// This is key
		int[] cursor = new int[primes.length];

		while (humbles.size() < n + 1) {
			long newMin = Long.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				newMin = Math.min(primes[j] * humbles.get(cursor[j]), newMin);
			}
			humbles.add(newMin);
			for (int j = 0; j < primes.length; j++) {
				while (primes[j] * humbles.get(cursor[j]) <= newMin) {
					cursor[j]++;
				}
			}
		}
		return humbles.get(n);
	}

	// Too slow
	public long solveHash(int n, long[] primes) {

		HashSet<Long> humbles = new HashSet<Long>();
		humbles.add(1L);

		for (long res = 2; res <= Long.MAX_VALUE; res++) {
			for (long p : primes) {
				if (res % p > 0) continue;
				if (humbles.contains(res / p)) {
					humbles.add(res);
					if (humbles.size() == n + 1) return res;
					continue;
				}
			}
		}
		return -1;
	}

	// Too slow
	public long solveHeap(int n, long[] primes) {

		PriorityQueue<Long> heap = new PriorityQueue<Long>();
		for (long p : primes) {
			heap.add(p);
		}
		int seen = 0;
		long res = -1;
		while (seen < n) {
			res = heap.remove();
			for (long p : primes) {
				long newNum = p * res;
				if (!heap.contains(newNum)) {
					heap.add(newNum);
				}
			}
			seen++;
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "humble";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long[] p = new long[k];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < k; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		long res = (new humble()).solve(n, p);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}