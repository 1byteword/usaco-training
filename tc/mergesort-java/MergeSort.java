public class MergeSort {


	public int howManyComparisons(int[] numbers) {
		int[] dummy = mergeSort(numbers);
		return res;
	}

	private int[] mergeSort(int[] a) {
		int l = a.length;
		if (l <= 1)
			return a;

		int[] b = new int[l / 2];
		int[] c = new int[l - l / 2];
		for (int i = 0; i < l / 2; i++) {
			b[i] = a[i];
		}
		for (int i = 0; i < l - l / 2; i++) {
			c[i] = a[i + l / 2];
		}
		int[] sb = mergeSort(b);
		int[] sc = mergeSort(c);

		return merge(sb, sc);
	}

	private int[] merge(int[] b, int[] c) {
		int[] a = new int[b.length + c.length];
		int pb = 0;
		int pc = 0;
		int p = 0;
		while (pb < b.length && pc < c.length) {
			int cp  = compare(b[pb], c[pc]);
			if (cp == LESS) {
				a[p++] = b[pb++];
			} else if (cp == MORE) {
				a[p++] = c[pc++];
			} else {
				a[p++] = b[pb++];
				a[p++] = c[pc++];
			}
			
		}
		if (pb < b.length) {
			for (int i = pb; i < b.length; i++) {
				a[p++] = b[i]; 
			}
		} else if (pc < c.length) {
			for (int i = pc; i < c.length; i++) {
				a[p++] = c[i]; 
			}
		}
		return a;
	}

	int res;
	private static final int LESS = -1;
	private static final int EQUAL = 0;
	private static final int MORE = 1;

	private int compare(int i, int j) {
		res++;
		if (i < j)
			return LESS;
		if (i == j)
			return EQUAL;
		return MORE;
	}
}
