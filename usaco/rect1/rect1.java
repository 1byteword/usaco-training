/*
ID: changhu1
LANG: JAVA
TASK: rect1
 */
import java.io.*;
import java.util.*;

public class rect1 {
	class YPoint implements Comparable<YPoint> {
		private int xMin;
		private int xMax;
		private int value;
		private boolean isBegin;
		private int rect;

		public boolean isInEffect(int x) {
			return (x >= xMin && x < xMax);
		}

		public boolean isBegin() {
			return isBegin;
		}

		public int getRect() {
			return rect;
		}

		public int getValue() {
			return value;
		}

		public YPoint(int value, int xMin, int xMax, boolean isBegin, int rect) {
			this.value = value;
			this.xMin = xMin;
			this.xMax = xMax;
			this.isBegin = isBegin;
			this.rect = rect;
		}

		public int compareTo(YPoint other) {
			if (this.value == other.value) {
				return this.isBegin ? -1 : 1;
			}
			return this.value - other.value;
		}

		public String toString() {
			return String.format("%d, x between %d and %d, %s of rect %d", value, xMin, xMax, (isBegin ? "begin" : "end"), rect);
		}
	}

	public String[] solve(int lenX, int lenY, String[] rects) {
		int n = rects.length;

		int[] colors = new int[n]; // the color of the rect x
		int[] areas = new int[n]; // visible area of each rect
		int[] xs = new int[2 * n];
		YPoint[] yPoints = new YPoint[2 * n];

		// Init
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(rects[i]);
			int xmin = Integer.parseInt(st.nextToken());
			int ymin = Integer.parseInt(st.nextToken());
			int xmax = Integer.parseInt(st.nextToken());
			int ymax = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());

			xs[2 * i] = xmin;
			xs[2 * i + 1] = xmax;

			yPoints[2 * i] = new YPoint(ymin, xmin, xmax, true, i);
			yPoints[2 * i + 1] = new YPoint(ymax, xmin, xmax, false, i);

			colors[i] = color;
		}

		Arrays.sort(xs);
		Arrays.sort(yPoints);

		// Line scan
		for (int i = 0; i < xs.length - 1; i++) {
			int scanX = xs[i];
			int nextX = xs[i + 1];
			int width = nextX - scanX;

			PriorityQueue<Integer> rectangles = new PriorityQueue<Integer>(2 * n - 1, Collections.reverseOrder());
			int currectRect = -1;
			for (int j = 0; j < yPoints.length - 1; j++) {
				YPoint scanY = yPoints[j];
				if (!scanY.isInEffect(scanX)) {
					continue;
				}
				YPoint nextY = null;
				for (int k = j + 1; k < yPoints.length; k++) {
					 if( yPoints[k].isInEffect(scanX) ) {
						 nextY = yPoints[k];
						 break;
					 }
				}
				if (nextY == null) continue; // Last ending y scanned

				int height = nextY.getValue() - scanY.getValue();
				if (scanY.isBegin()) {
					rectangles.add(scanY.getRect());
				} else {
					rectangles.remove(scanY.getRect());
				}
				if (rectangles.size() > 0) {
					currectRect = rectangles.peek();
					areas[currectRect] += (width * height);
				}
			}
		}

		TreeMap<Integer, Integer> colorAreas = new TreeMap<Integer, Integer>();
		int totalArea = 0;
		for (int rect = 0; rect < n; rect++) {
			int color = colors[rect];
			int area = areas[rect];
			if (area == 0) continue;
			totalArea += area;
			if (!colorAreas.containsKey(color)) colorAreas.put(color, 0);
			colorAreas.put(color, colorAreas.get(color) + area);
		}

		// add the background
		int bgColor = 1;
		int bgArea = (lenX * lenY) - totalArea;
		if (!colorAreas.containsKey(bgColor)) colorAreas.put(bgColor, 0);
		colorAreas.put(bgColor, colorAreas.get(bgColor) + bgArea);

		ArrayList<String> res = new ArrayList<String>();
		for (int color : colorAreas.keySet()) {
			res.add(String.format("%d %d", color, colorAreas.get(color)));
		}

		return res.toArray(new String[0]);
	}

	public static void main(String[] args) throws IOException {
		String problemName = "rect1";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		String[] rects = new String[n];

		for (int i = 0; i < n; i++) {
			rects[i] = f.readLine();
		}

		String[] res = (new rect1()).solve(a, b, rects);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}