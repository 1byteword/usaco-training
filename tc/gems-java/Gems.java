public class Gems {
	char[][] board;
	int m, n;

	public int numMoves(String[] b) {
		m = b.length;
		n = b[0].length();
		board = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = b[i].charAt(j);
			}
		}

		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (checkNeighbor(i, j, true)) res++;
				if (checkNeighbor(i, j, false)) res++;
			}
		}
		return res;

	}

	private boolean checkNeighbor(int i, int j, boolean below) {
		int i1 = i + (below ? 1 : 0);
		if (i1 >= m) return false;
		int j1 = j + (below ? 0 : 1);
		if (j1 >= n) return false;

		boolean res = false;
		swap(i, j, i1, j1);
		res |= checkLine(i, j);
		res |= checkLine(i1, j1);
		swap(i, j, i1, j1);
		return res;
	}

	private void swap(int i, int j, int i1, int j1) {
		char temp = board[i][j];
		board[i][j] = board[i1][j1];
		board[i1][j1] = temp;
	}

	private boolean checkLine(int i, int j) {
		char c = board[i][j];
		if (i - 2 >= 0 && board[i - 2][j] == c && board[i - 1][j] == c) return true;
		if (i - 1 >= 0 && i + 1 < m && board[i - 1][j] == c && board[i + 1][j] == c) return true;
		if (i + 2 < m && board[i + 1][j] == c && board[i + 2][j] == c) return true;
		if (j - 2 >= 0 && board[i][j - 2] == c && board[i][j - 1] == c) return true;
		if (j - 1 >= 0 && j + 1 < n && board[i][j - 1] == c && board[i][j + 1] == c) return true;
		if (j + 2 < n && board[i][j + 1] == c && board[i][j + 2] == c) return true;
		return false;
	}
}
