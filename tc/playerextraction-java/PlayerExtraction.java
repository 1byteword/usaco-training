import java.util.ArrayList;
import java.util.Collections;


public class PlayerExtraction {

	String[] photo;
	int m;
	int n;
	int[][] map;

	private static int[] di = new int[] { 0, 0, 1, -1 };
	private static int[] dj = new int[] { 1, -1, 0, 0 };

	private class Component implements Comparable<Component> {
		private int x0, y0, x1, y1;
		int area;

		public Component(int x, int y) {
			x0 = x1 = x;
			y0 = y1 = y;
			area = 4;
		}

		public void add(int x, int y) {
			x0 = Math.min(x0, x);
			x1 = Math.max(x1, x);
			y0 = Math.min(y0, y);
			y1 = Math.max(y1, y);
			area += 4;
		}

		public int X() {
			return y0 + y1 + 1;
		}

		public int Y() {
			return x0 + x1 + 1;
		}

		public int compareTo(Component other) {
			int res = X() - other.X();
			if (res == 0) return Y() - other.Y();
			return res;
		}

	}

	Component[] components;

	public String[] extractPlayers(String[] photo, int k, int threshold) {
		this.photo = photo;
		m = photo.length;
		n = photo[0].length();
		map = new int[m][n];
		components = new Component[m * n];

		int c = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (photo[i].charAt(j) == ('0' + k) && map[i][j] == 0) {
					flood(i, j, k, c++);
				}
			}
		}

		ArrayList<Component> players = new ArrayList<Component>();
		for (int i = 0; i < components.length; i++) {
			Component cp = components[i];
			if (cp != null && cp.area >= threshold) players.add(cp);
		}
		Collections.sort(players);

		ArrayList<String> res = new ArrayList<String>();
		for (Component cp : players) {
			res.add(String.format("%d %d", cp.X(), cp.Y()));
		}
		return res.toArray(new String[0]);

	}

	private void flood(int i, int j, int team, int component) {

		map[i][j] = component;
		if (components[component] == null) {
			components[component] = new Component(i, j);
		} else {
			components[component].add(i, j);
		}

		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
			if (photo[ni].charAt(nj) != ('0' + team)) continue;
			if (map[ni][nj] != 0) continue;
			flood(ni, nj, team, component);

		}
	}
}
