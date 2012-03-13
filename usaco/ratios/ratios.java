/*
ID: changhu1
LANG: JAVA
TASK: ratios
 */
import java.io.*;
import java.util.*;

public class ratios {

	public int[] solve(int[] goal, int[][] mixtures) {
		if (goal[0] == 0 && goal[1] == 0 && goal[2] == 0) return new int[] { 0, 0, 0, 0 };

		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				for (int k = 0; k <= 100; k++) {
					if (i == 0 && j == 0 && k == 0) continue;
					double ratio = -1;
					boolean found = true;
					for (int w = 0; w < 3; w++) {
						if (goal[w] > 0) {
							double currentRatio = (double) (i * mixtures[0][w] + j * mixtures[1][w] + k * mixtures[2][w]) / goal[w];
							if (ratio == -1) {
								ratio = currentRatio;
							} else if (ratio != currentRatio) {
								found = false;
							}
						}
					}
					if (found && ratio %1 == 0) {
						return new int[] {i, j, k, (int) ratio};
					}
				}
			}
		}

		return null;

	}

	public static void main(String[] args) throws IOException {
		String problemName = "ratios";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int[] goal = new int[3];
		for (int i = 0; i < 3; i++) {
			goal[i] = Integer.parseInt(st.nextToken());
		}
		int[][] mixtures = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < 3; j++) {
				mixtures[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] res = (new ratios()).solve(goal, mixtures);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		if (res == null) {
			out.println("NONE");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i : res) {
				sb.append(i);
				sb.append(" ");
			}
			out.println(sb.toString().trim());
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}