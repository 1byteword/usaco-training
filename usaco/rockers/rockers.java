/*
ID: changhu1
LANG: JAVA
TASK: rockers
 */
import java.io.*;
import java.util.*;

public class rockers {

	private int[] songs;
	private int timePerDisc;

	public int solve(int timePerDisc, int maxDiscs, int[] songs) {
		int n = songs.length;
		this.songs = songs;
		this.timePerDisc = timePerDisc;

		int res = 0;
		for (int state = 0; state < (1 << n); state++) {
			int discsNeeded = discsNeeded(state);
			int songsIn = songsIn(state);
			if (discsNeeded <= maxDiscs) {
				res = Math.max(res, songsIn);
			}

		}

		return res;
	}

	private int discsNeeded(int state) {
		int res = 0;
		int onDisc = 0;
		int n = songs.length;
		for (int i = 0; i < n; i++) {
			if ((state >> i & 1) == 0) continue;
			if (timePerDisc < songs[i]) continue;
			if (onDisc + songs[i] > timePerDisc) {
				res++;
				onDisc = 0;
			}
			onDisc += songs[i];
		}
		if (onDisc > 0) res++;

		return res;
	}

	private int songsIn(int state) {
		int res = 0;
		int n = songs.length;
		for (int i = 0; i < n; i++) {
			if ((state >> i & 1) == 0) continue;
			if (timePerDisc < songs[i]) continue;
			res++;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "rockers";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] songs = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			songs[i] = Integer.parseInt(st.nextToken());
		}

		int res = (new rockers()).solve(t, m, songs);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}
