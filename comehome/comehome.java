/*
ID: changhu1
LANG: JAVA
TASK: comehome
 */
import java.io.*;
import java.util.*;

public class comehome {

	private static final int N = 26 * 2; 
	private boolean[] hasCow = new boolean[N];
	private int[][] distance = new int[N][N];

	private static int convert(char point) {
		if (Character.isUpperCase(point)) {
			return 26 + point - 'A';
		}
		return point - 'a';
	}

	public String solve(String[] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		for (String s : map) {
			StringTokenizer st = new StringTokenizer(s);
			char from = st.nextToken().charAt(0);
			int pFrom = convert(from);
			if (Character.isUpperCase(from) && from != 'Z') {
				hasCow[pFrom] = true;
			}
			char to = st.nextToken().charAt(0);
			int d = Integer.parseInt(st.nextToken());
			int pTo = convert(to);
			distance[pFrom][pTo] = Math.min(distance[pFrom][pTo], d);
			distance[pTo][pFrom] = Math.min(distance[pTo][pFrom], d);
		}

		int[] dist = dijkstra(convert('Z'));
		int minDist = Integer.MAX_VALUE;
		char minPas = ' ';

		for (char pasture = 'A'; pasture < 'Z'; pasture++) {
			int p = convert(pasture);
			if (hasCow[p] && dist[p] < minDist) {
				minDist = dist[p];
				minPas = pasture;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(minPas);
		sb.append(" ");
		sb.append(minDist);

		return sb.toString();
	}

	private int[] dijkstra(int source) {
		int[] dist = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;
		boolean[] visited = new boolean[N];
		int visitedNodes = 0;

		while (visitedNodes < N) {
			int checking = minDist(dist, visited);
			if (checking == -1) {
				break;
			}
			for (int v : neighbors(checking)) {
				// distance(checking,v) = 1
				if (!visited[v]) {
					dist[v] = Math.min(dist[v], dist[checking] + distance[checking][v]);
				}
			}
			visited[checking] = true;
			visitedNodes++;
		}

		return dist;
	}

	private ArrayList<Integer> neighbors(int checking) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			if (distance[checking][i] > 0 && distance[checking][i] < Integer.MAX_VALUE) {
				res.add(i);
			}
		}

		return res;
	}

	private static int minDist(int[] distance, boolean[] visited) {
		assert (distance.length == visited.length);
		int res = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			if (visited[i]) continue;
			if (min > distance[i]) {
				min = distance[i];
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "comehome";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		String[] map = new String[n];

		for (int i = 0; i < n; i++) {
			map[i] = f.readLine();
		}

		String res = (new comehome()).solve(map);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}