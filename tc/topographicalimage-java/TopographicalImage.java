import java.util.*;

public class TopographicalImage {

	private class Point implements Comparable<Point> {
		int x, y;
		char height;

		public Point(int x, int y, char height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		public int compareTo(Point other) {
			if (other.height != height) return other.height - height;
			if (other.x != x) return x - other.x;
			return y - other.y;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) return false;
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}

	}

	ArrayList<Integer> res = new ArrayList<Integer>();

	private int m, n;
	private String[] heights;
	private PriorityQueue<Point> points = new PriorityQueue<Point>();
	private int[][] peaks;

	public int[] calcPeakAreas(String[] topoData) {
		m = topoData.length;
		n = topoData[0].length();
		heights = topoData;
		peaks = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				points.add(new Point(i, j, heights[i].charAt(j)));
				peaks[i][j] = -1;
			}
		}

		int peak;
		for (peak = 0; !points.isEmpty(); peak++) {
			Point p = points.remove();
			flood(p.x, p.y, peak);
		}

		int[] res = new int[peak];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[peaks[i][j]]++;
			}
		}

		return res;
	}

	private static final int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static final int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

	private void flood(int x, int y, int peak) {
		peaks[x][y] = peak;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0) continue;
			if (nx >= m || ny >= n) continue;
			if (peaks[nx][ny] > -1) continue;
			char nh = heights[nx].charAt(ny);
			if (nh > heights[x].charAt(y)) continue;

			points.remove(new Point(nx, ny, nh));
			flood(nx, ny, peak);
		}

	}

}
