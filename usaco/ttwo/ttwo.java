/*
ID: changhu1
LANG: JAVA
TASK: ttwo
 */
import java.io.*;
import java.util.*;


public class ttwo {
	// Directions: N, E, S, W
	private static int[] incx = new int[] { -1, 0, 1, 0 };
	private static int[] incy = new int[] { 0, 1, 0, -1 };
	private static int N = 10;
	private static int MAX = 160000;  // (4 directions * 10x * 10y) ^ 2

	class Sprite {
		int x;
		int y;
		int facing;

		public Sprite(int x, int y) {
			this.x = x;
			this.y = y;
			this.facing = 0; // Start by facing N
		}

		// move one step in direction
		public void move() {
			x = nextX();
			y = nextY();
		}

		public int nextX() {
			return x + incx[facing];
		}

		public int nextY() {
			return y + incy[facing];
		}

		public void rotate() {
			facing = (facing + 1) % 4;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Sprite)) return false;
			Sprite other = (Sprite) obj;
			if (other.x != x) return false;
			if (other.y != y) return false;
			return true;
		}
		
		public String toString() {
			return String.format("%d, %d, %d", x, y, facing); 
		}
	}

	public int solve(String[] map) {

		Sprite farmer = new Sprite(-1, -1);
		Sprite cows = new Sprite(-1, -1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i].charAt(j) == 'F') {
					farmer = new Sprite(i, j);
				}
				if (map[i].charAt(j) == 'C') {
					cows = new Sprite(i, j);
				}
			}
		}

		int minutes = 0;
		while ( !(farmer.equals(cows))) {
			moveSprite(farmer, map);
			moveSprite(cows, map);
			minutes++;
			if (minutes == MAX) return 0;
		}
		return minutes;
	}

	private void moveSprite(Sprite spr, String[] map) {
		int nextX = spr.nextX();
		int nextY = spr.nextY();
		if (nextX < 0 || nextY < 0 || nextX == N || nextY == N) {
			spr.rotate();
		} else if (map[spr.nextX()].charAt(spr.nextY()) == '*') {
			spr.rotate();
		} else {
			spr.move();
		}
	}

	public static void main(String[] args) throws IOException {
		String problemName = "ttwo";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		String[] map = new String[N];
		for (int i = 0; i < N; i++) {
			String line = f.readLine();
			map[i] = line;
		}

		int res = (new ttwo()).solve(map);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}