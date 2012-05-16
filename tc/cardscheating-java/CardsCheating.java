public class CardsCheating {

	public int numberOfShuffles(int[] cards, int[] map) {
		int[] s = new int[cards.length];
		for (int i = 0; i < cards.length; i++) {
			s[i] = cards[i];
		}

		for (int i = 0;; i++) {
			if (goal(s)) {
				return i;
			}
			s = shuffle(s, map);
			if (same(s, cards)) {
				return -1;
			}
		}
	}

	private boolean same(int[] s, int[] cards) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] != cards[i]) {
				return false;
			}
		}
		return true;
	}

	private boolean goal(int[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] != (i % 3)) {
				return false;
			}
		}
		return true;
	}

	private int[] shuffle(int[] s, int[] map) {
		int[] res = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			res[map[i]] = s[i];
		}
		return res;
	}

}
