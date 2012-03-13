/*
ID: changhu1
LANG: JAVA
TASK: holstein
 */
import java.io.*;
import java.util.*;

public class holstein {

	public String solve(int[][] scoops, int[] vitamins) {

		int scps = scoops.length;
		int vtms = vitamins.length;
		long minState = (1 << scps);

		int minScoops = scps;

		for (long state = 0; state < (1 << scps); state++) {
			boolean stateOkay = true;
			for (int vtm = 0; vtm < vtms; vtm++) {
				int sum = 0;
				for (int scp = 0; scp < scps; scp++) {
					if (((state >> scp) & 1) == 1) {
						// add this scoop
						sum += scoops[scp][vtm];
					}
				}
				if (sum < vitamins[vtm]) {
					stateOkay = false;
					break;
				}
			}
			if (stateOkay) {
				int s = scoops(state);
				if (s == minScoops) {
					minState = Math.min(minState, state);
				} else if (s < minScoops) {
					minScoops = s;
					minState = state;
				}
			}
		}

		String res = String.format("%d %s", minScoops, decode(minState));
		return res;
	}

	private String decode(long state) {
		String res = "";
		for (int i = 0; state > 0; i++) {
			if (state % 2 == 1) {
				res += (String.valueOf(i + 1) + " ");
			}
			state = (state >> 1);
		}
		return res.trim();
	}

	private int scoops(long state) {
		int res = 0;
		while (state > 0) {
			res += (state % 2);
			state = (state >> 1);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "holstein";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] daily = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			daily[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[][] scoops = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < n; j++) {
				scoops[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		String res = (new holstein()).solve(scoops, daily);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}