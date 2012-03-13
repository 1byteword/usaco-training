/*
ID: changhu1
LANG: JAVA
TASK: clocks
 */
import java.io.*;
import java.util.*;

public class clocks {

	private final static long[] OPS = new long[] {
			// dummy
			0,
			// abcdefghi
			Integer.parseInt("001001000" +
						     "001001000" +
						     "000000000", 2), 
						     
			Integer.parseInt("001001001" +
					         "000000000" +
					         "000000000", 2),
					         
			Integer.parseInt("000001001" +
							 "000001001" +
							 "000000000", 2),
							 
			Integer.parseInt("001000000" +
					         "001000000" +
					         "001000000", 2),
					         
			Integer.parseInt("000001000" +
					         "001001001" +
					         "000001000", 2),
					         
			Integer.parseInt("000000001" +
					         "000000001" +
					         "000000001", 2),
					         
			Integer.parseInt("000000000" +
       					     "001001000" +
					         "001001000", 2),
			
			Integer.parseInt("000000000" +
					         "000000000" +
					         "001001001", 2),
					         
			Integer.parseInt("000000000" +
					         "000001001" +
					         "000001001", 2) };
	
	String res = "";
	private long initState;

	public String solve(int[] clocks) {
		initState = 0;
		for (int i = 0; i < 9; i++) {
			initState += (clocks[i] / 3) % 4;
			initState = initState << 3;
		}
		initState = initState >> 3;
		
		if (initState == 0) return "0";
		dfs(new int[10], 1);
		return res;
	}

	private void dfs(int[] ops, int pos) {
		if (res.length() > 0) return;
		if  (pos == 10) {
			test(ops);
			return;
		}
		
		int temp = ops[pos];
		for (int i = 0; i < 4; i++) {
			ops[pos] = i;
			dfs(ops, pos + 1);
		}
		ops[pos] = temp;
	}

	private boolean test(int[] ops) {
		long state = initState;
		for (int i = 1; i < ops.length; i++) {
			int times = ops[i];
			if (times > 0) {
				state = normalize(state + OPS[i] * times);
			}
		}
		if (state == 0) {
			res = decode(ops);
			return true;
		}
		return false;
	}

	private String decode(int[] ops) {
		String res = "";
		for (int i = 1; i < ops.length; i++) {
			for (int j = 0; j < ops[i]; j++) {
				res += String.valueOf(i);
			}
		}
		return res;
	}

	long normalize(long l) {
		return l & Integer.parseInt("011011011" +
			                        "011011011" +
			                        "011011011", 2);
	}

	public static void main(String[] args) throws IOException {
		String problemName = "clocks";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		int[] clocks = new int[9];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			for (int j = 0; j < 3; j++) {
				clocks[3 * i + j] = Integer.parseInt(st.nextToken());
			}
		}

		String res = (new clocks()).solve(clocks);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		String output = "";
		for (char c : res.toCharArray()) {
			output += (String.valueOf(c) + " ");
		}
		out.println(output.trim());
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}