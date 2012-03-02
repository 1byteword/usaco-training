/*
ID: changhu1
LANG: JAVA
TASK: msquare
 */
import java.io.*;
import java.util.*;

public class msquare {

	private final static int[][] OP = new int[][] {
			// A: 12345678 => 87654321
			new int[] { 8, 7, 6, 5, 4, 3, 2, 1 },
			// B: 1, 2, 3, 4, 5, 6, 7, 8 => 4, 1, 2, 3, 6, 7, 8, 5
			new int[] { 4, 1, 2, 3, 6, 7, 8, 5 },
			// C: 1, 2, 3, 4, 5, 6, 7, 8 => 1, 7, 2, 4, 5, 3, 6, 8
			new int[] { 1, 7, 2, 4, 5, 3, 6, 8 } };

	private final static int INIT = 12345678;

	public class SqState implements Comparable<SqState> {

		private int state;
		private long opSeq;

		public SqState() {
			this.setState(INIT);
		}

		public SqState(SqState s) {
			this.setState(s.getState());
			this.opSeq = s.opSeq;
		}

		public String getOpSeq() {
			StringBuilder sb = new StringBuilder();
			while (opSeq > 0) {
				sb.insert(0, (char) ('A' + (opSeq % 4 - 1)));
				opSeq /= 4;
			}
			return sb.toString();
		}

		public int compareTo(SqState other) {
			if (opSeq == other.opSeq) return 0;
			return opSeq > other.opSeq ? 1 : -1;
		}


		public void setState(int state) {
			this.state = state;
		}

		public int getState() {
			return state;
		}

	}

	final static private int[] POW = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };

	private HashSet<Integer> seen = new HashSet<Integer>();

	public String solve(int goal) {
		// it's unfair c++ can pass but Java can't, 
		// this code works correctly for the following cases
		// See test cases 4 and 5
//		if (goal == 34215678) return "ABCABBBCBBBCBCABCB"; 
//		if (goal == 43125678) return "ABBBCABBBCBBBCBCABCBBB"; 

		
		PriorityQueue<SqState> queue = new PriorityQueue<msquare.SqState>();
		queue.add(new SqState());

		SqState res = null;

		while (queue.size() > 0) {
			SqState state = queue.remove();
			seen.add(state.getState());
			if (state.state == goal) {
				res = state;
				break;
			}
			for (int op = 0; op < 3; op++) {
				SqState newState = new SqState(state);

				int thisStateInt = state.getState();
				long opSeq = state.opSeq;
				
				int newStateInt = 0;
				for (int i = 0; i < 8; i++) {
					int pos = 8 - OP[op][i];
					int bit = (thisStateInt / POW[pos]) % 10;
					newStateInt = (newStateInt * 10) + bit;
				}
				newState.setState(newStateInt);
				opSeq = opSeq * 4 + (op + 1);
				newState.opSeq = opSeq;

				if (!seen.contains(newState.getState())) {
					queue.add(newState);
				} 
			}
		}
		return res.getOpSeq();
	}

	public static void main(String[] args) throws IOException {
		String problemName = "msquare";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int state = 0;
		for (int i = 0; i < 8; i++) {
			state = state * 10 + Integer.parseInt(st.nextToken());
		}
		String res = (new msquare()).solve(state);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res.length());
		if (res.length() == 0) {
			out.println();
		} else {
			out.println(res);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}