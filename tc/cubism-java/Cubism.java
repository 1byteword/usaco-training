public class Cubism {

	public int lines(String[] lattice, String c) {
		int res = 0;
		char color = c.equals("black") ? 'B' : 'W';

		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 4; k++) {
				boolean good = true;
				for (int i = 0; i < 4; i++) {
					if (cube(lattice, i, j, k) != color) {
						good = false;
						break;
					}
				}
				if (good) res++;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 4; k++) {
				boolean good = true;
				for (int j = 0; j < 4; j++) {
					if (cube(lattice, i, j, k) != color) {
						good = false;
						break;
					}
				}
				if (good) res++;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				boolean good = true;
				for (int k = 0; k < 4; k++) {
					if (cube(lattice, i, j, k) != color) {
						good = false;
						break;
					}
				}
				if (good) res++;
			}
		}

		for (int k = 0; k < 4; k++) {
			boolean good = true;
			for (int j = 0; j < 4; j++) {
				int i = j;
				if (cube(lattice, i, j, k) != color) {
					good = false;
					break;
				}
			}
			if (good) res++;
		}

		for (int j = 0; j < 4; j++) {
			boolean good = true;
			for (int k = 0; k < 4; k++) {
				int i = k;
				if (cube(lattice, i, j, k) != color) {
					good = false;
					break;
				}
			}
			if (good) res++;
		}

		for (int i = 0; i < 4; i++) {
			boolean good = true;
			for (int j = 0; j < 4; j++) {
				int k = j;
				if (cube(lattice, i, j, k) != color) {
					good = false;
					break;
				}
			}
			if (good) res++;
		}

		for (int k = 0; k < 4; k++) {
			boolean good = true;
			for (int j = 0; j < 4; j++) {
				int i = 3 - j;
				if (cube(lattice, i, j, k) != color) {
					good = false;
					break;
				}
			}
			if (good) res++;
		}

		for (int j = 0; j < 4; j++) {
			boolean good = true;
			for (int k = 0; k < 4; k++) {
				int i = 3 - k;
				if (cube(lattice, i, j, k) != color) {
					good = false;
					break;
				}
			}
			if (good) res++;
		}

		for (int i = 0; i < 4; i++) {
			boolean good = true;
			for (int j = 0; j < 4; j++) {
				int k = 3 - j;
				if (cube(lattice, i, j, k) != color) {
					good = false;
					break;
				}
			}
			if (good) res++;
		}

		boolean good = true;
		for (int i = 0; i < 4; i++) {
			int j = i;
			int k = i;
			if (cube(lattice, i, j, k) != color) {
				good = false;
				break;
			}
		}
		if (good) res++;

		good = true;
		for (int i = 0; i < 4; i++) {
			int j = i;
			int k = 3 - i;
			if (cube(lattice, i, j, k) != color) {
				good = false;
				break;
			}
		}
		if (good) res++;

		good = true;
		for (int i = 0; i < 4; i++) {
			int j = 3 - i;
			int k = i;
			if (cube(lattice, i, j, k) != color) {
				good = false;
				break;
			}
		}
		if (good) res++;

		good = true;
		for (int i = 0; i < 4; i++) {
			int j = 3 - i;
			int k = 3 - i;
			if (cube(lattice, i, j, k) != color) {
				good = false;
				break;
			}
		}
		if (good) res++;


		return res;
	}

	private char cube(String[] lattice, int i, int j, int k) {
		return lattice[i].charAt(j * 4 + k);
	}

}
