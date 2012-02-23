/*
ID: changhu1
LANG: JAVA
TASK: lamps
 */
import java.io.*;
import java.util.*;

public class lamps {

	int[] a = new int[4];

	public String[] solve(int n, int c, int[] ons, int[] offs) {
		ArrayList<Integer> states = new ArrayList<Integer>();
		ArrayList<String> res = new ArrayList<String>();

		int[] lamps = new int[n + 1];
		
		for (int state = 0; state < (1 << 4); state++) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				a[i] = state >> i & 1;
				sum += a[i];
			}
			if (sum % 2 != c % 2) continue;		
			if (sum > c) continue;

			// Operate the lamps
			for (int i = 1; i <= n; i++) {
				lamps[i] = 1;
				lamps[i] += a[0];
				if (i % 2 == 1) lamps[i] += a[1];
				if (i % 2 == 0) lamps[i] += a[2];
				if (i % 3 == 1) lamps[i] += a[3];
				lamps[i] %= 2;
			}
			
			boolean stateOkay = true;
			for (int i : ons) {
				if (lamps[i] != 1) stateOkay = false; 
			}
			for (int i : offs) {
				if (lamps[i] != 0) stateOkay = false; 
			}
			if (stateOkay) {
				res.add(printLamps(lamps));
			}
		}
		
		int l = res.size();
		if (l == 0) return new String[] { "IMPOSSIBLE" };
		Collections.sort(res);
		return res.toArray(new String[0]);
	}

	private String printLamps(int[] lamps) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < lamps.length; i++) {
			sb.append(lamps[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		String problemName = "lamps";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.readLine());
		ArrayList<Integer> ons = new ArrayList<Integer>();
		int i = Integer.parseInt(st.nextToken());
		while (i > -1) {
			ons.add(i);
			i = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(f.readLine());
		ArrayList<Integer> offs = new ArrayList<Integer>();
		i = Integer.parseInt(st.nextToken());
		while (i > -1) {
			offs.add(i);
			i = Integer.parseInt(st.nextToken());
		}

		String[] res = (new lamps()).solve(n, c, toArray(ons), toArray(offs));

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	private static int[] toArray(ArrayList<Integer> list) {
		int l = list.size();
		int[] res = new int[l];
		for (int i = 0; i < l; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}