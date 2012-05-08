import java.util.ArrayList;

public class KthElement {

	public int find(int A, int B, int K) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(0);

		int period = -1;
		int start = -1;
		for (int i = 1; i <= K; i++) {
			x.add( A * f(x.get(i - 1)) + B);
			for (int j = i - 1; j >= 0; j--) {
				if (x.get(i).intValue() == x.get(j).intValue()) {
					start = j;
					period = i - j;
					break;
				}
			}
			if (start > -1) {
				return x.get((K - start) % period + start);
			}
		}
		return x.get(K);
	}

	private int f(int x) {
		int res = 0;
		while (x > 0) {
			res += (x & 1);
			x = x >> 1;
		}
		return res;
	}

}
