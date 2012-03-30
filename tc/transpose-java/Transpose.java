import java.util.ArrayList;

public class Transpose {

	public int numSwaps(int m, int n) {
		int res = 0;
		int[] a = new int[m * n];
		int p = 0;
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				a[i * m + j] = p++;
			}
		}

		int ii = 0;

		for (int i = 0; i < m * n; i++) {
			ArrayList<Integer> sub = new ArrayList<Integer>();
			sub.add(i);
			for (int k = i; a[k] != i; k = a[k]) {
				sub.add(a[k]);
			}
			res += (sub.size() - 1);
			for (int k : sub) {
				a[k] = k;
			}
			
		}

		return res;
	}
}
