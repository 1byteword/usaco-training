import java.util.HashSet;

public class MNS {

	
	HashSet<Integer> seen = new HashSet<Integer>();
	int[] numbers;

	public int combos(int[] numbers) {
		int l = numbers.length;
		int[] n = new int[l];
		boolean[] taken = new boolean[l];
		this.numbers = numbers;

		dfs(n, taken, 0);

		return seen.size();
	}

	private void dfs(int[] n, boolean[] taken, int len) {
		int l = numbers.length;
		if (len == l) {
			if (!check(n)) return;
			int s = state(n);
			if (!seen.contains(s)) {
				seen.add(s);
			}
			return;
		}

		for (int i = 0; i < l; i++) {
			if (taken[i]) continue;
			taken[i] = true;
			n[len] = numbers[i];
			dfs(n, taken, len + 1);
			taken[i] = false;
		}

	}

	private int state(int[] n) {
		int res = 0;
		for (int i = 0; i < n.length; i++) {
			res *= 10;
			res += n[i];
		}
		return res;
	}

	private boolean check(int[] n) {
		int sum = n[0] + n[1] + n[2];
		
		if (n[3] + n[4] + n[5] != sum) return false;
		if (n[6] + n[7] + n[8] != sum) return false;
		
		if (n[0] + n[3] + n[6] != sum) return false;
		if (n[1] + n[4] + n[7] != sum) return false;
		if (n[2] + n[5] + n[8] != sum) return false;
		
		return true;
	}


}
