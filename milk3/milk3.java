/*
ID: changhu1
LANG: JAVA
TASK: milk3
 */
import java.io.*;
import java.util.*;

public class milk3 {

	ArrayList<Integer> res = new ArrayList<Integer>();
	private int[] buckets;

	private int[] state = new int[3];

	ArrayList<Integer> seen = new ArrayList<Integer>();

	public int[] solve(int[] buckets) {
		this.buckets = buckets;
		state[2] = buckets[2];

		dfs();
		Collections.sort(res);
		return toArray(res);
	}

	private void dfs() {
		int[] oldState = Arrays.copyOf(state, 3);
		seen.add(encode(oldState));
		if (state[0] == 0) res.add(state[2]);

		for (int from = 0; from < 3; from ++) {
			for (int to = 0; to < 3; to ++) {
				if (from == to) continue;
				if (state[to] == buckets[to]) continue;
				if (state[from] == 0) continue;
				
				int move = Math.min(state[from], buckets[to] - state[to]);
				state[from] -= move;
				state[to] += move;
				
				if (stateUnseen()){
					dfs();
				}
				// recover
				state = Arrays.copyOf(oldState, 3);
			}
		}
	}


	private boolean stateUnseen() {
		int encoded = encode(state);
		return !seen.contains(encoded);
	}

	private int encode(int[] state) {
		int encoded = 0;
		for (int i = 0; i < 3; i++) {
			encoded *= 100;
			encoded += state[i];
		}
		return encoded;
	}

	private int[] toArray(ArrayList<Integer> l) {
		int[] res = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			res[i] = l.get(i);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "milk3";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		int[] buckets = new int[3];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for (int i = 0; i < 3; i++) {
			buckets[i] = Integer.parseInt(st.nextToken());
		}

		int[] res = (new milk3()).solve(buckets);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		String output = "";
		for (int r : res) {
			output += (String.valueOf(r) + " ");
		}
		out.println(output.trim());
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}