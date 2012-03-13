/*
ID: changhu1
LANG: JAVA
TASK: calfflac
 */
import java.io.*;
import java.util.*;

public class calfflac {

	class Span {
		int start = 0;
		int end = 0;

		int length() {
			return end - start + 1;
		}

		public Span(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	char[] raw = null;
	char[] clean = null;
	int[] offset = null;
	int cleanLength = 0;
	
	private void init(String input) {
		raw = input.toCharArray();
		clean = new char[raw.length	];
	}


	private static boolean legal(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	private void cleanString() {
		int l = raw.length;
		offset = new int[l];
		int off = 0;
		cleanLength = 0;
		for (int i = 0; i < l; i++) {
			offset[i - off] = off;
			char c = raw[i];
			if (legal(c)) {
				clean[cleanLength++] = Character.toLowerCase(c);
			} else {
				off++;
			}
		}
	}

	int maxLength = 0;

	private Span findMaxPal() {
		Span res = new Span(0, 0);
		maxLength = 0;

		int l = cleanLength;
		for (int center = 0; center < l ; center ++ ){
			res = expandSpan(res, center);
			if (maxLength >= 2000) break;
		}
		
		return res;
	}

	private Span expandSpan(Span res, int center) {
		Span even = expand(center, center);
		if (maxLength < even.length()) {
			res = even;
			maxLength = res.length();
		}
		Span odd = expand(center, center + 1);
		if (maxLength < odd.length()) {
			res = odd;
			maxLength = res.length();
		}
		return res;
	}

	private Span expand(int start, int end) {
		int l = cleanLength;
		while (start >= 0 && end <= l - 1 && clean[start] == clean[end]) {
			start--;
			end++;
		}
		return new Span(start + 1, end - 1);
	}

	private String rawString(Span span) {
		int start = span.start + offset[span.start];
		int end = span.end + offset[span.end];
		return new String(Arrays.copyOfRange(raw, start, end + 1));
	}

	public String[] solve(String input) {
		init(input);
		cleanString();

		Span maxSpan = findMaxPal();

		ArrayList<String> res = new ArrayList<String>();
		res.add(String.valueOf(maxSpan.length()));
		res.add(rawString(maxSpan));
		return res.toArray(new String[0]);
	}


	public static void main(String[] args) throws IOException {
		String problemName = "calfflac";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		String line = f.readLine();
		String input = "";
		while (line != null) {
			input += (line + "\n");
			line = f.readLine();
		}

		String[] res = (new calfflac()).solve(input.trim());

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String op : res) {
			for (String l : op.split("\n")) {
				out.println(l);
			}
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}