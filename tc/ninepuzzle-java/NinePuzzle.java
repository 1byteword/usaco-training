import java.util.*;
import java.util.Arrays;


public class NinePuzzle {

	private class State {
		private final int[][] NEIGHBORS = new int[][] { new int[] { 1, 2 }, new int[] { 0, 2, 3, 4 }, new int[] { 0, 1, 4, 5 },
				new int[] { 1, 4, 6, 7 }, new int[] { 1, 2, 3, 5, 7, 8 }, new int[] { 2, 4, 8, 9 }, new int[] { 3, 7 }, new int[] { 3, 4, 6, 8 },
				new int[] { 4, 5, 7, 9 }, new int[] { 5, 8 } };
		byte[] board = new byte[10];
		int spaceAt = -1;
		int hashcode = -1;

		public State(byte[] board) {
			int l = board.length;
			this.board = new byte[l];
			for (int i = 0; i < l; i++) {
				this.board[i] = board[i];
				if (board[i] == code('*')) spaceAt = i;
			}
		}

		public State[] change() {
			int[] neighbors = NEIGHBORS[spaceAt];
			State[] res = new State[neighbors.length];
			int p = 0;
			for (int pos : neighbors) {
				res[p++] = new State(swap(board, pos, spaceAt));
			}
			return res;
		}

		private byte[] swap(byte[] b, int x, int y) {
			byte[] res = new byte[b.length];
			for (int i = 0; i < b.length; i++) {
				res[i] = b[i];
			}
			res[x] = b[y];
			res[y] = b[x];
			return res;
		}
		
		public int distance(byte[] goal) {
			int res = 0;
			for (int i = 0; i < board.length; i++	) {
				if (board[i] != goal[i]) res++;
			}
			return res;
		}
		
		public int hashCode() {
			if (hashcode > -1) return hashcode;
			int res = 0;
			for (byte c : board) {
				res *= 5;
				res += c;
			}
			hashcode = res;
			return res;
		}
		
		public boolean equals(Object obj) {
			if (!(obj instanceof State)) return false;
			State other = (State)obj;
			return hashCode() == other.hashCode();
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (byte i : board) {
				sb.append(i);
			}
			return sb.toString();
		}

	}
	
	private byte code(char c) {
		switch (c) {
		case 'R':
			return 1;
		case 'G':
			return 2;
		case 'B':
			return 3;
		case 'Y':
			return 4;
		case '*':
			return 0;
		}
		return -1;
	}
	
	private byte[] code(char[] chars) {
		int l = chars.length;
		byte[] res = new byte[l];
		for (int i = 0; i < l; i++) {
			res[i]  = code(chars[i]);
		}
		return res;
	}



	public int getMinimumCost(String initStr, String goalStr) {
		byte[] goal = code(goalStr.toCharArray());
		LinkedList<State> states = new LinkedList<State>();
		HashSet<State> seen = new HashSet<State>();
		State init = new State(code(initStr.toCharArray()));
		
		seen.add(init);
		states.add(init);
		int res = init.distance(goal);
		while (!states.isEmpty()) {
			State current = states.remove();
			for (State s : current.change()) {
				if (!seen.contains(s)) {
					seen.add(s);
					states.add(s);
					res = Math.min(res, s.distance(goal));
					if (res == 0) return res;
				}
			}
		}
		
		return res;
//		return seen.size();
	}

}
