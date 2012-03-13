public class ChessKnight {

	static int[] neighborX = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] neighborY = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

	public double probability(int x, int y, int N) {
		
		double[][][] board = new double[9][9][N + 1];
		board[x][y][0] = 1.0;

		for (int n = 1; n <= N; n++) {
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 8; j++) {
					double sum = 0.0;
					for (int l = 0; l < 8; l++) {
						int prevX = i + neighborX[l];
						int prevY = j + neighborY[l];
						if (prevX >= 1 && prevX <= 8 && prevY >= 1 && prevY <= 8) {
							sum += board[prevX][prevY][n - 1];
						}
					}
					board[i][j][n] = sum / 8.0;
				}
			}
		}

		double res = 0.0;
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				res += board[i][j][N];
			}
		}

		return res;
	}
}
