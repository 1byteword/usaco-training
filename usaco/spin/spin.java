/*
ID: changhu1
LANG: JAVA
TASK: spin
 */
import java.io.*;
import java.util.*;

public class spin {

	public int solve(int[] speeds, int[][] starts, int[][] widths) {
		for (int t = 0; t <= 360; t++) {
			for (int angle = 0; angle < 720; angle++) {
				boolean[] found = new boolean[5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < starts[i].length; j++) {
						int start = (starts[i][j] + t * speeds[i]) % 360;
						int end = start + widths[i][j];
						if ((angle >= start && angle <= end) || (angle % 360 >= start && angle % 360 <= end) ) {
							found[i] = true;
							break;
						}
					}
				}
				if (found[0] && found[1] && found[2] && found[3] && found[4]) return t;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "spin";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		int[] speeds = new int[5];
		int[][] starts = new int[5][];
		int[][] widths = new int[5][];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			speeds[i] = Integer.parseInt(st.nextToken());
			int wedges = Integer.parseInt(st.nextToken());
			starts[i] = new int[wedges];
			widths[i] = new int[wedges];
			for (int j = 0; j < wedges; j++) {
				starts[i][j] = Integer.parseInt(st.nextToken());
				widths[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = (new spin()).solve(speeds, starts, widths);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		if (res == -1) {
			out.println("none");
		} else {
			out.println(res);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}