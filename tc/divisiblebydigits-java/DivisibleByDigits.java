import java.util.LinkedList;

public class DivisibleByDigits {

	final static int D = 10;

	public long getContinuation(int n) {
		if (n == 0) return n;

		boolean[] digits = new boolean[D];
		for (int temp = n; temp > 0;) {
			digits[temp % 10] = true;
			temp /= 10;
		}

		LinkedList<Long> queue = new LinkedList<Long>();
		queue.add((long) n);

		while (true) {
			long checking = queue.remove();
			if (divide(checking, digits)) return checking;
			for (int i = 0; i < D; i++) {
				queue.add(checking * 10 + i);
			}
		}
	}

	private boolean divide(long checking, boolean[] digits) {
		for (int i = 1; i < D; i++) {
			if (digits[i] && checking % i > 0) return false;
		}
		return true;
	}

}
