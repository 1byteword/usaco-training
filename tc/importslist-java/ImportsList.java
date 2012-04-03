public class ImportsList {

	public int[] importsCount(String[] requires) {
		int l = requires.length;

		int[][] imports = new int[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				imports[i][j] = requires[i].charAt(j) == 'N' ? 0 : -1;
			}
		}

		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					if (imports[i][j] > -1) continue;
					
					boolean allN = true;
					for (int k = 0; k < l; k++) {
						if (imports[i][k] != 0 && imports[k][j] != 0) {
							allN = false;
							break;
						}
					}
					
					if (allN) {
						imports[i][j] = 1;
						changed = true;
					} 
				}
			}
		}

		int[] res = new int[l];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				res[i] += imports[i][j] == 1 ? 1 : 0;
			}
		}

		return res;
	}

}
