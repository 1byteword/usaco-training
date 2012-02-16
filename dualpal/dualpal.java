/*
ID: changhu1
LANG: JAVA
TASK: dualpal
 */
import java.io.*;
import java.util.*;

public class dualpal {

	private static boolean isPalindrome(String s) {
		int l = s.length();
		for (int i = 0; i < l / 2 + 1; i++) {
			if (s.charAt(i) != s.charAt(l - 1 - i)) return false;
		}
		return true;
	}

	public String convert(int n, int b) {
		String res = "";
		while (n > 0) {
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

	public int[] solve(int n, int s) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = s + 1; res.size() < n; i++) {
			int palCount = 0;
			for (int b = 2; b <= 10; b++) {
				if (isPalindrome(convert(i, b))) {
					palCount++;
					if (palCount == 2) {
						res.add(i);
						break;
					}
				}
			}
		}

		int[] p = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			p[i] = res.get(i);
		}

		return p;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "dualpal";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] res = (new dualpal()).solve(N, S);

		// output result
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (int i : res) {
			out.println(i);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}