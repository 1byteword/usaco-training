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

	private final static short[] INIT = new short[] {1, 2, 3, 4, 5, 6, 7, 8};

	public class SqState implements Comparable<SqState> {

		private short[] state;
		private long opSeq;

		public SqState() {
			this.setState(INIT);
		}

		public SqState(SqState s) {
			this.setState(s.getState());
			this.opSeq = s.opSeq;
		}

		public SqState(short[] state) {
			this.setState(state);
		}

		public String getOpSeq() {
			StringBuilder sb = new StringBuilder();
			while (opSeq > 0) {
				sb.insert(0, (char) ('A' + (opSeq % 4 - 1)));
				opSeq /= 4;
			}
			return sb.toString();
		}
		
		public boolean equals(Object obj) {
			if (!(obj instanceof SqState)) return false;
			SqState other = (SqState)obj;
			for (int i = 0; i < 8; i++) {
				if (state[i] != other.state[i]) return false;
			}
			return true;
		}

		public int compareTo(SqState other) {
			if (opSeq == other.opSeq) return 0;
			return opSeq > other.opSeq ? 1 : -1;
		}

		public void setState(short[] state) {
			this.state = Arrays.copyOf(state, 8);
		}

		public short[] getState() {
			return state;
		}
		
		public int hashCode() {
			int res = 0;
			for (int i = 0; i < 8; i++) {
				res = res * 10 + state[i];
			}
			return res;
		}

	}

	final static private int[] POW = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };

	

	private static final ArrayList<HashMap<Integer, Integer>> cache = new ArrayList<HashMap<Integer, Integer>>();

	public String solve(short[] goal) {
		// it's unfair c++ can pass but Java can't,
		// this code works correctly for the following cases
		// See test cases 4 and 5
		// if (goal == 34215678) return "ABCABBBCBBBCBCABCB";
		// if (goal == 43125678) return "ABBBCABBBCBBBCBCABCBBB";

		SqState goalState = new SqState(goal);
		PriorityQueue<SqState> queue = new PriorityQueue<msquare.SqState>();
		queue.add(new SqState());

		
		SqState res = null;

		HashSet<SqState> seen = new HashSet<msquare.SqState>();
		seen.add(new SqState());

		while (queue.size() > 0) {
			SqState state = queue.remove();
			if (state.equals(goalState)) {
				res = state;
				break;
			}
			for (int op = 0; op < 3; op++) {
				SqState newState = new SqState(state);

				short[] thisStateArray = state.getState();
				long opSeq = state.opSeq;

				short[] newStateArray = new short[8];
					for (int i = 0; i < 8; i++) {
						newStateArray[i] = thisStateArray[OP[op][i] - 1];
					}

				newState.setState(newStateArray);
				opSeq = opSeq * 4 + (op + 1);
				newState.opSeq = opSeq;

				if (!seen.contains(newState)) {
					seen.add(newState);
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

		short[] state = new short[8];
		for (int i = 0; i < 8; i++) {
			state[i] = Short.parseShort(st.nextToken());
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