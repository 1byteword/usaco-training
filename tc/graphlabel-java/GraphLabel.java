public class GraphLabel {

	int res = Integer.MAX_VALUE;
	int[] labels;
	boolean[] used;
	String[] graph;
	int n;
	
	public int adjacentDifference(String[] graph) {
		n = graph.length;
		labels = new int[n];
		used = new boolean[n];
		this.graph = graph;
		
		dfs(0, 0);

		return res;
	}

	private void dfs(int node, int max) {
		if (max > res) return;
		if (node == n) {
			res = Math.min(res, max);
			return;
		}
		
		for (int label = 0; label < n; label++) {
			if (used[label]) continue;
			labels[node] = label;
			used[label]  = true;
			
			int nodeMax = 0;
			for (int j = 0; j < node; j++) {
				if (graph[node].charAt(j) == '1') {
					nodeMax = Math.max(nodeMax, Math.abs(labels[j] - labels[node]));
				}
			}
			
			dfs(node + 1, Math.max(nodeMax, max));
			used[label] = false;
		}
		
	}

}
