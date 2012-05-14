public class InfiniteSequence {
	private static final int M = 1000000;
	long[] cache = new long[M];
	int p, q;

	public long calc(long n, int p, int q) {
		this.p = p;
		this.q = q;
		cache[0] = 1;

		long res = A(n);
		return res;
	}

	private long A(long n) {
		if (n < M && cache[(int) n] > 0)
			return cache[(int) n];
		long res = A((long) Math.floor((double) n / p))
				+ A((long) Math.floor((double) n / q));
		if (n < M)
			cache[(int) n] = res;
		return res;
	}

}
