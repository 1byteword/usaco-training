/*
ID: changhu1
LANG: JAVA
TASK: packrec
 */
import java.io.*;
import java.util.*;

public class packrec {

	class Rectl implements Comparable<Rectl> {
		int length;
		int width;
		private String debugMsg = "";

		int area() {
			return length * width;
		}

		public Rectl(int l, int w) {
			this.length = l;
			this.width = w;
		}

		public Rectl(Rectl r) {
			this.length = r.length;
			this.width = r.width;
		}

		public Rectl rot90() {
			return new Rectl(width, length);
		}

		public String toString() {
			return String.format("<%d %d>: %s", length, width, debugMsg);
		}

		public int p() {
			return Math.min(length, width);
		}

		public int q() {
			return Math.max(length, width);
		}

		public void setDebugMsg(String msg) {
			debugMsg = msg;
		}

		public String output() {
			return String.format("%d %d", p(), q());
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Rectl)) return false;
			Rectl other = (Rectl) obj;
			return compareTo(other) == 0;
		}

		public int compareTo(Rectl other) {
			if (p() == other.p()) return q() - other.q();
			return p() - other.p();
		}
	}

	private static final int N = 4;
	Rectl[] rects = new Rectl[N];
	ArrayList<Rectl> bestRects = new ArrayList<Rectl>();
	int minArea = Integer.MAX_VALUE;

	public String[] solve(int[] lengths, int[] widths) {
		for (int i = 0; i < N; i++) {
			rects[i] = new Rectl(lengths[i], widths[i]);
		}

		ArrayList<Integer> permutation = new ArrayList<Integer>();
		dfs(permutation);

		for (int i = bestRects.size() - 1; i >= 0; i--) {
			if (bestRects.get(i).area() > minArea) {
				bestRects.remove(i);
			}
		}
		ArrayList<Rectl> resRects = new ArrayList<Rectl>();
		for (Rectl r : bestRects) {
			if (!resRects.contains(r)) {
				resRects.add(r);
			}
		}
		Collections.sort(resRects);
		

		ArrayList<String> res = new ArrayList<String>();
		res.add(String.valueOf(minArea));
		for (Rectl r : resRects) {
			res.add(r.output());
		}

		return res.toArray(new String[0]);
	}

	private void dfs(ArrayList<Integer> perm) {
		if (perm.size() == N) {
			calAreaAtPerm(perm);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!perm.contains(i)) {
				perm.add(i);
				dfs(perm);
				perm.remove(new Integer(i));
			}
		}

	}

	// flipping is probably not needed
	private void calAreaAtPerm(ArrayList<Integer> perm) {
		for (int count = 0; count < Math.pow(2, N); count++) {
			Rectl[] working = copyRects(perm);
			for (int r = 0; r < N; r++) {
				if (((count >> r) & 1) == 1) {
					working[r] = working[r].rot90();
				}
			}
			calAreaForLayouts(working);
		}
	}

	private Rectl[] copyRects(ArrayList<Integer> perm) {
		Rectl[] res = new Rectl[N];
		for (int i = 0; i < N; i++) {
			res[i] = new Rectl(rects[perm.get(i)]);
		}
		return res;
	}

	private static int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	private static int max(int a, int b, int c, int d) {
		return Math.max(a, max(b, c, d));
	}

	private void calAreaForLayouts(Rectl[] r) {
		// Calculate 6 layouts

		// 1
		Rectl rect = new Rectl(max(r[0].length, r[1].length, r[2].length, r[3].length), r[0].width + r[1].width + r[2].width + r[3].width);
		rect.setDebugMsg(printArray(r) + " layout: 1");
		checkRect(rect);

		// 2
		rect = new Rectl(max(r[0].length, r[1].length, r[2].length) + r[3].length, Math.max(r[0].width + r[1].width + r[2].width, r[3].width));
		rect.setDebugMsg(printArray(r) + " layout: 2");
		checkRect(rect);

		// 3
		rect = new Rectl(Math.max(Math.max(r[0].length, r[1].length) + r[2].length, r[3].length), Math.max(r[0].width + r[1].width, r[2].width)
				+ r[3].width);
		rect.setDebugMsg(printArray(r) + " layout: 3");
		checkRect(rect);

		// 4
		rect = new Rectl(max(r[0].length, r[1].length + r[2].length, r[3].length), r[0].width + Math.max(r[1].width, r[2].width) + r[3].width);
		rect.setDebugMsg(printArray(r) + " layout: 4");
		checkRect(rect);

		// 5
		rect = new Rectl(max(r[0].length + r[1].length, r[2].length, r[3].length), Math.max(r[0].width, r[1].width) + r[2].width + r[3].width);
		rect.setDebugMsg(printArray(r) + " layout: 5");
		checkRect(rect);

		// 6
		int width;
		if (r[1].length >= r[2].length + r[3].length) {
			width = max(r[0].width, r[1].width + r[2].width, r[1].width + r[3].width);
		} else if (r[1].length >= r[3].length){
			width = max(r[0].width + r[2].width, r[1].width + r[2].width, r[1].width + r[3].width);
		} else if (r[3].length < r[0].length + r[1].length) {
			width = max(r[0].width + r[3].width, r[0].width + r[2].width, r[1].width + r[3].width);
		} else { // r[3].length >= r[0].length + r[1].length
			width = max(r[2].width, r[0].width + r[3].width, r[1].width + r[3].width);
		}
		rect = new Rectl(Math.max(r[0].length + r[1].length, r[2].length + r[3].length), width);
		rect.setDebugMsg(printArray(r) + " layout: 6");
		checkRect(rect);

	}

	private String printArray(Rectl[] arr) {
		String res = "";
		for (Rectl r  : arr) {
			res += (r.toString() + " ");
		}
		return res.trim();
	}

	private void checkRect(Rectl rect) {
		int area = rect.area();
		if (area <= minArea) {
			minArea = area;
			for (int i = bestRects.size() - 1; i >= 0; i--) {
				if (bestRects.get(i).area() > minArea) {
					bestRects.remove(i);
				}
			}
			bestRects.add(rect);
		}
	}

	public static void main(String[] args) throws IOException {
		String problemName = "packrec";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		ArrayList<Integer> ls = new ArrayList<Integer>();
		ArrayList<Integer> ws = new ArrayList<Integer>();
		String line = f.readLine();
		while (line != null) {
			StringTokenizer st = new StringTokenizer(line);
			ls.add(Integer.parseInt(st.nextToken()));
			ws.add(Integer.parseInt(st.nextToken()));
			line = f.readLine();
		}

		String[] res = (new packrec()).solve(toArray(ls), toArray(ws));

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	private static int[] toArray(ArrayList<Integer> l) {
		int[] res = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			res[i] = l.get(i);
		}
		return res;
	}

}