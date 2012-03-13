/*
ID: changhu1
LANG: JAVA
TASK: milk2
 */
import java.io.*;
import java.util.*;

public class milk2 {

	class Span implements Comparable<Span> {
		int start;
		int end;

		public void merge(Span other) {
			start = Math.min(start, other.start);
			end = Math.max(end, other.end);
		}

		public boolean overlap(Span other) {
			if (other.start >= start && other.start <= end) return true;
			if (start >= other.start && start <= other.end) return true;
			return false;
		}

		public Span(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Span o) {
			return start - o.start;
		}

		public int length() {
			return end - start;
		}

		public int distance(Span other) {
			return other.start - end;
		}
		
		public String toString() {
			return String.format("<%d, %d>", start, end);
		}
	}

	public String solve(int[] starts, int[] ends) {
		ArrayList<Span> spans = new ArrayList<milk2.Span>();
		for (int i = 0; i < starts.length; i++) {
			spans.add(new Span(starts[i], ends[i]));
		}
		Collections.sort(spans);
		for (int i = 0; i < spans.size() - 1;) {
			Span curr = spans.get(i);
			Span next = spans.get(i + 1);
			if (curr.overlap(next)) {
				curr.merge(next);
				spans.remove(i + 1);
			} else {
				i++;
			}
		}

		int maxWork = 0;
		int maxIdle = 0;

		for (int i = 0; i < spans.size(); i++) {
			maxWork = Math.max(maxWork, spans.get(i).length());
			if (i + 1 < spans.size()) maxIdle = Math.max(maxIdle, spans.get(i).distance(spans.get(i + 1)));

		}
		return String.format("%d %d", maxWork, maxIdle);
	}

	// solve0 below
	public String solve0(int[] starts, int[] ends) {
		int tmin = starts[0];
		int tmax = ends[0];
		for (int i = 0; i < starts.length; i++) {
			tmin = Math.min(tmin, starts[i]);
			tmax = Math.max(tmax, ends[i]);
		}

		boolean[] milking = new boolean[tmax - tmin];
		for (int i = 0; i < starts.length; i++) {
			for (int j = starts[i] - tmin; j < ends[i] - tmin; j++) {
				milking[j] = true;
			}
		}

		int maxWork = count(milking, true);
		int maxIdle = count(milking, false);
		return String.format("%d %d", maxWork, maxIdle);
	}

	private int count(boolean[] milking, boolean work) {
		int start = 0;
		boolean counting = false;
		for (int i = 0; i < milking.length; i++) {
			if (milking[i] == work) {
				counting = true;
				start = i;
				break;
			}
		}

		if (!counting) return 0;

		int res = 0;
		for (int i = start; i < milking.length; i++) {
			if (milking[i] != work && counting) {
				counting = false;
				res = Math.max(res, i - start);
			} else if (milking[i] == work && !counting) {
				counting = true;
				start = i;
			}
		}
		if (counting) {
			res = Math.max(res, milking.length - start);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "milk2";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			starts[i] = Integer.parseInt(st.nextToken());
			ends[i] = Integer.parseInt(st.nextToken());
		}

		String res = (new milk2()).solve(starts, ends);

		// output result
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}