public class TeamBuilder {

	public int[] specialLocations(String[] paths) {
		int l = paths.length;
		boolean[][] reachable = new boolean[l][l];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				reachable[i][j] = (paths[i].charAt(j) == '1');
			}
			reachable[i][i] = true;
		}

		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					for (int k = 0; k < l; k++) {
						if (reachable[i][j] && reachable[j][k]) {
							if (!reachable[i][k]) {
								changed = true;
								reachable[i][k] = true;
							}
						}
					}
				}
			}
		}

		int[] res = new int[2];
		for (int i = 0; i < l; i++) {
			boolean source = true;
			boolean sink = true;
			for (int j = 0; j < l; j++) {
				if (!reachable[i][j]) {
					source = false;
				}
				if (!reachable[j][i]) {
					sink = false;
				}
			}
			if (source) res[0]++;
			if (sink) res[1]++;
		}

		return res;
	}

}
