/*
ID: changhu1
LANG: JAVA
TASK: palsquare
 */
import java.io.*;
import java.util.*;

public class palsquare {

	public String convert(int n, int b) {
		String res = "";
		while( n > 0 ) {
			int thisDigit = n % b;
			res = (print(thisDigit) + res);
			n /= b;
		}
		return res;
	}

	private static String print(int thisDigit) {
		if (thisDigit < 10) return String.valueOf(thisDigit);
		return String.valueOf((char) ('A' + (thisDigit - 10)));
	}

	public String[] solve(int b) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 1; i <= 300; i++) {
			String iBaseB = convert(i, b);
			String iSquareBaseB = convert(i * i, b);
			if (isPalSquare(iSquareBaseB)) {
				res.add(String.format("%s %s", iBaseB, iSquareBaseB));
			}
		}
		return res.toArray(new String[0]);
	}

	private boolean isPalSquare(String s) {
		int l =  s.length();
		for (int i = 0; i < l / 2 + 1; i++) {
			if (s.charAt(i) != s.charAt(l - 1 - i)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "palsquare";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int b = Integer.parseInt(st.nextToken());
		String[] res = (new palsquare()).solve(b);

		// output result
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}