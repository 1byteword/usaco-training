/*
ID: changhu1
LANG: JAVA
TASK: barn1
 */
import java.io.*;
import java.util.*;

public class barn1 {
	
	public int solve(int boards, int[] stalls) {
		Arrays.sort(stalls);
		int l = stalls.length;
		int res = stalls[l - 1] - stalls[0] + 1;
		
		int[] distances = new int[l - 1];
		for (int i = 0; i < l - 1 ; i++) {
			distances[i] = stalls[i + 1] - stalls[i] - 1;
		}
		Arrays.sort(distances);
		
		for (int i = 0; i < boards - 1; i++) {
			if (l - 2 - i < 0) return res;
			res -= distances[l - 2 - i]; 
		}
		return res;
	}

	public int solve0(int boards, int[] stalls) {
		Arrays.sort(stalls);
		int l = stalls.length;
		int res = stalls[l - 1] - stalls[0] + 1; 
		int used = 1;
		ArrayList<Integer> cutPositions = new ArrayList<Integer>();
		
		while (used < boards) {
			// find max interval
			int maxIntr = 0;
			int cutPos = 0;
			for (int i = 0; i < l - 1 ; i++) {
				int distance = stalls[i + 1] - stalls[i] - 1;
				if (distance > maxIntr && !cutPositions.contains(i)) {
					maxIntr = distance;
					cutPos = i;
				}
			}
			// cut
			res -= maxIntr;
			cutPositions.add(cutPos);
			used++;
		}
		
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "barn1";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] stalls = new int[c];
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(f.readLine());
			stalls[i] = Integer.parseInt(st.nextToken());
		}

		int res = (new barn1()).solve(m, stalls);

		// output result
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}