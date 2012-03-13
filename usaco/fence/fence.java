/*
ID: changhu1
LANG: JAVA
TASK: fence
 */
import java.io.*;
import java.util.*;

public class fence {

	private class Edge {
		int from;
		int to;

		public Edge(int f, int t) {
			from = f;
			to = t;
		}

		public String toString() {
			return String.format("(%d-%d)", from, to);
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Edge)) return false;
			Edge other = (Edge) obj;
			return (from == other.from && to == other.to) || (from == other.to && to == other.from);
		}
	}

	ArrayList<Integer> circuit = new ArrayList<Integer>();
	ArrayList<Edge> edges = new ArrayList<Edge>();

	public int[] solve(String[] edgeStrings) {

		ArrayList<Integer> oddPoints = new ArrayList<Integer>();

		int min = Integer.MAX_VALUE;
		for (String s : edgeStrings) {
			StringTokenizer st = new StringTokenizer(s);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to));

			min = Math.min(min, from);
			min = Math.min(min, to);
			oddPoint(oddPoints, from);
			oddPoint(oddPoints, to);
		}

		assert (oddPoints.size() < 3);

		if (oddPoints.size() > 0) {
			dfs(min(oddPoints));
			return toArray(circuit);
		} else {
			dfs(min);
			return toArray(circuit);
		}
	}

	private int min(ArrayList<Integer> points) {
		int res = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			res = Math.min(res, points.get(i));
		}
		return res;
	}

	private void oddPoint(ArrayList<Integer> oddPoints, int from) {
		if (oddPoints.contains(from)) {
			oddPoints.remove(new Integer(from));
		} else {
			oddPoints.add(from);
		}
	}

	private void dfs(int i) {
		int j = neighbor(i);
		while ((j = neighbor(i)) > 0) {
			// has neighbor, remove edge
			edges.remove(new Edge(i, j));
			dfs(j);
		}
		circuit.add(0, i);
	}

	private int neighbor(int i) {
		int res = Integer.MAX_VALUE;
		for (Edge e : edges) {
			if (e.from == i) {
				res = Math.min(res, e.to);
			} else if (e.to == i) {
				res = Math.min(res, e.from);
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private static int[] toArray(ArrayList<Integer> a) {
		int[] res = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			res[i] = a.get(i);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "fence";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		String[] edges = new String[n];
		for (int i = 0; i < n; i++) {
			edges[i] = f.readLine();
		}

		int[] res = (new fence()).solve(edges);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (int i : res) {
			out.println(i);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}