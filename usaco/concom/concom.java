/*
ID: changhu1
LANG: JAVA
TASK: concom
 */
import java.io.*;
import java.util.*;

public class concom {

	private static int N = 100;
	
	public String[] solve(int[] froms, int[] tos, int[] pts) {
		int n = froms.length;

		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> toCheck = new ArrayList<Integer>();
		
		boolean[][] controls = new boolean[N + 1][N + 1];
		int[][] percentages = new int[N + 1][N + 1];
		
		for (int i = 0; i < n; i++) {
			percentages[froms[i]][tos[i]] = pts[i];
		}		
		
		for (int i = 0; i < n; i++) {
			int from = froms[i];
			toCheck.clear();
			visited.clear();
			toCheck.add(from);
			int[] controlRates = new int[N + 1];
			
			while (!toCheck.isEmpty()) {
				int checking = toCheck.remove(0);
				visited.add(checking);

				for (int to = 1; to <= N ; to++) {
					if (percentages[checking][to] > 0 && !visited.contains(to)) {
						controlRates[to] += percentages[checking][to];
						if (controlRates[to] > 50) {
							controls[from][to] = true;
							toCheck.add(to);
						}
					}
				}
			}
			
		}
		
		ArrayList<String> res = new ArrayList<String>();
		for (int from = 1; from <= N; from ++) {
			for (int to = 1; to <= N; to++) {
				if (controls[from][to]) {
					res.add(String.format("%d %d", from, to));
				}
			}
		}
		
		return res.toArray(new String[0]);
	}

	public static void main(String[] args) throws IOException {
		String problemName = "concom";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[] froms = new int[n];
		int[] tos = new int[n];
		int[] percentages = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			froms[i] = Integer.parseInt(st.nextToken());
			tos[i] = Integer.parseInt(st.nextToken());
			percentages[i] = Integer.parseInt(st.nextToken());
		}

		String[] res = (new concom()).solve(froms, tos, percentages);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}