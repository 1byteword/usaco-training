import java.util.*;

public class ProductBundling {

	private String[] data;
	private ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>();
	private int[] areas;

	public int howManyBundles(String[] data) {
		this.data = data;
		int n = data[0].length();
		areas = new int[n];

		for (int i = 0; i < n; i++) {
			neighbors.add(new ArrayList<Integer>());
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (connected(i, j)) {
					neighbors.get(i).add(j);
				}
			}
		}

		int area = 1;
		for (int i = 0; i < n; i++) {
			if (areas[i] > 0) continue;
			flood(i, area);
			area++;
		}

		return area - 1;
	}

	private void flood(int i, int area) {
		areas[i] = area;
		for (int j : neighbors.get(i)) {
			if (areas[j] > 0) continue;
			flood(j, area);
		}
	}
	
	private boolean connected(int i, int j) {
		for (int k = 0; k < data.length; k++) {
			if (data[k].charAt(i) != data[k].charAt(j)) return false;
		}
		return true;
	}

}
