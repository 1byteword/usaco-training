/*
ID: changhu1
LANG: JAVA
TASK: zerosum
 */
import java.io.*;
import java.util.*;

public class zerosum {

	ArrayList<String>res = new ArrayList<String>();
	int n;
	public String[] solve(int n) {
		this.n = n;
		
		char[] equ = new char[2 * n - 1];
		equ[0] = '1';
		dfs(1, '+', 1, equ, 2);

		Collections.sort(res);
		return res.toArray(new String[0]);
	}

	private void dfs(int sum, char lastSign, int lastNum, char[] equ, int currentNum) {
		if (currentNum >  n) {
			if (sum == 0) res.add(new String(equ));
			return;
		}
		
		int signPos = 2 * (currentNum - 1) - 1;
		int numPos = signPos + 1;
		
		// +
		equ[signPos] = '+'; 
		equ[numPos] = (char)('0' + currentNum);
		dfs(sum +currentNum, '+', currentNum, equ, currentNum + 1);
		
		// -
		equ[signPos] = '-'; 
		equ[numPos] = (char)('0' + currentNum);
		dfs(sum - currentNum, '-', currentNum, equ, currentNum + 1);
		
		// ' '
		equ[signPos] = ' '; 
		equ[numPos] = (char)('0' + currentNum);
		
		int newNum = lastNum * 10 + currentNum;
		
		if (lastSign == '+') {
			dfs(sum - lastNum + newNum, lastSign, newNum, equ, currentNum + 1);
		} else {
			dfs(sum + lastNum - newNum, lastSign, newNum, equ, currentNum + 1);
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		String problemName = "zerosum";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		String[] res = (new zerosum()).solve(n);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}